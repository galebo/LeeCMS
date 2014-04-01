package com.galebo.lowyer.model;

import java.util.ArrayList;
import java.util.List;

import com.galebo.common.jgrid.JGridAble;

public class IndexMenu implements JGridAble{
    private Long Id;
    private String name;
    private String type;
    
    private Long sort;
    private Long colPid;
    private Long relativeId;

    public Long getRelativeId() {
		return relativeId;
	}

	public void setRelativeId(Long relativeId) {
		this.relativeId = relativeId;
	}
    public Long getColPid() {
        return this.colPid;
    }
    
    public void setColPid(Long colPid) {
        this.colPid = colPid;
    }
    public Long getSort() {
        return this.sort;
    }
    
    public void setSort(Long sort) {
        this.sort = sort;
    }

    public List<Object> toSimpleJson() {
    	List<Object> a=new ArrayList<Object>();
        a.add("");
        a.add(getId());
        a.add(getName());
        a.add(type);
        a.add(getSort());
        a.add(getColPid());
        a.add(relativeId);
        a.add("");
      
        return a;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Long id) {
		Id = id;
	}

	public Long getId() {
		return Id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
