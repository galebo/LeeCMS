package com.galebo.lowyer.webapp.controller;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.web.context.HttpSessionContextIntegrationFilter;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.galebo.lowyer.model.User;
import com.galebo.lowyer.services.CommonService;
import com.galebo.lowyer.services.impl.Statistics;
import com.galebo.lowyer.services.impl.UserDataCreator;

public class BaseController implements ServletContextAware{
    @Autowired
	protected CommonService commonService;
    @Autowired
    protected UserDataCreator userDataCreator;
    @Autowired
    protected Statistics statistics;

    protected ServletContext servletContext;
    public void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    protected ServletContext getServletContext() {
        return servletContext;
    }
    static public Long getCurrentUser(HttpServletRequest request){
        HttpSession session = request.getSession();
        SecurityContext securityContext = (SecurityContext)session.getAttribute(HttpSessionContextIntegrationFilter.SPRING_SECURITY_CONTEXT_KEY) ;
        if (securityContext.getAuthentication().getPrincipal() instanceof User) {
            User user = (User) securityContext.getAuthentication().getPrincipal();
           return user.getId();
        }
        return 1L;
	}
    static public User getCurrentUser_(HttpServletRequest request){
        HttpSession session = request.getSession();
        SecurityContext securityContext = (SecurityContext)session.getAttribute(HttpSessionContextIntegrationFilter.SPRING_SECURITY_CONTEXT_KEY) ;
        if (securityContext!=null&&securityContext.getAuthentication().getPrincipal() instanceof User) {
            User user = (User) securityContext.getAuthentication().getPrincipal();
           return user;
        }
        return null;
	}
    protected static final String successDirect = "redirect:/ja/success";
    protected static ModelAndView successView=new ModelAndView(successDirect);

    protected MessageSourceAccessor messages;
    @Autowired
    public void setMessages(MessageSource messageSource) {
        messages = new MessageSourceAccessor(messageSource);
    }
}
