package com.galebo.lowyer.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.galebo.common.jgrid.JGridAble;
import com.galebo.common.jgrid.JGridBean;
import com.galebo.common.jgrid.JGridHelper;
import com.galebo.lowyer.service.MailEngine;
import com.galebo.lowyer.service.RoleManager;
import com.galebo.lowyer.service.UserManager;
import com.galebo.lowyer.services.CommonService;
@Service("commonService")
public class CommonServiceImpl extends BaseService implements CommonService {


	public JGridBean getColumns(Long userId,int page,int pageSize)
	{
			return new JGridHelperColumn(userId,Constants.columnType).getJGridBean(-1L,page,pageSize);
	}
	public JGridBean getCategorys(Long userId, int page,int pageSize)
	{
		return new JGridHelperCategory(userId,Constants.categoryType).getJGridBean(-1L,page,pageSize);
}
	public JGridBean getGroups(Long userId,int page,int pageSize)
	{
			return new JGridHelperGroup(userId).getJGridBean(-1L,page,pageSize);
	}
	public JGridBean getIndexColumns(Long userId, int page, int pageSize) {
		return new JGridHelperMenu(userId).getJGridBean(userId,page,pageSize);
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

	class JGridHelperGroup extends JGridHelper{
		Long userId;
		public JGridHelperGroup(Long userId) {
			this.userId=userId;
		}

		@SuppressWarnings("unchecked")
		public List getSons(long ParentId, int level,int page,int pageSize) {
				if(level>0)
					return new ArrayList<JGridAble>();
				return queryDao.getCfgGroupsByUserId(userId);
			}

	
		@Override
		public Long getSonSize(long ParentId) {
			return queryDao.getCfgGroupsByUserIdSize(userId);
		}

	}
	class JGridHelperMenu extends JGridHelper{
		Long userId;
		public JGridHelperMenu(Long userId) {
			this.userId=userId;
		}

		@SuppressWarnings("unchecked")
		public List getSons(long ParentId, int level,int page,int pageSize) {
			if(level>0)
				return new ArrayList<JGridAble>();
			return queryDao.getIndexMenus(this.userId);
		}
	
		@Override
		public Long getSonSize(long ParentId) {
			return queryDao.getIndexMenusSize(this.userId);
		}
	}
	class JGridHelperColumn extends JGridHelper{
		Long userId;
		String type;
		public JGridHelperColumn(Long userId,String type) {
			this.userId=userId;
			this.type=type;
		}

		@SuppressWarnings("unchecked")
		public List getSons(long ParentId, int level,int page,int pageSize) {
				return queryDao.getSonColumns(ParentId,this.userId,type);
			}
	
		@Override
		public Long getSonSize(long ParentId) {
			return queryDao.getSonColumnSize(ParentId,this.userId,type);
		}
	}
	class JGridHelperCategory extends JGridHelper{
		Long userId;
		String type;
		public JGridHelperCategory(Long userId,String type) {
			this.userId=userId;
			this.type=type;
		}

		@SuppressWarnings("unchecked")
		public List getSons(long ParentId, int level,int page,int pageSize) {
				return queryDao.getSonCategorys(ParentId,this.userId,type);
			}
	
		@Override
		public Long getSonSize(long ParentId) {
			return queryDao.getSonColumnSize(ParentId,this.userId,type);
		}
	}
}
