package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//@WebServlet("/TrangChu")
public class TrangChu extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public TrangChu() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null)
			request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
		else
			response.sendRedirect("dangnhap");
	}

}
