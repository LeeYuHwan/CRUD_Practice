package kr.or.connect.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import kr.or.connect.todolist.dto.todolistDto;
import kr.or.connect.todolist.service.todolistService;

@Controller
public class mainController {
	@Autowired
	todolistService mainService;
	
	@GetMapping("/main")
	public String list(ModelMap model) {
		List<todolistDto> todolist = mainService.todoGetTodolst();
		List<todolistDto> doinglist = mainService.doingGetTodolst();
		List<todolistDto> donelist = mainService.doneGetTodolst();
		
		model.addAttribute("todolist",todolist);
		model.addAttribute("doinglist",doinglist);
		model.addAttribute("donelist",donelist);
		
		return "main";
	}
	@GetMapping("/todoForm")
	public String form() {
		return "todoForm";
	}
}
