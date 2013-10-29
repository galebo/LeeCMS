package com.galebo.lowyer.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.galebo.lowyer.model.Role;
import com.galebo.lowyer.service.RoleManager;
import com.galebo.lowyer.services.impl.BaseService;

/**
 * Implementation of RoleManager interface.
 *
 * @author <a href="mailto:dan@getrolling.com">Dan Kibler</a>
 */
@Service("roleManager")
public class RoleManagerImpl extends BaseService implements RoleManager {

    /**
     * {@inheritDoc}
     */
    public List<Role> getRoles(Role role) {
        return queryDao.getSqlMapClientTemplate().queryForList("getRoles", null);
    }

    /**
     * {@inheritDoc}
     */
    public Role getRole(String rolename) {
        return (Role) queryDao.getSqlMapClientTemplate().queryForObject("getRoleByName", rolename);
    }

    /**
     * {@inheritDoc}
     */
    public Role saveRole(Role role) {
        if (role.getId() == null) {
        	queryDao.getSqlMapClientTemplate().insert("addRole", role);
        } else {
        	queryDao.getSqlMapClientTemplate().update("updateRole", role);
        }
        return role;
    }

    /**
     * {@inheritDoc}
     */
    public void removeRole(String rolename) {
    	queryDao.getSqlMapClientTemplate().update("deleteRole", rolename);
    }

}