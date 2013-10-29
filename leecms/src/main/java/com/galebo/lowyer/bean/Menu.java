package com.galebo.lowyer.bean;

import java.util.List;

import com.galebo.lowyer.bean.common.UrlNameImg;

public class Menu extends UrlNameImg{
	int sort;
	List<Menu> sonMenus;
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
	public List<Menu> getSonMenus() {
		return sonMenus;
	}
	public void setSonMenus(List<Menu> sonMenus) {
		this.sonMenus = sonMenus;
	}
}
