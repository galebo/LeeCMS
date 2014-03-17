package com.galebo.lowyer.services;

import java.util.List;

import com.galebo.common.jgrid.JGridBean;
import com.galebo.lowyer.dao.ModifyDao;
import com.galebo.lowyer.dao.QueryDao;
import com.galebo.lowyer.service.MailEngine;
import com.galebo.lowyer.service.RoleManager;
import com.galebo.lowyer.service.UserManager;


public interface CommonService {
	public QueryDao getQueryDao() ;
	public ModifyDao getModifyDao() ;

	public JGridBean getColumns(Long userId, int page);
	public JGridBean getCategorys(Long userId, int page);
	public JGridBean getIndexColumns(Long userId, int page);
	public JGridBean getGroups(Long userId,int page, String type);

	public String deleteColumn(Long columnId);
	public List search(String searchTerm, Class<?> clazz);

    public UserManager getUserManager();
    public MailEngine getMailEngine() ;
	public RoleManager getRoleManager() ;

}