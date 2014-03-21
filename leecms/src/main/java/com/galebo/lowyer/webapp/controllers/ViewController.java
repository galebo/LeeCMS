package com.galebo.lowyer.webapp.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.galebo.common.WorkerException;
import com.galebo.lowyer.bean.Common;
import com.galebo.lowyer.bean.Item;
import com.galebo.lowyer.bean.common.Group;
import com.galebo.lowyer.bean.common.UrlNameAuthorHtml;
import com.galebo.lowyer.bean.common.UrlNameImg;
import com.galebo.lowyer.model.Template;
import com.galebo.lowyer.model.WebInfo;
import com.galebo.lowyer.services.BeanCreater;
import com.galebo.lowyer.services.impl.Constants;
import com.galebo.lowyer.services.impl.Search;
import com.galebo.lowyer.services.impl.TemplateStatic;
import com.galebo.lowyer.services.impl.TemplateUrl;
import com.galebo.lowyer.services.impl.Url;
import com.galebo.lowyer.webapp.controller.BaseController;

import freemarker.template.TemplateException;

@Controller
public class ViewController extends BaseController{
	private static final String PATH_NO_TEMPLATE_ID = "../";
	BeanCreater beanCreater;
	@Autowired
	public void setBeanCreater(BeanCreater beanCreater) {
		this.beanCreater = beanCreater;
	}

    @RequestMapping(value = "/pp/w/{viewName}", method = RequestMethod.GET)
    public ModelAndView main(@PathVariable String viewName,HttpServletRequest request) {
    	if(viewName.equals("webIndex"))
    	{
    		List<UrlNameImg> loops=new ArrayList<UrlNameImg>();
    		UrlNameImg one=new UrlNameImg();
    		one.setImg(commonService.getQueryDao().getGlobalDefines().get("imgSite").getText()+"loop1.jpg");
    		one.setName("");
    		one.setUrl("#");
    		loops.add(one);
    		one=new UrlNameImg();
    		one.setImg(commonService.getQueryDao().getGlobalDefines().get("imgSite").getText()+"loop2.jpg");
    		one.setName("");
    		one.setUrl("#");
    		loops.add(one);
    		one=new UrlNameImg();
    		one.setImg(commonService.getQueryDao().getGlobalDefines().get("imgSite").getText()+"loop3.jpg");
    		one.setName("");
    		one.setUrl("#");
    		loops.add(one);
			Group links=new Group();
			links.setTitle("title");
			links.setSons(loops);
    		return new ModelAndView("/web/main").addObject("user", getCurrentUser_(request)).addObject("loop1",links);
    	}
    	if(viewName.equals("adminIndex"))
    	{
    		return new ModelAndView("redirect:/pages/main/index.jsp");
    	}
		return new ModelAndView("/web/"+viewName);
    }

	@RequestMapping(value = "/pp/h/{name}/{type}/{id}", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable String name,@PathVariable String type,@PathVariable String id,HttpServletRequest request) {
		WebInfo webInfo = commonService.getQueryDao().getWebInfoByDomain(name);
		if(webInfo==null)
			return new ModelAndView("close");
		Url url=new Url();
		url.setSon(new Url());
		TemplateUrl templateUrl=new TemplateUrl();
		init1(webInfo.getUserId(),"/pp/h/"+name+"/",url,templateUrl);
		return exe(type, id, webInfo.getUserId(),webInfo.getParentId(),url,templateUrl);
	}


	@RequestMapping(value = "/pages/view/{type}/{id}", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable String type,@PathVariable String id,HttpServletRequest request) {
		Long currentUser = getCurrentUser(request);
		if(currentUser==null)
			return new ModelAndView("close");
		Url url=new Url();
		url.setSon(new Url());
		TemplateUrl templateUrl=new TemplateUrl();
		init1(currentUser,PATH_NO_TEMPLATE_ID,url,templateUrl);
		return exe(type, id, currentUser,null/*parentUserId*/,url,templateUrl);
	}

	@RequestMapping(value = "/pages/ftl/{templateId}/{cssId}/{type}/{id}", method = RequestMethod.GET)
	public ModelAndView index(@PathVariable Long templateId,@PathVariable long cssId,@PathVariable String type,@PathVariable String id,HttpServletRequest request) {

		Long currentUser = getCurrentUser(request);
		if(currentUser==null)
			return new ModelAndView("close");
		Url url=new Url();
		url.setSon(new Url());
		TemplateUrl templateUrl=new TemplateUrl();
		url.setBaseUrl("../");
		templateUrl.set(templateId,cssId,"/p/common","");

		return exe(type, id, currentUser,null/*parentUserId*/,url,templateUrl);
	}


	private void init1(Long currentUser,String baseUrl,Url url,TemplateUrl templateUrl) {
		Long templateId=1L;
		Long cssId=1L;
		Template cfgRelative = commonService.getQueryDao().getTemplateByUserId(currentUser);
		if(cfgRelative!=null)
		{
				templateId=cfgRelative.getTemplateId();
				cssId=cfgRelative.getTemplateCssId();
		}
		url.setBaseUrl(baseUrl);
		templateUrl.set(templateId,cssId,"/p/common","");
	}

	private ModelAndView exe(String type, String id,Long userId,Long parentUserId, Url url,TemplateUrl templateUrl) {
		url.setNoChangeUpload();
		Common mainCommon=beanCreater.getCommon(userId, parentUserId, url);
		Common common=mainCommon;
		if(type.startsWith("ss"))
		{
			common=common.getSonCommon();
			type = type.substring(2);
			url=url.getSon();
		}
		Object object=null;
		if(type.equals("item"))
		{
			Item item2 = beanCreater.getItem2(Long.valueOf(id),url,common);
			if(item2.isHasSon())
				type="items";
			object = item2;
		}
		else if(type.equals("detail"))
			object = beanCreater.getDetail(Long.valueOf(id),url,common);
		else if(type.equals("detail2"))
			object = beanCreater.getDetail2(Long.valueOf(id),url,common);
		else if(type.equals("indexSearch"))
			object = beanCreater.getIndeSearch(url,common);
		else if(type.equals("search"))
		{
			object = search(userId, common, id,url);
			type="item";
		}
		else
		{
			object = beanCreater.getIndex(url,common);
		}

		System.out.println(JSONObject.fromBean(object).toString());
		return getMV(templateUrl.getTemplateId(), object,type,mainCommon,templateUrl,userId,false);
	}

	
	private ModelAndView getMV(Long templateId,Object object,String ftlName,Common common,TemplateUrl templateUrl,Long userId,boolean isUseDb) {
		ModelAndView mv = new ModelAndView("dynamic/template"+templateId+"/"+ftlName);

		TemplateStatic.setMap(object, mv.getModelMap(),templateUrl,common,userId,isUseDb);
		return mv;
	}
	@RequestMapping(value = "/ftl/export", method = RequestMethod.GET)
	public ModelAndView export() {
		ModelAndView mv = new ModelAndView("dynamic/export");
		mv.addObject("beans",commonService.getQueryDao().getConContentDao().getAll());
		return mv;
	}


	@Autowired
    Search search;
    public Item search(Long userId,Common common,String key,Url url){
		List<UrlNameAuthorHtml> contents=new ArrayList<UrlNameAuthorHtml>();
		if(StringUtils.isNotBlank(key))
		{
        	String realPath = getServletContext().getRealPath(Constants.indexPath);
	    	try {
				contents = search.search2(realPath,userId,key);
			} catch (Exception e) {
				WorkerException.handleNoThrowNew(e);
			}
		}
		else
			key="";
		return beanCreater.getSearchItem(contents, key, url, common);
    }
    @RequestMapping(value = "/rebuldIndex", method = RequestMethod.GET)
    public ModelAndView rebuldIndex(HttpServletRequest request) throws IOException, TemplateException {
    	String realPath = getServletContext().getRealPath(Constants.indexPath);

    	Url url=new Url();
		url.setBaseUrl(PATH_NO_TEMPLATE_ID);
    	search.build(realPath, getCurrentUser(request),url);
		return successView;
    }

	
}
