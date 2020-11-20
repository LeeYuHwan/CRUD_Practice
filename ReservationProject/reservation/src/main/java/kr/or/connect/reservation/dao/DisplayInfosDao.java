package kr.or.connect.reservation.dao;

import static kr.or.connect.reservation.dao.reservationSqls.DISPLAY_INFOS;
import static kr.or.connect.reservation.dao.reservationSqls.DISPLAY_INFOS_CHOICE;
import static kr.or.connect.reservation.dao.reservationSqls.DISPLAY_INFO_IMAGE_CHOICE;
import static kr.or.connect.reservation.dao.reservationSqls.PRODUCT_IMAGES_CHOICE;
import static kr.or.connect.reservation.dao.reservationSqls.PRODUCT_PRICE_CHOICE;
import static kr.or.connect.reservation.dao.reservationSqls.RESERVATION_USER_COMMENT_CHOICE;
import static kr.or.connect.reservation.dao.reservationSqls.RESERVATION_USER_COMMENT_IMAGE_CHOICE;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import kr.or.connect.reservation.dto.DisplayinfoImage;
import kr.or.connect.reservation.dto.Displayinfos;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.dto.ReservationUserCommentImage;

@Repository
public class DisplayInfosDao {
	private NamedParameterJdbcTemplate jdbc;
	private RowMapper<Displayinfos> disRowMapper = BeanPropertyRowMapper.newInstance(Displayinfos.class);
	private RowMapper<ProductImage> proImaRowMapper = BeanPropertyRowMapper.newInstance(ProductImage.class);
	private RowMapper<DisplayinfoImage> disImaRowMapper = BeanPropertyRowMapper.newInstance(DisplayinfoImage.class);
	private RowMapper<ProductPrice> proRowMapper = BeanPropertyRowMapper.newInstance(ProductPrice.class);
	private RowMapper<ReservationUserComment> userComRowMapper = BeanPropertyRowMapper.newInstance(ReservationUserComment.class);
	private RowMapper<ReservationUserCommentImage> userComImaproRowMapper = BeanPropertyRowMapper.newInstance(ReservationUserCommentImage.class);
	
	public DisplayInfosDao(DataSource dataSource) {
		this.jdbc = new NamedParameterJdbcTemplate(dataSource);
	}
	
	public List<Displayinfos> selectAll(){			
		return jdbc.query(DISPLAY_INFOS, Collections.emptyMap(), disRowMapper);		
	}
	 
	public List<ReservationUserComment> reservationUserCommentSelect(int choiceId) {
		Map<String, ?> params = Collections.singletonMap("choiceId", choiceId);
		return jdbc.query(RESERVATION_USER_COMMENT_CHOICE, params, userComRowMapper);	
	}
	
	public List<ReservationUserCommentImage> reservationUserCommentImageChoice(int choiceId) {
		Map<String, ?> params = Collections.singletonMap("choiceId", choiceId);
		return jdbc.query(RESERVATION_USER_COMMENT_IMAGE_CHOICE, params, userComImaproRowMapper);	
	}
	
	public List<Displayinfos> displayinfosChoice(int choiceId) {
		Map<String, ?> params = Collections.singletonMap("choiceId", choiceId);
		return jdbc.query(DISPLAY_INFOS_CHOICE, params, disRowMapper);
	}
	
	public List<ProductPrice> productPriceChoice(int choiceId) {
		Map<String, ?> params = Collections.singletonMap("choiceId", choiceId);
		return jdbc.query(PRODUCT_PRICE_CHOICE, params, proRowMapper);
	}
	
	public List<ProductImage> productImageChoice(int choiceId) {
		Map<String, ?> params = Collections.singletonMap("choiceId", choiceId);
		return jdbc.query(PRODUCT_IMAGES_CHOICE, params, proImaRowMapper);
	}
	
	public List<DisplayinfoImage> displayInfoImageChoice(int choiceId) {
		Map<String, ?> params = Collections.singletonMap("choiceId", choiceId);
		return jdbc.query(DISPLAY_INFO_IMAGE_CHOICE, params, disImaRowMapper);
	}
		
}
