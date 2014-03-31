package com.galebo.lowyer.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.galebo.lowyer.dao.rowmapper.RowMapperGstMessage;
import com.galebo.lowyer.model.GstMessage;
@Service("commonDao")
public class CommonDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	/*public GstMessage insertGstMessage(final GstMessage bean){
		final String sql="insert into `gst_message`(`message`,`user_name`,`is_public`,`create_time`,`content_id`) "
			+"values (?,?,?,?,?)";
	
		final KeyHolder key = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				PreparedStatement ps = con.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
				int i=1;
				ps.setString   (i++    , bean.getMessage   ()               );
				ps.setString   (i++    , bean.getUserName()                 );
				ps.setLong     (i++    , bean.getIsPublic ()                );
				ps.setTimestamp(i++    , new Timestamp(new Date().getTime()));
				ps.setLong     (i++    , bean.getContentId ()               );
				return ps;
			}
		}, key);
	
		bean.setId(Long.valueOf(key.getKey().intValue()));
		return bean;
	}



	public void updateGstMessage(GstMessage bean) {
		String sql="update gst_message set id=?,message=?,is_public=?,create_time=?,content_id=? where id=?";
		jdbcTemplate.update(sql,new Object[]{bean.getId(),bean.getMessage(),bean.getIsPublic(),bean.getCreateTime(),bean.getContentId(),bean.getId()});
	}*/


	public int getGstMessagesSize() {
		return jdbcTemplate.queryForInt("select count(id) from gst_message");
	}
	public List<GstMessage> getGstMessages(int page,int pageSize){
		return jdbcTemplate.query("select * from gst_message order by id desc limit ?,?",new Object[]{ page, pageSize},new RowMapperGstMessage());
	}
	public void insertGstMessage(final GstMessage bean){
		final String sql="insert into `gst_message`(`message`,`user_name`,`is_public`,`create_time`,`content_id`) "
			+"values (?,?,?,?,?)";
		jdbcTemplate.update(sql,new Object[]{bean.getMessage(),bean.getUserName(),bean.getIsPublic(),bean.getCreateTime(),bean.getContentId()});
	}

}
