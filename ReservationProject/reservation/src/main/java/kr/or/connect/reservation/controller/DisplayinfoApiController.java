package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Displayinfos;
import kr.or.connect.reservation.service.reservationService;

@RestController
@RequestMapping(path="/api/displayinfos")
public class DisplayinfoApiController {
	@Autowired
	reservationService displayinfosService;
	
	@GetMapping
	public Map<String, Object> list(){	
		List<Displayinfos> products = displayinfosService.getDisplayInfos();
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("products", products);	
		
		return map;
	}
}
