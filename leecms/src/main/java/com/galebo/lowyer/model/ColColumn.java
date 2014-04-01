package com.galebo.lowyer.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
@Table(name="col_column")
@Searchable
@XmlRootElement
public class ColColumn extends BaseObject implements Serializable ,JGridAble{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8080316868994049794L;
	private Long columnId;
    private Long userId;
    private Date CTime;
    private Long smallId;
    private Long maxId;
    private Long firstId;
    private Long lastId;
    private String colName;
    private String colType;
    private String description;
    private String dispType;
    private Long level;
    private String status;
    
    private Long sort;
    private Long colPid;
    private Long relativeId;

	private Set<ColColumnContent> colColumnContents = new HashSet<ColColumnContent>(0);
    private List<ColColumn> sonColumn = new ArrayList<ColColumn>();

    public Long getRelativeId() {
		return relativeId;
	}

	public void setRelativeId(Long relativeId) {
		this.relativeId = relativeId;
	}
    public List<ColColumn> getSonColumn() {
		return sonColumn;
	}

	public void setSonColumn(List<ColColumn> sonColumn) {
		this.sonColumn = sonColumn;
	}

	@Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getColumnId() {
        return this.columnId;
    }
    
    public void setColumnId(Long columnId) {
        this.columnId = columnId;
    }
    
    @Column(name="user_id", nullable=false)
    @SearchableProperty
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="C_TIME", nullable=false, length=10)
    @SearchableProperty
    public Date getCTime() {
        return this.CTime;
    }
    
    public void setCTime(Date CTime) {
        this.CTime = CTime;
    }
    
    @Column(name="SMALL_ID")
    @SearchableProperty
    public Long getSmallId() {
        return this.smallId;
    }
    
    public void setSmallId(Long smallId) {
        this.smallId = smallId;
    }
    
    @Column(name="MAX_ID")
    @SearchableProperty
    public Long getMaxId() {
        return this.maxId;
    }
    
    public void setMaxId(Long maxId) {
        this.maxId = maxId;
    }
    
    @Column(name="FIRST_ID")
    @SearchableProperty
    public Long getFirstId() {
        return this.firstId;
    }
    
    public void setFirstId(Long firstId) {
        this.firstId = firstId;
    }
    
    @Column(name="LAST_ID")
    @SearchableProperty
    public Long getLastId() {
        return this.lastId;
    }
    
    public void setLastId(Long lastId) {
        this.lastId = lastId;
    }
    
    @Column(name="COL_NAME", nullable=false, length=100)
    @SearchableProperty
    public String getColName() {
        return this.colName;
    }
    
    public void setColName(String colName) {
        this.colName = colName;
    }
    
    @Column(name="COL_PID")
    @SearchableProperty
    public Long getColPid() {
        return this.colPid;
    }
    
    public void setColPid(Long colPid) {
        this.colPid = colPid;
    }
    
    @Column(name="COL_TYPE", length=3)
    @SearchableProperty
    public String getColType() {
        return this.colType;
    }
    
    public void setColType(String colType) {
        this.colType = colType;
    }
    
    @Column(name="DESCRIPTION", length=200)
    @SearchableProperty
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    @Column(name="DISP_TYPE", length=3)
    @SearchableProperty
    public String getDispType() {
        return this.dispType;
    }
    
    public void setDispType(String dispType) {
        this.dispType = dispType;
    }
    
    @Column(name="LEVEL")
    @SearchableProperty
    public Long getLevel() {
        return this.level;
    }
    
    public void setLevel(Long level) {
        this.level = level;
    }
    
    @Column(name="SORT")
    @SearchableProperty
    public Long getSort() {
        return this.sort;
    }
    
    public void setSort(Long sort) {
        this.sort = sort;
    }
    
    @Column(name="STATUS", length=3)
    @SearchableProperty
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
@OneToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="colColumn")
    public Set<ColColumnContent> getColColumnContents() {
        return this.colColumnContents;
    }
    
    public void setColColumnContents(Set<ColColumnContent> colColumnContents) {
        this.colColumnContents = colColumnContents;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColColumn pojo = (ColColumn) o;

        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (CTime != null ? !CTime.equals(pojo.CTime) : pojo.CTime != null) return false;
        if (smallId != null ? !smallId.equals(pojo.smallId) : pojo.smallId != null) return false;
        if (maxId != null ? !maxId.equals(pojo.maxId) : pojo.maxId != null) return false;
        if (firstId != null ? !firstId.equals(pojo.firstId) : pojo.firstId != null) return false;
        if (lastId != null ? !lastId.equals(pojo.lastId) : pojo.lastId != null) return false;
        if (colName != null ? !colName.equals(pojo.colName) : pojo.colName != null) return false;
        if (colPid != null ? !colPid.equals(pojo.colPid) : pojo.colPid != null) return false;
        if (colType != null ? !colType.equals(pojo.colType) : pojo.colType != null) return false;
        if (description != null ? !description.equals(pojo.description) : pojo.description != null) return false;
        if (dispType != null ? !dispType.equals(pojo.dispType) : pojo.dispType != null) return false;
        if (level != null ? !level.equals(pojo.level) : pojo.level != null) return false;
        if (sort != null ? !sort.equals(pojo.sort) : pojo.sort != null) return false;
        if (status != null ? !status.equals(pojo.status) : pojo.status != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (CTime != null ? CTime.hashCode() : 0);
        result = 31 * result + (smallId != null ? smallId.hashCode() : 0);
        result = 31 * result + (maxId != null ? maxId.hashCode() : 0);
        result = 31 * result + (firstId != null ? firstId.hashCode() : 0);
        result = 31 * result + (lastId != null ? lastId.hashCode() : 0);
        result = 31 * result + (colName != null ? colName.hashCode() : 0);
        result = 31 * result + (colPid != null ? colPid.hashCode() : 0);
        result = 31 * result + (colType != null ? colType.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (dispType != null ? dispType.hashCode() : 0);
        result = 31 * result + (level != null ? level.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("columnId").append("='").append(getColumnId()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("CTime").append("='").append(getCTime()).append("', ");
        sb.append("smallId").append("='").append(getSmallId()).append("', ");
        sb.append("maxId").append("='").append(getMaxId()).append("', ");
        sb.append("firstId").append("='").append(getFirstId()).append("', ");
        sb.append("lastId").append("='").append(getLastId()).append("', ");
        sb.append("colName").append("='").append(getColName()).append("', ");
        sb.append("colPid").append("='").append(getColPid()).append("', ");
        sb.append("colType").append("='").append(getColType()).append("', ");
        sb.append("description").append("='").append(getDescription()).append("', ");
        sb.append("dispType").append("='").append(getDispType()).append("', ");
        sb.append("level").append("='").append(getLevel()).append("', ");
        sb.append("sort").append("='").append(getSort()).append("', ");
        sb.append("status").append("='").append(getStatus()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }
    public List<Object> toSimpleJson() {
    	List<Object> a=new ArrayList<Object>();
        a.add("");
        a.add(getColumnId());
        a.add(getColName());
        a.add(getSort());
        a.add(UtilsCommon.sdf_yyyy_mm_dd_HH_mm_ss.format(getCTime()));
        a.add(getColPid());
        a.add(relativeId);
        a.add("");
      
        return a;
	}

	public Long getId() {
		return getColumnId();
	}
}
