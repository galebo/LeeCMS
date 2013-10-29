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

import com.galebo.lowyer.model.CfgDefineInstance;

@Controller
@RequestMapping("/defineInstanceform*")
public class DefineInstanceFormController extends BaseFormController {

    public DefineInstanceFormController() {
        setCancelView("redirect:defineInstances");
        setSuccessView("redirect:defineInstances");
    }

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected CfgDefineInstance showForm(HttpServletRequest request)
    throws Exception {
        String defineInstanceId = request.getParameter("defineInstanceId");

        if (!StringUtils.isBlank(defineInstanceId)) {
            return commonService.getQueryDao().getDefineInstanceDao().get(new Long(defineInstanceId));
        }

        return new CfgDefineInstance();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(CfgDefineInstance defineInstance, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }


        boolean isNew = (defineInstance.getDefineInstanceId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	commonService.getQueryDao().getDefineInstanceDao().remove(defineInstance.getDefineInstanceId());
            saveMessage(request, getText("deleted", locale));
        } else {
        	defineInstance.setUpdateTime(new Date());
        	commonService.getQueryDao().getDefineInstanceDao().save(defineInstance);
            String key = (isNew) ? "added" : "updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:defineInstanceform?defineInstanceId=" + defineInstance.getDefineInstanceId();
            }
        }

        return success;
    }
}
