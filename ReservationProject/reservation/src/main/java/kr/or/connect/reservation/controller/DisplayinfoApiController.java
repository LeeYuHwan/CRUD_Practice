package kr.or.connect.reservation.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.DisplayinfoImage;
import kr.or.connect.reservation.dto.Displayinfos;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.dto.ReservationUserCommentImage;
import kr.or.connect.reservation.service.reservationService;

@RestController
@RequestMapping(path="/api/displayinfos")
public class DisplayinfoApiController {
	@Autowired
	reservationService displayinfosService;
	
	@GetMapping
	public Map<String, Object> list(){	
		List<Displayinfos> products = displayinfosService.getDisplayInfos();
		List<ReservationUserComment> reservationUserComments = displayinfosService.getReservationUserComment(5);
		List<ReservationUserCommentImage> reservationUserCommentImages = displayinfosService.getReservationUserCommentImageChoice(5);
		//5개씩 불러온다.
		
		Map<String, Object> map = new HashMap<>();
		
		map.put("products", products);	
		map.put("reservationUserComments", reservationUserComments);
		map.put("reservationUserCommentImages", reservationUserCommentImages);
		return map;
	}
	@GetMapping("/{id}")
	public Map<String, Object> choice(@PathVariable(name = "id") int id){
		List<Displayinfos> products = displayinfosService.getDisplayinfoChoice(id);
		List<ProductImage> productImages = displayinfosService.getProductImageChoice(id);
		List<DisplayinfoImage> displayInfoImages = displayinfosService.getDisplayinfoImageChoice(id);
		List<ProductPrice> productPrices = displayinfosService.getProductPriceChoice(3);
		//원래 댓글점수의 평균값을 일단은 3으로 초기화
		Map<String, Object> map = new HashMap<>();
		
		map.put("products", products);	
		map.put("productImages", productImages);
		map.put("displayInfoImages", displayInfoImages);
		map.put("avgScore", 3); //원래 댓글점수의 평균값을 일단은 3으로 초기화
		map.put("productPrices", productPrices);
		
		return map;
	}
}
