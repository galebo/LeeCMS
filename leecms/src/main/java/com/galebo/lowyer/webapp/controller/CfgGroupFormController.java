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

import com.galebo.lowyer.model.CfgGroup;

@Controller
@RequestMapping("/cfgGroupform*")
public class CfgGroupFormController extends BaseFormController {

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected CfgGroup showForm(HttpServletRequest request)
    throws Exception {
        String groupId = request.getParameter("groupId");
        String type = request.getParameter("type");
        request.setAttribute("jbox", request.getParameter("jbox"));

        if (!StringUtils.isBlank(groupId)) {
            return commonService.getQueryDao().getCfgGroupDao().get(new Long(groupId));
        }

        CfgGroup cfgGroup = new CfgGroup();
        cfgGroup.setType(type);
		return cfgGroup;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(CfgGroup cfgGroup, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response)
    throws Exception {
        setCancelView("redirect:cfgGroups?type="+cfgGroup.getType());
        setSuccessView("redirect:cfgGroups?type="+cfgGroup.getType());
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }


        boolean isNew = (cfgGroup.getGroupId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	commonService.getQueryDao().getCfgGroupDao().remove(cfgGroup.getGroupId());
            saveMessage(request, getText("deleted", locale));
        } else {
        	Long userId = getCurrentUser(request);
        	if(!StringUtils.isAlphanumeric(cfgGroup.getType()))
                saveMessage(request, getText("key.isChiness", locale));
        	else if(!isNew&&commonService.getQueryDao().isGroupExist(cfgGroup.getType(), cfgGroup.getGroupKey(), userId))
                saveMessage(request, getText("key.isUsed", locale));
        	else
        	{
    			cfgGroup.setUserId(userId);
            	commonService.getQueryDao().getCfgGroupDao().save(cfgGroup);
                String key = (isNew) ? "added" : "updated";
                saveMessage(request, getText(key, locale));
        	}
        		

            if (!isNew) {
                success = "redirect:cfgGroupform?groupId=" + cfgGroup.getGroupId();
            }
            if (request.getParameter("jbox")!=null) {
                success = successDirect;
            }
        }

        return success;
    }
}
