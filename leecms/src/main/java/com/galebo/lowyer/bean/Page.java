package com.galebo.lowyer.bean;


public class Page
{
	int total=0,pageNo=1;

	public int getTotal() {
		return total;
	}
	public int getPageNo() {
		return pageNo;
	}
	public Page(int _totals,int _pageNo)
	{
		total=_totals;
		pageNo=_pageNo;
	}
}