package com.galebo.lowyer.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.galebo.lowyer.model.TemplatePage;

@Controller
@RequestMapping("/templatePageform*")
public class TemplatePageFormController extends BaseFormController {

    public TemplatePageFormController() {
        setCancelView("redirect:templatePages");
        setSuccessView("redirect:templatePages");
    }

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected TemplatePage showForm(HttpServletRequest request)
    throws Exception {
        String templatePageId = request.getParameter("templatePageId");

        if (!StringUtils.isBlank(templatePageId)) {
            return commonService.getQueryDao().getTemplatePageDao().get(new Long(templatePageId));
        }

        return new TemplatePage();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(TemplatePage templatePage, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }


        boolean isNew = (templatePage.getTemplatePageId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	commonService.getQueryDao().getTemplatePageDao().remove(templatePage.getTemplatePageId());
            saveMessage(request, getText("deleted", locale));
        } else {
        	commonService.getQueryDao().getTemplatePageDao().save(templatePage);
            String key = (isNew) ? "added" : "updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:templatePageform?templatePageId=" + templatePage.getTemplatePageId();
            }
        }

        return success;
    }
}
