package com.galebo.lowyer.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Service;

import com.galebo.lowyer.model.LabelValue;
import com.galebo.lowyer.model.Role;
import com.galebo.lowyer.service.LookupManager;


/**
 * Implementation of LookupManager interface to talk to the persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("lookupManager")
public class LookupManagerImpl implements LookupManager {
    private Log log = LogFactory.getLog(LookupManagerImpl.class);
    private SqlMapClientTemplate sqlMapClientTemplate = null;

    @Autowired
    public final void setSqlMapClientTemplate(SqlMapClientTemplate sqlMapClient) {
        this.sqlMapClientTemplate=sqlMapClient;
    }

    /**
     * {@inheritDoc}
     */
    public List<LabelValue> getAllRoles() {
    	log.debug("Retrieving all role names...");

        List<Role> roles = sqlMapClientTemplate.queryForList("getRoles", null);
        List<LabelValue> list = new ArrayList<LabelValue>();

        for (Role role1 : roles) {
            list.add(new LabelValue(role1.getName(), role1.getName()));
        }

        return list;
    }
}
