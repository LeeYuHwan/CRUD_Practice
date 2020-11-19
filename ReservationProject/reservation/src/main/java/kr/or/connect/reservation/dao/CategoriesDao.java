package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.reservationSqls.CATEGORY_COUNT;
import static kr.or.connect.reservation.dao.reservationSqls.CATEGORY_SELECT_ALL;

import java.util.Collections;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.Categories;

@Repository
public class CategoriesDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<Categories> rowMapper = BeanPropertyRowMapper.newInstance(Categories.class);
	
	public CategoriesDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("category")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<Categories> selectAll(){
			
		return jdbc.query(CATEGORY_SELECT_ALL, Collections.emptyMap(), rowMapper);		
	}
	
	public int getCategoriesCount() {
		return jdbc.queryForObject(CATEGORY_COUNT, Collections.emptyMap(), Integer.class);
	}
	
}
