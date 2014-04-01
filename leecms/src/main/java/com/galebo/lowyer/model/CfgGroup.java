package com.galebo.lowyer.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

import com.galebo.common.UtilsCommon;
import com.galebo.common.jgrid.JGridAble;

@Entity
@Table(name="cfg_group")
@Searchable
@XmlRootElement
public class CfgGroup extends BaseObject implements Serializable,JGridAble {
    /**
	 * 
	 */
	private static final long serialVersionUID = -8924515176095335282L;
	private Long groupId;
    private String groupName;
    private String groupKey;
    private String type;
    private Long userId;
    private Date updateTime;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getGroupId() {
        return this.groupId;
    }
    
    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }
    
    @Column(name="group_NAME", nullable=false, length=50)
    @SearchableProperty
    public String getGroupName() {
        return this.groupName;
    }
    
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
    
    @Column(name="group_key", nullable=false, length=30)
    @SearchableProperty
    public String getGroupKey() {
        return this.groupKey;
    }
    
    public void setGroupKey(String groupKey) {
        this.groupKey = groupKey;
    }
    
    @Column(name="type", nullable=false, length=200)
    @SearchableProperty
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name="user_id", nullable=false)
    @SearchableProperty
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATE_TIME", nullable=false, length=19)
    @SearchableProperty
    public Date getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CfgGroup pojo = (CfgGroup) o;

        if (groupName != null ? !groupName.equals(pojo.groupName) : pojo.groupName != null) return false;
        if (groupKey != null ? !groupKey.equals(pojo.groupKey) : pojo.groupKey != null) return false;
        if (type != null ? !type.equals(pojo.type) : pojo.type != null) return false;
        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (updateTime != null ? !updateTime.equals(pojo.updateTime) : pojo.updateTime != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (groupKey != null ? groupKey.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("groupId").append("='").append(getGroupId()).append("', ");
        sb.append("groupName").append("='").append(getGroupName()).append("', ");
        sb.append("groupKey").append("='").append(getGroupKey()).append("', ");
        sb.append("type").append("='").append(getType()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("updateTime").append("='").append(getUpdateTime()).append("'");
        sb.append("]");
      
        return sb.toString();
    }


	public List<Object> toSimpleJson() {
    	List<Object> a=new ArrayList<Object>();
        a.add(getGroupId().toString());
        a.add(getGroupName());
        a.add(getGroupKey());
        a.add(getType());
        a.add(UtilsCommon.sdf_yyyy_mm_dd_HH_mm_ss.format(getUpdateTime()));
        a.add("");
      
        return a;
    }

	public Long getId() {
		return getGroupId();
	}

}
