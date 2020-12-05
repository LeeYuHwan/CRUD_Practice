package kr.or.connect.todolist.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.connect.todolist.dto.todolistDto;
import kr.or.connect.todolist.service.todolistService;

@Controller
public class formController {
	@Autowired
	todolistService formService;
	
	@PostMapping("/write")
	public String write(@ModelAttribute todolistDto todolistdto, HttpServletRequest request) {
		
		formService.addTodolist(todolistdto);
		return "redirect:main";
	}
	
	@PostMapping("/todoup")
	public String todoup(@RequestParam("todoupf") long id) {
		
		formService.updateTodolist("DOING", id);
		return "redirect:main";
	}
	
	@PostMapping("/doingup")
	public String doingup(@RequestParam("doingupf") long id) {
		
		formService.updateTodolist("DONE", id);
		return "redirect:main";
	}
	
}
