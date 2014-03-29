package com.galebo.lowyer.webapp.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.galebo.common.freemarker.DbTemplateLoader;
import com.galebo.lowyer.model.CfgDefineInstance;
import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.services.impl.CmsMap;
import com.galebo.lowyer.services.impl.Constants;
import com.galebo.lowyer.services.impl.UserDataCreator;
import com.galebo.lowyer.webapp.controller.BaseController;

@Controller
public class ConfigController extends BaseController implements ServletContextAware{

    @RequestMapping(value = "/useDb/{set}", method = RequestMethod.GET)
    public ModelAndView useDb(@PathVariable String set) {
    	if("true".equals(set))
    		CommonController.useDb=true;
    	else
    		CommonController.useDb=false;
		return successView;
    }
    @RequestMapping(value = "/clearMap", method = RequestMethod.GET)
    public ModelAndView clearMap(HttpServletRequest request) {
		Long userId = getCurrentUser(request);
		if(userId!=null)
			CmsMap.clearMap(userId);
		return successView;
    }
    @RequestMapping(value = "/initUser", method = RequestMethod.GET)
    public ModelAndView initUser(HttpServletRequest request) {
    	userDataCreator.createUserData_small(getCurrentUser(request));
		return successView;
    }
    @RequestMapping(value = "/setUploadNew", method = RequestMethod.GET)
    public ModelAndView setUploadNew(HttpServletRequest request) {
    	Map<String, CfgDefineInstance> globalDefines = commonService.getQueryDao().getGlobalDefines();
    	Constants.uploadDirNew = globalDefines.get("imgSite").getText();
		return successView;
    }

    @RequestMapping(value = "/statistics", method = RequestMethod.GET)
    public ModelAndView statistics(HttpServletRequest request) {
    	statistics.exe();
		return successView;
    }
    @RequestMapping(value = "/isNewImport", method = RequestMethod.GET)
    public ModelAndView isNewImport(HttpServletRequest request) {
    	DbTemplateLoader.isNewImport=true;
		return successView;
    }
    @RequestMapping(value = "/createContent/{columnId}")
    public ModelAndView createContent(HttpServletRequest request,@PathVariable Long columnId,@RequestParam(value="size",required=false,defaultValue="3") int size) {
    	ColColumn colColumn = commonService.getQueryDao().getColColumnDao().get(columnId);
		userDataCreator.createContent(colColumn.getUserId(),UserDataCreator.HTML,colColumn,size);
		return successView;
    }
    @RequestMapping(value = "/createColumn")
    public ModelAndView createColumn(HttpServletRequest request,@RequestParam(value="size",required=false,defaultValue="3") int size) {
		userDataCreator.createColumnHaveRoot(getCurrentUser(request),size);
		return successView;
    }

    @Autowired
    UserDataCreator userDataCreator;
}
