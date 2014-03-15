package com.galebo.lowyer.webapp.controller;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.galebo.lowyer.model.CfgRelative;
import com.galebo.lowyer.model.ProCategory;
import com.galebo.lowyer.services.impl.Constants;

@Controller
@RequestMapping("/proCategoryform*")
public class ProCategoryFormController extends BaseFormController {

    public ProCategoryFormController() {
        setCancelView("redirect:proCategories");
        setSuccessView("redirect:proCategories");
    }

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected ProCategory showForm(HttpServletRequest request)
    throws Exception {
        String categoryId = request.getParameter("categoryId");

        if (!StringUtils.isBlank(categoryId)) {
            return commonService.getQueryDao().getProCategoryDao().get(new Long(categoryId));
        }
        ProCategory colColumn = new ProCategory();
        colColumn.setParentId(Long.valueOf(request.getParameter("parentId")));
        return colColumn;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(ProCategory proCategory, BindingResult errors, HttpServletRequest request)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (proCategory.getCategoryId() == null);
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	commonService.getQueryDao().getProCategoryDao().remove(proCategory.getCategoryId());
            saveMessage(request, getText("proCategory.deleted", locale));
        } else {
	        proCategory.setCTime(new Date());
	        proCategory.setUserId(getCurrentUser(request));
	        proCategory.setMaxId(20L);
	        proCategory.setRelativeId(20L);
	    	commonService.getQueryDao().getProCategoryDao().save(proCategory);
	    	if(proCategory.getParentId()!=null)
	    	{
	    		CfgRelative bean=new CfgRelative();
	    		bean.setElementId(proCategory.getCategoryId());
	    		bean.setElementType(Constants.categoryType);
	    		bean.setParentElementId(proCategory.getParentId());
	    		bean.setSort(proCategory.getCategoryId());
	    		bean.setUserId(getCurrentUser(request));
	        	commonService.getQueryDao().getCfgRelativeDao().save(bean);
	    	}

	        String key = (isNew) ? "added" : "updated";
	        saveMessage(request, getText(key, locale));
	
	        if (!isNew) {
	            return getUpdateSuccessView_Html_Ajax(request,"redirect:proCategoryform?categoryId=" + proCategory.getCategoryId());
	        }
	    }
        return getInsertSuccessView_Html_Ajax(request);
    }
}
