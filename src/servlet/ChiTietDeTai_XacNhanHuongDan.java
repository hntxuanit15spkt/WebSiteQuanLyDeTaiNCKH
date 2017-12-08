package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import connect.DBConnect;
import model.DeTai;
import model.ThongTinNguoiDung;
import view_model.SinhVien_DeTai;

/**
 * Servlet implementation class ChiTietDeTai_XacNhanHuongDan
 */
@WebServlet("/ChiTietDeTai_XacNhanHuongDan")
public class ChiTietDeTai_XacNhanHuongDan extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChiTietDeTai_XacNhanHuongDan() {
	super();
	// TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	String maDeTai = request.getParameter("madetai");
	String maGiangVienHuongDan = request.getParameter("magiangvienhuongdan");
	HttpSession session = request.getSession();
	String tenDangNhap = (String) session.getAttribute("username");
	SinhVien_DeTai dt_sv = null;
	DeTai dt = null;
	ThongTinNguoiDung sv = null;
	Connection c = null;
	try {
	    c = DBConnect.getConnection();
	    Statement stmt = (Statement) c.createStatement();
	    String sql = "select * from detai, nguoidung,detai_trangthai where detai_trangthai.MaDeTai=detai.MaDeTai \r\n"
		    + "and MaTrangThai=1 and MaNguoiDung=" + maGiangVienHuongDan + " and detai.MaDeTai=" + maDeTai + "";
	    ResultSet rs = stmt.executeQuery(sql);
	    while (rs.next()) {
		dt = new DeTai(rs.getInt("MaDeTai"), rs.getString("TenDeTai"), rs.getString("MucTieu"),
			rs.getString("MoTaYTuong"), rs.getString("TinhCapThiet"), rs.getString("LinhVucNghienCuu"),
			rs.getString("PhuongPhapThucHien"), rs.getBigDecimal("KinhPhi"), rs.getString("ThoiGianBatDau"),
			rs.getString("ThoiGianKetThuc"));
		/*
		 * dt_sv = new SinhVien_DeTai(rs.getString("TenDeTai"), rs.getString("MucTieu"),
		 * rs.getString("MoTaYTuong"), rs.getString("TinhCapThiet"),
		 * rs.getString("LinhVucNghienCuu"), rs.getString("PhuongPhapThucHien"),
		 * rs.getBigDecimal("KinhPhi"), rs.getString("ThoiGianBatDau"),
		 * rs.getString("ThoiGianKetThuc"), rs.getString("HoTen"),
		 * rs.getString("DiaChi"), rs.getString("SoTaiKhoanNganHang"),
		 * rs.getString("SoDienThoai"), rs.getString("Email"), rs.getString("MaSo"),
		 * rs.getString("Lop"), rs.getString("KhoaHoc"), rs.getString("NgaySinh"),
		 * rs.getBoolean("GioiTinh"));
		 */
	    }
	    sql = "select * from detai, nguoidung, detai_sinhvien,detai_trangthai\r\n"
		    + "where detai.MaDeTai=detai_sinhvien.MaDeTai\r\n"
		    + "and nguoidung.MaNguoiDung=detai_sinhvien.MaSinhVien\r\n" + " and detai_trangthai.MaDeTai=1\r\n"
		    + "and detai_trangthai.MaDeTai=" + maDeTai + "\r\n" + " and detai.MaGiangVienHuongDan="
		    + maGiangVienHuongDan;
	    rs = stmt.executeQuery(sql);
	    while (rs.next()) {
		sv = new ThongTinNguoiDung(rs.getString("HoTen"), rs.getString("DiaChi"),
			rs.getString("SoTaiKhoanNganHang"), rs.getString("SoDienThoai"), rs.getString("Email"),
			rs.getString("MaSo"), rs.getString("Lop"), rs.getString("KhoaHoc"), rs.getDate("NgaySinh"),
			rs.getBoolean("GioiTinh"));
	    }
	    request.setAttribute("ThongTin_DeTai", dt);
	    request.setAttribute("ThongTin_SinhVien", sv);
	    request.getRequestDispatcher("/WEB-INF/chi-tiet-de-tai-xac-nhan-hd.jsp").forward(request, response);
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

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

    }

}
