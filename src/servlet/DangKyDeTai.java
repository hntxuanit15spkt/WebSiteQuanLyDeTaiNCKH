package servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DataAccessObject.DangKyDeTai_DAO;
import model.DeTai;

@WebServlet("/dangkydetai")
public class DangKyDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public DangKyDeTai() {
	super();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	String username = (String) session.getAttribute("username");
	if (username != null) {
	    request.getRequestDispatcher("/WEB-INF/dangkydetai1.jsp").forward(request, response);
	} else {
	    response.sendRedirect("dangnhap");
	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setContentType("text/html;charset=UTF-8");
	response.setCharacterEncoding("utf-8");
	HttpSession session = request.getSession();
	String tenDangNhapNCV = (String) session.getAttribute("username");
	DangKyDeTai_DAO dkdt_dao = new DangKyDeTai_DAO();
	String thoiGianBatDau = "";
	thoiGianBatDau = request.getParameter("thoigianbatdau");
	String ngaysinh = request.getParameter("ngaysinh");
	String thoiGianKetThuc = request.getParameter("thoigianketthuc");
	boolean gioitinh = false;
	if (request.getParameter("gioitinh").equals("1")) {
	    gioitinh = true;
	}
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-dd-MM");
	String tendetai = request.getParameter("tendetai");
	String muctieu = request.getParameter("muctieu");
	String motaytuong = request.getParameter("motaytuong");
	String tinhcapthiet = request.getParameter("tinhcapthiet");
	String linhvucnghiencuu = request.getParameter("linhvucnghiencuu");
	String phuongphapthuchien = request.getParameter("phuongphapthuchien");
	BigDecimal kinhphi = new BigDecimal(request.getParameter("kinhphi"));
	int masosinhvien = Integer.parseInt(request.getParameter("masosinhvien"));
	String hoten = request.getParameter("hoten");
	String khoahoc = request.getParameter("khoahoc");
	int maGiangVienHuongDan = Integer.parseInt(request.getParameter("magiangvienhuongdan"));
	String diachi = request.getParameter("diachi");
	int masolop = Integer.parseInt(request.getParameter("masolop"));
	String taikhoannganhang = request.getParameter("taikhoannganhang");
	String sodienthoai = request.getParameter("sodienthoai");
	String email = request.getParameter("email");
	String trangThai = "Chưa xác nhận";
	// String loaiDeTai = "";

	DeTai deTai = new DeTai(tendetai, muctieu, motaytuong, tinhcapthiet, linhvucnghiencuu, phuongphapthuchien,
		kinhphi, thoiGianBatDau, thoiGianKetThuc, maGiangVienHuongDan);
	try {
	    dkdt_dao.InsertDeTai(deTai, tenDangNhapNCV);
	} catch (SQLException e) {

	    e.printStackTrace();
	}
    }
}