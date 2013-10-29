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
@Table(name="cfg_template_info",catalog="lowyer")
@Searchable
@XmlRootElement
public class CfgTemplateInfo extends BaseObject implements Serializable {
    private Long cfgTemplateId;
    private Date CTime;
    private String columnCfg;
    private String contentCfg;
    private String page;
    private String status;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getCfgTemplateId() {
        return this.cfgTemplateId;
    }
    
    public void setCfgTemplateId(Long cfgTemplateId) {
        this.cfgTemplateId = cfgTemplateId;
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
    
    @Column(name="column_cfg", length=256)
    @SearchableProperty
    public String getColumnCfg() {
        return this.columnCfg;
    }
    
    public void setColumnCfg(String columnCfg) {
        this.columnCfg = columnCfg;
    }
    
    @Column(name="content_cfg", length=256)
    @SearchableProperty
    public String getContentCfg() {
        return this.contentCfg;
    }
    
    public void setContentCfg(String contentCfg) {
        this.contentCfg = contentCfg;
    }
    
    @Column(name="page", length=256)
    @SearchableProperty
    public String getPage() {
        return this.page;
    }
    
    public void setPage(String page) {
        this.page = page;
    }
    
    @Column(name="STATUS", length=3)
    @SearchableProperty
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CfgTemplateInfo pojo = (CfgTemplateInfo) o;

        if (CTime != null ? !CTime.equals(pojo.CTime) : pojo.CTime != null) return false;
        if (columnCfg != null ? !columnCfg.equals(pojo.columnCfg) : pojo.columnCfg != null) return false;
        if (contentCfg != null ? !contentCfg.equals(pojo.contentCfg) : pojo.contentCfg != null) return false;
        if (page != null ? !page.equals(pojo.page) : pojo.page != null) return false;
        if (status != null ? !status.equals(pojo.status) : pojo.status != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (CTime != null ? CTime.hashCode() : 0);
        result = 31 * result + (columnCfg != null ? columnCfg.hashCode() : 0);
        result = 31 * result + (contentCfg != null ? contentCfg.hashCode() : 0);
        result = 31 * result + (page != null ? page.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("cfgTemplateId").append("='").append(getCfgTemplateId()).append("', ");
        sb.append("CTime").append("='").append(getCTime()).append("', ");
        sb.append("columnCfg").append("='").append(getColumnCfg()).append("', ");
        sb.append("contentCfg").append("='").append(getContentCfg()).append("', ");
        sb.append("page").append("='").append(getPage()).append("', ");
        sb.append("status").append("='").append(getStatus()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
