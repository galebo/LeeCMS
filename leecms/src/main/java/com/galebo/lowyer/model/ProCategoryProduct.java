package com.galebo.lowyer.model;

import com.galebo.common.jgrid.JGridAble;
import com.galebo.lowyer.model.BaseObject;

import org.compass.annotations.Searchable;
import org.compass.annotations.SearchableComponent;
import org.compass.annotations.SearchableId;
import org.compass.annotations.SearchableProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.xml.bind.annotation.XmlRootElement;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="pro_category_product",catalog="lowyer")
@Searchable
@XmlRootElement
public class ProCategoryProduct extends BaseObject implements Serializable,JGridAble {
    private Long categoryProductId;
    private Long categoryId;
    private Long sort;
    private Long productId;
    private Long preId;
    private Long nextId;
    private ProProduct product;

    public ProProduct getProduct() {
		return product;
	}

	public void setProduct(ProProduct product) {
		this.product = product;
	}

	@Id @GeneratedValue(strategy=IDENTITY) @SearchableId    
    public Long getCategoryProductId() {
        return this.categoryProductId;
    }
    
    public void setCategoryProductId(Long categoryProductId) {
        this.categoryProductId = categoryProductId;
    }
    public Long getCategoryId() {
        return this.categoryId;
    }
    
    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
    
    @Column(name="SORT", nullable=false)
    @SearchableProperty
    public Long getSort() {
        return this.sort;
    }
    
    public void setSort(Long sort) {
        this.sort = sort;
    }
    
    @Column(name="product_Id", nullable=false)
    @SearchableProperty
    public Long getProductId() {
        return this.productId;
    }
    
    public void setProductId(Long productId) {
        this.productId = productId;
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

        ProCategoryProduct pojo = (ProCategoryProduct) o;

        if (categoryId != null ? !categoryId.equals(pojo.categoryId) : pojo.categoryId != null) return false;
        if (sort != null ? !sort.equals(pojo.sort) : pojo.sort != null) return false;
        if (productId != null ? !productId.equals(pojo.productId) : pojo.productId != null) return false;
        if (preId != null ? !preId.equals(pojo.preId) : pojo.preId != null) return false;
        if (nextId != null ? !nextId.equals(pojo.nextId) : pojo.nextId != null) return false;

        return true;
    }

    public int hashCode() {
        int result = 0;
        result = (categoryId != null ? categoryId.hashCode() : 0);
        result = 31 * result + (sort != null ? sort.hashCode() : 0);
        result = 31 * result + (productId != null ? productId.hashCode() : 0);
        result = 31 * result + (preId != null ? preId.hashCode() : 0);
        result = 31 * result + (nextId != null ? nextId.hashCode() : 0);

        return result;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer(getClass().getSimpleName());

        sb.append(" [");
        sb.append("categoryProductId").append("='").append(getCategoryProductId()).append("', ");
        sb.append("proCategory").append("='").append(getCategoryId()).append("', ");
        sb.append("sort").append("='").append(getSort()).append("', ");
        sb.append("productId").append("='").append(getProductId()).append("', ");
        sb.append("preId").append("='").append(getPreId()).append("', ");
        sb.append("nextId").append("='").append(getNextId()).append("'");
        sb.append("]");
      
        return sb.toString();
    }

	public Long getId() {
		return getCategoryProductId();
	}

	public List<Object> toSimpleJson() {
    	List<Object> a=new ArrayList<Object>();
        a.add(getCategoryId());
        a.add(getProduct().getProductId());
        a.add(getProduct().getNameCn());
        a.add(getSort());
        a.add(getCategoryProductId());
        return a;
	}

}
