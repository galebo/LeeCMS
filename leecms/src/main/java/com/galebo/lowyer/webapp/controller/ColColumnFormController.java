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

import com.galebo.lowyer.model.CfgRelative;
import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.services.impl.Constants;

@Controller
@RequestMapping("/colColumnform*")
public class ColColumnFormController extends BaseFormController {
    public ColColumnFormController() {
        setCancelView("redirect:/jq/colColumns");
        setSuccessView("redirect:/jq/colColumns");
    }

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected ColColumn showForm(HttpServletRequest request)
    throws Exception {
        String columnId = request.getParameter("columnId");

        if (!StringUtils.isBlank(columnId)) {
            return commonService.getQueryDao().getColColumnDao().get(new Long(columnId));
        }

        String jbox = request.getParameter("jbox");
        request.setAttribute("jbox", jbox);
        ColColumn colColumn = new ColColumn();
        colColumn.setColPid(Long.valueOf(request.getParameter("parentId")));
		return colColumn;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(ColColumn colColumn, BindingResult errors, HttpServletRequest request,
                           HttpServletResponse response,@RequestParam(value="jbox",required=false)String jbox)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }


        boolean isNew = (colColumn.getColumnId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	if(commonService.getQueryDao().isColumnUsed(colColumn.getColumnId()))
                saveMessage(request, getText("column.isUsed", locale));
        	else
    		{
        		commonService.getQueryDao().getColColumnDao().remove(colColumn.getColumnId());
                saveMessage(request, getText("deleted", locale));
    		}
        } else {
        	colColumn.setCTime(new Date());
        	colColumn.setUserId(getCurrentUser(request));
        	colColumn.setSmallId(10000L);
        	colColumn.setMaxId(10000L);
        	commonService.getQueryDao().getColColumnDao().save(colColumn);
        	if(colColumn.getColPid()!=null)
        	{
        		CfgRelative bean=new CfgRelative();
        		bean.setElementId(colColumn.getColumnId());
        		bean.setElementType(Constants.columnType);
        		bean.setParentElementId(colColumn.getColPid());
        		bean.setSort(colColumn.getColumnId());
        		bean.setUserId(getCurrentUser(request));
            	commonService.getQueryDao().getCfgRelativeDao().save(bean);
        	}
            String key = (isNew) ? "added" : "updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:colColumnform?columnId=" + colColumn.getColumnId();
            }
            if (jbox!=null) {
                success = successDirect;
            }
        }

        return success;
    }
}
