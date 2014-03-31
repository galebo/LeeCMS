package com.galebo.lowyer.dao;

import java.util.List;
import java.util.Map;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.galebo.lowyer.bean.NameKey1234;
import com.galebo.lowyer.bean.common.Define;
import com.galebo.lowyer.bean.common.IdCount;
import com.galebo.lowyer.dao.ibatis.GenericDaoiBatis;
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
import com.galebo.lowyer.model.ProProduct;
import com.galebo.lowyer.model.Role;
import com.galebo.lowyer.model.Template;
import com.galebo.lowyer.model.TemplatePage;
import com.galebo.lowyer.model.User;
import com.galebo.lowyer.model.WebInfo;

public interface QueryDao {
    public GenericDaoiBatis<ConContent, Long> getConContentDao();
    public GenericDaoiBatis<CfgDefine, Long> getDefineDao();
    public GenericDaoiBatis<CfgDefineInstance, Long> getDefineInstanceDao();
    public GenericDaoiBatis<ColColumn, Long> getColColumnDao();
    public GenericDaoiBatis<Role, Long> getRoleDao() ;
    public GenericDaoiBatis<User, Long> getUserDao() ;
    public GenericDaoiBatis<Template, Long> getTemplateDao();
    public GenericDaoiBatis<TemplatePage, Long> getTemplatePageDao();
    public GenericDaoiBatis<ConLink, Long> getConLinkDao();
    public GenericDaoiBatis<CfgRelative, Long> getCfgRelativeDao();
    public GenericDaoiBatis<CfgGroup, Long> getCfgGroupDao();
    public GenericDaoiBatis<ConUploadData, Long> getConUploadDataDao();
    public GenericDaoiBatis<ColColumnContent, Long> getColColumnContentDao();
	public GenericDaoiBatis<ProCategory, Long> getProCategoryDao();
	public GenericDaoiBatis<ProProduct, Long> getProProductDao();
	public GenericDaoiBatis<ProCategoryProduct, Long> getProCategoryProductDao();
	
    public SqlMapClientTemplate getSqlMapClientTemplate() ;
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate);
	public List<ColColumnContent> getColumnContents(Long columnId,int page,int pageSize);
	public List<ProCategoryProduct> getCategoryProducts(long parentId, int page, int pageSize);
	public List<ColColumnContent> getColumnContentsByColumnId(Long columnId);
	public List<ColColumnContent> getColumnContents(Long userId);
	public List<ColColumnContent> getColColumnContentSortByViewCount();
	public Map<Long,ColColumnContent> getColumnContentsMap(Long userId);
	public ColColumnContent getColumnContent(Long columnContentId);
	public int getContentsSize(Long columnId);
	public int getProductsSize(long parentId);
	public ColColumn getColumn(Long columnId);
	public ColColumn getRootColumn(Long userId);
	public List<ColColumn> getColColumnsByUserId(Long userId);
	public List<Long> getColumnsInIndex(long userId);
	public List<ColColumn> getSonColumns(Long columnId, Long userId,String type);
	public Long getSonColumnSize(Long columnId, Long userId,String type);
	public List<IndexMenu> getIndexBeans(Long userId,String indexType);
	public Long getIndexBeansSize(Long userId,String indexType);

	public List<ColColumn> getColumnsNoInRelative(Long userId,String type,String indexType);
	public int getColumnsNoInRelativeSize(Long userId,String type,String indexType);

	public List<ProCategory> getSonCategorys(Long columnId,Long userId,String type);
	public Long getSonCategorySize(Long columnId,Long userId,String type);
	
	public String getColumnCfg(String type,Long userId);
	public List<Define> getDivDefines(Long userId);
	public Map<String,CfgDefineInstance> getSiteDefines(Long userId);
	public Map<String,CfgDefineInstance> getGlobalDefines();
	public List<ConLink> getLinks(String type,Long userId);
	public List<ConLink> getSonLinks(Long parentId,Long userId,String type, int page, int pageSize);
	public int getSonLinksSize(Long parentId,Long userId,String type);
	public List<ConLink> getSonLinksNoSelect(Long parentId,Long userId,String type, int page, int pageSize);
	public int getSonLinksNoSelectSize(long groupId, Long currentUser, String type);

	public List<CfgGroup> getGroup(String type,Long userId);
	

	public List<TemplatePage> getTemplatePage(Long userId);
	public List<ConLink> getConLinksGroup(Long userId, String linktype);
	public boolean isGroupExist(String type,String key,Long userId);
	public boolean isColumnUsed(Long columnId);
	public boolean isTemplateExist(Long templateId, Long templateCssId);
	public GenericDaoiBatis<WebInfo, Long> getWebInfoDao();
	public WebInfo getWebInfoByDomain(String name);
	public WebInfo getWebInfoByUserId(Long userId);
	public Template getTemplateByUserId(Long currentUser);
	public List<IdCount> getContentCount(String replaceAll);
	public Long getCfgGroupsByUserIdSize(Long userId, String type);
	public List<CfgDefine> getCfgDefinesByUserId(Long userId);
	public List<CfgDefine> getCfgDefines();
	public List<CfgDefineInstance> getSiteDefineWithName(Long userId);
	public List<CfgGroup> getCfgGroupsByUserId(Long userId, String type);
	public List<ConContent> getConContentsByUserId(Long userId);
	public List<ConUploadData> getConUploadDatasByUserId(Long userId);
	public List<CfgRelative> getRelativeMaxSort(String type, Long groupId);
	public IdCount getWebCount(Long webId);
	public Map<Long, ConContent> getContentsMap(Long userId);
	public List<ConContent> getContentsByIndex(String key1, String key2);
	public List<NameKey1234> getIndexSearchData(Long userId,Long columnId);
	public List<NameKey1234> getIndexSearchDataNotIn(Long userId,Long columnId);
	public Map<Long, ConContent> getContentsMap_index(Long userId,Long columnId);
	public List<ConContent> getContentsNoBang(Long parentId,Long userId, int page, int pageSize);
	public int getContentsNoBangSize(Long parentId,Long userId);
}
