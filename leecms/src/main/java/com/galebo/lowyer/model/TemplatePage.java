package com.galebo.lowyer.model;

import com.galebo.lowyer.model.BaseObject;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;

@Entity
@Table(name="template_page")
@Searchable
@XmlRootElement
public class TemplatePage extends BaseObject implements Serializable {
    private Long templatePageId;
    private Long templateId;
    private String templatePageName;
    private Long userId;
    private String template;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getTemplatePageId() {
        return this.templatePageId;
    }
    
    public void setTemplatePageId(Long templatePageId) {
        this.templatePageId = templatePageId;
    }
    
    @Column(name="template_id", nullable=false)
    @SearchableProperty
    public Long getTemplateId() {
        return this.templateId;
    }
    
    public void setTemplateId(Long templateId) {
        this.templateId = templateId;
    }
    
    @Column(name="template_page_name", nullable=false)
    @SearchableProperty
    public String getTemplatePageName() {
        return this.templatePageName;
    }
    
    public void setTemplatePageName(String templatePageName) {
        this.templatePageName = templatePageName;
    }
    
    @Column(name="user_id", nullable=false)
    @SearchableProperty
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    @Column(name="template", nullable=false, length=65535)
    @SearchableProperty
    public String getTemplate() {
        return this.template;
    }
    
    public void setTemplate(String template) {
        this.template = template;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TemplatePage pojo = (TemplatePage) o;

        if (templateId != null ? !templateId.equals(pojo.templateId) : pojo.templateId != null) return false;
        if (templatePageName != null ? !templatePageName.equals(pojo.templatePageName) : pojo.templatePageName != null) return false;
        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (template != null ? !template.equals(pojo.template) : pojo.template != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (templateId != null ? templateId.hashCode() : 0);
        result = 31 * result + (templatePageName != null ? templatePageName.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (template != null ? template.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("templatePageId").append("='").append(getTemplatePageId()).append("', ");
        sb.append("templateId").append("='").append(getTemplateId()).append("', ");
        sb.append("templatePageName").append("='").append(getTemplatePageName()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("template").append("='").append(getTemplate()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
