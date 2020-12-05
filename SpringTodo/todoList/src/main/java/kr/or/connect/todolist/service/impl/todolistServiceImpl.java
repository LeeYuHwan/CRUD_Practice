package kr.or.connect.todolist.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.todolist.dao.todolistDao;
import kr.or.connect.todolist.dto.todolistDto;
import kr.or.connect.todolist.service.todolistService;

@Service
public class todolistServiceImpl implements todolistService {
	@Autowired
	todolistDao todolistdao;
	
	@Override
	@Transactional(readOnly = false)
	public todolistDto addTodolist(todolistDto todolistdto) {
		todolistdto.setRegdate(new Date());
		todolistdto.setType("TODO");
		Long id = todolistdao.insert(todolistdto);
		todolistdto.setId(id);
		
		return todolistdto;
	}

	@Override
	@Transactional
	public List<todolistDto> todoGetTodolst() {
		List<todolistDto> list = todolistdao.todoSelectAll();
		return list;
	}
	
	@Override
	public List<todolistDto> doingGetTodolst() {
		List<todolistDto> list = todolistdao.doingSelectAll();
		return list;
	}

	@Override
	public List<todolistDto> doneGetTodolst() {
		List<todolistDto> list = todolistdao.doneSelectAll();
		return list;
	}

	@Override
	@Transactional(readOnly = false)
	public long updateTodolist(String type, long id) {
		long count = todolistdao.update(type, id);
		return count;
	}

}
