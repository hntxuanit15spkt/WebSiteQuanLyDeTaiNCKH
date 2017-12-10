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

import DataAccessObject.DongYDuyet_DAO;
import model.DeTai;

/**
 * Servlet implementation class DuyetDeTai
 */
@WebServlet("/DanhSachChoDuyet")
public class DuyetDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DuyetDeTai() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	String username = (String) session.getAttribute("username");
	String maLoaiNguoiDung = (String) session.getAttribute("maloainguoidung");
	if (username != null && maLoaiNguoiDung.equals("5")) {
	    List<DeTai> lstDeTai = new ArrayList<DeTai>();
	    Connection c = null;
	    try {
		c = connect.DBConnect.getConnection();
		String sql = "select * \r\n" + "from detai_trangthai, detai, nguoidung,taikhoan\r\n"
			+ "where detai_trangthai.MaDeTai in (select MaDeTai from detai_trangthai  group by MaDeTai having COUNT(*) = 2)\r\n"
			+ "and detai.MaDeTai=detai_trangthai.MaDeTai\r\n"
			+ "and nguoidung.MaNguoiDung=taikhoan.MaNguoiDung\r\n" + "and taikhoan.TenDangNhap='" + username
			+ "'\r\n" + "group by detai_trangthai.MaDeTai";
		Statement stmt = (Statement) c.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
		    DeTai dt = new DeTai(rs.getInt("MaDeTai"), rs.getInt("MaGiangVienHuongDan"),
			    rs.getString("TenDeTai"), rs.getString("MucTieu"), rs.getString("MoTaYTuong"),
			    rs.getString("LinhVucNghienCuu"), rs.getString("TinhCapThiet"),
			    rs.getString("PhuongPhapThucHien"), rs.getBigDecimal("KinhPhi"), rs.getString("LoaiDeTai"),
			    rs.getDate("ThoiGianBatDau").toString(), rs.getString("ThoiGianKetThuc").toString());

		    lstDeTai.add(dt);
		}
		request.setAttribute("lstDeTaiCanDuyet", lstDeTai);
		request.getRequestDispatcher("/WEB-INF/danh-sach-cho-duyet.jsp").forward(request, response);
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
	} else {
	    response.sendRedirect("dangnhap");
	}
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	DongYDuyet_DAO dongYDuyet = new DongYDuyet_DAO();
	HttpSession session = request.getSession();
	String loaiNguoiDung = (String) session.getAttribute("maloainguoidung");
	String username = (String) session.getAttribute("username");
	if (loaiNguoiDung.equals("5")) {
	    int maDeTai = Integer.parseInt(request.getParameter("madetai"));
	    int maNguoiDuyet = dongYDuyet.LayMaNguoiDuyet(username);
	    String ngayPhanBien = request.getParameter("ngayphanbien");
	    dongYDuyet.CapNhatDeTai(maDeTai, maNguoiDuyet, ngayPhanBien);
	    dongYDuyet.CapNhatTrangThai(maDeTai, 6);
	    response.sendRedirect("trangchu");
	} else {
	    response.sendRedirect("dangnhap");
	}
    }

}
