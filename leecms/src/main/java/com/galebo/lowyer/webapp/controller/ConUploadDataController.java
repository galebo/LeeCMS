package com.galebo.lowyer.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/conUploadDatas*")
public class ConUploadDataController  extends BaseController{
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query, HttpServletRequest request)
    throws Exception {
        List queryForList = commonService.getQueryDao().getConUploadDatasByUserId(getCurrentUser(request));
		return new ModelAndView().addObject(queryForList);
    }

}
