package kr.or.connect.reservation.dao;

public class reservationSqls {
	public static final String CATEGORY_SELECT_ALL = "SELECT * FROM category";
	public static final String CATEGORY_COUNT = "SELECT COUNT(*) FROM category";
	public static final String PROMOTIONS_COUNT = "SELECT COUNT(*) FROM promotion";
	public static final String PRODUCT_PRICE_CHOICE = "SELECT * FROM product_price " + 
			"WHERE id <= :choiceId AND id >= 1 " + 
			"ORDER BY id DESC;";
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
	public static final String PROMOTIONS = "SELECT promotion.id AS id, promotion.product_id AS product_id, " + 
			"product.category_id AS category_id, category.name AS category_name, " + 
			"product.description AS description, product_image.file_id AS file_id " + 
			"FROM promotion, product, product_image ,category " + 
			"WHERE promotion.product_id = product.id " + 
			"AND product.category_id = category.id " + 
			"AND product_image.product_id = product.id " + 
			"AND product_image.type = 'ma'";
	public static final String DISPLAY_INFOS_CHOICE = "SELECT product.id AS id, category_id, " + 
			"display_info.id AS displayinfo_id, category.name AS NAME,  " + 
			"description, content, EVENT, opening_hours, place_name,  " + 
			"place_lot, tel, homepage, email, " + 
			"display_info.create_date AS create_date, " + 
			"display_info.modify_date AS modify_date, " + 
			"product_image.file_id AS file_id " + 
			"FROM product, category, display_info, display_info_image, " + 
			"file_info, product_image " + 
			"WHERE category_id = category.id AND display_info.product_id = product.id  " + 
			"AND display_info.id = display_info_id AND file_info.id =  product_image.file_id  " + 
			"AND product.id = product_image.product_id AND TYPE = 'ma' " + 
			"AND product.id = :choiceId";
	public static final String PRODUCT_IMAGES_CHOICE = "SELECT product_id, product_image.id AS product_image_id, " + 
			"TYPE, file_id, file_name, save_file_name, " + 
			"content_type, delete_flag, create_date, modify_date " + 
			"FROM product_image, file_info " + 
			"WHERE file_id = file_info.id AND TYPE = 'ma' " + 
			"AND product_id = :choiceId";
	public static final String DISPLAY_INFO_IMAGE_CHOICE = "SELECT display_info_image.id AS id, display_info_id, " + 
			"file_id, file_name, save_file_name, content_type, " + 
			"delete_flag, create_date, modify_date " + 
			"FROM file_info, display_info_image " + 
			"WHERE file_id = file_info.id AND display_info_image.id = :choiceId";
	public static final String RESERVATION_USER_COMMENT_CHOICE = "SELECT reservation_user_comment.id AS id, " + 
			"product_id, reservation_info_id, " + 
			"score, email AS reservation_eamil, COMMENT, " + 
			"reservation_user_comment.create_date AS create_date, " + 
			"reservation_user_comment.modify_date AS modify_date " + 
			"FROM reservation_user_comment, USER " + 
			"WHERE user_id = user.id " + 
			"AND reservation_user_comment.id >= 1 " + 
			"AND reservation_user_comment.id <= :choiceId " + 
			"ORDER BY reservation_user_comment.id DESC";
	public static final String RESERVATION_USER_COMMENT_IMAGE_CHOICE = "SELECT reservation_user_comment_image.id AS id, " + 
			"reservation_info_id, " + 
			"file_name, save_file_name, content_type, " + 
			"delete_flag, create_date, modify_date " + 
			"FROM reservation_user_comment_image, file_info " + 
			"WHERE reservation_user_comment_image.file_id = file_info.id " + 
			"AND reservation_user_comment_image.reservation_user_comment_id >= 1 " + 
			"AND reservation_user_comment_image.reservation_user_comment_id <= :choiceId;";
}
