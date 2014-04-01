package com.galebo.lowyer.services.mock;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.galebo.lowyer.bean.Common;
import com.galebo.lowyer.bean.Detail;
import com.galebo.lowyer.bean.Index;
import com.galebo.lowyer.bean.Item;
import com.galebo.lowyer.bean.Menu;
import com.galebo.lowyer.bean.common.UrlNameAuthor;
import com.galebo.lowyer.bean.common.UrlNameAuthorHtml;
import com.galebo.lowyer.services.impl.Constants;

public class BeanCreator {

	public Item getContentList(int count)
	{
		Item item=new Item();
		item.setName("title");
		item.setType(Constants.columnType_normal_3CA);
		item.setContents(getUrlNameList("二手房合同签订前和签订时需特别注意事项","一般情况下不能，因为房屋的权属以不动产登记本记载的为准，也就是以。",count));
		return item;
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
		System.out.println(menus.size());
		return index;
	}
	
	public Common getCommon(){
		Common common = new Common();
		common.setMenuList(getMenu(false));
		Item defaultItem = getItem();
		common.setDefaultItem(defaultItem);
		return common;
	}
	public Item getItem() {
		Item defaultItem = new Item();
		ArrayList<UrlNameAuthor> contents = new ArrayList<UrlNameAuthor>();
		for (int i = 0; i < 10; i++) {
			UrlNameAuthor e = new UrlNameAuthor("", "执行预案威力大 快速执结效果好");
			e.setUpdateTime(new Date());
			contents.add(e);
		}
		defaultItem.setContents(contents);
		defaultItem.setName("刑罚分类");
		defaultItem.setUrl("#");
		return defaultItem;
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
	public Detail getDetail() {
		Detail detail=new Detail();
		UrlNameAuthorHtml content = getContent("1");
		detail.setContent(content);
		content.setPre(getContent("2") );
		content.setNext(getContent("3"));
		content.setUpdateTime(new Date());
		
		detail.setItem(getItem());
		
		detail.setParentItems(getItemSimpleName());
		return detail;
	}

	private List<Item> getItemSimpleName() {
		ArrayList<Item> parentItems = new ArrayList<Item>();
		for (int i = 0; i < 10; i++) {
			Item e = new Item();
			e.setName("刑罚分类"+i);
			parentItems.add(e);
		}
		return parentItems;
	}
	private UrlNameAuthorHtml getContent(String ddd) {
		UrlNameAuthorHtml content = new UrlNameAuthorHtml();
		content.setAuthor("作者");
		try {
			content.setHtml(IOUtils.toString(new FileInputStream("E:/workspace/git/LeeCMS/leecms/content.txt")));
		} catch (Exception e) {
			e.printStackTrace();
		}
		content.setUrl("#");
		content.setName(" 加强侦查监督能力建设"+ddd);
		return content;
	}
}
