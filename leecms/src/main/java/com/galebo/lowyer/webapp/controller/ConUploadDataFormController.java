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

import com.galebo.lowyer.model.ConUploadData;

@Controller
@RequestMapping("/conUploadDataform*")
public class ConUploadDataFormController extends BaseFormController {
    public ConUploadDataFormController() {
        setCancelView("redirect:conUploadDatas");
        setSuccessView("redirect:conUploadDatas");
    }

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected ConUploadData showForm(HttpServletRequest request)
    throws Exception {
        String uploadDataId = request.getParameter("uploadDataId");

        if (!StringUtils.isBlank(uploadDataId)) {
            return commonService.getQueryDao().getConUploadDataDao().get(new Long(uploadDataId));
        }

        return new ConUploadData();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(ConUploadData conUploadData, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }


        boolean isNew = (conUploadData.getUploadDataId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	commonService.getQueryDao().getConUploadDataDao().remove(conUploadData.getUploadDataId());
            saveMessage(request, getText("deleted", locale));
        } else {
        	commonService.getQueryDao().getConUploadDataDao().save(conUploadData);
            String key = (isNew) ? "added" : "updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:conUploadDataform?uploadDataId=" + conUploadData.getUploadDataId();
            }
        }

        return success;
    }
}
