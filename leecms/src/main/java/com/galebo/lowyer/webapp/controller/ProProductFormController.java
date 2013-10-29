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
import org.springframework.web.bind.annotation.RequestParam;

import com.galebo.lowyer.model.ProCategory;
import com.galebo.lowyer.model.ProProduct;

@Controller
@RequestMapping("/proProductform*")
public class ProProductFormController extends BaseFormController {

    public ProProductFormController() {
        setCancelView("redirect:proProducts");
        setSuccessView("redirect:proProducts");
    }

    @ModelAttribute
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    protected ProProduct showForm(HttpServletRequest request)
    throws Exception {
        String productId = request.getParameter("sonId");

        if (!StringUtils.isBlank(productId)) {
            return commonService.getQueryDao().getProProductDao().get(new Long(productId));
        }
        String jbox = request.getParameter("jbox");
        request.setAttribute("jbox", jbox);
        String columnId = request.getParameter("parentId");
        request.setAttribute("parentId", columnId);

        return new ProProduct();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(ProProduct proProduct, BindingResult errors, HttpServletRequest request,
    		@RequestParam(value="jbox",required=false)String jbox,HttpServletResponse response,@RequestParam(value="parentId",required=false)Long parentId)
    throws Exception {
        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        log.debug("entering 'onSubmit' method...");

        boolean isNew = (proProduct.getProductId() == null);
        String success = getSuccessView();
        Locale locale = request.getLocale();

        if (request.getParameter("delete") != null) {
        	commonService.getQueryDao().getProProductDao().remove(proProduct.getProductId());
            saveMessage(request, getText("deleted", locale));
        } else {
        	ProCategory parent =null;
        	if(parentId!=null)
            {
        		parent = commonService.getQueryDao().getProCategoryDao().get(parentId);
            }
        	userDataCreator.save(proProduct, getCurrentUser(request),parent);
            String key = (isNew) ? "added" : "updated";
            saveMessage(request, getText(key, locale));

            if (!isNew) {
                success = "redirect:proProductform?productId=" + proProduct.getProductId();
            }
        }
        if (jbox!=null) {
            success = successDirect;
        }
        return success;
    }
}
