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

//@WebServlet("/HienThiKhungTen")
public class HienThiKhungTen extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public HienThiKhungTen() {
	super();
    }

    @Override
    /*
     * public void init(ServletConfig config) throws ServletException {
     * super.init(config); try { Class.forName("com.mysql.jdbc.Driver");//
     * initialize jdbc driver } catch (ClassNotFoundException e) { throw new
     * ServletException(e); } }
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {

	request.setCharacterEncoding("utf-8");
	response.setCharacterEncoding("utf-8");

	HttpSession session = request.getSession();

	String username = (String) session.getAttribute("username");
	Boolean flag = true;
	getServletContext().setAttribute("flag", flag);

	List<ThongTinNguoiDung> thongtin = new ArrayList<ThongTinNguoiDung>();
	Connection c = null;

	try {
	    // String url =
	    // "jdbc:mysql://localhost/quanlydetainghiencuukhoahoc?user=root&password=15110376";
	    String sql = "select * from taikhoan, nguoidung, loainguoidung where taikhoan.MaNguoiDung = nguoidung.MaNguoiDung and nguoidung.MaLoaiNguoiDung = loainguoidung.MaLoaiNguoiDung and taikhoan.tendangnhap = "
		    + "'" + username + "'";
	    /* c = (Connection) DriverManager.getConnection(url); */
	    c = connect.DBConnect.getConnection();
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
	request.setAttribute("thongtin", thongtin);
	request.getRequestDispatcher("/WEB-INF/profile_details.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

}
