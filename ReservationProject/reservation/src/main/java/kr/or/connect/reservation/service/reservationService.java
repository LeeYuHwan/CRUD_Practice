package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Categories;
import kr.or.connect.reservation.dto.DisplayinfoImage;
import kr.or.connect.reservation.dto.Displayinfos;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.Promotions;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.dto.ReservationUserCommentImage;

public interface reservationService {
	public List<Categories> getCategories();		
	public List<Displayinfos> getDisplayInfos();
	public List<Promotions> getPromotions();
	public List<ReservationUserComment> getReservationUserComment(int choiceId);
	public List<ReservationUserCommentImage> getReservationUserCommentImageChoice(int choiceId);
	public List<Displayinfos> getDisplayinfoChoice(int choiceId);
	public List<DisplayinfoImage> getDisplayinfoImageChoice(int choiceId);
	public List<ProductImage> getProductImageChoice(int choiceId);
	public List<ProductPrice> getProductPriceChoice(int choiceId);
	
	public int getCategoriesCount();
	public int getPromotionsCount();
}
