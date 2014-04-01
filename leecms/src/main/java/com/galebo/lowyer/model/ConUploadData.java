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
@Table(name="con_upload_data")
@Searchable
@XmlRootElement
public class ConUploadData extends BaseObject implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 7950232668385976473L;
	private Long uploadDataId;
    private String newName;
    private String name;
    private Long size;
    private Long userId;
    private String type;
    private String location;
    private String isDelete;
    private Date updateTime;
    private String address;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getUploadDataId() {
        return this.uploadDataId;
    }
    
    public void setUploadDataId(Long uploadDataId) {
        this.uploadDataId = uploadDataId;
    }
    
    @Column(name="NEW_NAME", nullable=false)
    @SearchableProperty
    public String getNewName() {
        return this.newName;
    }
    
    public void setNewName(String newName) {
        this.newName = newName;
    }
    
    @Column(name="NAME", nullable=false)
    @SearchableProperty
    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Column(name="SIZE", nullable=false)
    @SearchableProperty
    public Long getSize() {
        return this.size;
    }
    
    public void setSize(Long size) {
        this.size = size;
    }
    
    @Column(name="USER_ID", nullable=false)
    @SearchableProperty
    public Long getUserId() {
        return this.userId;
    }
    
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    
    @Column(name="TYPE", nullable=false, length=20)
    @SearchableProperty
    public String getType() {
        return this.type;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    @Column(name="LOCATION", nullable=false, length=1024)
    @SearchableProperty
    public String getLocation() {
        return this.location;
    }
    
    public void setLocation(String location) {
        this.location = location;
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
    
    @Column(name="ADDRESS", nullable=false, length=1024)
    @SearchableProperty
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ConUploadData pojo = (ConUploadData) o;

        if (newName != null ? !newName.equals(pojo.newName) : pojo.newName != null) return false;
        if (name != null ? !name.equals(pojo.name) : pojo.name != null) return false;
        if (size != null ? !size.equals(pojo.size) : pojo.size != null) return false;
        if (userId != null ? !userId.equals(pojo.userId) : pojo.userId != null) return false;
        if (type != null ? !type.equals(pojo.type) : pojo.type != null) return false;
        if (location != null ? !location.equals(pojo.location) : pojo.location != null) return false;
        if (isDelete != null ? !isDelete.equals(pojo.isDelete) : pojo.isDelete != null) return false;
        if (updateTime != null ? !updateTime.equals(pojo.updateTime) : pojo.updateTime != null) return false;
        if (address != null ? !address.equals(pojo.address) : pojo.address != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (newName != null ? newName.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (size != null ? size.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (location != null ? location.hashCode() : 0);
        result = 31 * result + (isDelete != null ? isDelete.hashCode() : 0);
        result = 31 * result + (updateTime != null ? updateTime.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("uploadDataId").append("='").append(getUploadDataId()).append("', ");
        sb.append("newName").append("='").append(getNewName()).append("', ");
        sb.append("name").append("='").append(getName()).append("', ");
        sb.append("size").append("='").append(getSize()).append("', ");
        sb.append("userId").append("='").append(getUserId()).append("', ");
        sb.append("type").append("='").append(getType()).append("', ");
        sb.append("location").append("='").append(getLocation()).append("', ");
        sb.append("isDelete").append("='").append(getIsDelete()).append("', ");
        sb.append("updateTime").append("='").append(getUpdateTime()).append("', ");
        sb.append("address").append("='").append(getAddress()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

}
