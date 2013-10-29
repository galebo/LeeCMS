package com.galebo.lowyer.bean.common;

import com.galebo.lowyer.services.impl.Constants;

public class UrlNameAuthorHtml extends UrlNameAuthor{
	public UrlNameAuthorHtml(String url, String name) {
		super();
		this.url = url;
		this.name = name;
	}
	public UrlNameAuthorHtml() {
	}
	String html;
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}

	static final public UrlNameAuthorHtml init=new UrlNameAuthorHtml(Constants.url,"");
	UrlNameAuthorHtml pre=UrlNameAuthorHtml.init;
	UrlNameAuthorHtml next=UrlNameAuthorHtml.init;
	public UrlNameAuthorHtml getPre() {
		return pre;
	}
	public void setPre(UrlNameAuthorHtml pre) {
		if(pre==null)
			return;
		this.pre = pre;
	}
	public UrlNameAuthorHtml getNext() {
		return next;
	}
	public void setNext(UrlNameAuthorHtml next) {
		if(next==null)
			return;
		this.next = next;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
}
