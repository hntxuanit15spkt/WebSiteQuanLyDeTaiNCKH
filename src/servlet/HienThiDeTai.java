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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import model.DeTai;

@WebServlet("/HienThiDeTai")
public class HienThiDeTai extends HttpServlet {

    private static final long serialVersionUID = 1L;

    /*
     * protected void doGet(HttpServletRequest request, HttpServletResponse
     * response) throws ServletException, IOException { HttpSession session =
     * request.getSession(); String username = (String)
     * session.getAttribute("username"); if (username != null) { List<DeTai>
     * lstDeTai = new ArrayList<DeTai>(); Connection c = null; try { c =
     * connect.DBConnect.getConnection(); String sql =
     * "select HoTen, TenLoaiNguoiDung, TenDeTai, MucTieu, TenTrangThai, ThoiGianBatDau, ThoiGianKetThuc, ThoiGianPhanBien \n"
     * +
     * "from taikhoan, nguoidung, loainguoidung, detai_sinhvien, detai, detai_trangthai, trangthai\n"
     * + "where taikhoan.MaNguoiDung = nguoidung.MaNguoiDung\n" +
     * "and nguoidung.MaLoaiNguoiDung = loainguoidung.MaLoaiNguoiDung\n" +
     * "and nguoidung.MaNguoiDung = detai_sinhvien.MaSinhVien\n" +
     * "and detai_sinhvien.MaDeTai = detai.MaDeTai\n" +
     * "and detai.MaDeTai = detai_trangthai.MaDeTai\n" +
     * "and detai_trangthai.MaTrangThai = trangthai.MaTrangThai\n" +
     * "and taikhoan.TenDangNhap = " + "'" + username + "'"; Statement stmt =
     * (Statement) c.createStatement(); ResultSet rs = stmt.executeQuery(sql); while
     * (rs.next()) { DeTai dt = new DeTai(rs.getString("HoTen"),
     * rs.getString("TenLoaiNguoiDung"), rs.getString("TenDeTai"),
     * rs.getString("MucTieu"), rs.getString("TenTrangThai"),
     * rs.getDate("ThoiGianBatDau"), rs.getDate("ThoiGianKetThuc"),
     * rs.getDate("ThoiGianPhanBien")); lstDeTai.add(dt); }
     * request.setAttribute("thongtin", lstDeTai);
     * request.getRequestDispatcher("/WEB-INF/hienthidetai.jsp").forward(request,
     * response); } catch (SQLException e) { throw new ServletException(e); }
     * finally { try { if (c != null) { c.close(); } } catch (SQLException e) {
     * throw new ServletException(e); } } } else response.sendRedirect("dangnhap");
     * }
     */

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	List<DeTai> lstDeTai = new ArrayList<DeTai>();
	Connection c = null;
	try {
	    /*
	     * String url =
	     * "jdbc:mysql://localhost/quanlydetainghiencuukhoahoc?user=root&password=15110376";
	     * c = (Connection) DriverManager.getConnection(url);
	     */
	    c = connect.DBConnect.getConnection();
	    Statement stmt = (Statement) c.createStatement();
	    ResultSet rs = stmt.executeQuery("select * from detai order by madetai");
	    while (rs.next()) {
		DeTai dt = new DeTai(rs.getInt("MaDeTai"), rs.getString("TenDeTai"), rs.getString("PhuongPhapThucHien"),
			rs.getString("KinhPhi"), rs.getString("LoaiDeTai"));
		lstDeTai.add(dt);
	    }
	    request.setAttribute("DeTai", lstDeTai);
	    request.getRequestDispatcher("/WEB-INF/testHienThiDeTaiJDBC.jsp").forward(request, response);
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
