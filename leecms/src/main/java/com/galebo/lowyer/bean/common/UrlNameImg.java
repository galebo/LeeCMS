package com.galebo.lowyer.bean.common;

import com.galebo.lowyer.services.impl.Constants;

public class UrlNameImg {
	String url=Constants.url;
	String name="";
	String img=Constants.img;
	Long id;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
