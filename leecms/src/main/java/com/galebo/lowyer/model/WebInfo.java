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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

@Entity
@Table(name="web_info", uniqueConstraints = {@UniqueConstraint(columnNames="web_domain"), @UniqueConstraint(columnNames="web_tmp_url")} )
@Searchable
@XmlRootElement
public class WebInfo extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 8361118532665704358L;
	private Long webId;
    private Long userId;
    private Long webCfgTemplateId;
    private String webType;
    private Date lastLoginTime;
    private String lastLoginIp;
    private Date expireTime;
    private Date createTime;
    private String webDomain;
    private String webTmpUrl;
    private Long parentId;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getWebId() {
        return this.webId;
    }
    
    public void setWebId(Long webId) {
        this.webId = webId;
    }
    
    @Column(name="user_id", nullable=false)
    @SearchableProperty
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    @Column(name="web_cfg_template_id", nullable=false)
    @SearchableProperty
    public Long getWebCfgTemplateId() {
        return this.webCfgTemplateId;
    }
    
    public void setWebCfgTemplateId(Long webCfgTemplateId) {
        this.webCfgTemplateId = webCfgTemplateId;
    }
    
    @Column(name="web_type", nullable=false, length=3)
    @SearchableProperty
    public String getWebType() {
        return this.webType;
    }
    
    public void setWebType(String webType) {
        this.webType = webType;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="last_login_TIME", nullable=false, length=10)
    @SearchableProperty
    public Date getLastLoginTime() {
        return this.lastLoginTime;
    }
    
    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
    
    @Column(name="last_login_ip", nullable=false)
    @SearchableProperty
    public String getLastLoginIp() {
        return this.lastLoginIp;
    }
    
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="expire_TIME", nullable=false, length=10)
    @SearchableProperty
    public Date getExpireTime() {
        return this.expireTime;
    }
    
    public void setExpireTime(Date expireTime) {
        this.expireTime = expireTime;
    }
    @Temporal(TemporalType.DATE)
    @Column(name="create_TIME", nullable=false, length=10)
    @SearchableProperty
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="web_domain", unique=true, nullable=false)
    @SearchableProperty
    public String getWebDomain() {
        return this.webDomain;
    }
    
    public void setWebDomain(String webDomain) {
        this.webDomain = webDomain;
    }
    
    @Column(name="web_tmp_url", unique=true, nullable=false)
    @SearchableProperty
    public String getWebTmpUrl() {
        return this.webTmpUrl;
    }
    
    public void setWebTmpUrl(String webTmpUrl) {
        this.webTmpUrl = webTmpUrl;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WebInfo pojo = (WebInfo) o;

        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (webCfgTemplateId != null ? !webCfgTemplateId.equals(pojo.webCfgTemplateId) : pojo.webCfgTemplateId != null) return false;
        if (webType != null ? !webType.equals(pojo.webType) : pojo.webType != null) return false;
        if (lastLoginTime != null ? !lastLoginTime.equals(pojo.lastLoginTime) : pojo.lastLoginTime != null) return false;
        if (lastLoginIp != null ? !lastLoginIp.equals(pojo.lastLoginIp) : pojo.lastLoginIp != null) return false;
        if (expireTime != null ? !expireTime.equals(pojo.expireTime) : pojo.expireTime != null) return false;
        if (createTime != null ? !createTime.equals(pojo.createTime) : pojo.createTime != null) return false;
        if (webDomain != null ? !webDomain.equals(pojo.webDomain) : pojo.webDomain != null) return false;
        if (webTmpUrl != null ? !webTmpUrl.equals(pojo.webTmpUrl) : pojo.webTmpUrl != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (webCfgTemplateId != null ? webCfgTemplateId.hashCode() : 0);
        result = 31 * result + (webType != null ? webType.hashCode() : 0);
        result = 31 * result + (lastLoginTime != null ? lastLoginTime.hashCode() : 0);
        result = 31 * result + (lastLoginIp != null ? lastLoginIp.hashCode() : 0);
        result = 31 * result + (expireTime != null ? expireTime.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (webDomain != null ? webDomain.hashCode() : 0);
        result = 31 * result + (webTmpUrl != null ? webTmpUrl.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("webId").append("='").append(getWebId()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("webCfgTemplateId").append("='").append(getWebCfgTemplateId()).append("', ");
        sb.append("webType").append("='").append(getWebType()).append("', ");
        sb.append("lastLoginTime").append("='").append(getLastLoginTime()).append("', ");
        sb.append("lastLoginIp").append("='").append(getLastLoginIp()).append("', ");
        sb.append("expireTime").append("='").append(getExpireTime()).append("', ");
        sb.append("createTime").append("='").append(getCreateTime()).append("', ");
        sb.append("webDomain").append("='").append(getWebDomain()).append("', ");
        sb.append("webTmpUrl").append("='").append(getWebTmpUrl()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}

}
