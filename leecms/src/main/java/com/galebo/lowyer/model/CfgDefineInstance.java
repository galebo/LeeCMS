package com.galebo.lowyer.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

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

@Entity
@Table(name="cfgDefineInstance")
@Searchable
@XmlRootElement
public class CfgDefineInstance extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -4962232530762714808L;
	private Long defineInstanceId;
    private Long userId;
    private String title;
    private String text;
    private String type;
    private Date updateTime;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getDefineInstanceId() {
        return this.defineInstanceId;
    }
    
    public void setDefineInstanceId(Long defineInstanceId) {
        this.defineInstanceId = defineInstanceId;
    }
    
    @Column(name="USER_ID", nullable=false)
    @SearchableProperty
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    @Column(name="TITLE", nullable=false, length=200)
    @SearchableProperty
    public String getTitle() {
        return this.title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    @Column(name="TEXT", nullable=false, length=65535)
    @SearchableProperty
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }
    
    @Column(name="TYPE", nullable=false, length=3)
    @SearchableProperty
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
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

        CfgDefineInstance pojo = (CfgDefineInstance) o;

        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (title != null ? !title.equals(pojo.title) : pojo.title != null) return false;
        if (text != null ? !text.equals(pojo.text) : pojo.text != null) return false;
        if (type != null ? !type.equals(pojo.type) : pojo.type != null) return false;
        if (updateTime != null ? !updateTime.equals(pojo.updateTime) : pojo.updateTime != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("defineInstanceId").append("='").append(getDefineInstanceId()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("title").append("='").append(getTitle()).append("', ");
        sb.append("text").append("='").append(getText()).append("', ");
        sb.append("type").append("='").append(getType()).append("', ");
        sb.append("updateTime").append("='").append(getUpdateTime()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
