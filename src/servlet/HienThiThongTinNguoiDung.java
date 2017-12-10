package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import model.ThongTinNguoiDung;

@WebServlet("/HienThiThongTinNguoiDung")
public class HienThiThongTinNguoiDung extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HienThiThongTinNguoiDung() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	String username = (String) session.getAttribute("username");
	if (username != null) {

	    List<ThongTinNguoiDung> lstThongTinNguoiDung = new ArrayList<ThongTinNguoiDung>();
	    Connection c = null;

	    try {
		c = connect.DBConnect.getConnection();
		String sql = "select * from taikhoan, nguoidung, loainguoidung where taikhoan.MaNguoiDung = nguoidung.MaNguoiDung and nguoidung.MaLoaiNguoiDung = loainguoidung.MaLoaiNguoiDung and taikhoan.tendangnhap = "
			+ "'" + username + "'";
		Statement stmt = (Statement) c.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
		    ThongTinNguoiDung thongtin = new ThongTinNguoiDung(rs.getString("TenDangNhap"),
			    rs.getString("MatKhau"), rs.getInt("MaNguoiDung"), rs.getInt("MaBoMon"),
			    rs.getInt("MaLoaiNguoiDung"), rs.getString("HoTen"), rs.getString("DiaChi"),
			    rs.getString("SoTaiKhoanNganHang"), rs.getString("SoDienThoai"), rs.getString("Email"),
			    rs.getString("MaSo"), rs.getString("Lop"), rs.getString("KhoaHoc"),
			    rs.getString("TenLoaiNguoiDung"), rs.getDate("NgaySinh"), rs.getBoolean("GioiTinh"),
			    rs.getBoolean("TrangThaiNguoiDung"));
		    lstThongTinNguoiDung.add(thongtin);
		}

	    } catch (Exception e) {
		throw new ServletException(e);
	    }

	    finally {
		try {
		    if (c != null)
			c.close();
		} catch (Exception e) {
		    throw new ServletException(e);
		}
	    }
	    request.setAttribute("thongtin", lstThongTinNguoiDung);
	    request.getRequestDispatcher("/WEB-INF/thongtincanhan.jsp").forward(request, response);
	} else
	    response.sendRedirect("dangnhap");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	request.setCharacterEncoding("UTF-8");
	response.setCharacterEncoding("utf-8");
	// Get info
	Integer manguoidung = Integer.valueOf(request.getParameter("manguoidung"));
	String key = request.getParameter("name");
	System.out.println(key);
	String value = request.getParameter(key);
	Connection c = null;

	try {
	    String sql = "update nguoidung, taikhoan set " + key + " = " + "'" + value + "'"
		    + " where taikhoan.manguoidung = nguoidung.manguoidung and nguoidung.manguoidung =" + manguoidung;

	    // Use PreparedStstement to get sql' code
	    c = connect.DBConnect.getConnection();
	    PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
	    pstmt.executeUpdate();

	} catch (Exception e) {
	    throw new ServletException(e);
	}

	finally {
	    try {
		if (c != null)
		    c.close();
	    } catch (Exception e) {
		throw new ServletException(e);
	    }
	}
	response.sendRedirect("thongtin");
    }

}
