package com.galebo.common;

import java.util.ArrayList;
import java.util.List;

import com.galebo.lowyer.model.ColColumn;
import com.galebo.lowyer.model.LabelValue;
import com.galebo.lowyer.services.impl.Constants;

public class Select {
	static List<LabelValue> ColumnType = null;
	static List<LabelValue> Columns = null;
	static {
		ColumnType = new ArrayList<LabelValue>();
		ColumnType.add(new LabelValue("普通栏目",Constants.columnType_normal_3CA));
		ColumnType.add(new LabelValue("图片栏目",Constants.columnType_pic_3CB));
		ColumnType.add(new LabelValue("视频栏目",Constants.columnType_video_3CC));
	}
	static public List<LabelValue> getSelectValueLists(String code) {
		if("Columns".equals(code)){
			return Columns;
		}
		if("ColumnType".equals(code)){
			return ColumnType;
		}
		return new ArrayList<LabelValue>();
	}
	private static void columns() {
		@SuppressWarnings("unchecked")
		List<ColColumn> beans=(List<ColColumn>)SpringContext.getSqlMapClientTemplate().queryForList("getColColumns");
		List<LabelValue> _Columns = new ArrayList<LabelValue>();
		for(ColColumn bean:beans){
			LabelValue labelValue = new LabelValue();
			labelValue.setValue(""+bean.getColumnId());
			labelValue.setLabel(bean.getColName());
			_Columns.add(labelValue);
		}
		Columns=_Columns;
	}
	static public void reset(){
		columns();
	}
}
