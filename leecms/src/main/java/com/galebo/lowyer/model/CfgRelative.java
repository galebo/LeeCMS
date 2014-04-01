package com.galebo.lowyer.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

import com.galebo.lowyer.bean.Sortable;

@Entity
@Table(name="cfg_relative")
@Searchable
@XmlRootElement
public class CfgRelative extends BaseObject implements Serializable,Sortable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4624094357963175958L;
	private Long cfgRelateId;
    private Long elementId;
    private String elementType;
    private String elementType2;
    private Long userId;
    private Long sort;
    private Long parentElementId;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getCfgRelateId() {
        return this.cfgRelateId;
    }
    
    public void setCfgRelateId(Long cfgRelateId) {
        this.cfgRelateId = cfgRelateId;
    }
    
    @Column(name="element_Id", nullable=false)
    @SearchableProperty
    public Long getElementId() {
        return this.elementId;
    }
    
    public void setElementId(Long elementId) {
        this.elementId = elementId;
    }

    @Column(name="element_type", nullable=false, length=3)
    @SearchableProperty
    public String getElementType() {
        return this.elementType;
    }
    
    public void setElementType(String elementType) {
        this.elementType = elementType;
    }
    @Column(name="element_type2", nullable=false, length=3)
    @SearchableProperty
    public String getElementType2() {
        return this.elementType2;
    }
    
    public void setElementType2(String elementType2) {
        this.elementType2 = elementType2;
    }
    
    @Column(name="user_id", nullable=false)
    @SearchableProperty
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    @Column(name="sort", nullable=false)
    @SearchableProperty
    public Long getSort() {
        return this.sort;
    }
    
    public void setSort(Long sort) {
        this.sort = sort;
    }
    
    @Column(name="parent_element_id", nullable=false)
    @SearchableProperty
    public Long getParentElementId() {
        return this.parentElementId;
    }
    
    public void setParentElementId(Long parentElementId) {
        this.parentElementId = parentElementId;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CfgRelative pojo = (CfgRelative) o;

        if (elementId != null ? !elementId.equals(pojo.elementId) : pojo.elementId != null) return false;
        if (elementType != null ? !elementType.equals(pojo.elementType) : pojo.elementType != null) return false;
        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (sort != null ? !sort.equals(pojo.sort) : pojo.sort != null) return false;
        if (parentElementId != null ? !parentElementId.equals(pojo.parentElementId) : pojo.parentElementId != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (elementId != null ? elementId.hashCode() : 0);
        result = 31 * result + (elementType != null ? elementType.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (parentElementId != null ? parentElementId.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("cfgRelateId").append("='").append(getCfgRelateId()).append("', ");
        sb.append("elementId").append("='").append(getElementId()).append("', ");
        sb.append("elementType").append("='").append(getElementType()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("sort").append("='").append(getSort()).append("', ");
        sb.append("parentElementId").append("='").append(getParentElementId()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

	public Long getId() {
		return getCfgRelateId();
	}

	public Long getSonId() {
		return getElementId();
	}
}
