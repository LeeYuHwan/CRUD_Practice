package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Categories;
import kr.or.connect.reservation.service.reservationService;

@RestController
@RequestMapping(path="/api/categories")
public class CategoriesApiController {
	@Autowired
	reservationService categoriesService;
	
	@GetMapping
	public Map<String, Object> list(){
		
		List<Categories> items = categoriesService.getCategories();
				
		Map<String, Object> map = new HashMap<>();
		
		int size = categoriesService.getCategoriesCount();
		
		map.put("items", items);
		map.put("size", size);
		
		return map;	
	}
}
