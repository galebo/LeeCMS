package com.galebo.lowyer.bean.common;

import java.util.List;

import net.sf.json.JSONArray;


public class Group {
	List<UrlNameImg> sons;
	String title;

	String json;
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<UrlNameImg> getSons() {
		return sons;
	}

	public void setSons(List<UrlNameImg> sons) {
		this.sons = sons;
		setJson(JSONArray.fromCollection(sons).toString());
	}
}
