package com.galebo.lowyer.services.impl;

import com.galebo.lowyer.services.impl.Constants;


public class Url {
	private static final String SS = "ss";
	Url son=null;
	boolean isChangeUpload =false;
	/*
	 * 用户访问的路径
	 */
	private String baseUrl="";
	/*
	 * 用户生成静态文件的路径
	 */
	private String saveBaseUrl="";
	public String getBaseUrl() {
		return baseUrl;
	}
	
	public void setSaveBaseUrl(String saveBaseUrl) {
		this.saveBaseUrl = saveBaseUrl;
		if(son!=null)
			son.setBaseUrl(saveBaseUrl);
	}
	public void setBaseUrl(String baseUrl){
		this.baseUrl=baseUrl;
		if(son!=null)
			son.setBaseUrl(baseUrl);
	}

	public  String getIndexUrl() {
		return this.baseUrl+"index/1.html";
	}
	public  String getSearchUrl() {
		return this.baseUrl+"search/";
	}
	public  String getItemUrl(Long long1) {
		return this.baseUrl+(son==null?SS:"")+"item/"+long1+".html";
	}
	public  String getDetailUrl(Long long1) {
		return this.baseUrl+(son==null?SS:"")+"detail/"+long1+".html";
	}
	public  String getDetailNoTitleUrl(Long long1) {
		return this.baseUrl+(son==null?SS:"")+"detail2/"+long1+".html";
	}
	public String getIndexSearch(String key1, String key2) {
		return this.baseUrl+(son==null?SS:"")+"indexSearch/"+key1+"-"+key2+".html";
	}
	/*
	 * 用户生成静态文件的路径
	 */
	public  String getSaveIndexUrl() {
		return this.saveBaseUrl+"index/1.html";
	}
	public  String getSaveItemUrl(Long long1) {
		return this.saveBaseUrl+(son==null?SS:"")+"item/"+long1+".html";
	}
	public  String getSaveDetailUrl(Long long1) {
		return this.saveBaseUrl+(son==null?SS:"")+"detail/"+long1+".html";
	}
	public  String getSaveDetailNoTitleUrl(Long long1) {
		return this.saveBaseUrl+(son==null?SS:"")+"detail2/"+long1+".html";
	}
	public String getSaveIndexSearch() {
		return this.saveBaseUrl+(son==null?SS:"")+"indexSearch/111.html";
	}
	
	public String getLinkUrl(String in)
	{
		if(in.indexOf("${content}")>-1)
			return getDetailUrl(Long.valueOf(in.substring(11)));
		if(in.indexOf("${column}")>-1)
			return getItemUrl(Long.valueOf(in.substring(10)));
		if(in.indexOf("${scontent}")>-1)
			return getDetailUrl(Long.valueOf(in.substring(12)));
		if(in.indexOf("${scolumn}")>-1)
			return getItemUrl(Long.valueOf(in.substring(11)));
		else return in;
	}

	public void setChangeUpload() {
		this.isChangeUpload = true;
	}
	public void setNoChangeUpload() {
		this.isChangeUpload = false;
	}

	public String getImgUrl(String in)
	{
		if(isChangeUpload) {
			return in.replaceAll(Constants.uploadDir,Constants.exportUploadDir);
		} else
			return in.replaceAll(Constants.uploadDir,Constants.uploadDirNew);
	}

	public Url getSon() {
		return son;
	}

	public void setSon(Url son) {
		this.son = son;
	}
	public static Url getUrl() {
		Url url=new Url();
		url.setSon(new Url());
		return url;
	}

}
