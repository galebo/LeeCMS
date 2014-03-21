package com.galebo.lowyer.services.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.galebo.lowyer.model.CfgDefine;
import com.galebo.lowyer.model.CfgDefineInstance;
import com.galebo.lowyer.model.CfgGroup;
import com.galebo.lowyer.model.CfgRelative;
import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.model.ColColumnContent;
import com.galebo.lowyer.model.ConContent;
import com.galebo.lowyer.model.ConLink;
import com.galebo.lowyer.model.ProCategory;
import com.galebo.lowyer.model.ProCategoryProduct;
import com.galebo.lowyer.model.ProProduct;

@Service("UserDataCreator")
public class UserDataCreator  extends BaseService{
	private static final String HTML = "<p>第一段</p><p>第二段</p><p>第三段</p><p>第四段</p>";
	private void createColumn(Long userId,String html) {
		ColColumn root=new ColColumn();
		{
			root.setColName("root");
			root.setCTime(new Date());
			root.setColPid(-1L);
			root.setUserId(userId);
			root=queryDao.getColColumnDao().save(root);
		}
		saveRelate(Constants.columnType, null, -1L, root.getColumnId(), userId);
		createColumn(userId, html, root,4);
	}

	private void createColumn(Long userId, String html, ColColumn root,int count) {
		for (int i = 0; i < count; i++) {
			ColColumn colColumn=new ColColumn();
			{
				colColumn.setColName("栏目"+i);
				colColumn.setCTime(new Date());
				colColumn.setColPid(root.getColumnId());
				colColumn.setUserId(userId);
				colColumn.setSmallId(10000L);
				colColumn.setMaxId(10000L);
				colColumn=queryDao.getColColumnDao().save(colColumn);
				saveRelate(Constants.columnType, null, root.getColumnId(), colColumn.getColumnId(), userId);
			}
			createContent(userId, html, colColumn,5);
		}
	}



	public void createColumnHaveRoot(Long userId,int count) {
		ColColumn root=queryDao.getRootColumn(userId);
		createColumn(userId,HTML,root,count);
	}
	public void createContent(Long userId, String html, ColColumn colColumn,int size) {
		for (int x = 0; x < size; x++) {
			ConContent conContent=new ConContent();
			conContent.setHtml(html);
			conContent.setNameCn("标题"+x+",待编辑");
			conContent.setSource("原创");
			conContent.setAuthor("作者");
			saveContent(conContent,userId,colColumn);
		}
	}


	public void updateContent(ConContent conContent,Long userId) {
		{
			conContent.setSubmitTime(new Date());
			conContent.setUserId(userId);
			conContent.setUpdateTime(new Date());
			conContent.setViewCount(0L);
			queryDao.getConContentDao().save(conContent);
		}
	}
	public void saveContent(ConContent conContent,Long userId,ColColumn colColumn) {
		{
			conContent.setSubmitTime(new Date());
			conContent.setUserId(userId);
			conContent.setUpdateTime(new Date());
			conContent.setViewCount(0L);
			queryDao.getConContentDao().save(conContent);
		}
		saveColumnContent(conContent, colColumn);
	}

	public void saveColumnContent2Last(ConContent conContent, ColColumn colColumn) {
		{
        	ColColumnContent columnContent=new ColColumnContent();
    		columnContent.setColColumn(colColumn);
    		columnContent.setConContent(conContent);
			columnContent.setSort(colColumn.getMaxId()+1);
			columnContent.setNextId(null);
			columnContent.setPreId(colColumn.getLastId());
			columnContent=queryDao.getColColumnContentDao().save(columnContent);
        	if(colColumn.getLastId()!=null)
        	{
            	ColColumnContent columnContentPre = (ColColumnContent) queryDao.getColColumnContentDao().get(colColumn.getLastId());
            	columnContentPre.setNextId(columnContent.getColumnContentId());
            	queryDao.getColColumnContentDao().save(columnContentPre);
        	}
        	
    		if(colColumn.getFirstId()==null)
    			colColumn.setFirstId(columnContent.getColumnContentId());
			colColumn.setLastId(columnContent.getColumnContentId());
			colColumn.setMaxId(columnContent.getSort());
        	queryDao.getColColumnDao().save(colColumn);
        }
	}
	public void saveColumnContent(ConContent conContent, ColColumn colColumn) {
		{
        	ColColumnContent columnContent=new ColColumnContent();
    		columnContent.setColColumn(colColumn);
    		columnContent.setConContent(conContent);
			columnContent.setSort(colColumn.getSmallId()-1);
			columnContent.setPreId(null);
			columnContent.setNextId(colColumn.getFirstId());
			columnContent=queryDao.getColColumnContentDao().save(columnContent);
        	if(colColumn.getFirstId()!=null)
        	{
            	ColColumnContent columnContent_last = (ColColumnContent) queryDao.getColColumnContentDao().get(colColumn.getFirstId());
            	columnContent_last.setPreId(columnContent.getColumnContentId());
            	queryDao.getColColumnContentDao().save(columnContent_last);
        	}
        	
    		if(colColumn.getLastId()==null)
    			colColumn.setLastId(columnContent.getColumnContentId());
			colColumn.setFirstId(columnContent.getColumnContentId());
			colColumn.setSmallId(columnContent.getSort());
        	queryDao.getColColumnDao().save(colColumn);
        }
	}
	public void save(ProProduct conContent,Long userId,ProCategory parent) {
		{
			conContent.setSubmitTime(new Date());
			conContent.setUserId(userId);
			conContent.setViewCount(0L);
			queryDao.getProProductDao().save(conContent);
		}
		
        if(parent!=null)
        {
        	ProCategoryProduct parentSon=new ProCategoryProduct();
    		parentSon.setCategoryId(parent.getCategoryId());
    		parentSon.setProductId(conContent.getProductId());
			parentSon.setSort(parent.getMaxId()+1);
			parentSon.setNextId(null);
			parentSon.setPreId(parent.getLastId());
        	queryDao.getProCategoryProductDao().save(parentSon);
        	if(parent.getLastId()!=null)
        	{
        		ProCategoryProduct columnContentPre = (ProCategoryProduct) queryDao.getProCategoryProductDao().get(parent.getLastId());
            	columnContentPre.setNextId(parentSon.getCategoryProductId());
            	queryDao.getProCategoryProductDao().save(columnContentPre);
        	}
        	
    		if(parent.getFirstId()==null)
    			parent.setFirstId(parentSon.getCategoryProductId());
			parent.setLastId(parentSon.getCategoryProductId());
			parent.setMaxId(parentSon.getSort());
        	queryDao.getProCategoryDao().save(parent);
        }
	}
	
	
	
	private ConLink createLink(String type,String name ,Long count,Long userId,String imgUrl) {
        ConLink conLink = new ConLink();
		conLink.setType(type);
		conLink.setTitle(name+count);
        conLink.setUrl("#");
		conLink.setImgUrl(imgUrl);
        conLink.setUserId(userId);
        conLink.setUpdateTime(new Date());
        
    	queryDao.getConLinkDao().save(conLink);
    	return conLink;
	}
	public void saveRelate(String type,String type2,Long groupId ,String sonIds,Long userId) {
       	List<CfgRelative> Relative = queryDao.getRelativeMaxSort(type, groupId);

    	Long sort=null;
    	if(Relative.size()==0)
    		sort=1L;
    	else
    		sort=Relative.get(0).getSort();
    	String[] split = sonIds.split(",");
    	for (int i = 0; i < split.length; i++) {
    		CfgRelative bean=new CfgRelative();
        	bean.setElementId(Long.valueOf(split[i]));
        	bean.setElementType(type);
        	bean.setElementType2(type2);
        	bean.setParentElementId(groupId);
        	bean.setUserId(userId);
        	bean.setSort(++sort);
        	queryDao.getCfgRelativeDao().save(bean);
		}
	}
	/*type2 可以为空*/
	public void saveRelate(String type,String type2,Long groupId ,Long sonId,Long userId) {
       	List<CfgRelative> Relative = queryDao.getRelativeMaxSort(type, groupId);

    	Long sort=null;
    	if(Relative.size()==0)
    		sort=1L;
    	else
    		sort=Relative.get(0).getSort();
    	{
    		CfgRelative bean=new CfgRelative();
        	bean.setElementId(Long.valueOf(sonId));
        	bean.setElementType(type);
        	bean.setElementType2(type2);
        	bean.setParentElementId(groupId);
        	bean.setUserId(userId);
        	bean.setSort(++sort);
        	queryDao.getCfgRelativeDao().save(bean);
    	}
	}

	private void createGroup(String type,Long count,Long userId,String key,String name,int id,Boolean isImg) {
        CfgGroup cfgGroup = new CfgGroup();
        cfgGroup.setType(type);
		cfgGroup.setUserId(userId);
		cfgGroup.setGroupKey(key+id);
		cfgGroup.setGroupName(name+id);
    	queryDao.getCfgGroupDao().save(cfgGroup);
    	String sonIds=null;
    	for (Long i = 0L; i < count; i++) {
			ConLink createLoop = createLink(type, name,i,userId,isImg?Constants.uploadDir+"/default"+(count+1)+".jpg":"XNDQ4Njc4NTYw");
			if(sonIds==null)
				sonIds=""+createLoop.getLinkId();
			else
				sonIds=sonIds+","+createLoop.getLinkId();
		}
    	saveRelate(type,null, cfgGroup.getGroupId(), sonIds, userId);
	}

	public void createUserData_small(Long userId) {
		createColumn(userId,HTML);
		createGroup(Constants.loopType, 3L, userId,"loop","链接",1,false);
		getSiteDefineWithName(userId);
		CmsMap.clearMap(userId);
	}
	public void createUserData(Long userId) {
		createColumn(userId,HTML);
		createGroup(Constants.linkType, 3L, userId,"link","链接",1,true);
		createGroup(Constants.linkType, 3L, userId,"link","链接",2,true);
		createGroup(Constants.loopType, 3L, userId,"loop","轮播",1,true);
		createGroup(Constants.loopType, 3L, userId,"loop","轮播",2,true);
		getSiteDefineWithName(userId);
		CmsMap.clearMap(userId);
	}
	public List<CfgDefineInstance> getSiteDefineWithName(Long userId) {
		
		List<CfgDefineInstance> cfgDefineInstances = queryDao.getSiteDefineWithName(userId);
		List<CfgDefine> cfgDefines = queryDao.getCfgDefines();
		List<CfgDefine> cfgDefinesOrg = queryDao.getCfgDefinesByUserId(userId);
		if (cfgDefineInstances.size()!=cfgDefines.size()) {//如果配置项少，重新插入
			for (Iterator<CfgDefine>  iterator = cfgDefinesOrg.iterator(); iterator.hasNext();) {
				CfgDefine object = (CfgDefine) iterator.next();

				CfgDefineInstance a=new CfgDefineInstance();
				a.setTitle(object.getKey());
				a.setText(object.getDefaultValue());
				a.setType(Constants.SiteDefineType);
				a.setUpdateTime(new Date());
				a.setUserId(userId);
				queryDao.getDefineInstanceDao().save(a);
			}
			cfgDefineInstances = queryDao.getSiteDefineWithName(userId);
		}
		return cfgDefineInstances;
	}
}
