package com.galebo.lowyer.bean.common;

import java.util.List;

import net.sf.json.JSONArray;


public class Group {
	List<UrlNameImg> sons;
	String name;

	String json;
	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public String getName() {
		return name;
	}

	public void setName(String title) {
		this.name = title;
	}

	public List<UrlNameImg> getSons() {
		return sons;
	}

	public void setSons(List<UrlNameImg> sons) {
		this.sons = sons;
		setJson(JSONArray.fromCollection(sons).toString());
	}
}
