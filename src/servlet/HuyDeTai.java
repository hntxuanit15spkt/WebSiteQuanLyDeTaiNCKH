package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataAccessObject.HuyDeTai_DAO;

/**
 * Servlet implementation class HuyDeTai
 */
@WebServlet("/HuyDeTai")
public class HuyDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HuyDeTai() {
	super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HuyDeTai_DAO huyDeTai = new HuyDeTai_DAO();
	HttpSession session = request.getSession();
	String loaiNguoiDung = (String) session.getAttribute("maloainguoidung");
	String username = (String) session.getAttribute("username");
	if (loaiNguoiDung.equals("3")) {
	    int maDeTai = Integer.parseInt(request.getParameter("madetai"));
	    huyDeTai.CapNhatTrangThaiDeTaiHuy(maDeTai, 5);
	    response.sendRedirect("trangchu");
	} else {
	    response.sendRedirect("dangnhap");
	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

}
