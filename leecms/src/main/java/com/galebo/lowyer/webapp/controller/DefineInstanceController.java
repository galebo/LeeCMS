package com.galebo.lowyer.webapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/defineInstances*")
public class DefineInstanceController extends BaseController{

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query, HttpServletRequest request)
    throws Exception {
        return new ModelAndView().addObject(userDataCreator.getSiteDefineWithName(BaseFormController.getCurrentUser(request)));
    }
}
