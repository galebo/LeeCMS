package com.galebo.lowyer.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Service;

import com.galebo.lowyer.bean.Common;
import com.galebo.lowyer.bean.Detail;
import com.galebo.lowyer.bean.Index;
import com.galebo.lowyer.bean.IndexSearch;
import com.galebo.lowyer.bean.Item;
import com.galebo.lowyer.bean.Menu;
import com.galebo.lowyer.bean.NameKey1234;
import com.galebo.lowyer.bean.common.UrlNameAuthor;
import com.galebo.lowyer.bean.common.UrlNameAuthorHtml;
import com.galebo.lowyer.bean.common.UrlNameImg;
import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.model.ColColumnContent;
import com.galebo.lowyer.model.ConContent;
import com.galebo.lowyer.model.ConLink;
import com.galebo.lowyer.model.IndexMenu;
import com.galebo.lowyer.model.LabelValue;
import com.galebo.lowyer.model.Template;
import com.galebo.lowyer.services.BeanCreater;
@Service("BeanCreater")
public class BeanCreator2 extends BaseService implements BeanCreater {
    protected final Log log = LogFactory.getLog(getClass());
    
	public Common getCommon(Long userId,Long parentUserId,Url url)
	{
		Common common=null;
		if(parentUserId==null)
		{
			common=getCommon(userId,url);
		}
		else
		{
			common=getCommon(parentUserId,url);
			common.setSonCommon(getCommon(userId, url.getSon()));
		}
		return common;
	}
	private Common getCommon(Long userId,Url url)
	{
		String key = ""+userId+"_"+url.getBaseUrl();
		Common common = CmsMap.cmsMap.getCommonMap().get(key);
		if(common==null)
		{
			log.info(key+"创建common开始");
			common = create(userId,url);
			CmsMap.cmsMap.getCommonMap().put(key, common);
			log.info(key+"创建common结束");
		}
		return common;
	}
	private Common create(Long userId,Url url) {
		Common common;
		common=new Common();
		{
			Map<Long, ConContent> contentsMap = queryDao.getContentsMap(userId);
			common.setSimilar(Convertor.convert(url, contentsMap));
			Map<Long, ConContent> contentsMap_index = queryDao.getContentsMap_index(userId, 322L);
			common.setContents_IndexSearch(Convertor.convert(url, contentsMap_index));
			
			contentsMap.putAll( contentsMap_index);
			common.setContentIdMap(contentsMap);
			
			List<NameKey1234> indexSearchData = queryDao.getIndexSearchData(userId, 322L);
			common.setIndexSearchData(indexSearchData);
			Map<Long,List<ColColumn>> columnPidMap=common.getColumnPidMap();

			common.setColumns(queryDao.getColColumnsByUserId(userId));
			for (ColColumn colColumn : common.getColumns()) {
				if(columnPidMap.get(colColumn.getColPid())==null)
				{
					List<ColColumn> list=new ArrayList<ColColumn>();
					columnPidMap.put(colColumn.getColPid(), list);
				}
				columnPidMap.get(colColumn.getColPid()).add(colColumn);
				if(colColumn.getColPid()!=null&&colColumn.getColPid()==-1)
					common.setRootColumn(colColumn);
				else
					common.setDefaultColumn(colColumn);

			}
			initIdMap(columnPidMap, common.getRootColumn(),common.getColumnIdMap(),0);
			
			common.setColumnContentMap(queryDao.getColumnContentsMap(userId));

			
			//组合兄弟子栏目
			for (ColColumn colColumn : common.getColumns()) {
				if(colColumn.getColPid()!=-1) {
					List<ColColumn> list = common.getColumnPidMap().get(colColumn.getColPid());
					common.getColumnId_brotherColumnsMap().put(colColumn.getColumnId(),list);
				}
			}
			//组合栏目id与内容map
			for (ColColumn colColumn : common.getColumns()) {
				if(colColumn.getColPid()!=-1)
					common.getItemIdList().add(getItem2(colColumn.getColumnId(), url, common));
			}
		}
		{
			List<IndexMenu> indexMenus = queryDao.getIndexBeans(userId,Constants.indexMenuType);
			common.setMenuList(getMenu(indexMenus,url,common));
//				common.setMenuList(getMenu(common.getRootColumn(),url));
		}
		
		{
			List<ConLink> links = queryDao.getConLinksGroup(userId, Constants.linkType);
			common.setLinks(Convertor.convert(links,url));
			common.setGroupLinks(Convertor.convert2Map(links,url));

			List<ConLink> loops = queryDao.getConLinksGroup(userId, Constants.loopType);
			common.setLoops(Convertor.convert(loops,url));
			common.setGroupLoops(Convertor.convert2Map(loops,url));
			
			common.setGlobalDefine(Convertor.convert(queryDao.getGlobalDefines(),""));
			common.setSiteDefine(Convertor.convert(queryDao.getSiteDefines(userId),common.getGlobalDefine().get("imgSite")));
			common.setDivDefines(queryDao.getDivDefines(userId));
			UrlNameImg homePage=new UrlNameImg();
			homePage.setName(common.getSiteDefine().get("homePage")==null?"网站首页":common.getSiteDefine().get("homePage"));
			homePage.setUrl(url.getIndexUrl());
			common.setHomePage(homePage);
			UrlNameImg searchPage=new UrlNameImg();
			searchPage.setName(common.getSiteDefine().get("search")==null?"搜索":common.getSiteDefine().get("search"));
			searchPage.setUrl(url.getSearchUrl());
			common.setSearchPage(searchPage);
		}
		common.setDefaultItem(createItem(common.getDefaultColumn().getColumnId(), url, common));

		
		return common;
	}


	private void initIdMap(Map<Long, List<ColColumn>> parentIdMap, ColColumn parent, Map<Long, ColColumn> idMap,long level) {
		if(parent==null)
			return;
		List<ColColumn> sonColumn = parentIdMap.get(parent.getColumnId());
		if(sonColumn!=null)
			parent.setSonColumn(sonColumn);
		for (ColColumn son: parent.getSonColumn()) {
			son.setLevel(level);
			log.debug(son.getColName()+","+level);
			idMap.put(son.getColumnId(), son);
			initIdMap(parentIdMap,son,idMap,level+1);
		}
	}
	public Index getIndex(Url url,Common common)
	{
		Index index=new Index();
		return index;
	}
	public Item getItem2(Long itemId, Url url,Common common)
	{
		Item item2 = _getItem2InMap(itemId, url, common);
		return item2;
	}

	public Detail getDetail(Long columnContentId, Url url,Common common) {
		Detail detail = _getDetailInMap(columnContentId, url, common);
		return detail;
	}
	public Detail getDetail2(Long contentId, Url url,Common common) {
		Detail detail = _getContentInMap(contentId, url, common);
		return detail;
	}
	private Item _getItem2InMap(Long itemId, Url url,Common common)
	{
		String key = ""+itemId+"_"+url.getBaseUrl();
		Item item = CmsMap.cmsMap.getItemMap().get(key);
		if(item==null)
		{
			log.debug("item no in Map");
			item = createItem(itemId,url,common);
			CmsMap.cmsMap.getItemMap().put(key, item);
		}
		return item;
	}
	private Detail _getDetailInMap(Long columnContentId, Url url,Common common) {
		String key = ""+columnContentId+"_"+url.getBaseUrl();
		Detail detail = CmsMap.cmsMap.getDetailMap().get(key);
		if(detail==null)
		{
			log.debug("detail no in Map");
			detail=createDetail(columnContentId,url,common);
			CmsMap.cmsMap.getDetailMap().put(key, detail);
		}
		return detail;
	}
	private Detail _getContentInMap(Long contentId, Url url,Common common) {
		String key = ""+contentId+"_"+url.getBaseUrl();
		Detail detail = CmsMap.cmsMap.getContentMap().get(key);
		if(detail==null)
		{
			log.debug("content no in Map");
			detail=createContent(contentId,url,common);
			CmsMap.cmsMap.getContentMap().put(key, detail);
		}
		return detail;
	}
	private Item createItem(Long itemId,Url url,Common common) {
		ColColumn column = common.getColumnIdMap().get(itemId);
		Item item2=new Item();
		List<UrlNameAuthor> contents = getContents(column.getColumnId(),url);

		item2.setId(column.getColumnId());
		item2.setContents(contents);
		item2.setUrl(url.getItemUrl(column.getColumnId()));
		item2.setName(column.getColName());
		item2.setHasSon(column.getSonColumn().size()>0);
		item2.setSonItems(createSimpleItem(column.getSonColumn(),url,common));
		item2.setBrotherItems(createSimpleItem(common.getColumnId_brotherColumnsMap().get(column.getColumnId()),url,common));
		item2.setLevel(column.getLevel());
		return item2;
	}

	private List<Item> createSimpleItem(List<ColColumn> list,Url url,Common common) {
		List<Item> a=new ArrayList<Item>();
		for (ColColumn column : list) {
			Item item2=new Item();
			item2.setId(column.getColumnId());
			item2.setUrl(url.getItemUrl(column.getColumnId()));
			item2.setName(column.getColName());
			item2.setContents(getContents(column.getColumnId(),url));
			a.add(item2);
		}
		return a;
	}
	private Detail createContent(Long contentId,Url url,Common common) {
		ConContent bean = common.getContentIdMap().get(contentId);
		Detail detail=new Detail();
		
		detail.setSimilar(common.getSimilar());
		detail.setContent(Convertor.convert(bean,url));

		return detail;
	}
	private Detail createDetail(Long columnContentId,Url url,Common common) {
		ColColumnContent columnContent = common.getColumnContentMap().get(columnContentId);
		ColColumnContent pre = common.getColumnContentMap().get(columnContent.getPreId());
		ColColumnContent next =  common.getColumnContentMap().get(columnContent.getNextId());
		Detail detail=new Detail();
		detail.setItem(_getItem2InMap(columnContent.getColColumn().getColumnId(),url,common));
		detail.setContent(Convertor.convert(columnContent,pre,next,url));

		ColColumn column=common.getColumnIdMap().get(columnContent.getColColumn().getColumnId());
		ColColumn parentColumn=common.getColumnIdMap().get(column.getColPid());


		if(parentColumn==null)
			detail.setSimilar(getContents(columnContent.getColColumn().getColumnId(), url));
		else
		{
			List<ColColumn> brotherColumn = common.getColumnPidMap().get(column.getColPid());
			List<Item> brotherItems=new ArrayList<Item>();
			for (ColColumn item2 : brotherColumn) {
				brotherItems.add(createItem(item2.getColumnId(), url, common));
			}
			for (Item item2 : brotherItems) {
				if(item2.getBrotherItems()==null)
					item2.setBrotherItems(brotherItems);
			}
			detail.setParentItems(brotherItems);
		}
		return detail;
	}

	public Item getSearchItem(List<UrlNameAuthorHtml> contents,String key,Url url,Common common) {
		Item item2=new Item();

		item2.setId(-1L);
//		item2.setContents(contents);lyz
		item2.setUrl("#");
		item2.setName("搜索\""+key+"\"结果,共"+contents.size()+"条");
		return item2;
	}
	/*
	 * 组合菜单
	 */
	@SuppressWarnings("unused")
	private List<Menu> getMenu(ColColumn parentColumns,Url url,Common common) {
		List<Menu> menus=new ArrayList<Menu>();
		if(parentColumns!=null)
		{
			for (ColColumn sonColumn:parentColumns.getSonColumn()) {
				Menu menu = new Menu();
				menu.setName(sonColumn.getColName());
				menu.setUrl(url.getItemUrl(sonColumn.getColumnId()));
				menu.setId(sonColumn.getColumnId());
				menu.setSonMenus(getMenu(sonColumn,url,common));
				menus.add(menu);
			}
		}
		return menus;
	}

	private List<Menu> getMenu(List<IndexMenu> indexMenus, Url url,Common common) {

		List<Menu> menus=new ArrayList<Menu>();
		for (IndexMenu sonColumn:indexMenus) {
			Menu menu = new Menu();
			menu.setName(sonColumn.getName());
			if(sonColumn.getType().equals("栏目"))
				menu.setUrl(url.getItemUrl(sonColumn.getId()));
			else if(sonColumn.getType().equals("链接"))
			{
				ConLink conLink = queryDao.getConLinkDao().get(sonColumn.getId());
				menu.setUrl(conLink.getUrl());
			}
			else
				menu.setUrl(url.getDetailNoTitleUrl(sonColumn.getId()));
			menu.setId(sonColumn.getId());
			menu.setSonMenus(new ArrayList<Menu>());
			menus.add(menu);
		}
		return menus;
	}

	/*
	 * 获取栏目下面的内容
	 */
	private List<UrlNameAuthor> getContents(Long columnId,	Url url) {
		List<ColColumnContent> list = queryDao.getColumnContentsByColumnId(columnId);
		List<UrlNameAuthor> Contents=new ArrayList<UrlNameAuthor>();

		for (int i = 0; i < list.size(); i++) {
			if(list.size()==1)
				Contents.add(Convertor.convert_UrlNameAuthor(list.get(i),url));
			else if(i==0)
				Contents.add(Convertor.convert_UrlNameAuthor(list.get(i),url));
			else if(i == (list.size()-1))
				Contents.add(Convertor.convert_UrlNameAuthor(list.get(i), url));
			else
				Contents.add(Convertor.convert_UrlNameAuthor(list.get(i),url));
		}
		return Contents;
	}


	public List<Template> getTemplateAll() {
		return queryDao.getTemplateDao().getAll();
	}
	public Template getUserTemplate(long userId) {
		return queryDao.getTemplateByUserId(userId);
	}
	public IndexSearch getIndeSearch(Url url, Common common) {
		IndexSearch indexSearch = new IndexSearch();
		Map<String,List<UrlNameAuthor>> sons=new HashMap<String, List<UrlNameAuthor>>();
		
		for (LabelValue _key1 : IndexSearch._key1) {
			for (LabelValue _key2 : IndexSearch._key2) {
				sons.put(_key1.getLabel()+"_"+_key2.getLabel(), new ArrayList<UrlNameAuthor>());
			}
		}
		
		for (NameKey1234 nameKey1234 : common.getIndexSearchData()) {
			UrlNameAuthorHtml convert = Convertor.convert(common.getContentIdMap().get(nameKey1234.getId()),url);
			sons.get(nameKey1234.getKey1()+"_"+nameKey1234.getKey2()).add(convert);
			sons.get(nameKey1234.getKey1()+"_"+IndexSearch.ALL).add(convert);
			sons.get(IndexSearch.ALL+"_"+nameKey1234.getKey2()).add(convert);
			sons.get(IndexSearch.ALL+"_"+IndexSearch.ALL).add(convert);
		}
		indexSearch.setSons(sons);
		return indexSearch;
	}
}
