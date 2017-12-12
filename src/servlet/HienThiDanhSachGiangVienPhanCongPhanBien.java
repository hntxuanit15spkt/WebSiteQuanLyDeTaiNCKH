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

import model.GiangVien;

/**
 * Servlet implementation class PhanCongHoiDongPhanBienDeTai
 */
@WebServlet("/HienThiDanhSachGiangVienPhanCongPhanBien")
public class HienThiDanhSachGiangVienPhanCongPhanBien extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String maDeTai = request.getParameter("madetai");
	HttpSession session = request.getSession();
	String username = (String) session.getAttribute("username");
	String maLoaiNguoiDung = (String) session.getAttribute("maloainguoidung");
	if (username != null && maLoaiNguoiDung.equals("5")) {
	    List<GiangVien> lstGiangVien = new ArrayList<GiangVien>();
	    Connection c = null;
	    try {
		c = connect.DBConnect.getConnection();
		// Chọn ra những giảng viên không phải là giảng viên hướng dẫn của đề tài đang
		// phân công hội đồng phản biện
		String sql = "select * from detai,nguoidung,bomon\r\n" + "where MaDeTai=" + maDeTai + "\r\n"
			+ "and detai.MaGiangVienHuongDan!=nguoidung.MaNguoiDung\r\n"
			+ " and nguoidung.MaLoaiNguoiDung=4" + " and nguoidung.MaBoMon=bomon.MaBoMon";
		Statement stmt = (Statement) c.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
		    GiangVien gv = new GiangVien(rs.getInt("MaGiangVienHuongDan"), rs.getInt("MaNguoiDung"),
			    rs.getString("HoTen"), rs.getString("TenBoMon"));
		    lstGiangVien.add(gv);
		}
		request.setAttribute("lstGiangVien", lstGiangVien);
		request.setAttribute("maDeTai_PhanCongPhanBien", maDeTai);
		request.getRequestDispatcher("/WEB-INF/danh-sach-giang-vien-phan-bien.jsp").forward(request, response);
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
	}
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
