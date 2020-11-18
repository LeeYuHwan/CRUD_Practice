package kr.or.connect.mvcexam.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.or.connect.mvcexam.dto.PlusResult;

@Controller
public class PlusApiController {
	@GetMapping("/api/plus")
	@ResponseBody//@ResponseBody 어노테이션이 붙게 되면 해당 메소드는 뷰이름을 리턴하는 것이 아니라, 리턴한 객체를 출력하라는 의미를 가집니다.
	public PlusResult plus(@RequestParam("value1") int value1
			, @RequestParam("value2") int value2) {
		PlusResult plusResult = new PlusResult();
		plusResult.setValue1(value1);
		plusResult.setValue2(value2);
		plusResult.setResult(value1 + value2);
		return plusResult;
	}
}
