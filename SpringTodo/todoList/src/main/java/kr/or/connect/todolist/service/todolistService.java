package kr.or.connect.todolist.service;

import java.util.List;

import kr.or.connect.todolist.dto.todolistDto;

public interface todolistService {
	public todolistDto addTodolist(todolistDto todolistdto);
	public List<todolistDto> todoGetTodolst();
	public List<todolistDto> doingGetTodolst();
	public List<todolistDto> doneGetTodolst();
	public long updateTodolist(String type, long id);
}
