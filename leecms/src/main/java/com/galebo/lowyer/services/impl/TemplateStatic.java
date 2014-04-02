package com.galebo.lowyer.services.impl;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.galebo.common.UtilsCommon;
import com.galebo.common.WorkerException;
import com.galebo.common.freemarker.DbTemplateLoader;
import com.galebo.lowyer.bean.Common;
import com.galebo.lowyer.bean.Detail;
import com.galebo.lowyer.bean.Index;
import com.galebo.lowyer.bean.IndexSearch;
import com.galebo.lowyer.bean.Item;
import com.galebo.lowyer.bean.common.UrlNameAuthor;
import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.services.BeanCreater;

import freemarker.template.Configuration;
import freemarker.template.Template;
@Service("templateStatic")
public class TemplateStatic {
    private static final String staticPath = "/static";
	static protected final Log log = LogFactory.getLog(TemplateStatic.class);
	Configuration configuration = null;
	BeanCreater beanCreater;
	@Autowired
	public void setFreemarkerConfig(FreeMarkerConfigurer freemarkerConfig) {
		setConfiguration(freemarkerConfig.getConfiguration());
	}
	@Autowired
	public void setBeanCreater(BeanCreater beanCreater) {
		this.beanCreater = beanCreater;
	}
	public void setConfiguration(Configuration freemarkerConfig) {
		configuration = freemarkerConfig;
	}

	public void exeUser(String realPath,Long userId,Long parentUserId, String commonPath, Boolean useDb)
	{
		Url url = Url.getUrl();
		url.setBaseUrl("../");
		url.setChangeUpload();
		Common common = beanCreater.getCommon(userId, parentUserId,url);
		
		log.info("个人静态化开始");
		Date begin=new Date();
		com.galebo.lowyer.model.Template template = beanCreater.getUserTemplate(userId);
		createAll(template.getTemplateId(),template.getTemplateCssId(),common,common,userId,useDb,url,realPath);
		
		Date end=new Date();
		long l = end.getTime()-begin.getTime();
		log.info("个人静态化结束,耗时:"+(l/(1000*60)%60)+":"+((l/1000)%60)+"."+l%(1000));
		 begin=new Date();
			try {
				String pathname = realPath+staticPath;
				String destPath = Constants.destPath+"/user"+userId+"/";

				log.info("输出目录:"+destPath+",模板id:"+template.getTemplateId()+",cssId:"+template.getTemplateCssId());
				FileUtils.copyDirectory(new File(pathname),new File(destPath));
				FileUtils.copyDirectory(new File(commonPath+"/js"),new File(destPath+"/js"));
				FileUtils.copyDirectory(new File(commonPath+"/template"+template.getTemplateId()),new File(destPath+"/template"+template.getTemplateId()));
				FileUtils.deleteDirectory(new File(pathname));
			} catch (IOException e) {
				WorkerException.handle(e);
			}
			 end=new Date();
			l = end.getTime()-begin.getTime();
			log.info("复制文件结束,耗时："+(l/(1000*60)%60)+":"+((l/1000)%60)+"."+l%(1000));
	}
	public void exeAdmin(String realPath,Long userId, Boolean useDb)
	{
		Url url = Url.getUrl();
		url.setBaseUrl("../");
		url.setChangeUpload();

		Common common=beanCreater.getCommon(userId,null,url);
		
		log.info("静态化开始");
		Date begin=new Date();
		List<com.galebo.lowyer.model.Template> all = beanCreater.getTemplateAll();
		for (com.galebo.lowyer.model.Template template : all) {
			createAll(template.getTemplateId(),template.getTemplateCssId(),common,common,userId,useDb,url,realPath);
		}
		Date end=new Date();
		long l = end.getTime()-begin.getTime();
		log.info("静态化结束,耗时:"+(l/(1000*60)%60)+":"+((l/1000)%60)+"."+l%(1000));
		 begin=new Date();
		try {
			String pathname = realPath+staticPath;
			FileUtils.copyDirectory(new File(pathname),new File(Constants.destPath));
			FileUtils.deleteDirectory(new File(pathname));
		} catch (IOException e) {
			WorkerException.handle(e);
		}
		 end=new Date();
		l = end.getTime()-begin.getTime();
		log.info("复制文件结束,耗时："+(l/(1000*60)%60)+":"+((l/1000)%60)+"."+l%(1000));
	}
	private void createAll(Long templateId,Long cssId,Common common,Common parentCommon,Long userId, Boolean useDb,Url url,String realPath)
	{
		if(common.getSonCommon()!=null)
			createAll(templateId,cssId,common.getSonCommon(),parentCommon,userId,useDb,url.getSon(),realPath);
		url.setSaveBaseUrl(staticPath+"/");
		TemplateUrl templateUrl=new TemplateUrl();
		templateUrl.set(templateId,cssId, Constants.exportStaticPre,realPath);
		templateUrl.setUploadDir(Constants.exportUploadDir);
		
		Index index = beanCreater.getIndex(url,common);
		createHtml(index,null,url.getSaveIndexUrl(),"index.ftl",parentCommon,templateUrl,userId,useDb);
		IndexSearch bean = beanCreater.getIndeSearch(url, common);
		createHtml(bean,null,url.getSaveIndexSearch(),"indexSearch.ftl",parentCommon,templateUrl,userId,useDb);

		for (Iterator<ColColumn> iterator = common.getColumns().iterator(); iterator.hasNext();) {
			ColColumn column = iterator.next();
			if(column.getColPid()==-1)
				continue;
			Item item2=null;
			if(column.getSonColumn().size()>0)
			{
				item2 = beanCreater.getItem2(column.getColumnId(),url,common);
				createHtml(item2,null,url.getSaveItemUrl(column.getColumnId()),"items.ftl",parentCommon,templateUrl,userId,useDb);
			}
			else
			{
				item2 = beanCreater.getItem2(column.getColumnId(),url,common);
				createHtml(item2,null,url.getSaveItemUrl(column.getColumnId()),"item.ftl",parentCommon,templateUrl,userId,useDb);
			}
			
			for (Iterator<UrlNameAuthor> iterator2 = item2.getContents().iterator(); iterator2.hasNext();) {
				UrlNameAuthor content = iterator2.next();
				Detail detail = beanCreater.getDetail(content.getId(),url, common);
				createHtml(detail,null,url.getSaveDetailUrl(content.getId()),"detail.ftl",parentCommon,templateUrl,userId,useDb);
			}
			log.debug("文章数："+item2.getContents().size());
		}

		createDetail2(common, parentCommon, userId, useDb, url, templateUrl, common.getSimilar());
		log.debug(templateId+"栏目数："+common.getColumns().size());
	}
	private void createDetail2(Common common, Common parentCommon, Long userId, Boolean useDb, Url url, TemplateUrl templateUrl,
			List<UrlNameAuthor> similar) {
		for (Iterator<UrlNameAuthor> iterator2 = similar.iterator(); iterator2.hasNext();) {
			UrlNameAuthor content = iterator2.next();
			Detail detail = beanCreater.getDetail2(content.getContentId(),url, common);
			createHtml(detail,null,url.getSaveDetailNoTitleUrl(content.getId()),"detail2.ftl",parentCommon,templateUrl,userId,useDb);
		}
	}

	Map<String,Template> templateMap=new HashMap<String,Template>();

	private void createHtml(Object bean,Object pageObject, String outHtmlName,String ftlName,Common parentCommon,TemplateUrl templateUrl,Long userId, Boolean useDb) {
		Map<String, Object> map = new HashMap<String, Object>();
		setMap(bean,pageObject,map,templateUrl,parentCommon,userId,useDb);
		try {
			String name = templateUrl.getDynamicUrl()+"/"+ftlName;
			if(templateMap.get(name)==null)
			{
				templateMap.put(name, configuration.getTemplate(name));
			}
			UtilsCommon.mkdir(templateUrl.getRealPath()+outHtmlName);
			Writer writer= new OutputStreamWriter(new FileOutputStream(templateUrl.getRealPath()+outHtmlName),"UTF-8");
			templateMap.get(name).process(map, writer);
			writer.close();
		} catch (Exception e) {
			WorkerException.handleNoThrowNew(e);
		}
	}
	static public Map<String, Object> setMap(Object bean,Object pageObject,Map<String, Object> map,TemplateUrl templateUrl,Common parentCommon,Long userId,boolean isUseDb) {
		if(templateUrl.getCssId()==1)
			parentCommon.getDefines().put("g_boxCssId", "2");
		else 
			parentCommon.getDefines().put("g_boxCssId", "1");
		map.put("data",bean);
		map.put("pageObject",pageObject);
		map.put("common",parentCommon);
		map.put("commCssBase",templateUrl.getCommCssImageBase());
		map.put("commBase",templateUrl.getCommBase());
		map.put("commTBase",templateUrl.getCommTBase());
		String start=DbTemplateLoader.DbStartNo+userId+DbTemplateLoader.End;
		if(isUseDb)
			start=DbTemplateLoader.DbStart+userId+DbTemplateLoader.End;
		map.put("ftlPath"    ,start+templateUrl.getDynamicUrl());
		map.put("ftlBasePath",start+templateUrl.getDynamicBaseUrl());
		map.put("templateNum",templateUrl.getTemplateId());
		map.put("cssNum",templateUrl.getCssId());
		map.put("uploadDir",templateUrl.getUploadDir().replaceAll(Constants.uploadDir, Constants.uploadDirNew));
		return map;
	}//(1)
}
