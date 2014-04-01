package com.galebo.lowyer.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

import com.galebo.common.jgrid.JGridAble;
import com.galebo.lowyer.bean.Sortable;

@Entity
@Table(name="col_column_content")
@Searchable
@XmlRootElement
public class ColColumnContent extends BaseObject implements Serializable ,Sortable,JGridAble{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3228532305506697073L;
	private Long columnContentId;
    private ColColumn colColumn=new ColColumn();
    private ConContent conContent=new ConContent();
    public ConContent getConContent() {
		return conContent;
	}

	public void setConContent(ConContent conContent) {
		this.conContent = conContent;
	}


	private Long sort;
    private Long preId;
    private Long nextId;

    @Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getColumnContentId() {
        return this.columnContentId;
    }
    
    public void setColumnContentId(Long columnContentId) {
        this.columnContentId = columnContentId;
    }
@ManyToOne(fetch=FetchType.LAZY)
    public ColColumn getColColumn() {
        return this.colColumn;
    }
    
    public void setColColumn(ColColumn colColumn) {
        this.colColumn = colColumn;
    }
    
    @Column(name="SORT", nullable=false)
    @SearchableProperty
    public Long getSort() {
        return this.sort;
    }
    
    public void setSort(Long sort) {
        this.sort = sort;
    }
    @Column(name="PRE_ID")
    @SearchableProperty
    public Long getPreId() {
        return this.preId;
    }
    
    public void setPreId(Long preId) {
        this.preId = preId;
    }
    
    @Column(name="NEXT_ID")
    @SearchableProperty
    public Long getNextId() {
        return this.nextId;
    }
    
    public void setNextId(Long nextId) {
        this.nextId = nextId;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ColColumnContent pojo = (ColColumnContent) o;

        if (colColumn != null ? !colColumn.equals(pojo.colColumn) : pojo.colColumn != null) return false;
        if (sort != null ? !sort.equals(pojo.sort) : pojo.sort != null) return false;
        if (getConContent().getContentId()  != null ? !getConContent().getContentId() .equals(pojo.getConContent().getContentId() ) : pojo.getConContent().getContentId()  != null) return false;
        if (preId != null ? !preId.equals(pojo.preId) : pojo.preId != null) return false;
        if (nextId != null ? !nextId.equals(pojo.nextId) : pojo.nextId != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (colColumn != null ? colColumn.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (getConContent().getContentId() != null ? getConContent().getContentId() .hashCode() : 0);
        result = 31 * result + (preId != null ? preId.hashCode() : 0);
        result = 31 * result + (nextId != null ? nextId.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("columnContentId").append("='").append(getColumnContentId()).append("', ");
        sb.append("colColumn").append("='").append(getColColumn()).append("', ");
        sb.append("sort").append("='").append(getSort()).append("', ");
        sb.append("contentId").append("='").append(getConContent().getContentId()).append("', ");
        sb.append("preId").append("='").append(getPreId()).append("', ");
        sb.append("nextId").append("='").append(getNextId()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

	public Long getId() {
		return getColumnContentId();
	}


    public List<Object> toSimpleJson() {
    	List<Object> a=new ArrayList<Object>();
        a.add(getColColumn().getColumnId().toString());
        a.add(getConContent().getContentId().toString());
        a.add(getConContent().getNameCn());
        a.add(getSort());
        a.add(getColumnContentId().toString());
      
        return a;
    }

	public Long getSonId() {
		return getConContent().getContentId();
	}
}
