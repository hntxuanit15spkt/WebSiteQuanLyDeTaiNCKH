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

import model.DeTai;

/**
 * Servlet implementation class XemXetGiahHanDeTai
 */
@WebServlet("/XemXetGiaHanDeTai")
public class XemXetGiaHanDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public XemXetGiaHanDeTai() {
	super();
	// TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
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
		String sql = "select * from detai_trangthai,detai, detai_sinhvien\r\n"
			+ "where detai_trangthai.MaDeTai in (select MaDeTai from detai_trangthai where MaTrangThai=3 group by MaDeTai)\r\n"
			+ "and detai_trangthai.MaDeTai in (select MaDeTai from detai_trangthai where MaTrangThai=6 group by MaDeTai)\r\n"
			+ "and detai_trangthai.MaDeTai not in (select MaDeTai from detai_trangthai where MaTrangThai>6 group by MaDeTai)\r\n"
			+ "and detai_trangthai.MaDeTai=detai.MaDeTai\r\n" + " and detai.MaDeTai=detai_sinhvien.MaDeTai"
			+ " group by detai_trangthai.MaDeTai";
		Statement stmt = (Statement) c.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
		    if (rs.getString("NgayXinGiaHan") != null) {
			DeTai dt = new DeTai(rs.getInt("MaDeTai"), rs.getInt("MaGiangVienHuongDan"),
				rs.getString("TenDeTai"), rs.getString("MucTieu"), rs.getString("MoTaYTuong"),
				rs.getString("LinhVucNghienCuu"), rs.getString("TinhCapThiet"),
				rs.getString("PhuongPhapThucHien"), rs.getBigDecimal("KinhPhi"),
				rs.getString("LoaiDeTai"), rs.getDate("ThoiGianBatDau").toString(),
				rs.getString("ThoiGianKetThuc").toString(), rs.getString("NgayXinGiaHan").toString(),
				rs.getString("ThoiGianThayDoi").toString());
			lstDeTai.add(dt);
		    } else {
			DeTai dt = new DeTai(rs.getInt("MaDeTai"), rs.getInt("MaGiangVienHuongDan"),
				rs.getString("TenDeTai"), rs.getString("MucTieu"), rs.getString("MoTaYTuong"),
				rs.getString("LinhVucNghienCuu"), rs.getString("TinhCapThiet"),
				rs.getString("PhuongPhapThucHien"), rs.getBigDecimal("KinhPhi"),
				rs.getString("LoaiDeTai"), rs.getDate("ThoiGianBatDau").toString(),
				rs.getString("ThoiGianKetThuc").toString(),
				rs.getString("ThoiGianPhanBien").toString());
			lstDeTai.add(dt);
		    }

		}
		request.setAttribute("lstDeTaiCanDuyet", lstDeTai);
		request.getRequestDispatcher("/WEB-INF/danh-sach-cho-gia-han.jsp").forward(request, response);
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

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	// TODO Auto-generated method stub
	doGet(request, response);
    }

}
