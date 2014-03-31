package com.galebo.lowyer.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galebo.common.jgrid.JGridAble;
import com.galebo.common.jgrid.JGridBean;
import com.galebo.common.jgrid.JGridTreeHelper;
import com.galebo.lowyer.service.MailEngine;
import com.galebo.lowyer.service.RoleManager;
import com.galebo.lowyer.service.UserManager;
import com.galebo.lowyer.services.CommonService;
@Service("commonService")
public class CommonServiceImpl extends BaseService implements CommonService {


	public JGridBean getColumns(Long userId, int page)
	{
			return new JGridTreeHelper_Column(userId,Constants.columnType).getJGridBean(-1L,page);
	}
	public JGridBean getCategorys(Long userId, int page)
	{
		return new JGridTreeHelper_Category(userId,Constants.categoryType).getJGridBean(-1L,page);
}
	public JGridBean getGroups(Long userId, int page,String type)
	{
			return new JGridTreeHelper_Group(userId,type).getJGridBean(-1L,page);
	}
	public JGridBean getIndexMenus(Long userId, int page) {
		return new JGridTreeHelper_IndexBean(userId,Constants.indexMenuType).getJGridBean(userId,page);
	}
	public JGridBean getIndexColumns(Long userId, int page) {
		return new JGridTreeHelper_IndexBean(userId,Constants.indexItemType).getJGridBean(userId,page);
	}

    @Autowired
    public void setUserManager(UserManager userManager) {
        this.userManager = userManager;
    }
    @Autowired
    public void setMailEngine(MailEngine mailEngine) {
        this.mailEngine = mailEngine;
    }
    @Autowired
    public void setRoleManager(RoleManager roleManager) {
        this.roleManager = roleManager;
    }

    public UserManager getUserManager() {
        return this.userManager;
    }
    public MailEngine getMailEngine() {
        return this.mailEngine;
    }
	public RoleManager getRoleManager() {
		return roleManager;
	}
    private UserManager userManager = null;

    protected MailEngine mailEngine = null;
    private RoleManager roleManager;



	public String deleteColumn(Long columnId) {
    	if(getQueryDao().isColumnUsed(columnId))
           return "column.isUsed";
    	else
		{
    		getQueryDao().getColColumnDao().remove(columnId);
            return "deleted";
		}
	}

	class JGridTreeHelper_Group extends JGridTreeHelper{
		Long userId;
		String type;
		public JGridTreeHelper_Group(Long userId,String type) {
			this.userId=userId;
			this.type=type;
		}

		public List<? extends JGridAble> getSons(long ParentId, int level) {
				if(level>0)
					return new ArrayList<JGridAble>();
				return queryDao.getCfgGroupsByUserId(userId,type);
			}

	
		@Override
		public Long getSonSize(long ParentId) {
			return queryDao.getCfgGroupsByUserIdSize(userId,type);
		}

	}
	class JGridTreeHelper_IndexBean extends JGridTreeHelper{
		Long userId;
		String indexType ;
		public JGridTreeHelper_IndexBean(Long userId,String indexType) {
			this.userId=userId;
			this.indexType=indexType;
		}

		public List<? extends JGridAble> getSons(long ParentId, int level) {
			if(level>0)
				return new ArrayList<JGridAble>();
			return queryDao.getIndexBeans(this.userId,indexType);
		}
	
		@Override
		public Long getSonSize(long ParentId) {
			return queryDao.getIndexBeansSize(this.userId,indexType);
		}
	}
	class JGridTreeHelper_Column extends JGridTreeHelper{
		Long userId;
		String type;
		public JGridTreeHelper_Column(Long userId,String type) {
			this.userId=userId;
			this.type=type;
		}

		public List<? extends JGridAble> getSons(long ParentId, int level) {
				return queryDao.getSonColumns(ParentId,this.userId,type);
			}
	
		@Override
		public Long getSonSize(long ParentId) {
			return queryDao.getSonColumnSize(ParentId,this.userId,type);
		}
	}
	class JGridTreeHelper_Category extends JGridTreeHelper{
		Long userId;
		String type;
		public JGridTreeHelper_Category(Long userId,String type) {
			this.userId=userId;
			this.type=type;
		}

		public List<? extends JGridAble> getSons(long ParentId, int level) {
				return queryDao.getSonCategorys(ParentId,this.userId,type);
			}
	
		@Override
		public Long getSonSize(long ParentId) {
			return queryDao.getSonColumnSize(ParentId,this.userId,type);
		}
	}
}
