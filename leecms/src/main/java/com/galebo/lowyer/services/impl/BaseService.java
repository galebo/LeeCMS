package com.galebo.lowyer.services.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.galebo.lowyer.dao.ModifyDao;
import com.galebo.lowyer.dao.QueryDao;
import com.galebo.lowyer.model.CfgDefine;
import com.galebo.lowyer.model.ProCategory;
import com.galebo.lowyer.model.ProProduct;
import com.galebo.lowyer.model.Role;
import com.galebo.lowyer.model.Template;
import com.galebo.lowyer.model.TemplatePage;
import com.galebo.lowyer.model.User;

public class BaseService {
    protected final Log log = LogFactory.getLog(getClass());

	@Autowired
	protected QueryDao queryDao;
	@Autowired
	protected ModifyDao modifyDao;

	public QueryDao getQueryDao() {
		return queryDao;
	}
	public ModifyDao getModifyDao() {
		return modifyDao;
	}

	public User _getUserByUsername(String username) {
		return (User)queryDao.getSqlMapClientTemplate().queryForObject("getUserByUsername", username);
	}
	public User _getUser(String userId) {
		return (User)queryDao.getSqlMapClientTemplate().queryForObject("getUser", userId);
	}
	public List<Role> _getUserRoles(User user) {
		return queryDao.getSqlMapClientTemplate().queryForList("getUserRoles", user);
	}
	public int _deleteUserRoles(final Long userId) {
		return queryDao.getSqlMapClientTemplate().update("deleteUserRoles", userId);
	}
	public int _addUserRole(Map<String, Long> newRole) {
		return queryDao.getSqlMapClientTemplate().update("addUserRole", newRole);
	}
	public Long _addUser(final User user) {
		return (Long)queryDao.getSqlMapClientTemplate().insert("addUser", user);
	}
	public String _getUserPassword(String username) {
		return (String) queryDao.getSqlMapClientTemplate().queryForObject("getUserPassword", username);
	}
	public int _updateUser(final User user) {
		return queryDao.getSqlMapClientTemplate().update("updateUser", user);
	}
	public void _removeUser(String userId) {
		queryDao.getUserDao().remove(new Long(userId));
	}
	
	
	public List<CfgDefine> getCfgDefines() {
		return queryDao.getSqlMapClientTemplate().queryForList("getCfgDefines");
	}
	public List<ProCategory> getProCategorys() {
		return queryDao.getSqlMapClientTemplate().queryForList("getProCategorys");
	}
	public List<ProProduct> getProProducts() {
		return queryDao.getSqlMapClientTemplate().queryForList("getProProducts");
	}
	public List<Template> getTemplates() {
		return queryDao.getSqlMapClientTemplate().queryForList("getTemplates");
	}
	public List<TemplatePage> getTemplatePages() {
		return queryDao.getSqlMapClientTemplate().queryForList("getTemplatePages");
	}
	public List<User> _getUsers() {
		return queryDao.getSqlMapClientTemplate().queryForList("getUsers");
	}
	public List<User> getUsers(String getTerm) {return _getUsers();}
}
