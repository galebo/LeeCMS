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
@Table(name="pro_product",catalog="lowyer")
@Searchable
@XmlRootElement
public class ProProduct extends BaseObject implements Serializable {
    private Long productId;
    private Long userId;
    private String nameCn;
    private String status;
    private Date submitTime;
    private String html;
    private Long viewCount;
    private String author;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getProductId() {
        return this.productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    
    @Column(name="USER_ID")
    @SearchableProperty
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    @Column(name="NAME_CN", nullable=false, length=200)
    @SearchableProperty
    public String getNameCn() {
        return this.nameCn;
    }
    
    public void setNameCn(String nameCn) {
        this.nameCn = nameCn;
    }
    
    @Column(name="STATUS", length=3)
    @SearchableProperty
    public String getStatus() {
        return this.status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="SUBMIT_TIME", nullable=false, length=10)
    @SearchableProperty
    public Date getSubmitTime() {
        return this.submitTime;
    }
    
    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }
    
    @Column(name="HTML", nullable=false, length=65535)
    @SearchableProperty
    public String getHtml() {
        return this.html;
    }
    
    public void setHtml(String html) {
        this.html = html;
    }
    
    @Column(name="VIEW_COUNT", nullable=false)
    @SearchableProperty
    public Long getViewCount() {
        return this.viewCount;
    }
    
    public void setViewCount(Long viewCount) {
        this.viewCount = viewCount;
    }
    
    @Column(name="AUTHOR", nullable=false, length=11)
    @SearchableProperty
    public String getAuthor() {
        return this.author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProProduct pojo = (ProProduct) o;

        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (nameCn != null ? !nameCn.equals(pojo.nameCn) : pojo.nameCn != null) return false;
        if (status != null ? !status.equals(pojo.status) : pojo.status != null) return false;
        if (submitTime != null ? !submitTime.equals(pojo.submitTime) : pojo.submitTime != null) return false;
        if (html != null ? !html.equals(pojo.html) : pojo.html != null) return false;
        if (viewCount != null ? !viewCount.equals(pojo.viewCount) : pojo.viewCount != null) return false;
        if (author != null ? !author.equals(pojo.author) : pojo.author != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (nameCn != null ? nameCn.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (submitTime != null ? submitTime.hashCode() : 0);
        result = 31 * result + (html != null ? html.hashCode() : 0);
        result = 31 * result + (viewCount != null ? viewCount.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("productId").append("='").append(getProductId()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("nameCn").append("='").append(getNameCn()).append("', ");
        sb.append("status").append("='").append(getStatus()).append("', ");
        sb.append("submitTime").append("='").append(getSubmitTime()).append("', ");
        sb.append("html").append("='").append(getHtml()).append("', ");
        sb.append("viewCount").append("='").append(getViewCount()).append("', ");
        sb.append("author").append("='").append(getAuthor()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
