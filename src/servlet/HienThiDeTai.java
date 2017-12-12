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
	    Connection c = null;
	    try {
		c = connect.DBConnect.getConnection();
		String sql = "select HoTen, TenLoaiNguoiDung, TenDeTai, MucTieu, TenTrangThai, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianPhanBien \n"
			+ "from taikhoan, nguoidung, loainguoidung, detai_sinhvien, detai, detai_trangthai, trangthai\n"
			+ "where taikhoan.MaNguoiDung = nguoidung.MaNguoiDung\n"
			+ "and nguoidung.MaLoaiNguoiDung = loainguoidung.MaLoaiNguoiDung\n"
			+ "and nguoidung.MaNguoiDung = detai_sinhvien.MaSinhVien\n"
			+ "and detai_sinhvien.MaDeTai = detai.MaDeTai\n"
			+ "and detai.MaDeTai = detai_trangthai.MaDeTai\n"
			+ "and detai_trangthai.MaTrangThai = trangthai.MaTrangThai\n" + "and (taikhoan.TenDangNhap = "
			+ "'" + username + "'" + " or detai.MaGiangVienHuongDan = " + manguoidung + ")";
		Statement stmt = (Statement) c.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
		    DanhSachDeTai dt = new DanhSachDeTai(rs.getString("HoTen"), rs.getString("TenLoaiNguoiDung"),
			    rs.getString("TenDeTai"), rs.getString("MucTieu"), rs.getString("TenTrangThai"),
			    rs.getDate("ThoiGianBatDau"), rs.getDate("ThoiGianKetThuc"),
			    rs.getDate("ThoiGianPhanBien"));
		    lstDeTai.add(dt);
		}
		request.setAttribute("detai", lstDeTai);
		request.getRequestDispatcher("/WEB-INF/hienthidetai.jsp").forward(request, response);
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
}
