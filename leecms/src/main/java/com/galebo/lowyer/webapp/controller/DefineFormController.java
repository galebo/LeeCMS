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

import com.galebo.lowyer.model.CfgDefine;

@Controller
@RequestMapping("/defineform*")
public class DefineFormController extends BaseFormController {

    public DefineFormController() {
        setCancelView("redirect:defines");
        setSuccessView("redirect:defines");
    }

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected CfgDefine showForm(HttpServletRequest request)
    throws Exception {
        String defineId = request.getParameter("defineId");

        if (!StringUtils.isBlank(defineId)) {
            return commonService.getQueryDao().getDefineDao().get(new Long(defineId));
        }

        return new CfgDefine();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(CfgDefine define, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }


        boolean isNew = (define.getDefineId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	commonService.getQueryDao().getDefineDao().remove(define.getDefineId());
            saveMessage(request, getText("deleted", locale));
        } else {
        	commonService.getQueryDao().getDefineDao().save(define);
            String key = (isNew) ? "added" : "updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:defineform?defineId=" + define.getDefineId();
            }
        }

        return success;
    }
}
