package com.galebo.lowyer.webapp.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.galebo.lowyer.Constants;
import com.galebo.lowyer.model.CfgDefine;
import com.galebo.lowyer.model.ConContent;
import com.galebo.lowyer.model.ProCategory;
import com.galebo.lowyer.model.ProProduct;
import com.galebo.lowyer.model.Template;
import com.galebo.lowyer.model.TemplatePage;
import com.galebo.lowyer.model.User;
import com.galebo.lowyer.webapp.controller.BaseController;
import com.galebo.lowyer.webapp.controller.BaseFormController;

@Controller
public class ListController extends BaseController {

	@RequestMapping(value = "/conContents*", method = RequestMethod.GET)
	public ModelAndView conContents( HttpServletRequest request){
		return new ModelAndView().addObject(commonService.getQueryDao().getConContentsByUserId(getCurrentUser(request)));
	}

	@RequestMapping(value = "/conUploadDatas*", method = RequestMethod.GET)
	public ModelAndView conUploadDatas( HttpServletRequest request){
		return new ModelAndView().addObject(commonService.getQueryDao().getConUploadDatasByUserId(getCurrentUser(request)));
	}

	@RequestMapping(value = "/cfgGroups*", method = RequestMethod.GET)
	public ModelAndView cfgGroups(@RequestParam("type") String type,HttpServletRequest request){
		ModelAndView addObject = new ModelAndView().addObject(commonService.getQueryDao().getGroup(type, getCurrentUser(request)));
		addObject.addObject("type", type);
		return addObject;
	}

	@RequestMapping(value = "/defineInstances*", method = RequestMethod.GET)
	public ModelAndView defineInstances( HttpServletRequest request){
		return new ModelAndView().addObject(userDataCreator.getSiteDefineWithName(BaseFormController.getCurrentUser(request)));
	}

	@RequestMapping(value = "/conLinks/{type}", method = RequestMethod.GET)
	public ModelAndView conLinks(@PathVariable String type, HttpServletRequest request){
		ModelAndView addObject = new ModelAndView("conLinks").addObject(commonService.getQueryDao().getLinks(type, getCurrentUser(request)));
		addObject.addObject("type", type);
		return addObject;
	}

	@RequestMapping(value = "/defines*", method = RequestMethod.GET)
	public ModelAndView defines(@RequestParam(required = false, value = "q") String query){
		return new ModelAndView().addObject(commonService.search(query, CfgDefine.class));
	}

	@RequestMapping(value = "/proCategories*", method = RequestMethod.GET)
	public ModelAndView proCategories(@RequestParam(required = false, value = "q") String query){
		return new ModelAndView().addObject(commonService.search(query, ProCategory.class));
	}

	@RequestMapping(value = "/proProducts*", method = RequestMethod.GET)
	public ModelAndView proProducts(@RequestParam(required = false, value = "q") String query){
		return new ModelAndView().addObject(commonService.search(query, ProProduct.class));
	}

	@RequestMapping(value = "/templates*", method = RequestMethod.GET)
	public ModelAndView templates(@RequestParam(required = false, value = "q") String query){
		return new ModelAndView().addObject(commonService.search(query, Template.class));
	}

	@RequestMapping(value = "/templatePages*", method = RequestMethod.GET)
	public ModelAndView templatePages(HttpServletRequest request){
		return new ModelAndView().addObject(commonService.search("", TemplatePage.class));
	}

	@RequestMapping(value = "/admin/users*", method = RequestMethod.GET)
	public ModelAndView users(@RequestParam(required = false, value = "q") String query){
		return new ModelAndView("admin/userList", Constants.USER_LIST, commonService.search(query, User.class));
	}

	@RequestMapping("/export")
	public ModelAndView handleRequest() {
		List<ConContent> all = commonService.getQueryDao().getConContentDao().getAll();
		for (int i = 0; i < all.size(); i++) {

		}
		return null;
	}
}
