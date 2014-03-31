package com.galebo.lowyer.webapp.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.galebo.common.WorkerException;
import com.galebo.lowyer.bean.PageFront;
import com.galebo.lowyer.bean.common.IdCount;
import com.galebo.lowyer.dao.CommonDao;
import com.galebo.lowyer.model.GstMessage;
import com.galebo.lowyer.services.impl.Url;
import com.galebo.lowyer.webapp.controller.BaseController;

@Controller
public class PublicController extends BaseController implements ServletContextAware{

    @RequestMapping(value = "/pp/j/upCount", method = RequestMethod.GET)
    @ResponseBody
    public Object upCount(@RequestParam(required=false,value="id") Long contentId,@RequestParam(required=false,value="name") String name,@RequestParam(required=false,value="call") String call) {
    	if(contentId==null)
    			return new ArrayList<IdCount>(); 
    	commonService.getModifyDao().updateContentCount(contentId);
    	return getCounts(name, call, "-999,"+contentId);
    }
    @RequestMapping(value = "/pp/j/count", method = RequestMethod.GET)
    @ResponseBody
    public Object count(@RequestParam("ids") String ids,@RequestParam(required=false,value="name") String name,@RequestParam(required=false,value="call") String call) {
    	String newIds = ids.replaceAll(";","").replaceAll("%2C", ",");
    	return getCounts(name, call, newIds);
    }

	private Object getCounts(String name, String call, String ids) {
		List<IdCount> conContent = commonService.getQueryDao().getContentCount(ids);
    	if(call!=null)
    	{
    		return call+"(\""+name+"\","+JSONArray.fromCollection(conContent)+")";
    	}
    	return conContent;
	}
	
	@RequestMapping(value = "/pp/j/getWebCount", method = RequestMethod.GET)
    @ResponseBody
    public Object upWebCount(@RequestParam(required=false,value="id") Long userId,@RequestParam(required=false,value="name") String name,@RequestParam(required=false,value="call") String call) {
    	if(userId==null)
    			return new ArrayList<IdCount>(); 
    	commonService.getModifyDao().updateWebCount(userId);
    	return getWebCounts(name, call, userId);
    }
	private Object getWebCounts(String name, String call, Long userId) {
		IdCount conContent = commonService.getQueryDao().getWebCount(userId);
    	if(call!=null&&name!=null)
    	{
    		return call+"(\""+name+"\","+JSONArray.fromObject(conContent)+")";
    	}
    	return conContent;
	}
	@RequestMapping(value = "/pp/j/getItemTop", method = RequestMethod.GET)
    @ResponseBody
    public Object getItemTop(@RequestParam(required=false,value="id") Long itemId,@RequestParam(required=false,value="call") String call,
    		HttpServletResponse response) {
    	if(call!=null)
    	{
    		Url url=new Url();
    		url.setBaseUrl("../");
    		String string = call+"("+JSONArray.fromObject(statistics.get(itemId,url))+")";
			try {
				return new String(string.getBytes("UTF-8"),"iso-8859-1");
			} catch (UnsupportedEncodingException e) {
				WorkerException.handleNoThrowNew(e);
			}
    	}
    	return "";
    }
	
	
	/**
	 * 客户留言
	 */
	@Autowired
	CommonDao guestMessageDao;
	
    @RequestMapping(value="/pp/saveMessage",method = RequestMethod.POST)
    public String onSubmit(GstMessage gstMessage, BindingResult errors){

		if(gstMessage.getIsPublic()==null)
			gstMessage.setIsPublic (0l);
		if(gstMessage.getContentId()==null)
			gstMessage.setContentId (-1l);
		
        guestMessageDao.insertGstMessage(gstMessage);
        return "redirect:/pp/listMessage";
    }
    @RequestMapping(value="/pp/listMessage")
    public ModelAndView listMessage(@RequestParam(required=false,value="page") Integer currentPage){
    	int gstMessagesSize = guestMessageDao.getGstMessagesSize();
    	if(currentPage==null||(currentPage!=null&&currentPage<1))
    		currentPage=1;
    	PageFront page=new PageFront(5,gstMessagesSize,currentPage);
    	if(page.getTotalPage()<currentPage){
    		page=new PageFront(5,gstMessagesSize,page.getTotalPage());
    	}

		return new ModelAndView("/web/book").addObject("messages",guestMessageDao.getGstMessages((currentPage-1)*5,5))
				.addObject("page",page);
    }
}
