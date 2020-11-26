package kr.or.connect.reservation.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.or.connect.reservation.dto.Reservationinfos;
import kr.or.connect.reservation.service.reservationService;

@RestController
@RequestMapping(path="/api/reservationInfos")
public class ReservationApiController {
	@Autowired
	reservationService reservationinfosService;
	
	@PostMapping
	public Reservationinfos write(@RequestBody Reservationinfos reservationinfos,
						HttpServletRequest request) {
		String clientIp = request.getRemoteAddr();
		// id가 입력된 guestbook이 반환된다.
		Reservationinfos resultGuestbook = reservationinfosService.addGuestbook(reservationinfos);
		return resultGuestbook;
	}
}
