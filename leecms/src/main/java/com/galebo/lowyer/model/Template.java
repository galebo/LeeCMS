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
@Table(name="template",catalog="lowyer")
@Searchable
@XmlRootElement
public class Template extends BaseObject implements Serializable,JGridAble {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1993504384214370501L;
	private Long cfgTemplateId;
    private Date CTime;
    private Long templateId;
    private Long templateCssId;
    private String status;
    private Long userId;

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
    
    @Column(name="template_id", nullable=false)
    @SearchableProperty
    public Long getTemplateId() {
        return this.templateId;
    }
    
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
    
    @Column(name="template_css_id", nullable=false)
    @SearchableProperty
    public Long getTemplateCssId() {
        return this.templateCssId;
    }
    
    public void setTemplateCssId(Long templateCssId) {
        this.templateCssId = templateCssId;
    }
    
    @Column(name="STATUS", nullable=false, length=3)
    @SearchableProperty
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    @Column(name="user_id", nullable=false)
    @SearchableProperty
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Template pojo = (Template) o;

        if (CTime != null ? !CTime.equals(pojo.CTime) : pojo.CTime != null) return false;
        if (templateId != null ? !templateId.equals(pojo.templateId) : pojo.templateId != null) return false;
        if (templateCssId != null ? !templateCssId.equals(pojo.templateCssId) : pojo.templateCssId != null) return false;
        if (status != null ? !status.equals(pojo.status) : pojo.status != null) return false;
        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (CTime != null ? CTime.hashCode() : 0);
        result = 31 * result + (templateId != null ? templateId.hashCode() : 0);
        result = 31 * result + (templateCssId != null ? templateCssId.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("cfgTemplateId").append("='").append(getCfgTemplateId()).append("', ");
        sb.append("CTime").append("='").append(getCTime()).append("', ");
        sb.append("templateId").append("='").append(getTemplateId()).append("', ");
        sb.append("templateCssId").append("='").append(getTemplateCssId()).append("', ");
        sb.append("status").append("='").append(getStatus()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

	public Long getId() {
		return getCfgTemplateId();
	}

	public List<Object> toSimpleJson() {

    	List<Object> a=new ArrayList<Object>();
        a.add(getCfgTemplateId());
        a.add(getTemplateId());
        a.add(getTemplateCssId());
        a.add(UtilsCommon.sdf.format(getCTime()));
        a.add("");
      
        return a;
	}

}
