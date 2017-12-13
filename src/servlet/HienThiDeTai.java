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

import model.DanhSachDeTai;

@WebServlet("/HienThiDeTai")
public class HienThiDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	String username = (String) session.getAttribute("username");
	if (username != null) {
	    Integer manguoidung = (Integer) session.getAttribute("manguoidung");
	    List<DanhSachDeTai> lstDeTai = new ArrayList<DanhSachDeTai>();
	    List<DanhSachDeTai> detaimatrangthai = new ArrayList<DanhSachDeTai>();
	    Connection c = null;
	    try {
		c = connect.DBConnect.getConnection();
		String sql = "select MaDeTai, MAX(id) as IDLonNhat, ThoiGianThayDoi  from detai_trangthai group by MaDeTai";
		Statement stmt = (Statement) c.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
		    DanhSachDeTai max = new DanhSachDeTai(rs.getInt("MaDeTai"), rs.getDate("ThoiGianThayDoi"),
			    rs.getInt("IDLonNhat"));
		    detaimatrangthai.add(max);
		}

	    } catch (SQLException e) {
		throw new ServletException(e);
	    }
	    for (DanhSachDeTai list : detaimatrangthai) {
		int madetai = list.getMaDeTai();
		int IDLonNhat = list.getIDLonNhat();
		int matrangthai = 0;
		try {
		    c = connect.DBConnect.getConnection();
		    String sql = "select * from detai_trangthai where id = " + IDLonNhat;
		    Statement stmt = (Statement) c.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    while (rs.next()) {
			matrangthai = rs.getInt("MaTrangThai");
		    }
		    sql = "select * from taikhoan, nguoidung, loainguoidung, detai_sinhvien, detai, detai_trangthai, trangthai where taikhoan.MaNguoiDung = nguoidung.MaNguoiDung and nguoidung.MaLoaiNguoiDung = loainguoidung.MaLoaiNguoiDung and nguoidung.MaNguoiDung = detai_sinhvien.MaSinhVien and detai_sinhvien.MaDeTai = detai.MaDeTai and detai.MaDeTai = detai_trangthai.MaDeTai and detai_trangthai.MaTrangThai = trangthai.MaTrangThai and (taikhoan.TenDangNhap = "
			    + "'" + username + "'" + " or detai.MaGiangVienHuongDan = " + manguoidung
			    + ") and detai_trangthai.MaDeTai = " + madetai + " and detai_trangthai.MaTrangThai = "
			    + matrangthai + " group by detai.MaDeTai";
		    stmt = (Statement) c.createStatement();
		    rs = stmt.executeQuery(sql);
		    while (rs.next()) {
			DanhSachDeTai dt = new DanhSachDeTai(rs.getInt("MaTrangThai"), rs.getString("HoTen"),
				rs.getString("TenLoaiNguoiDung"), rs.getInt("MaDeTai"), rs.getString("TenDeTai"),
				rs.getString("MucTieu"), rs.getString("TenTrangThai"), rs.getDate("ThoiGianBatDau"),
				rs.getDate("ThoiGianKetThuc"), rs.getDate("ThoiGianPhanBien"));
			lstDeTai.add(dt);
		    }

		} catch (SQLException e) {
		    throw new ServletException(e);
		}
	    }

	    request.setAttribute("detai", lstDeTai);
	    request.getRequestDispatcher("/WEB-INF/hienthidetai.jsp").forward(request, response);
	} else
	    response.sendRedirect("dangnhap");
    }
    /*
     * protected void doGet(HttpServletRequest request, HttpServletResponse
     * response) throws ServletException, IOException { HttpSession session =
     * request.getSession(); String username = (String)
     * session.getAttribute("username"); if (username != null) { Integer manguoidung
     * = (Integer) session.getAttribute("manguoidung"); List<DanhSachDeTai> lstDeTai
     * = new ArrayList<DanhSachDeTai>(); List<DanhSachDeTai> detaimatrangthai = new
     * ArrayList<DanhSachDeTai>(); Connection c = null; try { c =
     * connect.DBConnect.getConnection(); String sql =
     * "select MaDeTai, max(MaTrangThai) as maxmtt, ThoiGianThayDoi from detai_trangthai\n"
     * + "group by MaDeTai;"; Statement stmt = (Statement) c.createStatement();
     * ResultSet rs = stmt.executeQuery(sql); while (rs.next()) { DanhSachDeTai max
     * = new DanhSachDeTai(rs.getInt("MaDeTai"), rs.getDate("ThoiGianThayDoi"),
     * rs.getInt("maxmtt")); detaimatrangthai.add(max); } } catch (SQLException e) {
     * throw new ServletException(e); } for (DanhSachDeTai list : detaimatrangthai)
     * { int madetai = list.getMaDeTai(); int matrangthai = list.getMaTrangThai();
     * try { c = connect.DBConnect.getConnection(); String sql =
     * "select * from taikhoan, nguoidung, loainguoidung, detai_sinhvien, detai, detai_trangthai, trangthai where taikhoan.MaNguoiDung = nguoidung.MaNguoiDung and nguoidung.MaLoaiNguoiDung = loainguoidung.MaLoaiNguoiDung and nguoidung.MaNguoiDung = detai_sinhvien.MaSinhVien and detai_sinhvien.MaDeTai = detai.MaDeTai and detai.MaDeTai = detai_trangthai.MaDeTai and detai_trangthai.MaTrangThai = trangthai.MaTrangThai and (taikhoan.TenDangNhap = "
     * + "'" + username + "'" + " or detai.MaGiangVienHuongDan = " + manguoidung +
     * ") and detai_trangthai.MaDeTai = " + madetai +
     * " and detai_trangthai.MaTrangThai = " + matrangthai +
     * " group by detai.MaDeTai"; Statement stmt = (Statement) c.createStatement();
     * ResultSet rs = stmt.executeQuery(sql);
     * 
     * while (rs.next()) { DanhSachDeTai dt = new
     * DanhSachDeTai(rs.getInt("MaTrangThai"), rs.getString("HoTen"),
     * rs.getString("TenLoaiNguoiDung"), rs.getInt("MaDeTai"),
     * rs.getString("TenDeTai"), rs.getString("MucTieu"),
     * rs.getString("TenTrangThai"), rs.getDate("ThoiGianBatDau"),
     * rs.getDate("ThoiGianKetThuc"), rs.getDate("ThoiGianPhanBien"));
     * lstDeTai.add(dt); }
     * 
     * } catch (SQLException e) { throw new ServletException(e); } }
     * 
     * request.setAttribute("detai", lstDeTai);
     * request.getRequestDispatcher("/WEB-INF/hienthidetai.jsp").forward(request,
     * response); } else response.sendRedirect("dangnhap"); }
     */
}
