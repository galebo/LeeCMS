package com.galebo.lowyer.services.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.galebo.lowyer.bean.common.IdCount;
import com.galebo.lowyer.model.ColColumnContent;

@Service("statistics")
public class Statistics extends BaseService{
	public static Map<Long,List<IdCount>> map=new HashMap<Long,List<IdCount>>();
	public void exe()
	{
		map.clear();
    	Url url=new Url();
    	url.setBaseUrl("../");
		List<ColColumnContent> all = queryDao.getColColumnContentSortByViewCount();
		List<List<IdCount>> lists=new ArrayList<List<IdCount>>();
		if(all.size()>0)
		{
			ArrayList<IdCount> b=new ArrayList<IdCount>();
			Long oldColumnId=all.get(0).getColColumn().getColumnId();
			for (ColColumnContent colColumnContent : all) {
				IdCount convert = Convertor.convert( url,colColumnContent);
				if(!colColumnContent.getColColumn().getColumnId().equals(oldColumnId))
				{
					lists.add(b);
					map.put(oldColumnId, b);
					b=new ArrayList<IdCount>();
					oldColumnId=colColumnContent.getColColumn().getColumnId();
				}
				if(b.size()<10)
					b.add(convert);
				else
				{
					continue;
				}
			}
			map.put(oldColumnId, b);
		}
		for (List<IdCount> list : lists) {
			for (IdCount colColumnContent : list) {
				System.out.println(colColumnContent.getId()
						+"-"+colColumnContent.getName()
						+"-"+colColumnContent.getCount());
			}
		}
	}
	public List<List<IdCount>> get(Long itemId,Url url)
	{
		if(map.size()==0)
			exe();
		List<IdCount> list = Statistics.map.get(itemId);
		for (IdCount idCount : list) {
			idCount.setUrl(url.getDetailUrl(idCount.getId()));
		}
		List<List<IdCount>> rtn=new ArrayList<List<IdCount>>();
		rtn.add(list);
		rtn.add(list);
		return rtn;
	}
}
