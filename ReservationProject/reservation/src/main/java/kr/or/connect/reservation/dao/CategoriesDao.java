package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.CategoriesDaoSqls.CATEGORY_COUNT;
import static kr.or.connect.reservation.dao.CategoriesDaoSqls.SELECT_ALL;

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
			
		return jdbc.query(SELECT_ALL, Collections.emptyMap(), rowMapper);		
	}
	
	public int getCategoriesCount() {
		return jdbc.queryForObject(CATEGORY_COUNT, Collections.emptyMap(), Integer.class);
	}
	
	/*public Long insert(Categories guestbook) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(guestbook);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public int deleteById(Long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		return jdbc.update(DELETE_BY_ID, params);
	}
	
	*/
}
