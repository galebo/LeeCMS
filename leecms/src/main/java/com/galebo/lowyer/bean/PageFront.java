package com.galebo.lowyer.bean;

public class PageFront {
	int pageSize;
	int totalPage;
	int currentPage;
	int count;
	public PageFront(int pageSize,int count,int currentPage){
		this.pageSize=pageSize;
		this.count=count;
		this.currentPage=currentPage;
		this.totalPage=(count+pageSize-1)/pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public int getCount() {
		return count;
	}
}
