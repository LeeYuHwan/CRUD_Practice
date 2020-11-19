package kr.or.connect.reservation.service;

import java.util.List;

import kr.or.connect.reservation.dto.Categories;
import kr.or.connect.reservation.dto.Displayinfos;

public interface reservationService {
	public List<Categories> getCategories();		
	public List<Displayinfos> getDisplayInfos();
	
	public int getCategoriesCount();
}
