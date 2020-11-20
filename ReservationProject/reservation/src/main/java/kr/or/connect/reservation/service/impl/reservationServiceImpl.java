package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoriesDao;
import kr.or.connect.reservation.dao.DisplayInfosDao;
import kr.or.connect.reservation.dao.PromotionsDao;
import kr.or.connect.reservation.dto.Categories;
import kr.or.connect.reservation.dto.DisplayinfoImage;
import kr.or.connect.reservation.dto.Displayinfos;
import kr.or.connect.reservation.dto.ProductImage;
import kr.or.connect.reservation.dto.ProductPrice;
import kr.or.connect.reservation.dto.Promotions;
import kr.or.connect.reservation.dto.ReservationUserComment;
import kr.or.connect.reservation.dto.ReservationUserCommentImage;
import kr.or.connect.reservation.service.reservationService;

@Service
public class reservationServiceImpl implements reservationService {

	@Autowired
	CategoriesDao categoriesDao;
	@Autowired
	DisplayInfosDao displayInfosDao;
	@Autowired
	PromotionsDao promotionsDao;
		
	@Override
	@Transactional
	public List<Categories> getCategories() {
		List<Categories> list = categoriesDao.selectAll();
		return list;
	}

	@Override
	@Transactional
	public List<Displayinfos> getDisplayInfos() {
		List<Displayinfos> list = displayInfosDao.selectAll();
		return list;
	}
	
	@Override
	@Transactional
	public List<Promotions> getPromotions() {
		List<Promotions> list = promotionsDao.selectAll();
		return list;
	}
	
	@Override
	@Transactional
	public int getCategoriesCount() {	
		return categoriesDao.getCategoriesCount();
	}

	@Override
	@Transactional
	public int getPromotionsCount() {
		return promotionsDao.getPromotionsCount();
	}

	@Override
	@Transactional
	public List<Displayinfos> getDisplayinfoChoice(int choiceId) {
		List<Displayinfos> list = displayInfosDao.displayinfosChoice(choiceId);
		return list;
	}

	@Override
	@Transactional
	public List<DisplayinfoImage> getDisplayinfoImageChoice(int choiceId) {
		List<DisplayinfoImage> list = displayInfosDao.displayInfoImageChoice(choiceId);
		return list;
	}

	@Override
	@Transactional
	public List<ProductImage> getProductImageChoice(int choiceId) {
		List<ProductImage> list = displayInfosDao.productImageChoice(choiceId);
		return list;
	}

	@Override
	@Transactional
	public List<ProductPrice> getProductPriceChoice(int choiceId) {
		List<ProductPrice> list = displayInfosDao.productPriceChoice(choiceId);
		return list;
	}

	@Override
	@Transactional
	public List<ReservationUserComment> getReservationUserComment(int choiceId) {
		List<ReservationUserComment> list = displayInfosDao.reservationUserCommentSelect(choiceId);
		return list;
	}

	@Override
	@Transactional
	public List<ReservationUserCommentImage> getReservationUserCommentImageChoice(int choiceId) {
		List<ReservationUserCommentImage> list = displayInfosDao.reservationUserCommentImageChoice(choiceId);
		return list;
	}
}
