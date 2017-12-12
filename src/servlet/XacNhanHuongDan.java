package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import view_model.SinhVien_DeTai;

/**
 * Servlet implementation class XacNhanHuongDan
 */
@WebServlet("/XacNhanHuongDan")
public class XacNhanHuongDan extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public XacNhanHuongDan() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	String username = (String) session.getAttribute("username");
	String maLoaiNguoiDung = (String) session.getAttribute("maloainguoidung");
	/*
	 * Integer maLoaiNguoiDung = Integer.parseInt((String)
	 * session.getAttribute("maloainguoidung"));
	 */
	if (username != null && maLoaiNguoiDung.equals("4")) {
	    List<SinhVien_DeTai> lstDeTai_SinhVien = new ArrayList<SinhVien_DeTai>();
	    Connection c = null;
	    try {
		c = connect.DBConnect.getConnection();
		String sql = "select detai.MaGiangVienHuongDan,detai.MaDeTai, TenDeTai,ThoiGianBatDau, ThoiGianKetThuc\r\n"
			+ "from taikhoan, nguoidung, detai, detai_trangthai\r\n"
			+ "where detai.MaGiangVienHuongDan = taikhoan.MaNguoiDung\r\n"
			+ " and detai.MaDeTai = detai_trangthai.MaDeTai\r\n" + "and detai_trangthai.MaTrangThai = 1\r\n"
			+ " and detai.MaDeTai not in (select MaDeTai from detai_trangthai\r\n" + "where MaTrangThai!=1)"
			+ " and nguoidung.MaLoaiNguoiDung=4 " + "and taikhoan.TenDangNhap = " + "'" + username + "'"
			+ " group by MaDeTai";
		Statement stmt = (Statement) c.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
		    SinhVien_DeTai dt_sv = new SinhVien_DeTai(rs.getInt("MaGiangVienHuongDan"), rs.getInt("MaDeTai"),
			    rs.getString("TenDeTai"), rs.getDate("ThoiGianBatDau").toString(),
			    rs.getString("ThoiGianKetThuc").toString());

		    lstDeTai_SinhVien.add(dt_sv);
		}
		request.setAttribute("danhsachdetaicanxacnhan", lstDeTai_SinhVien);
		request.getRequestDispatcher("/WEB-INF/danh-sach-de-tai-can-xac-nhan-huong-dan.jsp").forward(request,
			response);
	    } catch (SQLException e) {
		throw new ServletException(e);
	    } finally {
		try {
		    if (c != null) {
			c.close();
		    }
		} catch (SQLException e) {
		    throw new ServletException(e);
		}
	    }
	} else
	    response.sendRedirect("dangnhap");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

}
