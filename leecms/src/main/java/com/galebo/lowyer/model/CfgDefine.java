package com.galebo.lowyer.model;

import com.galebo.lowyer.model.BaseObject;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="cfg_define")
@Searchable
@XmlRootElement
public class CfgDefine extends BaseObject implements Serializable {
    private Long defineId;
    private String positionName;
    private String defaultValue;
    private String key;
    private Date updateTime;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getDefineId() {
        return this.defineId;
    }
    
    public void setDefineId(Long defineId) {
        this.defineId = defineId;
    }
    
    @Column(name="POSITION_NAME", nullable=false, length=100)
    @SearchableProperty
    public String getPositionName() {
        return this.positionName;
    }
    
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }
    
    @Column(name="DEFAULT_VALUE", nullable=false)
    @SearchableProperty
    public String getDefaultValue() {
        return this.defaultValue;
    }
    
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }
    
    @Column(name="KEY_", nullable=false, length=200)
    @SearchableProperty
    public String getKey() {
        return this.key;
    }
    
    public void setKey(String key) {
        this.key = key;
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

        CfgDefine pojo = (CfgDefine) o;

        if (positionName != null ? !positionName.equals(pojo.positionName) : pojo.positionName != null) return false;
        if (defaultValue != null ? !defaultValue.equals(pojo.defaultValue) : pojo.defaultValue != null) return false;
        if (key != null ? !key.equals(pojo.key) : pojo.key != null) return false;
        if (updateTime != null ? !updateTime.equals(pojo.updateTime) : pojo.updateTime != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (positionName != null ? positionName.hashCode() : 0);
        result = 31 * result + (defaultValue != null ? defaultValue.hashCode() : 0);
        result = 31 * result + (key != null ? key.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("defineId").append("='").append(getDefineId()).append("', ");
        sb.append("positionName").append("='").append(getPositionName()).append("', ");
        sb.append("defaultValue").append("='").append(getDefaultValue()).append("', ");
        sb.append("key").append("='").append(getKey()).append("', ");
        sb.append("updateTime").append("='").append(getUpdateTime()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
