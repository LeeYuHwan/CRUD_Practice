package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Categories;

public interface reservationService {
	public List<Categories> getCategories();
	public int getCategoriesCount();
}
