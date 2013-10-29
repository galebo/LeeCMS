package com.galebo.lowyer.bean;

import java.util.ArrayList;
import java.util.List;

import com.galebo.common.jgrid.JGridAble;


public class NameKey1234 implements JGridAble{
	Long id;
	String name;
	String key1;
	String key2;
	String key3;
	String key4;
	Long userId;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getKey1() {
		return key1;
	}
	public void setKey1(String key1) {
		this.key1 = key1;
	}
	public String getKey2() {
		return key2;
	}
	public void setKey2(String key2) {
		this.key2 = key2;
	}
	public String getKey3() {
		return key3;
	}
	public void setKey3(String key3) {
		this.key3 = key3;
	}
	public String getKey4() {
		return key4;
	}
	public void setKey4(String key4) {
		this.key4 = key4;
	}
	public List<Object> toSimpleJson() {
    	List<Object> a=new ArrayList<Object>();
        a.add("");
        a.add(getId());
        a.add(getName());
        a.add(getKey1());
        a.add(getKey2());
        a.add(getKey3());
        a.add(getKey4());
        a.add("");
      
        return a;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
