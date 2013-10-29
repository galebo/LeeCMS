package com.galebo.lowyer.webapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.galebo.lowyer.model.ConContent;

@Controller
public class ConContentController extends BaseController{
    @RequestMapping("/conContents*")
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query,HttpServletRequest request)
    throws Exception {
        return new ModelAndView().addObject(commonService.getQueryDao().getConContentsByUserId(getCurrentUser(request)));
    }
    @RequestMapping("/export")
    public ModelAndView handleRequest(){
    	List<ConContent> all = commonService.getQueryDao().getConContentDao().getAll();
    	for (int i = 0; i < all.size(); i++) {
			
		}
    	return null;
    }
    
}
