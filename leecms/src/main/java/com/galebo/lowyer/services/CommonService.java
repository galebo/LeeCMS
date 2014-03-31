package com.galebo.lowyer.services;

import java.util.List;

import com.galebo.common.jgrid.JGridBean;
import com.galebo.lowyer.dao.ModifyDao;
import com.galebo.lowyer.dao.QueryDao;
import com.galebo.lowyer.model.CfgDefine;
import com.galebo.lowyer.model.ProCategory;
import com.galebo.lowyer.model.ProProduct;
import com.galebo.lowyer.model.Template;
import com.galebo.lowyer.model.TemplatePage;
import com.galebo.lowyer.model.User;
import com.galebo.lowyer.service.MailEngine;
import com.galebo.lowyer.service.RoleManager;
import com.galebo.lowyer.service.UserManager;


public interface CommonService {
	public QueryDao getQueryDao() ;
	public ModifyDao getModifyDao() ;

	public JGridBean getColumns(Long userId, int page);
	public JGridBean getCategorys(Long userId, int page);
	public JGridBean getIndexColumns(Long userId, int page);
	public JGridBean getIndexMenus(Long userId, int page);
	public JGridBean getGroups(Long userId,int page, String type);

	public String deleteColumn(Long columnId);

    public UserManager getUserManager();
    public MailEngine getMailEngine() ;
	public RoleManager getRoleManager() ;
	public List<CfgDefine> getCfgDefines();
	public List<ProCategory> getProCategorys();
	public List<ProProduct> getProProducts();
	public List<Template> getTemplates();
	public List<TemplatePage> getTemplatePages();
	public List<User> _getUsers();

}