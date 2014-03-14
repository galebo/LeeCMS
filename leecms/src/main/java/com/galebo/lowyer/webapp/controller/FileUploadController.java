package com.galebo.lowyer.webapp.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.galebo.common.UtilsCommon;
import com.galebo.lowyer.Constants;
import com.galebo.lowyer.model.ConUploadData;

/**
 * Controller class to upload Files.
 * <p/>
 * <p>
 * <a href="FileUploadFormController.java.html"><i>View Source</i></a>
 * </p>
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Controller
@RequestMapping("/fileupload*")
public class FileUploadController extends BaseFormController {

    public FileUploadController() {
        setCancelView("redirect:/mainMenu");
        setSuccessView("uploadDisplay");
    }

    @ModelAttribute
    @RequestMapping(method = RequestMethod.GET)
    public FileUpload showForm() {
        return new FileUpload();
    }

    @RequestMapping(method = RequestMethod.POST)
    public String onSubmit(FileUpload fileUpload, BindingResult errors, HttpServletRequest request)
            throws Exception {

        if (request.getParameter("cancel") != null) {
            return getCancelView();
        }

        if (validator != null) { // validator is null during testing
            validator.validate(fileUpload, errors);

            if (errors.hasErrors()) {
                return "fileupload";
            }
        }

        // validate a file was entered
        if (fileUpload.getFile().length == 0) {
            Object[] args =
                    new Object[]{getText("uploadForm.file", request.getLocale())};
            errors.rejectValue("file", "errors.required", args, "File");

            return "fileupload";
        }

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        CommonsMultipartFile file = (CommonsMultipartFile) multipartRequest.getFile("file");

        // the directory to upload to
        String uploadDir = getServletContext().getRealPath(com.galebo.lowyer.services.impl.Constants.uploadDir);

        // Create the directory if it doesn't exist
        File dirPath = new File(uploadDir);

        if (!dirPath.exists()) {
            dirPath.mkdirs();
        }

        //retrieve the file data
        InputStream stream = file.getInputStream();
        String format = UtilsCommon.sdf_yyyyMMddhhmmssSSS.format(new Date());
        //write the file to the file specified
        String name = file.getOriginalFilename();
		String newName = getCurrentUser(request)+format+name.substring(name.lastIndexOf("."));
		newName=newName.replaceAll(".jsp", "").replaceAll(".ftl", "");
        OutputStream bos = new FileOutputStream(uploadDir+Constants.FILE_SEP  + newName);
        int bytesRead;
        byte[] buffer = new byte[8192];

        while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
            bos.write(buffer, 0, bytesRead);
        }

        bos.close();

        //close the stream
        stream.close();

        String address = request.getContextPath() + com.galebo.lowyer.services.impl.Constants.uploadDir + "/" + newName;
        String location = dirPath.getAbsolutePath() + Constants.FILE_SEP + file.getOriginalFilename();
        // place the data into the request for retrieval on next page
        request.setAttribute("friendlyName", newName);
        request.setAttribute("fileName", file.getOriginalFilename());
        request.setAttribute("contentType", file.getContentType());
        request.setAttribute("size", file.getSize() + " bytes");
        request.setAttribute("location", address);
		request.setAttribute("link",address);

        ConUploadData bean=new ConUploadData();
		bean.setAddress(address);
		bean.setLocation(location);
        bean.setName(file.getOriginalFilename());
        bean.setNewName(fileUpload.getName());
        bean.setSize( file.getSize());
        bean.setType(file.getContentType());
        bean.setUpdateTime(new Date());
        bean.setUserId(getCurrentUser(multipartRequest));
        commonService.getQueryDao().getConUploadDataDao().save(bean);

        return getSuccessView_Html_Ajax(request,"/fileUploadSuccess");
    }

}
