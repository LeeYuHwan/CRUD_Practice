package kr.or.connect.reservation.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.or.connect.reservation.dao.CategoriesDao;
import kr.or.connect.reservation.dao.DisplayInfosDao;
import kr.or.connect.reservation.dto.Categories;
import kr.or.connect.reservation.dto.Displayinfos;
import kr.or.connect.reservation.service.reservationService;

@Service
public class reservationServiceImpl implements reservationService {

	@Autowired
	CategoriesDao categoriesDao;
	@Autowired
	DisplayInfosDao displayInfosDao;
	
	@Override
	@Transactional
	public List<Categories> getCategories() {
		List<Categories> list = categoriesDao.selectAll();
		return list;
	}

	@Override
	public List<Displayinfos> getDisplayInfos() {
		List<Displayinfos> list = displayInfosDao.selectAll();
		return list;
	}
	
	@Override
	public int getCategoriesCount() {	
		return categoriesDao.getCategoriesCount();
	}
}
