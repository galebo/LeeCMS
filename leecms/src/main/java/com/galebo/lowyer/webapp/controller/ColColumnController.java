package com.galebo.lowyer.webapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.galebo.lowyer.model.ColColumn;

@Controller
@RequestMapping("/colColumns*")
public class ColColumnController extends BaseController{
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView handleRequest(@RequestParam(required = false, value = "q") String query)
    throws Exception {
        return new ModelAndView().addObject(commonService.search(query, ColColumn.class));
    }
}
