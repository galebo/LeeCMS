package com.galebo.lowyer.webapp.controllers;

import java.io.File;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.galebo.common.UtilsCommon;
import com.galebo.lowyer.Constants;
import com.galebo.lowyer.model.ConUploadData;
import com.galebo.lowyer.webapp.controller.BaseFormController;


@Controller
public class FileUploadAjaxController extends BaseFormController {

    @RequestMapping("/aFile*")
    @ResponseBody
    public Result onSubmit(HttpServletRequest request,HttpServletResponse response) {


        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile imgFile = (CommonsMultipartFile) multipartRequest.getFile("imgFile");

        // the directory to upload to
        String uploadDir = getServletContext().getRealPath(com.galebo.lowyer.services.impl.Constants.uploadDir);

        // Create the directory if it doesn't exist
        File dirPath = new File(uploadDir);

        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }

        
        

      //定义允许上传的文件扩展名
      HashMap<String, String> extMap = new HashMap<String, String>();
      extMap.put("image", "gif,jpg,jpeg,png,bmp");
      extMap.put("flash", "swf,flv");
      extMap.put("media", "swf,flv,mp3,wav,wma,wmv,mid,avi,mpg,asf,rm,rmvb");
      extMap.put("file", "doc,docx,xls,xlsx,ppt,htm,html,txt,zip,rar,gz,bz2");

      //最大文件大小
      long maxSize = 1000000;

      response.setContentType("text/html; charset=UTF-8");

      if(!ServletFileUpload.isMultipartContent(request)){
      	return Result.getError("请选择文件。");
      }

      	FileItem item =imgFile.getFileItem();
      	String fileName = item.getName();
      	if (!item.isFormField()) {
      		//检查文件大小
      		if(item.getSize() > maxSize){
      			return Result.getError("上传文件大小超过限制。");
      		}
      		//检查扩展名
      		String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
      		if(!Arrays.<String>asList(extMap.get("image").split(",")).contains(fileExt)){
      			return Result.getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get("image") + "格式。");
      		}
            String format = UtilsCommon.sdf_yyyyMMddhhmmssSSS.format(new Date());
            //write the file to the file specified
            String name = imgFile.getOriginalFilename();
    		String newName = getCurrentUser(request)+format+name.substring(name.lastIndexOf("."));
      		try{
      			File uploadedFile = new File(uploadDir, newName);
      			item.write(uploadedFile);
      		}catch(Exception e){
      			return  Result.getError("上传文件失败。");
      		}

            

            String address = request.getContextPath() + com.galebo.lowyer.services.impl.Constants.uploadDir + "/" + newName;
            String location = dirPath.getAbsolutePath() + Constants.FILE_SEP + imgFile.getOriginalFilename();


            ConUploadData bean=new ConUploadData();
    		bean.setAddress(address);
    		bean.setLocation(location);
            bean.setName(imgFile.getOriginalFilename());
            bean.setNewName("直接上传");
            bean.setSize( imgFile.getSize());
            bean.setType(imgFile.getContentType());
            bean.setUpdateTime(new Date());
            bean.setUserId(getCurrentUser(multipartRequest));
            commonService.getQueryDao().getConUploadDataDao().save(bean);
      		return  Result.getSucess(address);
      	}
      	return Result.getError("文件格式不正确");
    }

}
