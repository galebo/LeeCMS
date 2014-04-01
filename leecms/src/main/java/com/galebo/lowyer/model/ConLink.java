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

import com.galebo.common.jgrid.JGridAble;

@Entity
@Table(name="con_link")
@Searchable
@XmlRootElement
public class ConLink extends BaseObject implements Serializable,JGridAble{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7450499980677202985L;
	private Long linkId;
    private String type;
	private Long userId;
    private String title;
    private String url;
    private String imgUrl;
    private Date updateTime;
    private Long sort;
    private Long relativeId;
    private CfgGroup cfgGroup=new CfgGroup();

    public CfgGroup getCfgGroup() {
		return cfgGroup;
	}

	public void setCfgGroup(CfgGroup cfgGroup) {
		this.cfgGroup = cfgGroup;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

    public void setRelativeId(Long relativeId) {
		this.relativeId = relativeId;
	}

	public void setSort(Long sort) {
		this.sort = sort;
	}

	@Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getLinkId() {
        return this.linkId;
    }
    
    public void setLinkId(Long linkId) {
        this.linkId = linkId;
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
    
    @Column(name="URL", nullable=false, length=200)
    @SearchableProperty
    public String getUrl() {
        return this.url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    @Column(name="IMG_URL", length=200)
    @SearchableProperty
    public String getImgUrl() {
        return this.imgUrl;
    }
    
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

        ConLink pojo = (ConLink) o;

        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (title != null ? !title.equals(pojo.title) : pojo.title != null) return false;
        if (url != null ? !url.equals(pojo.url) : pojo.url != null) return false;
        if (imgUrl != null ? !imgUrl.equals(pojo.imgUrl) : pojo.imgUrl != null) return false;
        if (updateTime != null ? !updateTime.equals(pojo.updateTime) : pojo.updateTime != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (imgUrl != null ? imgUrl.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("linkId").append("='").append(getLinkId()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("title").append("='").append(getTitle()).append("', ");
        sb.append("url").append("='").append(getUrl()).append("', ");
        sb.append("imgUrl").append("='").append(getImgUrl()).append("', ");
        sb.append("updateTime").append("='").append(getUpdateTime()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

    public List<Object> toSimpleJson() {
    	List<Object> a=new ArrayList<Object>();
        a.add("");
        a.add(getLinkId());
        a.add(getTitle());
        a.add(getImgUrl());
        a.add(getUrl());
        a.add(sort);
        a.add(relativeId);
        return a;
    }

	public Long getId() {
		return getLinkId();
	}

}
