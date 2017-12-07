package servlet;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.ThongTinNguoiDung;

//@WebServlet("/TrangChu")
public class TrangChu extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public TrangChu() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	String username = (String) session.getAttribute("username");
	if (username != null) {
	    request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");

	    List<ThongTinNguoiDung> thongtin = new ArrayList<ThongTinNguoiDung>();
	    Connection c = null;

	    try {
		c = connect.DBConnect.getConnection();
		String sql = "select * from taikhoan, nguoidung, loainguoidung where taikhoan.MaNguoiDung = nguoidung.MaNguoiDung and nguoidung.MaLoaiNguoiDung = loainguoidung.MaLoaiNguoiDung and taikhoan.tendangnhap = "
			+ "'" + username + "'";
		Statement stmt = (Statement) c.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		while (rs.next()) {
		    ThongTinNguoiDung tthoten = new ThongTinNguoiDung(rs.getString("HoTen"),
			    rs.getString("TenLoaiNguoiDung"));
		    thongtin.add(tthoten);
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
	    session.setAttribute("thongtin", thongtin);
	    // request.setAttribute("thongtin", thongtin);
	    request.getRequestDispatcher("/WEB-INF/main.jsp").forward(request, response);
	} else
	    response.sendRedirect("dangnhap");
    }

}
