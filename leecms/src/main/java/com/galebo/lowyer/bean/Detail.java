package com.galebo.lowyer.bean;

import java.util.List;

import com.galebo.lowyer.bean.common.UrlNameAuthor;
import com.galebo.lowyer.bean.common.UrlNameAuthorHtml;

public class Detail{
	UrlNameAuthorHtml content;
	boolean noTitle;

	public List<UrlNameAuthor> similar;
	Item item;
	List<Item> parentItems;
	public Item getItem() {
		return item;
	}

	public void setItem(Item item2) {
		this.item = item2;
	}

	public UrlNameAuthorHtml getContent() {
		return content;
	}

	public void setContent(UrlNameAuthorHtml content) {
		this.content = content;
	}

	public boolean isNoTitle() {
		return noTitle;
	}

	public void setNoTitle(boolean noTitle) {
		this.noTitle = noTitle;
	}

	public List<UrlNameAuthor> getSimilar() {
		return similar;
	}

	public void setSimilar(List<UrlNameAuthor> similar) {
		this.similar = similar;
	}

	public List<Item> getParentItems() {
		return parentItems;
	}

	public void setParentItems(List<Item> parentItems) {
		this.parentItems = parentItems;
	}
}
