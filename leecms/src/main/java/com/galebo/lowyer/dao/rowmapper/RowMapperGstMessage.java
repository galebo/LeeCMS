package com.galebo.lowyer.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.galebo.lowyer.model.GstMessage;

public class RowMapperGstMessage implements RowMapper<GstMessage>{

	@Override
	public GstMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
		GstMessage bean = new GstMessage();
		bean.setId        (rs.getLong     ("id"         ));
		bean.setMessage   (rs.getString   ("message"    ));
		bean.setUserName  (rs.getString   ("user_name"  ));
		bean.setIsPublic  (rs.getLong     ("is_public"  ));
		bean.setCreateTime(rs.getTimestamp("create_time"));
		bean.setContentId (rs.getLong     ("content_id" ));
		return bean;
	}

}