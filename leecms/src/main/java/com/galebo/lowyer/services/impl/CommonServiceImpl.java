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
			return new JGridTreeHelperColumn(userId,Constants.columnType).getJGridBean(-1L,page);
	}
	public JGridBean getCategorys(Long userId, int page)
	{
		return new JGridTreeHelperCategory(userId,Constants.categoryType).getJGridBean(-1L,page);
}
	public JGridBean getGroups(Long userId, int page)
	{
			return new JGridTreeHelperGroup(userId).getJGridBean(-1L,page);
	}
	public JGridBean getIndexColumns(Long userId, int page) {
		return new JGridTreeHelperMenu(userId).getJGridBean(userId,page);
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

	class JGridTreeHelperGroup extends JGridTreeHelper{
		Long userId;
		public JGridTreeHelperGroup(Long userId) {
			this.userId=userId;
		}

		public List<? extends JGridAble> getSons(long ParentId, int level) {
				if(level>0)
					return new ArrayList<JGridAble>();
				return queryDao.getCfgGroupsByUserId(userId);
			}

	
		@Override
		public Long getSonSize(long ParentId) {
			return queryDao.getCfgGroupsByUserIdSize(userId);
		}

	}
	class JGridTreeHelperMenu extends JGridTreeHelper{
		Long userId;
		public JGridTreeHelperMenu(Long userId) {
			this.userId=userId;
		}

		public List<? extends JGridAble> getSons(long ParentId, int level) {
			if(level>0)
				return new ArrayList<JGridAble>();
			return queryDao.getIndexMenus(this.userId);
		}
	
		@Override
		public Long getSonSize(long ParentId) {
			return queryDao.getIndexMenusSize(this.userId);
		}
	}
	class JGridTreeHelperColumn extends JGridTreeHelper{
		Long userId;
		String type;
		public JGridTreeHelperColumn(Long userId,String type) {
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
	class JGridTreeHelperCategory extends JGridTreeHelper{
		Long userId;
		String type;
		public JGridTreeHelperCategory(Long userId,String type) {
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
