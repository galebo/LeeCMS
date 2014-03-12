package com.galebo.lowyer.model;

import com.galebo.lowyer.model.BaseObject;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="con_content_data")
@Searchable
@XmlRootElement
public class ConContentData extends BaseObject implements Serializable {
    private Long contentDataId;
    private ConContent conContent;
    private String isDelete;
    private Date updateTime;
    private String data;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getContentDataId() {
        return this.contentDataId;
    }
    
    public void setContentDataId(Long contentDataId) {
        this.contentDataId = contentDataId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    public ConContent getConContent() {
        return this.conContent;
    }
    
    public void setConContent(ConContent conContent) {
        this.conContent = conContent;
    }
    
    @Column(name="IS_DELETE", nullable=false, length=3)
    @SearchableProperty
    public String getIsDelete() {
        return this.isDelete;
    }
    
    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
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
    
    @Column(name="DATA", nullable=false, length=65535)
    @SearchableProperty
    public String getData() {
        return this.data;
    }
    
    public void setData(String data) {
        this.data = data;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConContentData pojo = (ConContentData) o;

        if (conContent != null ? !conContent.equals(pojo.conContent) : pojo.conContent != null) return false;
        if (isDelete != null ? !isDelete.equals(pojo.isDelete) : pojo.isDelete != null) return false;
        if (updateTime != null ? !updateTime.equals(pojo.updateTime) : pojo.updateTime != null) return false;
        if (data != null ? !data.equals(pojo.data) : pojo.data != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (conContent != null ? conContent.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (data != null ? data.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("contentDataId").append("='").append(getContentDataId()).append("', ");
        sb.append("conContent").append("='").append(getConContent()).append("', ");
        sb.append("isDelete").append("='").append(getIsDelete()).append("', ");
        sb.append("updateTime").append("='").append(getUpdateTime()).append("', ");
        sb.append("data").append("='").append(getData()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
