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

import com.galebo.lowyer.model.CfgRelative;

@Controller
@RequestMapping("/cfgRelativeform*")
public class CfgRelativeFormController extends BaseFormController {

    public CfgRelativeFormController() {
        setCancelView("redirect:cfgRelatives");
        setSuccessView("redirect:cfgRelatives");
    }

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected CfgRelative showForm(HttpServletRequest request)
    throws Exception {
        String cfgRelateId = request.getParameter("cfgRelateId");

        if (!StringUtils.isBlank(cfgRelateId)) {
            return commonService.getQueryDao().getCfgRelativeDao().get(new Long(cfgRelateId));
        }

        return new CfgRelative();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(CfgRelative cfgRelative, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }


        boolean isNew = (cfgRelative.getCfgRelateId() == null);
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	commonService.getQueryDao().getCfgRelativeDao().remove(cfgRelative.getCfgRelateId());
            saveMessage(request, getText("deleted", locale));
        } else {
        	commonService.getQueryDao().getCfgRelativeDao().save(cfgRelative);
            String key = (isNew) ? "added" : "updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                return getUpdateSuccessView_Html_Ajax(request,"redirect:cfgRelativeform?cfgRelateId=" + cfgRelative.getCfgRelateId());
            }
        }

        return getInsertSuccessView_Html_Ajax(request);
    }
}
