package com.galebo.lowyer.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.galebo.lowyer.bean.Common;
import com.galebo.lowyer.bean.Detail;
import com.galebo.lowyer.bean.Item;

public class CmsMap {
	Map<String,Common> commonMap=new HashMap<String,Common>();
	Map<String,Item> itemMap=new HashMap<String,Item>();
	Map<String,Detail> detailMap=new HashMap<String,Detail>();
	Map<String,Detail> contentMap=new HashMap<String,Detail>();
	public static CmsMap cmsMap=new CmsMap();

	public Map<String, Item> getItemMap() {
		return itemMap;
	}

	public void setItemMap(Map<String, Item> itemMap) {
		this.itemMap = itemMap;
	}

	public Map<String, Detail> getDetailMap() {
		return detailMap;
	}

	public void setDetailMap(Map<String, Detail> detailMap) {
		this.detailMap = detailMap;
	}

	public Map<String, Common> getCommonMap() {
		return commonMap;
	}

	public void setCommonMap(Map<String, Common> commonMap) {
		this.commonMap = commonMap;
	}

	public Map<String, Detail> getContentMap() {
		return contentMap;
	}

	public void setContentMap(Map<String, Detail> contentMap) {
		this.contentMap = contentMap;
	}
	public static void clearMap(Long userId) {
		String findKey=userId+"_";
		clearMap(CmsMap.cmsMap.getCommonMap(),findKey);
		CmsMap.cmsMap.getItemMap().clear();
		CmsMap.cmsMap.getDetailMap().clear();
		CmsMap.cmsMap.getContentMap().clear();
	}
	private static void clearMap(Map<String,?> map,String findKey) {
		Set<String> keySet =map.keySet();
		List<String> a=new ArrayList<String>();
		for (String key : keySet) {
			if(key.startsWith(findKey))
			{
				a.add(key);
			}
		}
		for (String key : a) {
			map.remove(key);
		}
	}

}
