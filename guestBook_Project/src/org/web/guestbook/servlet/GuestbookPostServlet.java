package org.web.guestbook.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.guestbook.dao.GuestbookDao;
import org.web.guestbook.dto.Guestbook;

/**
 * Servlet implementation class GuestbookPostServlet
 */
@WebServlet("/GuestbookPostServlet")
public class GuestbookPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestbookPostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		
		Guestbook guestbook = new Guestbook(name, content);
		GuestbookDao guestbookDao = new GuestbookDao();
		guestbookDao.addGuestbook(guestbook);
		 		 
		response.sendRedirect("http://localhost:8080/guestBook_Project/GuestbookGetServlet");
	}

}
