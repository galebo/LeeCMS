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
import org.springframework.web.bind.annotation.RequestParam;

import com.galebo.lowyer.model.ConLink;

@Controller
@RequestMapping("/conLinkform*")
public class ConLinkFormController extends BaseFormController {

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected ConLink showForm(HttpServletRequest request)
    throws Exception {
        String linkId = request.getParameter("linkId");
        String type = request.getParameter("type");
        request.setAttribute("jbox", request.getParameter("jbox"));
        request.setAttribute("groupId", request.getParameter("groupId"));

        if (!StringUtils.isBlank(linkId)) {
            return commonService.getQueryDao().getConLinkDao().get(new Long(linkId));
        }

        ConLink conLink = new ConLink();
        conLink.setType(type);
		return conLink;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(ConLink conLink, BindingResult errors, HttpServletRequest request,
    		@RequestParam(value="jbox",required=false)String jbox,
    		@RequestParam(value="groupId",required=false) Long groupId,
                           HttpServletResponse response)
    throws Exception {
        setCancelView("redirect:conLinks/"+conLink.getType());
        setSuccessView("redirect:conLinks/"+conLink.getType());
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }



        boolean isNew = (conLink.getLinkId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	commonService.getQueryDao().getConLinkDao().remove(conLink.getLinkId());
            saveMessage(request, getText("deleted", locale));
        } else {
        	conLink.setUserId(getCurrentUser(request));
        	conLink.setUpdateTime(new Date());
        	conLink=commonService.getQueryDao().getConLinkDao().save(conLink);
        	if(groupId!=null)
        	{
        		userDataCreator.saveRelate(conLink.getType(), null, groupId, conLink.getLinkId(), getCurrentUser(request));
        	}
            String key = (isNew) ? "added" : "updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:conLinkform?linkId=" + conLink.getLinkId()+"&type="+conLink.getType();
            }
        }
        if (jbox!=null) {
            success = successDirect;
        }
        return success;
    }
}
