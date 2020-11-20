package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.reservationSqls.PROMOTIONS;
import static kr.or.connect.reservation.dao.reservationSqls.PROMOTIONS_COUNT;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Promotions;

@Repository
public class PromotionsDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Promotions> rowMapper = BeanPropertyRowMapper.newInstance(Promotions.class);
	
	public PromotionsDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Promotions> selectAll(){		
		return jdbc.query(PROMOTIONS, Collections.emptyMap(), rowMapper);		
	}
	
	public int getPromotionsCount() {
		return jdbc.queryForObject(PROMOTIONS_COUNT, Collections.emptyMap(), Integer.class);
	}
}
