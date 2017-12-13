package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataAccessObject.XacNhanGiaHan_DAO;

/**
 * Servlet implementation class GiaHanDeTai
 */
@WebServlet("/GiaHanDeTai")
public class GiaHanDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public GiaHanDeTai() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// Hiện form cho phép nhập vào ngày muốn gia hạn
	HttpSession session = request.getSession();
	XacNhanGiaHan_DAO xacNhanGiaHan = new XacNhanGiaHan_DAO();
	String maDeTai = (String) request.getParameter("madetai");
	String loaiNguoiDung = (String) session.getAttribute("maloainguoidung");
	String username = (String) session.getAttribute("username");
	int maSinhVien = xacNhanGiaHan.LayMaSinhVien(username);
	if (loaiNguoiDung.equals("3")) {
	    request.setAttribute("maDeTai", maDeTai);
	    request.setAttribute("maSinhVien", maSinhVien);
	    request.getRequestDispatcher("/WEB-INF/form-nhap-ngay-xin-gia-han.jsp").forward(request, response);
	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	XacNhanGiaHan_DAO xacNhanGiaHan = new XacNhanGiaHan_DAO();
	HttpSession session = request.getSession();
	String loaiNguoiDung = (String) session.getAttribute("maloainguoidung");
	String username = (String) session.getAttribute("username");
	if (loaiNguoiDung.equals("3")) {
	    int maDeTai = Integer.parseInt(request.getParameter("madetai"));
	    int maSinhVien = Integer.parseInt(request.getParameter("masinhvien"));
	    String ngayXinGiaHan = request.getParameter("ngayxingiahan");
	    xacNhanGiaHan.CapNhatTrangThaiChoGiaHan(maDeTai, 3, maSinhVien, ngayXinGiaHan);
	    response.sendRedirect("trangchu");
	} else {
	    response.sendRedirect("dangnhap");
	}
    }

}
