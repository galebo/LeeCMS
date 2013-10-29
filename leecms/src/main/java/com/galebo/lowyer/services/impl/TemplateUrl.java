package com.galebo.lowyer.services.impl;

import com.galebo.lowyer.services.impl.Constants;


public class TemplateUrl {
	String realPath;
	private String staticPre;
	private Long templateId;
	private long cssId;
	private String uploadDir=Constants.uploadDir;
	private String dynamicBaseUrl="/dynamic";
	public String getUploadDir() {
		return uploadDir;
	}
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
	public Long getTemplateId() {
		return templateId;
	}
	public long getCssId() {
		return cssId;
	}
	public String getDynamicBaseUrl() {
		return dynamicBaseUrl;
	}
	public String getDynamicUrl() {
		return dynamicBaseUrl+"/template"+templateId;
	}
	public String getCommBase() {
		return staticPre;
	}
	public String getCommCssImageBase() {
		return staticPre+"/template"+templateId+"/"+"css/"+cssId;
	}
	public String getCommTBase() {
		return staticPre+"/template"+templateId;
	}
	public void set(Long templateId,long cssId,String staticPre,String realPath) {
		this.templateId = templateId;
		this.cssId = cssId;
		this.staticPre=staticPre;
		this.realPath=realPath;
	}
	public String getRealPath() {
		return realPath;
		
	}
}
