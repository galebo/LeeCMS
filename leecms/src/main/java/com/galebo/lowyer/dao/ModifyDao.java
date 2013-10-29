package com.galebo.lowyer.dao;

import com.galebo.lowyer.model.CfgIndexSearch;



public interface ModifyDao {
	public void updateContentCount(Long contentId);

	public void changeSort(String sqlName, Long id, Long sonId);

	public void deleteTemplatePageAll();
	public void deleteRelative(Long relateId);

	public void updateWebCount(Long userId);

	public void deleteColumnContent(Long columnContentId);

	public void updateUserTemplate(Long templateId, Long currentUser);

	public void setContentIndex(long contentId, String key1, String key2);

	public void insertContentIndex(CfgIndexSearch a);
}
