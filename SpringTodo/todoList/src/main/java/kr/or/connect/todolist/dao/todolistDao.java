package kr.or.connect.todolist.dao;

import static kr.or.connect.todolist.dao.todoSqls.LIST_DOING_UPDATE;
import static kr.or.connect.todolist.dao.todoSqls.LIST_DONE_UPDATE;
import static kr.or.connect.todolist.dao.todoSqls.LIST_SELECT;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import kr.or.connect.todolist.dto.todolistDto;

@Repository
public class todolistDao {
	private NamedParameterJdbcTemplate jdbc;
	private SimpleJdbcInsert insertAction;
	private RowMapper<todolistDto> rowMapper = BeanPropertyRowMapper.newInstance(todolistDto.class);
	
	public todolistDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
		this.insertAction = new SimpleJdbcInsert(dataSource)
				.withTableName("todo")
				.usingGeneratedKeyColumns("id");
	}
	
	public List<todolistDto> todoSelectAll(){
		Map<String, ?> params = Collections.singletonMap("type", "TODO");
		
		return jdbc.query(LIST_SELECT, params, rowMapper);		
	}
	
	public List<todolistDto> doingSelectAll(){
		Map<String, ?> params = Collections.singletonMap("type", "DOING");
		
		return jdbc.query(LIST_SELECT, params, rowMapper);		
	}
	
	public List<todolistDto> doneSelectAll(){
		Map<String, ?> params = Collections.singletonMap("type", "DONE");
		
		return jdbc.query(LIST_SELECT, params, rowMapper);		
	} 
	
	public Long insert(todolistDto todolist) {
		SqlParameterSource params = new BeanPropertySqlParameterSource(todolist);
		return insertAction.executeAndReturnKey(params).longValue();
	}
	
	public int update(String type, Long id) {
		Map<String, ?> params = Collections.singletonMap("id", id);
		String Sql = "";
		if(type.equals("DOING"))
			Sql = LIST_DOING_UPDATE;
		else if(type.equals("DONE"))
			Sql = LIST_DONE_UPDATE;
		
		return jdbc.update(Sql, params);
	}
}
