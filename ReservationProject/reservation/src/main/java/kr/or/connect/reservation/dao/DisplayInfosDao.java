package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.reservationSqls.DISPLAY_INFOS;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Displayinfos;

@Repository
public class DisplayInfosDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Displayinfos> rowMapper = BeanPropertyRowMapper.newInstance(Displayinfos.class);
	
	public DisplayInfosDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Displayinfos> selectAll(){
			
		return jdbc.query(DISPLAY_INFOS, Collections.emptyMap(), rowMapper);		
	}
}
