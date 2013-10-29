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
import com.galebo.common.UtilsString;
import com.galebo.common.jgrid.JGridAble;

@Entity
@Table(name="con_content",catalog="lowyer")
@Searchable
@XmlRootElement
public class ConContent extends BaseObject implements Serializable ,JGridAble{
    private Long contentId;
    private Long userId;
    private String nameCn;
    private String source;
    private String status;
    private Date submitTime;
    private Date updateTime;
    private String html;
    private Long viewCount;
    private String author;
    private String pic;
    private String desc;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getContentId() {
        return this.contentId;
    }
    
    public void setContentId(Long contentId) {
        this.contentId = contentId;
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
    
    @Column(name="SOURCE", length=3)
    @SearchableProperty
    public String getSource() {
        return this.source;
    }
    
    public void setSource(String source) {
        this.source = source;
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
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="UPDATE_TIME", nullable=false, length=19)
    @SearchableProperty
    public Date getUpdateTime() {
        return this.updateTime;
    }
    
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
    @Column(name="PIC", nullable=false, length=11)
    @SearchableProperty
    public String getPic() {
        return this.pic;
    }
    
    public void setPic(String pic) {
        this.pic = pic;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConContent pojo = (ConContent) o;

        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (nameCn != null ? !nameCn.equals(pojo.nameCn) : pojo.nameCn != null) return false;
        if (source != null ? !source.equals(pojo.source) : pojo.source != null) return false;
        if (status != null ? !status.equals(pojo.status) : pojo.status != null) return false;
        if (submitTime != null ? !submitTime.equals(pojo.submitTime) : pojo.submitTime != null) return false;
        if (updateTime != null ? !updateTime.equals(pojo.updateTime) : pojo.updateTime != null) return false;
        if (html != null ? !html.equals(pojo.html) : pojo.html != null) return false;
        if (viewCount != null ? !viewCount.equals(pojo.viewCount) : pojo.viewCount != null) return false;
        if (author != null ? !author.equals(pojo.author) : pojo.author != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (nameCn != null ? nameCn.hashCode() : 0);
        result = 31 * result + (source != null ? source.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (submitTime != null ? submitTime.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (html != null ? html.hashCode() : 0);
        result = 31 * result + (viewCount != null ? viewCount.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("contentId").append("='").append(getContentId()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("nameCn").append("='").append(getNameCn()).append("', ");
        sb.append("source").append("='").append(getSource()).append("', ");
        sb.append("status").append("='").append(getStatus()).append("', ");
        sb.append("submitTime").append("='").append(getSubmitTime()).append("', ");
        sb.append("updateTime").append("='").append(getUpdateTime()).append("', ");
        sb.append("html").append("='").append(getHtml()).append("', ");
        sb.append("viewCount").append("='").append(getViewCount()).append("', ");
        sb.append("author").append("='").append(getAuthor()).append("', ");
        
        sb.append("]");
      
        return sb.toString();
    }

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Long getId() {
		return contentId;
	}

	public List<Object> toSimpleJson() {
    	List<Object> a=new ArrayList<Object>();
        a.add("select");
        a.add(getContentId().toString());
        a.add(getNameCn());
        a.add(UtilsCommon.sdf.format(updateTime));
        return a;
	}

}
