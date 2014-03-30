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
@Table(name="gst_message")
@Searchable
@XmlRootElement
public class GstMessage extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = -3227130770702348038L;
	private Long id;
    private String message;
    private Long isPublic;
    private Date createTime;
    private Long contentId;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getId() {
        return this.id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    @Column(name="message", nullable=false, length=10240)
    @SearchableProperty
    public String getMessage() {
        return this.message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    @Column(name="is_public", nullable=false)
    @SearchableProperty
    public Long getIsPublic() {
        return this.isPublic;
    }
    
    public void setIsPublic(Long isPublic) {
        this.isPublic = isPublic;
    }
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="create_time", nullable=false, length=19)
    @SearchableProperty
    public Date getCreateTime() {
        return this.createTime;
    }
    
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
    
    @Column(name="content_id")
    @SearchableProperty
    public Long getContentId() {
        return this.contentId;
    }
    
    public void setContentId(Long contentId) {
        this.contentId = contentId;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GstMessage pojo = (GstMessage) o;

        if (message != null ? !message.equals(pojo.message) : pojo.message != null) return false;
        if (isPublic != null ? !isPublic.equals(pojo.isPublic) : pojo.isPublic != null) return false;
        if (createTime != null ? !createTime.equals(pojo.createTime) : pojo.createTime != null) return false;
        if (contentId != null ? !contentId.equals(pojo.contentId) : pojo.contentId != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (message != null ? message.hashCode() : 0);
        result = 31 * result + (isPublic != null ? isPublic.hashCode() : 0);
        result = 31 * result + (createTime != null ? createTime.hashCode() : 0);
        result = 31 * result + (contentId != null ? contentId.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("id").append("='").append(getId()).append("', ");
        sb.append("message").append("='").append(getMessage()).append("', ");
        sb.append("isPublic").append("='").append(getIsPublic()).append("', ");
        sb.append("createTime").append("='").append(getCreateTime()).append("', ");
        sb.append("contentId").append("='").append(getContentId()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
