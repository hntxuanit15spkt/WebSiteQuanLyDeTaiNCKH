package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DongYGiaHanDeTai_DAO;

@WebServlet("/DongYGiaHanDeTai")
public class DongYGiaHanDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DongYGiaHanDeTai() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	String loaiNguoiDung = (String) session.getAttribute("maloainguoidung");
	if (loaiNguoiDung.equals("5")) {
	    int maDeTai = Integer.parseInt((String) request.getParameter("madetai"));
	    int maSinhVien = Integer.parseInt((String) request.getParameter("masinhvien"));
	    String ngayXinGiaHan = request.getParameter("ngayxingiahan");
	    DongYGiaHanDeTai_DAO dygh_dao = new DongYGiaHanDeTai_DAO();
	    dygh_dao.DongYGiaHan(maDeTai, maSinhVien, 6, ngayXinGiaHan);
	    request.getRequestDispatcher("/WEB-INF/ThongBaoDongYHuongDanDeTai.jsp").forward(request, response);
	} else {
	    response.sendRedirect("dangnhap");
	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

}
