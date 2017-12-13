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

@WebServlet("/ChiTietDeTai")
public class ChiTietDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	String username = (String) session.getAttribute("username");
	if (username != null) {
	    Integer manguoidung = (Integer) session.getAttribute("manguoidung");
	    Integer madetai = Integer.valueOf(request.getParameter("madetai"));
	    Integer maTrangThai = 0;
	    List<DanhSachDeTai> lstDeTai = new ArrayList<DanhSachDeTai>();
	    List<DanhSachDeTai> detaimatrangthai = new ArrayList<DanhSachDeTai>();
	    List<DanhSachDeTai> chitietdetai = new ArrayList<DanhSachDeTai>();
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
		/*
		 * String sql =
		 * "select MaDeTai, max(MaTrangThai) as maxmtt, ThoiGianThayDoi from detai_trangthai\n"
		 * + "group by MaDeTai;"; Statement stmt = (Statement) c.createStatement();
		 * ResultSet rs = stmt.executeQuery(sql); while (rs.next()) { DanhSachDeTai max
		 * = new DanhSachDeTai(rs.getInt("MaDeTai"), rs.getDate("ThoiGianThayDoi"),
		 * rs.getInt("maxmtt")); detaimatrangthai.add(max); }
		 */
	    } catch (SQLException e) {
		throw new ServletException(e);
	    }
	    for (DanhSachDeTai list : detaimatrangthai) {
		int madetai2 = list.getMaDeTai();
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
		    c = connect.DBConnect.getConnection();
		    sql = "select * from taikhoan, nguoidung, loainguoidung, detai_sinhvien, detai, detai_trangthai, trangthai where taikhoan.MaNguoiDung = nguoidung.MaNguoiDung and nguoidung.MaLoaiNguoiDung = loainguoidung.MaLoaiNguoiDung and nguoidung.MaNguoiDung = detai_sinhvien.MaSinhVien and detai_sinhvien.MaDeTai = detai.MaDeTai and detai.MaDeTai = detai_trangthai.MaDeTai and detai_trangthai.MaTrangThai = trangthai.MaTrangThai and (taikhoan.TenDangNhap = "
			    + "'" + username + "'" + " or detai.MaGiangVienHuongDan = " + manguoidung
			    + ") and detai_trangthai.MaDeTai = " + madetai2 + " and detai_trangthai.MaTrangThai = "
			    + matrangthai;
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

	    // Lấy thông tin đề tài mà sinh viên đã đăng ký

	    try {
		c = connect.DBConnect.getConnection();
		for (DanhSachDeTai list : detaimatrangthai) {
		    if (madetai == list.getMaDeTai()) {
			maTrangThai = list.getMaTrangThai();
		    }
		    int IDLonNhat = list.getIDLonNhat();
		    int matrangthai = 0;
		    String sql = "select * from detai_trangthai where id = " + IDLonNhat;
		    Statement stmt = (Statement) c.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    while (rs.next()) {
			matrangthai = rs.getInt("MaTrangThai");
		    }
		    String slql = "select * " + "from taikhoan, nguoidung, detai_sinhvien, detai, detai_trangthai "
			    + "where taikhoan.MaNguoiDung = nguoidung.MaNguoiDung "
			    + "and detai_trangthai.MaDeTai=detai.MaDeTai " + "and detai_trangthai.MaTrangThai = "
			    + matrangthai + " and nguoidung.MaNguoiDung = detai_sinhvien.MaSinhVien "
			    + "and detai_sinhvien.MaDeTai = detai.MaDeTai and detai.MaDeTai = " + madetai;
		    stmt = (Statement) c.createStatement();

		    rs = stmt.executeQuery(slql);

		    while (rs.next()) {
			DanhSachDeTai ttdt = new DanhSachDeTai(rs.getInt("MaTrangThai"), rs.getInt("MaDeTai"),
				rs.getString("HoTen"), rs.getString("KhoaHoc"), rs.getString("SoTaiKhoanNganHang"),
				rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("Lop"),
				rs.getString("DiaChi"), rs.getString("TenDangNhap"), rs.getString("TenDeTai"),
				rs.getString("MucTieu"), rs.getString("MoTaYTuong"), rs.getString("TinhCapThiet"),
				rs.getString("LinhVucNghienCuu"), rs.getString("PhuongPhapThucHien"),
				rs.getBigDecimal("KinhPhi"), rs.getDate("NgaySinh"), rs.getDate("ThoiGianBatDau"),
				rs.getDate("ThoiGianKetThuc"), rs.getInt("MaGiangVienHuongDan"),
				rs.getBoolean("GioiTinh"));
			chitietdetai.add(ttdt);
		    }
		}

	    } catch (Exception e) {
		throw new ServletException(e);
	    }
	    request.setAttribute("detai", lstDeTai);
	    request.setAttribute("chitietdetai", chitietdetai);
	    request.getRequestDispatcher("/WEB-INF/chitietdetai.jsp").forward(request, response);
	} else
	    response.sendRedirect("dangnhap");
    }
}
