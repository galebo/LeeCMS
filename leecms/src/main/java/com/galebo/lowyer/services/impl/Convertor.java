package com.galebo.lowyer.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.galebo.lowyer.bean.common.Group;
import com.galebo.lowyer.bean.common.IdCount;
import com.galebo.lowyer.bean.common.UrlNameAuthor;
import com.galebo.lowyer.bean.common.UrlNameAuthorHtml;
import com.galebo.lowyer.bean.common.UrlNameImg;
import com.galebo.lowyer.model.CfgDefineInstance;
import com.galebo.lowyer.model.ColColumnContent;
import com.galebo.lowyer.model.ConContent;
import com.galebo.lowyer.model.ConLink;

public class Convertor {

	static private UrlNameAuthorHtml convert(ColColumnContent one,Url url)
	{
		if(one==null)
			return null;
		UrlNameAuthorHtml urlName = new UrlNameAuthorHtml();
		convert(one, url, urlName);
		urlName.setHtml(one.getConContent().getHtml());
		return urlName;
	}
	static public UrlNameAuthor convert_UrlNameAuthor(ColColumnContent one,Url url)
	{
		if(one==null)
			return null;
		UrlNameAuthor urlName = new UrlNameAuthor();
		convert(one, url, urlName);
		return urlName;
	}
	private static void convert(ColColumnContent one, Url url, UrlNameAuthor urlName) {
		urlName.setId(one.getColumnContentId());
		urlName.setContentId(one.getConContent().getContentId());
		urlName.setUrl(url.getDetailUrl(urlName.getId()));
		urlName.setName(one.getConContent().getNameCn());
		urlName.setAuthor(one.getConContent().getAuthor());
		urlName.setUpdateTime(one.getConContent().getUpdateTime());
		urlName.setSource(one.getConContent().getSource());
		urlName.setPic(one.getConContent().getPic());
		urlName.setDesc(one.getConContent().getDesc());
	}
	static public UrlNameAuthorHtml convert(ColColumnContent one, ColColumnContent pre, ColColumnContent next, Url url)
	{
		if(one==null)
			return null;
		UrlNameAuthorHtml urlName = convert(one,url);
		urlName.setPre(convert(pre,url));
		urlName.setNext(convert(next,url));
		return urlName;
	}
	static public IdCount convert(Url url,ColColumnContent one)
	{
		if(one==null)
			return null;
		IdCount outOne = new IdCount();
		outOne.setId(one.getColumnContentId());
		outOne.setName(one.getConContent().getNameCn());
		outOne.setUrl(url.getDetailUrl(one.getColumnContentId()));
		outOne.setCount(one.getConContent().getViewCount());
		return outOne;
	}
	static public Map<String, String> convert(Map<String, CfgDefineInstance> defines,String imgSite) {
		Map<String, String> defineMap=new HashMap<String, String>();
		for (Iterator<String> it = defines.keySet().iterator(); it.hasNext();) {
			String key = it.next();
			defineMap.put(key, defines.get(key).getText().replace(Constants.uploadDirKey, imgSite));
		}
		return defineMap;
	}
	public static List<UrlNameImg> convert(List<ConLink> in,Url url) {
		List<UrlNameImg> rtn=new ArrayList<UrlNameImg>();
		for (Iterator<ConLink> iterator = in.iterator(); iterator.hasNext();) {
			ConLink one = iterator.next();
			UrlNameImg outOne = convert(one,url);
			rtn.add(outOne);
		}
		return rtn;
	}
	public static Map<String,Group> convert2Map(List<ConLink> in,Url url) {
		Map<String,Group> rtn=new HashMap<String,Group>();
		List<UrlNameImg> list=new ArrayList<UrlNameImg>();
		ConLink old=null;
		for (Iterator<ConLink> iterator = in.iterator(); iterator.hasNext();) {
			ConLink one = iterator.next();
			if(old!=null&&!old.getCfgGroup().getGroupKey().equals(one.getCfgGroup().getGroupKey()))
			{
				Group links=new Group();
				links.setName(old.getCfgGroup().getGroupName());
				links.setSons(list);
				rtn.put(old.getCfgGroup().getGroupKey(), links);

				list=new ArrayList<UrlNameImg>();
			}
			UrlNameImg outOne = convert(one,url);
			list.add(outOne);
			old=one;
		}
		if(old!=null)
		{
			Group links=new Group();
			links.setName(old.getCfgGroup().getGroupName());
			links.setSons(list);
			rtn.put(old.getCfgGroup().getGroupKey(), links);
		}
		return rtn;
	}
	private static UrlNameImg convert(ConLink one, Url url) {
		UrlNameImg outOne = new UrlNameImg();
		outOne.setId(one.getLinkId());
		outOne.setName(one.getTitle());
		outOne.setUrl(url.getLinkUrl(one.getUrl()));
		outOne.setImg(url.getImgUrl(one.getImgUrl()));
		return outOne;
	}
	public static UrlNameAuthorHtml convert(ConContent one, Url url) {
		if(one==null)
			return null;
		UrlNameAuthorHtml urlName = new UrlNameAuthorHtml();
		urlName.setId(one.getContentId());
		urlName.setContentId(one.getContentId());
		urlName.setUrl(url.getDetailNoTitleUrl(urlName.getId()));
		urlName.setName(one.getNameCn());
		urlName.setHtml(one.getHtml());
		urlName.setAuthor(one.getAuthor());
		urlName.setUpdateTime(one.getUpdateTime());
		urlName.setSource(one.getSource());
		return urlName;
	}
	public static UrlNameAuthor convert(Url url,ConContent one) {
		if(one==null)
			return null;
		UrlNameAuthor urlName = new UrlNameAuthor();
		urlName.setId(one.getContentId());
		urlName.setContentId(one.getContentId());
		urlName.setUrl(url.getDetailNoTitleUrl(urlName.getId()));
		urlName.setName(one.getNameCn());
		urlName.setAuthor(one.getAuthor());
		urlName.setUpdateTime(one.getUpdateTime());
		urlName.setSource(one.getSource());
		return urlName;
	}
	public static List<UrlNameAuthor> convert(Url url, List<ConContent> contents) {
		List<UrlNameAuthor> rtn=new ArrayList<UrlNameAuthor>();
		for (ConContent urlNameAuthor : contents) {
			rtn.add(convert(url, urlNameAuthor));
		}
		return rtn;
	}

	public static  List<UrlNameAuthor> convert(Url url,Map<Long, ConContent> contentIdMap) {
		List<UrlNameAuthor> rtn=new ArrayList<UrlNameAuthor>();
		Set<Long> keySet = contentIdMap.keySet();
		for (Long contentId : keySet) {
			UrlNameAuthor convert = convert(url,contentIdMap.get(contentId));
			rtn.add(convert);
		}
		return rtn;
	}
}
