package com.galebo.lowyer.dao.ibatis;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.galebo.common.dao.SSIILL;
import com.galebo.lowyer.bean.NameKey1234;
import com.galebo.lowyer.bean.common.Define;
import com.galebo.lowyer.bean.common.IdCount;
import com.galebo.lowyer.dao.QueryDao;
import com.galebo.lowyer.model.CfgDefine;
import com.galebo.lowyer.model.CfgDefineInstance;
import com.galebo.lowyer.model.CfgGroup;
import com.galebo.lowyer.model.CfgRelative;
import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.model.ColColumnContent;
import com.galebo.lowyer.model.ConContent;
import com.galebo.lowyer.model.ConLink;
import com.galebo.lowyer.model.ConUploadData;
import com.galebo.lowyer.model.IndexMenu;
import com.galebo.lowyer.model.ProCategory;
import com.galebo.lowyer.model.ProCategoryProduct;
import com.galebo.lowyer.model.Template;
import com.galebo.lowyer.model.TemplatePage;
import com.galebo.lowyer.model.WebInfo;
import com.galebo.lowyer.services.impl.Constants;
@Service("queryDao")
public class QueryDaoImpl extends BaseDaoImpl implements QueryDao{
	@SuppressWarnings("unchecked")
	public List<ColColumnContent> getColumnContents(Long parentId,int page,int pageSize)
	{
		SSIILL create = SSIILL.create(null, null, null, null, parentId, null,pageSize,page);
		return (List<ColColumnContent>) sqlMapClientTemplate.queryForList("getColColumnContent_Page",create);
	}
	@SuppressWarnings("unchecked")
	public List<ProCategoryProduct> getCategoryProducts(long parentId, int page, int pageSize)
	{
		SSIILL create = SSIILL.create(null, null, null, null, parentId, null,pageSize,page);
		return (List<ProCategoryProduct>) sqlMapClientTemplate.queryForList("getProCategoryProduct_Page",create);
	}
	public int getContentsSize(Long parentId)
	{
		SSIILL create = SSIILL.create(null, null, null, null, parentId, null);
		return (Integer) sqlMapClientTemplate.queryForObject("getColColumnContent_PageSize",create);
	}
	public int getProductsSize(long parentId) {
		SSIILL create = SSIILL.create(null, null, null, null, parentId, null);
		return (Integer) sqlMapClientTemplate.queryForObject("getProCategoryProduct_PageSize",create);
	}
	@SuppressWarnings("unchecked")
	public List<ColColumnContent> getColumnContentsByColumnId(Long columnId)
	{
		return (List<ColColumnContent>) sqlMapClientTemplate.queryForList("getColColumnContentByColumnId",columnId);
	}

	@SuppressWarnings("unchecked")
	public List<ColColumnContent> getColumnContents(Long userId) {
		return (List<ColColumnContent>) sqlMapClientTemplate.queryForList("getColumnContentsByUserId",userId);
	}
	@SuppressWarnings("unchecked")
	public Map<Long,ColColumnContent> getColumnContentsMap(Long userId)
	{
		return (Map<Long,ColColumnContent>) sqlMapClientTemplate.queryForMap("getColumnContentsByUserId",userId,"columnContentId");
	}
	@SuppressWarnings("unchecked")
	public Map<Long,ConContent> getContentsMap(Long userId)
	{
		return (Map<Long,ConContent>) sqlMapClientTemplate.queryForMap("getContentsByUserId",userId,"contentId");
	}
	@SuppressWarnings("unchecked")
	public Map<Long, ConContent> getContentsMap_index(Long userId,Long columnId)
	{
		return (Map<Long,ConContent>) sqlMapClientTemplate.queryForMap("getContents_indexByUserId",SSIILL.create(null, null, null, null, userId,columnId),"contentId");
	}
	public ColColumnContent getColumnContent(Long columnContentId) {
		return (ColColumnContent) sqlMapClientTemplate.queryForList("getColColumnContent2",columnContentId);
	}
	@SuppressWarnings("unchecked")
	public List<ColColumn> getColColumnsByUserId(Long userId)
	{
		return (List<ColColumn>) sqlMapClientTemplate.queryForList("getColColumnsByUserId",SSIILL.create(Constants.columnType, null, null, null, userId, null));
	}
	public ColColumn getRootColumn(Long userId)
	{
		return (ColColumn)sqlMapClientTemplate.queryForObject("getColColumnRootByUserId",SSIILL.create(null, null, null, null, userId, null));
	}
	@SuppressWarnings("unchecked")
	public List<ColColumnContent> getColColumnContentSortByViewCount()
	{
		return (List<ColColumnContent>) sqlMapClientTemplate.queryForList("getColColumnContentSortByViewCount");
	}
	@SuppressWarnings("unchecked")
	public List<Long> getColumnsInIndex(long userId)
	{
		return (List<Long>)sqlMapClientTemplate.queryForList("getColumnsInIndex",SSIILL.create(null, null, null, null, userId, null));
	}
	@SuppressWarnings("unchecked")
	public List<ColColumn> getSonColumns(Long columnId,Long userId,String type)
	{
		return (List<ColColumn>)sqlMapClientTemplate.queryForList("getSonColumn",SSIILL.create(type,null, null, null, columnId, userId));
	}
	public Long getSonColumnSize(Long columnId,Long userId,String type)
	{
		return (Long)sqlMapClientTemplate.queryForObject("getSonColumnSize",SSIILL.create(type,null, null, null, columnId, userId) );
	}
	@SuppressWarnings("unchecked")
	public List<IndexMenu> getIndexMenus(Long userId)
	{
		return (List<IndexMenu>)sqlMapClientTemplate.queryForList("getIndexMenus",SSIILL.create(null,null, null, null, userId,null));
	}
	public Long getIndexMenusSize(Long userId)
	{
		return (Long)sqlMapClientTemplate.queryForObject("getIndexMenusSize",SSIILL.create(null,null, null, null, userId,null) );
	}
	@SuppressWarnings("unchecked")
	public List<ProCategory> getSonCategorys(Long columnId,Long userId,String type)
	{
		return (List<ProCategory>)sqlMapClientTemplate.queryForList("getSonCategory",SSIILL.create(type,null, null, null, columnId, userId));
	}
	public Long getSonCategorySize(Long columnId,Long userId,String type)
	{
		return (Long)sqlMapClientTemplate.queryForObject("getSonCategorySize",SSIILL.create(type,null, null, null, columnId, userId) );
	}
	@SuppressWarnings("unchecked")
	public List<ColColumn> getColumnsNoInIndex(Long userId,String type)
	{
		return (List<ColColumn>)sqlMapClientTemplate.queryForList("getColumnsNoInIndex",SSIILL.create(type, Constants.indexType, null, null, userId, null));
	}
	public int getColumnsNoInIndexSize(Long userId,String type)
	{
		return (Integer)sqlMapClientTemplate.queryForObject("getColumnsNoInIndexSize",SSIILL.create(type, Constants.indexType, null, null, userId, null) );
	}
	@SuppressWarnings("unchecked")
	public List<ConContent> getContentsNoInIndex(Long userId,String type)
	{
		return (List<ConContent>)sqlMapClientTemplate.queryForList("getContentsNoInIndex",SSIILL.create(type, Constants.indexType, null, null, userId, null));
	}
	public int getContentsNoInIndexSize(Long userId,String type)
	{
		return (Integer)sqlMapClientTemplate.queryForObject("getContentsNoInIndexSize",SSIILL.create(type, Constants.indexType, null, null, userId, null) );
	}
	public ColColumn getColumn(Long columnId)
	{
		return (ColColumn)sqlMapClientTemplate.queryForObject("getColColumn",columnId);
	}
	public String getColumnCfg(String type,Long userId)
	{
		return (String)sqlMapClientTemplate.queryForObject("selectColumnCfg",SSIILL.create(type, null, null, null, userId, null));
	}

	@SuppressWarnings("unchecked")
	public List<Define> getDivDefines(Long userId) {
		return (List<Define>)sqlMapClientTemplate.queryForList("getDefines",SSIILL.create(Constants.DivDefineType, null, null, null, userId, null));
	}
	@SuppressWarnings("unchecked")
	public Map<String,CfgDefineInstance> getSiteDefines(Long userId) {
		return (Map<String,CfgDefineInstance>)sqlMapClientTemplate.queryForMap("getDefines",SSIILL.create(Constants.SiteDefineType, null, null, null, userId, null),"title");
	}
	@SuppressWarnings("unchecked")
	public Map<String,CfgDefineInstance> getGlobalDefines() {
		return (Map<String,CfgDefineInstance>)sqlMapClientTemplate.queryForMap("getDefines",SSIILL.create(Constants.GlobalDefineType, null, null, null, -1L, null),"title");
	}
	@SuppressWarnings("unchecked")
	public List<ConLink> getLinks(String type,Long userId) {
		return (List<ConLink>)sqlMapClientTemplate.queryForList("getConLinksByType",SSIILL.create(type, null, null, null, null, userId));
	}
	@SuppressWarnings("unchecked")
	public List<ConLink> getSonLinksNoSelect(Long parentId,Long userId,String type, int page, int pageSize)
	{
		SSIILL create = SSIILL.create(type, null, null, null, parentId, userId,pageSize,page);
		return (List<ConLink>)sqlMapClientTemplate.queryForList("getConLinksNoSelect",create);
	}
	public int getSonLinksNoSelectSize(long parentId, Long userId, String type)
	{
		return (Integer)sqlMapClientTemplate.queryForObject("getConLinksNoSelectSize",SSIILL.create(type, null, null, null, parentId, userId));
	}
	@SuppressWarnings("unchecked")
	public List<ConLink> getSonLinks(Long parentId,Long userId,String type, int page, int pageSize)
	{
		SSIILL create = SSIILL.create(type, null, null, null, parentId, userId,pageSize,page);
		return (List<ConLink>)sqlMapClientTemplate.queryForList("getConLinksByParentId",create);
	}
	public int getSonLinksSize(Long parentId,Long userId,String type)
	{
		return (Integer)sqlMapClientTemplate.queryForObject("getConLinksByParentIdSize",SSIILL.create(type, null, null, null, parentId, userId));
	}
	@SuppressWarnings("unchecked")
	public List<CfgGroup> getGroup(String type,Long userId){
		return (List<CfgGroup>)sqlMapClientTemplate.queryForList("getCfgGroupsByType",SSIILL.create(type, null, null, null, userId,null));
	}
	@SuppressWarnings("unchecked")
	public List<TemplatePage> getTemplatePage(Long userId) {
		return sqlMapClientTemplate.queryForList("getTemplatePagesByUserId",userId);
	}
	@SuppressWarnings("unchecked")
	public List<ConLink> getConLinksGroup(Long userId, String linktype) {
		return sqlMapClientTemplate.queryForList("getConLinksGroup",SSIILL.create(linktype, null, null, null, userId, null));
	}

	public boolean isColumnUsed(Long columnId)
	{
		Long a=(Long)sqlMapClientTemplate.queryForObject("isColumnUsed",columnId);
		return a>0;
	}
	public boolean isTemplateExist(Long templateId,Long templateCssId)
	{
		return sqlMapClientTemplate.queryForList("isTemplateExist",SSIILL.create(null, null, null, null, templateId,templateCssId)).size()>0;
	}
	public boolean isGroupExist(String type,String key,Long userId)
	{
		return sqlMapClientTemplate.queryForList("getCfgGroupsByTypeKey",SSIILL.create(type, key, null, null, userId,null)).size()>0;
	}

	public WebInfo getWebInfoByDomain(String name) {
		return (WebInfo) sqlMapClientTemplate.queryForObject("getWebInfoByDomain",name);
	}

	public Template getTemplateByUserId(Long currentUser) {
		return (Template)sqlMapClientTemplate.queryForObject("getTemplateByUserId",currentUser);
	}

	@SuppressWarnings("unchecked")
	public List<IdCount> getContentCount(String replaceAll) {
		return sqlMapClientTemplate.queryForList("getContentCount",replaceAll);
	}

	public IdCount getWebCount(Long userId) {
		return (IdCount)sqlMapClientTemplate.queryForObject("getWebCount",userId);
	}
	public Long getCfgGroupsByUserIdSize(Long userId, String type) {
		return (Long)sqlMapClientTemplate.queryForObject("getCfgGroupsByUserIdSize",SSIILL.create(type, null, null, null, userId, null));
	}

	@SuppressWarnings("unchecked")
	public List<CfgDefine> getCfgDefinesByUserId(Long userId) {
		return sqlMapClientTemplate.queryForList("getCfgDefines1",userId);
	}


	@SuppressWarnings("unchecked")
	public List<CfgDefine> getCfgDefines() {
		List<CfgDefine> cfgDefines = sqlMapClientTemplate.queryForList("getCfgDefines");
		return cfgDefines;
	}


	@SuppressWarnings("unchecked")
	public List<CfgDefineInstance> getSiteDefineWithName(Long userId) {
		return sqlMapClientTemplate.queryForList("getSiteDefineWithName",SSIILL.create(Constants.SiteDefineType, null, null, null, userId, null));
	}

	@SuppressWarnings("unchecked")
	public List<CfgGroup> getCfgGroupsByUserId(Long userId, String type) {
		return sqlMapClientTemplate.queryForList("getCfgGroupsByUserId",SSIILL.create(type, null, null, null, userId, null));
	}

	@SuppressWarnings("unchecked")
	public List<ConContent> getConContentsByUserId(Long userId) {
		return sqlMapClientTemplate.queryForList("getConContentsByUserId",userId);
	}

	@SuppressWarnings("unchecked")
	public List<ConUploadData> getConUploadDatasByUserId(Long userId) {
		return sqlMapClientTemplate.queryForList("getConUploadDatasByUserId",userId);
	}

	@SuppressWarnings("unchecked")
	public List<CfgRelative> getRelativeMaxSort(String type, Long groupId) {
		return (List<CfgRelative>)sqlMapClientTemplate.queryForList("getRelativeMaxSort",SSIILL.create(type, null, null, null, groupId, null));
	}

	public WebInfo getWebInfoByUserId(Long userId) {
		return (WebInfo) sqlMapClientTemplate.queryForObject("getWebInfoByUserId",userId);
	}
	@SuppressWarnings("unchecked")
	public List<ConContent> getContentsByIndex(String key1, String key2) {
		return (List<ConContent> ) sqlMapClientTemplate.queryForList("getContentsByIndex",SSIILL.create(key1, key2, null, null, null, null));
	}
	@SuppressWarnings("unchecked")
	public List<NameKey1234> getIndexSearchData(Long userId,Long columnId) {
		return (List<NameKey1234>) sqlMapClientTemplate.queryForList("getNameKey",SSIILL.create(null, null, null, null, userId, columnId));
	}
	@SuppressWarnings("unchecked")
	public List<NameKey1234> getIndexSearchDataNotIn(Long userId,Long columnId) {
		return (List<NameKey1234>) sqlMapClientTemplate.queryForList("getNameKeyNotIn",SSIILL.create(null, null, null, null, userId, columnId));
	}
	@SuppressWarnings("unchecked")
	public List<ConContent> getContentsNoBang(Long parentId,Long userId, int page, int pageSize) {
		return (List<ConContent>)sqlMapClientTemplate.queryForList("getContentsNoBang",SSIILL.create(null, null, null, null, userId, parentId));
	}
	public int getContentsNoBangSize(Long parentId,Long userId) {
		return (Integer)sqlMapClientTemplate.queryForObject("getContentsNoBangSize",SSIILL.create(null, null, null, null, userId, parentId) );
	}
}
