package com.galebo.lowyer.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.compass.core.CompassHit;
import org.compass.core.support.search.CompassSearchCommand;
import org.compass.core.support.search.CompassSearchHelper;
import org.compass.core.support.search.CompassSearchResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;

import com.galebo.lowyer.dao.ModifyDao;
import com.galebo.lowyer.dao.QueryDao;
import com.galebo.lowyer.dao.ibatis.iBatisDaoUtils;

public class BaseService {
	CompassSearchHelper compass;
    protected final Log log = LogFactory.getLog(getClass());
	@Autowired
	public void setCompass(CompassSearchHelper compass) {
		this.compass = compass;
	}
	protected QueryDao queryDao;
	protected ModifyDao modifyDao;


	@Autowired
	public void setQueryDao(QueryDao commonDao) {
		this.queryDao = commonDao;
	}
	@Autowired
	public void setModifyDao(ModifyDao modifyDao) {
		this.modifyDao = modifyDao;
	}
	
	public QueryDao getQueryDao() {
		return queryDao;
	}
	public ModifyDao getModifyDao() {
		return modifyDao;
	}
    /**
     * {@inheritDoc}
     * <p/>
     * Search implementation using Compass.
     */
    @SuppressWarnings("unchecked")
    public List search(String q, Class clazz) {
        if (q == null || "".equals(q.trim())) {
            return queryDao.getSqlMapClientTemplate().queryForList(
                    iBatisDaoUtils.getSelectQuery(ClassUtils.getShortName(clazz.getName())), null);
            
        }

        List results = new ArrayList();

        CompassSearchCommand command = new CompassSearchCommand(q);
        CompassSearchResults compassResults = compass.search(command);
        CompassHit[] hits = compassResults.getHits();

        if (log.isDebugEnabled() && clazz != null) {
            log.debug("Filtering by type: " + clazz.getName());
        }

        for (CompassHit hit : hits) {
            if (clazz != null) {
                if (hit.data().getClass().equals(clazz)) {
                    results.add( hit.data());
                }
            } else {
                results.add( hit.data());
            }
        }

        if (log.isDebugEnabled()) {
            log.debug("Number of results for '" + q + "': " + results.size());
        }

        return results;
    }
}
