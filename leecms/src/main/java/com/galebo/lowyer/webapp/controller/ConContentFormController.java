package com.galebo.lowyer.webapp.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.model.ConContent;
import com.galebo.lowyer.services.impl.UserDataCreator;

@Controller
@RequestMapping("/conContentform*")
public class ConContentFormController extends BaseFormController {
	@Autowired
	UserDataCreator userDataCreator;
    public ConContentFormController() {
        setCancelView("redirect:conContents");
        setSuccessView("redirect:conContents");
    }

	@ModelAttribute
	@RequestMapping(method = { RequestMethod.GET, RequestMethod.POST })
	protected ConContent showForm(HttpServletRequest request) throws Exception {
		String contentId = request.getParameter("sonId");
		ConContent conContent=null;
        if (!StringUtils.isBlank(contentId)) {
            conContent = commonService.getQueryDao().getConContentDao().get(new Long(contentId));
        }
        else
        	conContent = new ConContent();
        request.setAttribute("jbox", request.getParameter("jbox"));
        request.setAttribute("parentId",request.getParameter("parentId") );
        request.setAttribute("parentSonId", request.getParameter("parentSonId"));
		return conContent;
    }

	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(ConContent conContent, BindingResult errors, HttpServletRequest request, HttpServletResponse response,
			@RequestParam(value="jbox",required=false)String jbox,@RequestParam(value="parentId",required=false)Long parentId,
			@RequestParam(value="parentSonId",required=false)Long parentSonId) throws Exception {
		if (request.getParameter("cancel") != null) {
			return getCancelView();
		}

        boolean isNew = (conContent.getContentId() == null);
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	commonService.getQueryDao().getConContentDao().remove(conContent.getContentId());
            saveMessage(request, getText("deleted", locale));
        } else {
        	ColColumn colColumn =null;
        	if(parentSonId==null&&parentId!=null)
            {
            	colColumn = commonService.getQueryDao().getColColumnDao().get(parentId);
        		userDataCreator.saveContent(conContent, getCurrentUser(request),colColumn);
            }
        	else
            	userDataCreator.updateContent(conContent,getCurrentUser(request));
            String key = (isNew) ? "added" : "updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                return "redirect:conContentform?contentId=" + conContent.getContentId();
            }
        }

        return getSuccessView_Html_Ajax(request);
    }
}
