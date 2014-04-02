package com.galebo.lowyer.bean;

import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.galebo.lowyer.bean.common.UrlNameAuthor;

public class Item {
	Long id;
	String name;
	String type;
	String url;
	List<UrlNameAuthor> Contents;
	Page page;
	String contentIds;
	String pageJson;
	String contentsJson;
	boolean hasSon;
	List<Item> brotherItems;
	List<Item> sonItems;
	long level;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public boolean isHasSon() {
		return hasSon;
	}
	public void setHasSon(boolean hasSon) {
		this.hasSon = hasSon;
	}
	public String getContentsJson() {
		if(contentsJson==null||contentsJson.length()==0){
			return "[]";
		}
		return contentsJson;
	}
	public String getPageJson() {
		return JSONObject.fromBean(page).toString();
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContentIds() {
		return contentIds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<UrlNameAuthor> getContents() {
		return Contents;
	}
	public void setContents(List<UrlNameAuthor> contents) {
		Contents = contents;
		contentIds="-9999";
		for (Iterator<UrlNameAuthor> iterator = contents.iterator(); iterator.hasNext();) {
			UrlNameAuthor one = iterator.next();
			contentIds=contentIds+","+one.getContentId();
		}
		page=new Page(getContents().size(),1);
		contentsJson=JSONArray.fromCollection(contents).toString();
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public List<Item> getBrotherItems() {
		return brotherItems;
	}
	public void setBrotherItems(List<Item> brotherItems) {
		this.brotherItems = brotherItems;
	}
	public List<Item> getSonItems() {
		return sonItems;
	}
	public void setSonItems(List<Item> sonItems) {
		this.sonItems = sonItems;
	}
	public long getLevel() {
		return level;
	}
	public void setLevel(long level) {
		this.level = level;
	}
}
