package com.galebo.lowyer.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.orm.ibatis.SqlMapClientTemplate;

import com.galebo.lowyer.model.CfgDefine;
import com.galebo.lowyer.model.CfgDefineInstance;
import com.galebo.lowyer.model.CfgGroup;
import com.galebo.lowyer.model.CfgRelative;
import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.model.ColColumnContent;
import com.galebo.lowyer.model.ConContent;
import com.galebo.lowyer.model.ConLink;
import com.galebo.lowyer.model.ConUploadData;
import com.galebo.lowyer.model.ProCategory;
import com.galebo.lowyer.model.ProCategoryProduct;
import com.galebo.lowyer.model.ProProduct;
import com.galebo.lowyer.model.Role;
import com.galebo.lowyer.model.Template;
import com.galebo.lowyer.model.TemplatePage;
import com.galebo.lowyer.model.User;
import com.galebo.lowyer.model.WebInfo;
public class BaseDaoImpl{
	protected SqlMapClientTemplate sqlMapClientTemplate;

    public SqlMapClientTemplate getSqlMapClientTemplate() 
    {
    	return sqlMapClientTemplate;
    }

    GenericDaoiBatis<ConContent,Long> ConContentDao=null;
    GenericDaoiBatis<CfgDefine,Long> DefineDao=null;
    GenericDaoiBatis<CfgDefineInstance,Long> DefineInstanceDao=null;
    GenericDaoiBatis<ColColumn,Long> ColColumnDao=null;
    GenericDaoiBatis<Role,Long> RoleDao=null;
    GenericDaoiBatis<User,Long> UserDao=null;
    GenericDaoiBatis<Template,Long> TemplateDao=null;
    GenericDaoiBatis<TemplatePage,Long> TemplatePageDao=null;
    GenericDaoiBatis<ConLink,Long> ConLinkDao=null;
    GenericDaoiBatis<CfgRelative,Long> CfgRelativeDao=null;
    GenericDaoiBatis<CfgGroup,Long> CfgGroupDao=null;
    GenericDaoiBatis<ConUploadData,Long> ConUploadDataDao=null;
    GenericDaoiBatis<ColColumnContent,Long> ColColumnContentDao=null;
    GenericDaoiBatis<ProCategory,Long> ProCategoryDao=null;
    GenericDaoiBatis<WebInfo,Long> WebInfoDao=null;
    GenericDaoiBatis<ProProduct,Long> ProProductDao=null;
    GenericDaoiBatis<ProCategoryProduct,Long> ProCategoryProductDao=null;
    public GenericDaoiBatis<ConContent, Long> getConContentDao() {
		return ConContentDao;
	}
    public GenericDaoiBatis<CfgDefine, Long> getDefineDao() {
		return DefineDao;
	}
    public GenericDaoiBatis<CfgDefineInstance, Long> getDefineInstanceDao() {
		return DefineInstanceDao;
	}
    public GenericDaoiBatis<ColColumn, Long> getColColumnDao() {
		return ColColumnDao;
	}
    public GenericDaoiBatis<Role, Long> getRoleDao() {
		return RoleDao;
	}
    public GenericDaoiBatis<User, Long> getUserDao() {
		return UserDao;
	}
    public GenericDaoiBatis<Template, Long> getTemplateDao() {
		return TemplateDao;
	}
    public GenericDaoiBatis<TemplatePage, Long> getTemplatePageDao() {
		return TemplatePageDao;
	}
    public GenericDaoiBatis<ConLink, Long> getConLinkDao() {
		return ConLinkDao;
	}
    public GenericDaoiBatis<CfgRelative, Long> getCfgRelativeDao() {
		return CfgRelativeDao;
	}
    public GenericDaoiBatis<CfgGroup, Long> getCfgGroupDao() {
		return CfgGroupDao;
	}
	public GenericDaoiBatis<ConUploadData, Long> getConUploadDataDao() {
		return ConUploadDataDao;
	}
	public GenericDaoiBatis<WebInfo, Long> getWebInfoDao() {
		return WebInfoDao;
	}
    public GenericDaoiBatis<ColColumnContent, Long> getColColumnContentDao()
    {
		return ColColumnContentDao;
    }

	public GenericDaoiBatis<ProCategory, Long>  getProCategoryDao()
	{
		return ProCategoryDao;
	}
	public GenericDaoiBatis<ProProduct, Long> getProProductDao()
	{
		return ProProductDao;
	}
	public GenericDaoiBatis<ProCategoryProduct, Long> getProCategoryProductDao()
	{
		return ProCategoryProductDao;
	}

	@Autowired
	JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	    ConContentDao=new GenericDaoiBatis<ConContent,Long>(ConContent.class,sqlMapClientTemplate);
	    DefineDao=new GenericDaoiBatis<CfgDefine,Long>(CfgDefine.class,sqlMapClientTemplate);
	    DefineInstanceDao=new GenericDaoiBatis<CfgDefineInstance,Long>(CfgDefineInstance.class,sqlMapClientTemplate);
	    ColColumnDao=new GenericDaoiBatis<ColColumn,Long>(ColColumn.class,sqlMapClientTemplate);
	    RoleDao=new GenericDaoiBatis<Role,Long>(Role.class,sqlMapClientTemplate);
	    UserDao=new GenericDaoiBatis<User,Long>(User.class,sqlMapClientTemplate);
	    ConLinkDao=new GenericDaoiBatis<ConLink, Long>(ConLink.class, sqlMapClientTemplate);
	    TemplateDao=new GenericDaoiBatis<Template, Long>(Template.class, sqlMapClientTemplate);
	    TemplatePageDao=new GenericDaoiBatis<TemplatePage, Long>(TemplatePage.class, sqlMapClientTemplate);
	    CfgRelativeDao=new GenericDaoiBatis<CfgRelative, Long>(CfgRelative.class, sqlMapClientTemplate);
	    CfgGroupDao=new GenericDaoiBatis<CfgGroup, Long>(CfgGroup.class, sqlMapClientTemplate);
	    ConUploadDataDao=new GenericDaoiBatis<ConUploadData, Long>(ConUploadData.class, sqlMapClientTemplate);
	    ColColumnContentDao=new GenericDaoiBatis<ColColumnContent, Long>(ColColumnContent.class, sqlMapClientTemplate);
	    WebInfoDao=new GenericDaoiBatis<WebInfo, Long>(WebInfo.class, sqlMapClientTemplate);
	    ProCategoryDao=new GenericDaoiBatis<ProCategory, Long>(ProCategory.class, sqlMapClientTemplate);
	    ProProductDao=new GenericDaoiBatis<ProProduct, Long>(ProProduct.class, sqlMapClientTemplate);
	    ProCategoryProductDao=new GenericDaoiBatis<ProCategoryProduct, Long>(ProCategoryProduct.class, sqlMapClientTemplate);
	}

}
