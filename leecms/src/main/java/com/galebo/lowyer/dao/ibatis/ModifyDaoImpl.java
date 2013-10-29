package com.galebo.lowyer.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Service;

import com.galebo.common.dao.SSIILL;
import com.galebo.lowyer.dao.ModifyDao;
import com.galebo.lowyer.model.CfgIndexSearch;
@Service("modifyDao")
public class ModifyDaoImpl extends BaseDaoImpl implements ModifyDao{
	@Autowired
	private SqlMapClientTemplate sqlMapClientTemplate;
	public void updateContentCount(Long contentId) {
		sqlMapClientTemplate.update("updateContentCount",contentId);
	}
	public void updateWebCount(Long userId) {
		sqlMapClientTemplate.update("updateWebCount",userId);
	}

	public void changeSort(String sqlName,Long id,Long sonId) {
		sqlMapClientTemplate.update(sqlName,SSIILL.create(null, null, null, null, id, sonId));
	}

	public void deleteTemplatePageAll() {
		sqlMapClientTemplate.delete("deleteTemplatePageAll");
	}
	public void deleteRelative(Long relateId)
	{
		getCfgRelativeDao().remove(relateId);
	}
	public void deleteColumnContent(Long columnContentId) {
		getColColumnContentDao().remove(columnContentId);
	}
	public void updateUserTemplate(Long templateId, Long currentUser) {
		sqlMapClientTemplate.update("updateUserTemplate",SSIILL.create(null, null, null, null, templateId, currentUser));
	}
	public void setContentIndex(long contentId, String key1, String key2) {
		sqlMapClientTemplate.update("setContentIndex",SSIILL.create(key1, key2, null, null, contentId, null));
		
	}
	public void insertContentIndex(CfgIndexSearch a) {
		sqlMapClientTemplate.update("addCfgIndexSearch",a);
	}
}
