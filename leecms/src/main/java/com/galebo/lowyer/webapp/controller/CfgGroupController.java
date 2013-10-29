package com.galebo.lowyer.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cfgGroups*")
public class CfgGroupController extends BaseController{

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query,
    		@RequestParam("type")String type, HttpServletRequest request)
    throws Exception {
        ModelAndView addObject = new ModelAndView().addObject(commonService.getQueryDao().getGroup(type,getCurrentUser(request)));
        addObject.addObject("type", type);
		return addObject;
    }
}
