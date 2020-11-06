package org.web.guestbook.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.web.guestbook.dao.GuestbookDao;
import org.web.guestbook.dto.Guestbook;

/**
 * Servlet implementation class GuestbookGetServlet
 */
@WebServlet("/GuestbookGetServlet")
public class GuestbookGetServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuestbookGetServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Guestbook> list = new ArrayList<>();
		GuestbookDao guest = new GuestbookDao();
		list = guest.getGuestbooks();
		request.setAttribute("list", list);
		RequestDispatcher rd = request.getRequestDispatcher("/guestbookMain.jsp");    
	    rd.forward(request, response); 
		
	}

}
