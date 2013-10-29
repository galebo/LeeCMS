package com.galebo.lowyer.services;

import java.util.ArrayList;
import java.util.List;

import com.galebo.lowyer.bean.Index;
import com.galebo.lowyer.bean.Item;
import com.galebo.lowyer.bean.Menu;
import com.galebo.lowyer.bean.common.UrlNameAuthor;

public class BeanCreator {

	public Item getContentList(int count)
	{
		Item contentList=new Item();
		contentList.setName("title");
		contentList.setContents(getUrlNameList("二手房合同签订前和签订时需特别注意事项","一般情况下不能，因为房屋的权属以不动产登记本记载的为准，也就是以。",count));
		return contentList;
	}
	public static List<UrlNameAuthor> getUrlNameList(String name,String url,int count) {
		List<UrlNameAuthor> Contents=new ArrayList<UrlNameAuthor>();
		for (int i = 0; i < count; i++) {
			UrlNameAuthor urlName = getUrlName(name, url, i);
			Contents.add(urlName);
		}
		return Contents;
	}
	static private UrlNameAuthor getUrlName(String name, String url, int i) {
		UrlNameAuthor urlName = new UrlNameAuthor();
		urlName.setName(name+i);
		urlName.setUrl(url);
		return urlName;
	}
	public Index getIndex()
	{
		Index index=new Index();
		List<Menu> menus = getMenu(true);
		return index;
	}
	private List<Menu> getMenu(boolean addSon) {
		List<Menu> menus=new ArrayList<Menu>();
		for (int i = 0; i < 5; i++) {
			Menu menu = new Menu();
			menu.setName("菜单"+i);
			menu.setUrl("");
			if(addSon)
				menu.setSonMenus(getMenu(false));
			menus.add(menu);
		}
		return menus;
	}
}
