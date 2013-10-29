package com.galebo.lowyer.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.galebo.lowyer.model.TemplatePage;

@Controller
@RequestMapping("/templatePages*")
public class TemplatePageController  extends BaseController{
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(HttpServletRequest request)
    throws Exception {
        return new ModelAndView().addObject(commonService.search("", TemplatePage.class));
    }
}
