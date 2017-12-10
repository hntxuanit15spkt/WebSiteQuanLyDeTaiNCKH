package servlet;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

@WebServlet("/ThemTaiKhoan")
public class ThemTaiKhoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ThemTaiKhoan() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect("Admin");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("utf-8");
		Integer manguoidung = 0;
		
		// Get Account information 
		String tendangnhap = (String) request.getParameter("tendangnhap");
		String matkhau = (String) request.getParameter("matkhau");
		
		// Get people information
		String hoten = (String) request.getParameter("hoten");
		String email = (String) request.getParameter("email");
		String ngaysinh = (String) request.getParameter("ngaysinh");
		String diachi = (String) request.getParameter("diachi");
		String sodienthoai = (String) request.getParameter("sodienthoai");
		String sotaikhoan = (String) request.getParameter("sotaikhoan");
		String lop = (String) request.getParameter("lop");
		String khoahoc = (String) request.getParameter("khoahoc");
		Boolean gioitinh = Boolean.parseBoolean(request.getParameter("gioitinh"));
		Integer mabomon = Integer.valueOf(request.getParameter("mabomon"));
		Integer maloainguoidung = Integer.valueOf(request.getParameter("maloainguoidung"));
		
		Connection c = null;
		
		// Get max manguoidung
		try {
			c = connect.DBConnect.getConnection();
			String sql = "select max(manguoidung) as maxmanguoidung from nguoidung";
			Statement stmt = (Statement) c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				manguoidung = rs.getInt("maxmanguoidung") + 1;
			}

		} catch (Exception e) {
			throw new ServletException(e);
		  }

		// Set new account
		try {
			c = connect.DBConnect.getConnection();
			String sql = "insert into taikhoan (TenDangNhap,MatKhau,MaNguoiDung) values (?, ?, ?)";
			PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
			pstmt.setString(1, tendangnhap);
			pstmt.setString(2, matkhau);
			pstmt.setInt(3, manguoidung);
		    pstmt.executeUpdate();

		}
		catch (Exception e) {
			throw new ServletException(e);
		}
		
		// Set account information
		try {
			c = connect.DBConnect.getConnection();
			String sql = "insert into nguoidung (MaNguoiDung, HoTen, ngaysinh, gioitinh, DiaChi, SoTaiKhoanNganHang, SoDienThoai, Email, MaBoMon, MaLoaiNguoiDung, Lop, KhoaHoc, TrangThaiNguoiDung) values ("+ manguoidung + ", '" + hoten + "', '" + ngaysinh + "', " + gioitinh + ", '" + diachi + "', '" + sotaikhoan + "', '" + sodienthoai + "', '" + email + "', " + mabomon + ", " + maloainguoidung + ", '" + lop + "', '" + khoahoc + "', " + true + ")";
			PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
		    pstmt.executeUpdate();

		}
		catch (Exception e) {
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
		if (maloainguoidung==2)
			response.sendRedirect("Admin");
		else if (maloainguoidung==3)
			response.sendRedirect("ThongTinSinhVien");
		else response.sendRedirect("ThongTinGiangVien");
	}
}
