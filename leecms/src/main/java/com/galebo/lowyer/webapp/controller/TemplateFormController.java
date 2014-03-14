package com.galebo.lowyer.webapp.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.galebo.lowyer.model.Template;
import com.galebo.lowyer.services.impl.Constants;

@Controller
@RequestMapping("/templateform*")
public class TemplateFormController extends BaseFormController {

    public TemplateFormController() {
        setCancelView("redirect:templates");
        setSuccessView("redirect:templates");
    }

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected Template showForm(HttpServletRequest request)
    throws Exception {
        String cfgTemplateId = request.getParameter("cfgTemplateId");

        if (!StringUtils.isBlank(cfgTemplateId)) {
            return commonService.getQueryDao().getTemplateDao().get(new Long(cfgTemplateId));
        }

        return new Template();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(Template template, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (template.getCfgTemplateId() == null);
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	commonService.getQueryDao().getTemplateDao().remove(template.getCfgTemplateId());
            saveMessage(request, getText("deleted", locale));
        } else {
        	if(!commonService.getQueryDao().isTemplateExist(template.getTemplateId(), template.getTemplateCssId()))
        	{
            	template.setCTime(new Date());
            	template.setUserId(getCurrentUser(request));
            	template.setStatus(Constants.STATUS_IN_USE);
            	commonService.getQueryDao().getTemplateDao().save(template);
                String key = (isNew) ? "added" : "updated";
                saveMessage(request, getText(key, locale));

                if (!isNew) {
                    return "redirect:templateform?cfgTemplateId=" + template.getCfgTemplateId();
                }
        	}
        	else
        	{
                saveMessage(request, getText("template.isExist", locale));
               return "templateform";
        	}
        }

        return getSuccessView();
    }
}
