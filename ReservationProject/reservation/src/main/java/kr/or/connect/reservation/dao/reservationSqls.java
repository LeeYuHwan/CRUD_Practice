package kr.or.connect.reservation.dao;

public class reservationSqls {
	public static final String CATEGORY_SELECT_ALL = "SELECT * FROM category";
	public static final String CATEGORY_COUNT = "SELECT COUNT(*) FROM category";
	public static final String DISPLAY_INFOS = "SELECT product.id AS id, category_id," + 
			"display_info.id AS displayinfo_id, category.name AS NAME, " + 
			"description, content, EVENT, opening_hours, place_name, " + 
			"place_lot, tel, homepage, email, " + 
			"display_info.create_date AS create_date, " + 
			"display_info.modify_date AS modify_date," + 
			"product_image.file_id AS file_id " + 
			"FROM product, category, display_info, display_info_image," + 
			"file_info, product_image " + 
			"WHERE category_id = category.id AND display_info.product_id = product.id " + 
			"AND display_info.id = display_info_id AND file_info.id =  product_image.file_id " + 
			"AND product.id = product_image.product_id AND TYPE = 'ma'";
}
