package com.galebo.lowyer.webapp.controllers;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.galebo.common.Result;
import com.galebo.common.UtilsWeb;
import com.galebo.common.dao.SSIILL;
import com.galebo.common.freemarker.DbTemplateLoader;
import com.galebo.common.jgrid.JGridAble;
import com.galebo.common.jgrid.JGridBean;
import com.galebo.lowyer.bean.NameKey1234;
import com.galebo.lowyer.bean.Sortable;
import com.galebo.lowyer.model.CfgIndexSearch;
import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.model.ColColumnContent;
import com.galebo.lowyer.model.ConContent;
import com.galebo.lowyer.model.ConLink;
import com.galebo.lowyer.model.ProCategoryProduct;
import com.galebo.lowyer.model.TemplatePage;
import com.galebo.lowyer.model.User;
import com.galebo.lowyer.model.WebInfo;
import com.galebo.lowyer.services.impl.Constants;
import com.galebo.lowyer.services.impl.TemplateStatic;
import com.galebo.lowyer.webapp.controller.BaseController;

import freemarker.template.TemplateException;

@Controller
public class CommonController extends BaseController{

	public static Boolean useDb=false;
	private TemplateStatic templateStatic;
	@Autowired
	public void setTemplateStatic(TemplateStatic templateStatic) {
		this.templateStatic = templateStatic;
	}

    @RequestMapping(value = "/selfPage", method = RequestMethod.GET)
    protected ModelAndView getUserTemplatePage(HttpServletRequest request){
    	Long currentUser = getCurrentUser(request);
    	List<TemplatePage> list=commonService.getQueryDao().getTemplatePage(currentUser);

		return new ModelAndView("templatePageformUser").addObject(list.get(0));
    }

    @RequestMapping(value = "/ja/{viewName}", method = RequestMethod.GET)
    public ModelAndView direct(@PathVariable String viewName,@RequestParam(value="type",required=false) String type) {
		ModelAndView modelAndView = new ModelAndView("/main/right/"+viewName);
		if(!StringUtils.isBlank(type))
			modelAndView.addObject("type", type);
		return modelAndView;
    }

    @RequestMapping(value = "/pages/webInfo", method = RequestMethod.GET)
    public ModelAndView viewWebInfo(HttpServletRequest request) {
    	User currentUser = getCurrentUser_(request);
    	WebInfo bean = commonService.getQueryDao().getWebInfoByUserId(currentUser.getId());
    	User currentUser2 = getCurrentUser_(request);
    	if(bean!=null) {
		}
    	else
    	{
    		bean=new WebInfo();
    		bean.setCreateTime(new Date());
    		bean.setWebCfgTemplateId(116L);
    		bean.setExpireTime(new Date());
    		bean.setLastLoginTime(new Date());
    		bean.setLastLoginIp(UtilsWeb.getIpAddr(request));
    		bean.setWebDomain(currentUser.getUsername());
    		bean.setWebTmpUrl("http://localhost:8080/pages/p/"+currentUser.getUsername()+"/index/1.html");
    		bean.setWebType("3AA");
    		bean.setUserId(currentUser.getId());
    		bean.setParentId(2L);
    		commonService.getQueryDao().getWebInfoDao().save(bean);
    	}
		return new ModelAndView("/main/right/center_right").addObject(bean).addObject(currentUser2);
    }

	@RequestMapping(value = "/admin/staticAdmin", method = RequestMethod.GET)
	public ModelAndView html(HttpServletRequest request) {
		templateStatic.exeAdmin(Constants.realPath,1L,useDb);

		return successView;
	}

	@RequestMapping(value = "/staticUser", method = RequestMethod.GET)
	public ModelAndView staticUser(HttpServletRequest request) {
		Long userId = getCurrentUser(request);
    	WebInfo webInfo = commonService.getQueryDao().getWebInfoByUserId(userId);
		String realPath1 =Constants.realPath+"user"+userId;
		templateStatic.exeUser(realPath1,webInfo.getUserId(),webInfo.getParentId(),servletContext.getRealPath("/p/common"),useDb);
		return successView;
	}


    @SuppressWarnings("unchecked")
	@RequestMapping(value = "/admin/importTemplate2DB", method = RequestMethod.GET)
    public ModelAndView importTemplate2DB() throws IOException, TemplateException {
    	commonService.getModifyDao().deleteTemplatePageAll();
    	TemplatePage object=new TemplatePage();
    	Collection<File> listFiles =(Collection<File>) FileUtils.listFiles(new File(getServletContext().getRealPath("/pages/dynamic")),new String[]{"ftl"},true);
    	for (Iterator<File> iterator = listFiles.iterator(); iterator.hasNext();) {
			File file = iterator.next();
	    	String absolutePath = file.getAbsolutePath();
			String name = absolutePath.substring(absolutePath.indexOf("dynamic")).replace("\\", "/").replace(".ftl", "");
			object.setTemplatePageName(name);
	    	object.setTemplate(FileUtils.readFileToString(file));
	    	object.setTemplatePageId(null);
	    	object.setUserId(-1L);
	    	String str = "template";
	    	int fromIndex = name.indexOf(str)+str.length();
			String substring = name.substring(fromIndex,name.indexOf("/",fromIndex));
			object.setTemplateId(StringUtils.isBlank(substring)?-1:Long.valueOf(substring));
			commonService.getQueryDao().getTemplatePageDao().save(object);
		}
    	DbTemplateLoader.isNewImport=true;
		return successView;
    }


	
	/*
	 * json
	 */


    //查询加入首页菜单的栏目和内容
    @RequestMapping(value = "/jqJson/indexMenus", method = RequestMethod.GET)
    @ResponseBody
    public Object indexMenus(@RequestParam("page") int page,@RequestParam("rows") int pageSize,HttpServletRequest request) {
    	Long userId = getCurrentUser(request);
    	return commonService.getIndexMenus(userId,page);
    }
    //没有加入首页菜单的栏目
    @RequestMapping(value = "/jqJson/itemsNoInMenu", method = RequestMethod.GET)
    @ResponseBody
    public Object itemsNoInMenu(@RequestParam("page") int page,@RequestParam("rows") int pageSize,HttpServletRequest request) {
    	Long userId = getCurrentUser(request);
    	int size = commonService.getQueryDao().getColumnsNoInRelativeSize(userId,Constants.columnType,Constants.indexMenuType);
    	List<ColColumn> list = commonService.getQueryDao().getColumnsNoInRelative(userId,Constants.columnType,Constants.indexMenuType);
    	return JGridBean.fromList(list,page, pageSize,size);
    }

    //将栏目加入菜单
    @RequestMapping(value = "/jqJson/addMenu_Item/{columnIds}", method = RequestMethod.GET)
    @ResponseBody
    public Object addMenu_Item(@PathVariable String columnIds,HttpServletRequest request) {
		Long userId = getCurrentUser(request);
		userDataCreator.saveRelate(Constants.indexMenuType,Constants.menuColumn, userId, columnIds, userId);

		return Result.Sucess;
    }
    //将内容加入菜单
    @RequestMapping(value = "/jqJson/addMenu_Content/{columnContentId}", method = RequestMethod.GET)
    @ResponseBody
    public Object addMenu_Content(@PathVariable Long columnContentId,HttpServletRequest request) {
    	String columnContentIds=""+columnContentId;
		Long userId = getCurrentUser(request);
		userDataCreator.saveRelate(Constants.indexMenuType,Constants.menuContent, userId, columnContentIds, userId);
		return Result.Sucess;
    }
    //将自定义链接加入菜单
    @RequestMapping(value = "/jqJson/addMenu_Link/{linkId}", method = RequestMethod.GET)
    @ResponseBody
    public Object addMenu_Link(@PathVariable Long linkId,HttpServletRequest request) {
    	String linkIds=""+linkId;
		Long userId = getCurrentUser(request);
		userDataCreator.saveRelate(Constants.indexMenuType,Constants.selfType, userId, linkIds, userId);
		return Result.Sucess;
    }

    //查询首页显示的栏目
    @RequestMapping(value = "/jqJson/indexItems", method = RequestMethod.GET)
    @ResponseBody
    public Object IndexItems(@RequestParam("page") int page,@RequestParam("rows") int pageSize,HttpServletRequest request) {
    	Long userId = getCurrentUser(request);
    	return commonService.getIndexColumns(userId,page);
    }
    //没有加入首页菜单的栏目
    @RequestMapping(value = "/jqJson/itemsNoInIndex", method = RequestMethod.GET)
    @ResponseBody
    public Object itemsNoInIndex(@RequestParam("page") int page,@RequestParam("rows") int pageSize,HttpServletRequest request) {
    	Long userId = getCurrentUser(request);
    	int size = commonService.getQueryDao().getColumnsNoInRelativeSize(userId,Constants.columnType,Constants.indexItemType);
    	List<ColColumn> list = commonService.getQueryDao().getColumnsNoInRelative(userId,Constants.columnType,Constants.indexItemType);
    	return JGridBean.fromList(list,page, pageSize,size);
    }
    //将栏目加入菜单
    @RequestMapping(value = "/jqJson/addIndexItem/{columnIds}", method = RequestMethod.GET)
    @ResponseBody
    public Object addIndexItem(@PathVariable String columnIds,HttpServletRequest request) {
		Long userId = getCurrentUser(request);
		userDataCreator.saveRelate(Constants.indexItemType,Constants.menuColumn, userId, columnIds, userId);

		return Result.Sucess;
    }
    
    @RequestMapping(value = "/jqJson/parents/{type}", method = RequestMethod.GET)
    @ResponseBody
    public Object parents(@PathVariable String type,@RequestParam("page") int page,@RequestParam("rows") int pageSize,HttpServletRequest request) {
    	Long userId = getCurrentUser(request);
    	if(type.equals(Constants.columnType))
    		return commonService.getColumns(userId,page);
    	else if(type.equals(Constants.categoryType))
    		return commonService.getCategorys(userId,page);
    	else if(type.equals(Constants.linkType))
    	{
        	List<ConLink> list = commonService.getQueryDao().getLinks(type,getCurrentUser(request));
        	return JGridBean.fromList(list,page, pageSize,list.size());
    	}
    	return null;
    }
    @RequestMapping(value = "/jqJson/CfgGroups", method = RequestMethod.GET)
    @ResponseBody
    public Object CfgGroups(@RequestParam("page") int page,@RequestParam("rows") int pageSize,@RequestParam("type") String type,HttpServletRequest request) {
    	Long userId = getCurrentUser(request);
    	return commonService.getGroups(userId,page,type);
    }

    @RequestMapping(value = "/jqJson/sons/{type}/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public Object sons(@PathVariable String type,@PathVariable long parentId,@RequestParam("page") int page,@RequestParam("rows") int pageSize) {
    	if(type.equals(Constants.columnType))
    	{
    		int size = commonService.getQueryDao().getContentsSize(parentId);
        	List<ColColumnContent> list = commonService.getQueryDao().getColumnContents(parentId,page, pageSize);
        	return JGridBean.fromList(list,page, pageSize,size);
    	}
    	else
    	{
    		int size = commonService.getQueryDao().getProductsSize(parentId);
        	List<ProCategoryProduct> list = commonService.getQueryDao().getCategoryProducts(parentId,page, pageSize);
        	return JGridBean.fromList(list,page, pageSize,size);
    	}
    }


    @RequestMapping(value = "/jqJson/sonsNoBang/{type}/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public Object sonsNoBang(@PathVariable String type,@PathVariable long parentId,@RequestParam("page") int page,@RequestParam("rows") int pageSize,HttpServletRequest request) {
    	if(type.equals(Constants.columnType))
    	{
    		int size = commonService.getQueryDao().getContentsNoBangSize(parentId,getCurrentUser(request));
        	List<ConContent> list = commonService.getQueryDao().getContentsNoBang(parentId,getCurrentUser(request),page, pageSize);
        	return JGridBean.fromList(list,page, pageSize,size);
    	}
    	else
    	{
    		int size = commonService.getQueryDao().getProductsSize(parentId);
        	List<ProCategoryProduct> list = commonService.getQueryDao().getCategoryProducts(parentId,page, pageSize);
        	return JGridBean.fromList(list,page, pageSize,size);
    	}
    }
    @RequestMapping(value = "/jqJson/addToParent/{type}/{parentId}", method = RequestMethod.GET)
    @ResponseBody
    public Object addToParent(@PathVariable String type,@PathVariable long parentId,HttpServletRequest request,@RequestParam("sonIds") String sonIds) {
    	if(type.equals(Constants.columnType))
    	{
    		String[] split = sonIds.split(",");
			ConContent conContent=new ConContent();
			ColColumn colColumn = commonService.getQueryDao().getColColumnDao().get(parentId);
			if(!colColumn.getUserId().equals(getCurrentUser(request)))
				return "错误请求";
    		for (String string : split) {
    			conContent.setContentId(Long.valueOf(string));
				userDataCreator.saveColumnContent(conContent, colColumn);
			}
    	}
    	else
    	{
    	}
    	return Result.Sucess;
    }
    //查询人属性
    @RequestMapping(value = "/jqJson/getIndexSearchData", method = RequestMethod.GET)
    @ResponseBody
    public Object getIndexSearchData(@RequestParam("page") int page,@RequestParam("rows") int pageSize,HttpServletRequest request) {
        	List<NameKey1234> list = commonService.getQueryDao().getIndexSearchData(getCurrentUser(request),322L);
        	return JGridBean.fromList(list,page, pageSize,list.size());
    }
    @RequestMapping(value = "/jqJson/getIndexSearchDataNotIn", method = RequestMethod.GET)
    @ResponseBody
    public Object getIndexSearchDataNotIn(@RequestParam("page") int page,@RequestParam("rows") int pageSize,HttpServletRequest request) {
        	List<NameKey1234> list = commonService.getQueryDao().getIndexSearchDataNotIn(getCurrentUser(request),322L);
        	return JGridBean.fromList(list,page, pageSize,list.size());
    }
    //设置人属性
    @RequestMapping(value = "/jqJson/setContentIndex/{contentId}/{key1}/{key2}", method = RequestMethod.GET)
    @ResponseBody
    public Object setContentIndex(@PathVariable long contentId,@PathVariable String key1,@PathVariable String key2) {
    	commonService.getModifyDao().setContentIndex(contentId,key1,key2);
    	return Result.Sucess;
    }
    //设置人属性
    @RequestMapping(value = "/jqJson/insertContentIndex/{contentId}/{key1}/{key2}", method = RequestMethod.GET)
    @ResponseBody
    public Object insertContentIndex(@PathVariable long contentId,@PathVariable String key1,@PathVariable String key2,HttpServletRequest request) {
    	CfgIndexSearch a=new CfgIndexSearch();
    	a.setKey1(key1);
    	a.setKey2(key2);
    	a.setUserId(getCurrentUser(request));
    	a.setId(contentId);
    	commonService.getModifyDao().insertContentIndex(a);
    	return Result.Sucess;
    }
    @RequestMapping(value = "/jqJson/GroupSon/{groupId}/{type}", method = RequestMethod.GET)
    @ResponseBody
    public Object GroupSon(@PathVariable long groupId,@PathVariable String type,HttpServletRequest request,@RequestParam("page") int page,@RequestParam("rows") int pageSize) {
    	int size = commonService.getQueryDao().getSonLinksSize(groupId, getCurrentUser(request), type);
    	List<ConLink> list = commonService.getQueryDao().getSonLinks(groupId,getCurrentUser(request),type,page,pageSize);
    	return JGridBean.fromList(list,page, pageSize,size);
    }
    @RequestMapping(value = "/jqJson/GroupSonNoSelect/{groupId}/{type}", method = RequestMethod.GET)
    @ResponseBody
    public Object GroupSonNoSelect(@PathVariable long groupId,@PathVariable String type,HttpServletRequest request,@RequestParam("page") int page,@RequestParam("rows") int pageSize) {
    	int size = commonService.getQueryDao().getSonLinksNoSelectSize(groupId, getCurrentUser(request), type);
    	List<ConLink> list = commonService.getQueryDao().getSonLinksNoSelect(groupId,getCurrentUser(request),type,page,pageSize);
    	return JGridBean.fromList(list,page, pageSize,size);
    }
    @RequestMapping(value = "/jqJson/GroupSonAdd/{groupId}/{type}", method = RequestMethod.GET)
    @ResponseBody
    public Object GroupSonAdd(@PathVariable long groupId,@PathVariable String type,@RequestParam("sonIds") String sonIds,HttpServletRequest request) {
    	userDataCreator.saveRelate(type,null, groupId, sonIds, getCurrentUser(request));
		return Result.Sucess;
    }
    /*
     * changeSort/ColColumnContent
     * changeSort/Relative
     * changeSort/Column
     * changeSort/IndexItem
     * changeSort/IndexMenu
     */
	
    @RequestMapping(value = "/jqJson/changeSort/{type}/{direct}/{groupId}/{relativeId}/{sonId}/{sort}", method = RequestMethod.GET)
    @ResponseBody
	public Object changeSort(@PathVariable String type,@PathVariable String direct,@PathVariable Long groupId,@PathVariable Long relativeId,
			@PathVariable Long sonId,@PathVariable Long sort,HttpServletRequest request)
	{
    	String statementName= "get"+type+direct+"One";
    	Sortable destOne =(Sortable) commonService.getQueryDao().getSqlMapClientTemplate().queryForObject(statementName,
    			SSIILL.create(null, null, null, null, sort, groupId));
    	if(destOne!=null)
    	{
    		if("ColColumnContent".equals(type))
    		{
        		commonService.getModifyDao().changeSort("update"+type+"Sort",destOne.getId(),sonId);
        		commonService.getModifyDao().changeSort("update"+type+"Sort",relativeId,destOne.getSonId());
        	}
    		else
    		{
        		commonService.getModifyDao().changeSort("updateRelativeSort",destOne.getId(),sort);
        		commonService.getModifyDao().changeSort("updateRelativeSort",relativeId,destOne.getSort());
    		}
    	}
		return Result.Sucess;
	}
    
    @RequestMapping(value = "/jqJson/deleteColumn/{columnId}", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteColumn(@PathVariable Long columnId,HttpServletRequest request) {
        return new Result(messages.getMessage(commonService.deleteColumn(columnId), request.getLocale()));
    }
    //删除首页下的栏目
    @RequestMapping(value = "/jqJson/releaseMenuElement/{relateId}", method = RequestMethod.GET)
    @ResponseBody
    public Object releaseMenuElement(@PathVariable long relateId) {
    	commonService.getModifyDao().deleteRelative(relateId);
		return Result.Sucess;
    }
    //解除友情链接和轮播图
    @RequestMapping(value = "/jqJson/releaseLinkLoop/{relateId}", method = RequestMethod.GET)
    @ResponseBody
    public Object releaseLinkElement(@PathVariable long relateId) {
    	commonService.getModifyDao().deleteRelative(relateId);
		return Result.Sucess;
    }
    //解绑栏目下的内容
    @RequestMapping(value = "/jqJson/releaseContent/{columnContentId}", method = RequestMethod.GET)
    @ResponseBody
    public Object deleteColumnContent(@PathVariable Long columnContentId,HttpServletRequest request) {
    	ColColumnContent colColumnContent = commonService.getQueryDao().getColColumnContentDao().get(columnContentId);
    	if(colColumnContent.getPreId()==null)
		{
    		ColColumn colColumn = commonService.getQueryDao().getColColumnDao().get(colColumnContent.getColColumn().getColumnId());
        	colColumn.setFirstId(colColumnContent.getNextId());
        	commonService.getQueryDao().getColColumnDao().save(colColumn);
        	
        	if(colColumnContent.getNextId()!=null)
        	{
            	ColColumnContent colColumnContent_newFist = commonService.getQueryDao().getColColumnContentDao().get(colColumnContent.getNextId());
            	colColumnContent_newFist.setPreId(null);
            	commonService.getQueryDao().getColColumnContentDao().save(colColumnContent_newFist);
        	}
		}
    	if(colColumnContent.getNextId()==null)
		{
    		ColColumn colColumn = commonService.getQueryDao().getColColumnDao().get(colColumnContent.getColColumn().getColumnId());
        	colColumn.setLastId(colColumnContent.getPreId());
        	commonService.getQueryDao().getColColumnDao().save(colColumn);

        	if(colColumnContent.getPreId()!=null)
        	{
            	ColColumnContent colColumnContent_newLast = commonService.getQueryDao().getColColumnContentDao().get(colColumnContent.getPreId());
            	colColumnContent_newLast.setNextId(null);
            	commonService.getQueryDao().getColColumnContentDao().save(colColumnContent_newLast);
        	}
		}
        commonService.getModifyDao().deleteColumnContent(columnContentId);
		return Result.Sucess;
    }

	@RequestMapping(value = "/jqJson/getTemplates", method = RequestMethod.GET)
    @ResponseBody
    public Object getTemplates(@RequestParam("page") int page,@RequestParam("rows") int pageSize,HttpServletRequest request) {
    	List<? extends JGridAble> list = commonService.getQueryDao().getTemplateDao().getAll();
    	return JGridBean.fromList(list,page, pageSize,list.size());
    }
    @RequestMapping(value = "/jqJson/updateUserTemplate/{templateId}", method = RequestMethod.GET)
    @ResponseBody
    public Object updateUserTemplate(@PathVariable Long templateId,HttpServletRequest request) {
    	commonService.getModifyDao().updateUserTemplate(templateId,getCurrentUser(request));
    	return Result.Sucess;
    }
}
