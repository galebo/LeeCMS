package com.galebo.lowyer.services;

import java.util.List;

import com.galebo.lowyer.bean.Common;
import com.galebo.lowyer.bean.Detail;
import com.galebo.lowyer.bean.Index;
import com.galebo.lowyer.bean.IndexSearch;
import com.galebo.lowyer.bean.Item;
import com.galebo.lowyer.bean.common.UrlNameAuthorHtml;
import com.galebo.lowyer.model.Template;
import com.galebo.lowyer.services.impl.Url;

public interface BeanCreater {
	public List<Template> getTemplateAll();
	public Template getUserTemplate(long userId);
	public Common getCommon(Long userId,Long parentId,Url url);
	public Index getIndex(Url url,Common common);
	public Item getItem(Long itemId, Url url,Common common);
	public Detail getDetail(Long columnContentId, Url url,Common common);
	public Item getSearchItem(List<UrlNameAuthorHtml> contents,String key,Url url,Common common);
	public Detail getDetail2(Long contentId, Url url, Common common);
	public IndexSearch getIndeSearch(Url url, Common common);
}