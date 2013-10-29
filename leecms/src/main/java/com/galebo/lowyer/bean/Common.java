package com.galebo.lowyer.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.galebo.lowyer.bean.common.Define;
import com.galebo.lowyer.bean.common.Group;
import com.galebo.lowyer.bean.common.UrlNameAuthor;
import com.galebo.lowyer.bean.common.UrlNameImg;
import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.model.ColColumnContent;
import com.galebo.lowyer.model.ConContent;

public class Common {
	private List<Menu> menuList;
	private ColColumn defaultColumn;
	private ColColumn rootColumn;

	private List<ColColumn> columns;
	private Map<Long,List<ColColumn>> columnPidMap=new HashMap<Long,List<ColColumn>>();//父id挂接的子栏目
	private Map<Long,List<ColColumn>> columnId_brotherColumnsMap=new HashMap<Long,List<ColColumn>>();//id挂接的兄弟栏目
	private Map<Long,ColColumnContent> columnContentMap=new HashMap<Long,ColColumnContent>();
	private Map<Long,ColColumn> columnIdMap=new HashMap<Long,ColColumn>();
	private Map<Long,ConContent> contentIdMap=null;//直接菜单内容的内容
//	private Map<Long,ConContent> contentIdMap_Index=null;//索引的内容

	private Item defaultItem;//用于如果没有找到栏目的默认项
	private List<Item> itemIdList=new ArrayList<Item>();//用于全局的栏目List
	private List<NameKey1234> indexSearchData=null;
	private List<UrlNameAuthor> similar = null;
	private List<UrlNameAuthor> contents_IndexSearch = null;
	
	private List<UrlNameImg> links;
	private List<UrlNameImg> loops;
	private Map<String,Group> groupLinks;
	private Map<String,Group> groupLoops;

	private UrlNameImg homePage;
	private UrlNameImg searchPage;

	private List<Define> divDefines;
	private Map<String,String> globalDefine;
	private Map<String,String> siteDefine;
	private Map<String,String> defines=new HashMap<String,String>();

	private boolean isParentSonStyle;
	private Common sonCommon;

	public UrlNameImg getSearchPage() {
		return searchPage;
	}

	public void setSearchPage(UrlNameImg searchPage) {
		this.searchPage = searchPage;
	}


	public Map<Long, List<ColColumn>> getColumnPidMap() {
		return columnPidMap;
	}
	public Map<Long, ColColumn> getColumnIdMap() {
		return columnIdMap;
	}

	public List<ColColumn> getColumns() {
		return columns;
	}

	public void setColumns(List<ColColumn> columns) {
		this.columns = columns;
	}
	public ColColumn getDefaultColumn() {
		return defaultColumn;
	}

	public void setDefaultColumn(ColColumn columns) {
		this.defaultColumn = columns;
	}
	public List<UrlNameImg> getLoops() {
		return loops;
	}

	public void setLoops(List<UrlNameImg> loops) {
		this.loops = loops;
	}

	public Map<String, Group> getGroupLoops() {
		return groupLoops;
	}

	public void setGroupLoops(Map<String, Group> groupLoops) {
		this.groupLoops = groupLoops;
	}
	public Map<String, String> getDefines() {
		return defines;
	}

	public Map<String, String> getSiteDefine() {
		return siteDefine;
	}

	public void setSiteDefine(Map<String, String> siteDefine) {
		this.siteDefine = siteDefine;
	}

	public Map<String, String> getGlobalDefine() {
		return globalDefine;
	}

	public void setGlobalDefine(Map<String, String> globalDefine) {
		this.globalDefine = globalDefine;
	}

	public List<UrlNameImg> getLinks() {
		return links;
	}

	public void setLinks(List<UrlNameImg> links) {
		this.links = links;
	}

	public Map<String,Group> getGroupLinks() {
		return groupLinks;
	}

	public void setGroupLinks(Map<String,Group> groupLinks) {
		this.groupLinks = groupLinks;
	}
	public UrlNameImg getHomePage() {
		return homePage;
	}

	public void setHomePage(UrlNameImg homePage) {
		this.homePage = homePage;
	}

	public List<Menu> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<Menu> list) {
		this.menuList = list;
	}
	
	public List<Define> getDivDefines() {
		return divDefines;
	}

	public void setDivDefines(List<Define> divDefines) {
		this.divDefines = divDefines;
	}

	public Item getDefaultItem() {
		return defaultItem;
	}

	public void setDefaultItem(Item defaultItem) {
		this.defaultItem = defaultItem;
	}


	public ColColumn getRootColumn() {
		return rootColumn;
	}

	public void setRootColumn(ColColumn rootColumn) {
		this.rootColumn = rootColumn;
	}

	public Map<Long, ColColumnContent> getColumnContentMap() {
		return columnContentMap;
	}

	public void setColumnContentMap(Map<Long, ColColumnContent> columnContentMap) {
		this.columnContentMap = columnContentMap;
	}

	public Map<Long, ConContent> getContentIdMap() {
		return contentIdMap;
	}

	public void setContentIdMap(Map<Long, ConContent> contentIdMap) {
		this.contentIdMap = contentIdMap;
	}

	public List<UrlNameAuthor> getSimilar() {
		return similar;
	}

	public void setSimilar(List<UrlNameAuthor> similar) {
		this.similar = similar;
	}

	public boolean isParentSonStyle() {
		return isParentSonStyle;
	}

	public List<Item> getItemIdList() {
		return itemIdList;
	}

	public void setItemIdList(List<Item> itemIdList) {
		this.itemIdList = itemIdList;
	}

	public Common getSonCommon() {
		return sonCommon;
	}

	public void setSonCommon(Common sonCommon) {
		this.sonCommon = sonCommon;
		isParentSonStyle=true;
	}

	public List<NameKey1234> getIndexSearchData() {
		return indexSearchData;
	}

	public void setIndexSearchData(List<NameKey1234> indexSearchData) {
		this.indexSearchData = indexSearchData;
	}

	public List<UrlNameAuthor> getContents_IndexSearch() {
		return contents_IndexSearch;
	}

	public void setContents_IndexSearch(List<UrlNameAuthor> contentsIndexSearch) {
		contents_IndexSearch = contentsIndexSearch;
	}

	public Map<Long, List<ColColumn>> getColumnId_brotherColumnsMap() {
		return columnId_brotherColumnsMap;
	}

	public void setColumnId_brotherColumnsMap(Map<Long, List<ColColumn>> columnIdBrotherColumnsMap) {
		columnId_brotherColumnsMap = columnIdBrotherColumnsMap;
	}

}
