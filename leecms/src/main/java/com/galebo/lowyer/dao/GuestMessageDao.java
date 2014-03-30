package com.galebo.lowyer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import com.galebo.lowyer.model.GstMessage;

public class GuestMessageDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public GstMessage insertGstMessage(final GstMessage bean){
		final String sql="insert into `gst_message`(`id`,`message`,`is_public`,`create_time`,`content_id`) "
			+"values (?,?,?,?,?)";
	
		final KeyHolder key = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				ps.setLong     (1    , bean.getId        ());
				ps.setString   (2    , bean.getMessage   ());
				ps.setLong     (3    , bean.getIsPublic  ());
				ps.setTimestamp(4    , new Timestamp(bean.getCreateTime().getTime()));
				ps.setLong     (5    , bean.getContentId ());
				return ps;
			}
		}, key);
	
		bean.setId(Long.valueOf(key.getKey().intValue()));
		return bean;
	}
	
	
	public void insertGstMessage_(final GstMessage bean){
		final String sql="insert into `gst_message`(`id`,`message`,`is_public`,`create_time`,`content_id`) "
			+"values (?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{bean.getId(),bean.getMessage(),bean.getIsPublic(),bean.getCreateTime(),bean.getContentId()});
	}


	public void updateGstMessage(GstMessage bean) {
		String sql="update gst_message set id=?,message=?,is_public=?,create_time=?,content_id=? where id=?";
		jdbcTemplate.update(sql,new Object[]{bean.getId(),bean.getMessage(),bean.getIsPublic(),bean.getCreateTime(),bean.getContentId(),bean.getId()});
	}



}
