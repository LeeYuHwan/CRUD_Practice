package kr.or.connect.todolist.dao;

public class todoSqls {
	public static final String LIST_DOING_UPDATE = "update todo set type = 'DOING' where id = :id";
	public static final String LIST_DONE_UPDATE = "update todo set type = 'DONE' where id = :id";
	public static final String LIST_SELECT = "SELECT id, title, NAME, sequence, TYPE, regdate FROM todo WHERE TYPE = :type ORDER BY regdate DESC";
}
