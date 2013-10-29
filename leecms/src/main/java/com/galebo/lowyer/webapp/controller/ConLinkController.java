package com.galebo.lowyer.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ConLinkController extends BaseController{

    @RequestMapping(value = "/conLinks/{type}",method = RequestMethod.GET)
    public ModelAndView handleRequest(@PathVariable String type, HttpServletRequest request)
    throws Exception {
            ModelAndView addObject = new ModelAndView("conLinks").addObject(commonService.getQueryDao().getLinks(type,getCurrentUser(request)));
            addObject.addObject("type", type);
			return addObject;
    }
}
