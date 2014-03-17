package com.galebo.lowyer.bean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.galebo.lowyer.bean.common.UrlNameAuthor;
import com.galebo.lowyer.model.LabelValue;

public class IndexSearch {
	static protected final Log log = LogFactory.getLog(IndexSearch.class);
	public final static  String ALL = "ALL";
	static public List<LabelValue> _key1= new ArrayList<LabelValue>();
	static public List<LabelValue> _key2= new ArrayList<LabelValue>();
	static {
		_key2.add(new LabelValue(ALL, ALL));
		for (int i = 'A'; i <= 'Z'; i++) {
			String valueOf = String.valueOf((char) i);
			_key2.add(new LabelValue(valueOf, valueOf));
		}
		_key1.add(new LabelValue(ALL,"所有"));
		_key1.add(new LabelValue("4AA","管理合伙人"));
		_key1.add(new LabelValue("4AB","合伙人"));
		_key1.add(new LabelValue("4AC","律师"));
		_key1.add(new LabelValue("4AD","律师助理"));
		_key1.add(new LabelValue("4AE","专业顾问"));
		_key1.add(new LabelValue("4AF","人力资源"));
		_key1.add(new LabelValue("4AG","市场部"));
	}
	
	Map<String,List<UrlNameAuthor>> sons=new HashMap<String, List<UrlNameAuthor>>();


	public List<LabelValue> getKey1() {
		return _key1;
	}

	public List<LabelValue> getKey2() {
		return _key2;
	}

	public static void main(String[] args) {
		print( IndexSearch._key1);
		print( IndexSearch._key2);
	}

	private static void print(List<LabelValue> key12) {
		String a="[";
		for (int i = 0; i < key12.size(); i++) {
			if(i==0)
				a=a+"{label:'"+key12.get(i).getLabel()+"',value:'"+key12.get(i).getValue()+"'}";
			else
				a=a+",{label:'"+key12.get(i).getLabel()+"',value:'"+key12.get(i).getValue()+"'}";
		}
		a=a+"]";
		log.debug(a);
	}

	public Map<String, List<UrlNameAuthor>> getSons() {
		return sons;
	}

	public void setSons(Map<String, List<UrlNameAuthor>> sons) {
		this.sons = sons;
	}
}
