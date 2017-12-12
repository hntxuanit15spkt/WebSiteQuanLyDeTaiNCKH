package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

@WebServlet("/EditNguoiQuanLy")
public class EditNguoiQuanLy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditNguoiQuanLy() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tendangnhap = request.getParameter("tendangnhap");
		Integer maloainguoidung = Integer.valueOf(request.getParameter("maloainguoidung"));
		
		Connection c = null;

		try {
			c = connect.DBConnect.getConnection();
		    String sql = "update taikhoan, nguoidung set matkhau = '', trangthainguoidung = 0 where taikhoan.manguoidung = nguoidung.manguoidung and tendangnhap = " + "'" + tendangnhap + "'";

		    // Use PreparedStstement to get sql' code
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
		if (maloainguoidung == 3)
			response.sendRedirect("ThongTinSinhVien");
		else if (maloainguoidung == 4)
			response.sendRedirect("ThongTinGiangVien");
		else
			response.sendRedirect("Admin");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tendangnhap = request.getParameter("tendangnhap");
		Connection c = null;

		try {
			c = connect.DBConnect.getConnection();
		    String sql = "update taikhoan, nguoidung set matkhau = '123', trangthainguoidung = 1 where taikhoan.manguoidung = nguoidung.manguoidung and tendangnhap = " + "'" + tendangnhap + "'";

		    // Use PreparedStstement to get sql' code
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
		response.sendRedirect("Admin");
	}

}
