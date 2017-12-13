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

@WebServlet("/KetQuaPhanBien")
public class KetQuaPhanBien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public KetQuaPhanBien() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			Integer manguoidung = (Integer) session.getAttribute("manguoidung");
			List<DanhSachDeTai> ketquaphanbien = new ArrayList<DanhSachDeTai>();
		    List<DanhSachDeTai> detaimatrangthai = new ArrayList<DanhSachDeTai>();
			Integer mahoidong = 0;
			Connection c = null;
			
			try {
				c = connect.DBConnect.getConnection();
				String sql = "select MaDeTai, max(MaTrangThai) as maxmtt, ThoiGianThayDoi from detai_trangthai group by MaDeTai;";
			    Statement stmt = (Statement) c.createStatement();
			    ResultSet rs = stmt.executeQuery(sql);
			    while (rs.next()) {
			    DanhSachDeTai max = new DanhSachDeTai(rs.getInt("MaDeTai"), rs.getDate("ThoiGianThayDoi"), rs.getInt("maxmtt"));
			    detaimatrangthai.add(max);
			    }
			} catch (SQLException e) {
			    throw new ServletException(e);
			}
			
			for (DanhSachDeTai list : detaimatrangthai) {
		    	int madetai = list.getMaDeTai();
				try {
					c = connect.DBConnect.getConnection();
					String sql = "select MaHoiDong from detai where madetai = " + madetai;
				    Statement stmt = (Statement) c.createStatement();
				    ResultSet rs = stmt.executeQuery(sql);
				    while (rs.next()) {
				    	mahoidong = rs.getInt("MaHoiDong");
				    }
				} catch (SQLException e) {
				    throw new ServletException(e);
				}
				// Có mã đề tài và mã trang thái cao nhất
				
				try {
					c = connect.DBConnect.getConnection();
					String sql = "select *, (select avg(DiemDanhGia) from detai_sinhvien, detai, chitiethoidongphanbien, detai_trangthai where detai_sinhvien.MaDeTai = detai.MaDeTai and detai.MaHoiDong = chitiethoidongphanbien.MaHoiDong and detai.MaDeTai = detai_trangthai.MaDeTai and (detai_trangthai.MaTrangThai = 7 or detai_trangthai.MaTrangThai = 8) and detai_sinhvien.MaSinhVien = " + manguoidung + " and chitiethoidongphanbien.MaHoiDong = " + mahoidong + ") as trungbinh from detai_sinhvien, detai, chitiethoidongphanbien, detai_trangthai, trangthai where detai_sinhvien.MaDeTai = detai.MaDeTai and detai.MaHoiDong = chitiethoidongphanbien.MaHoiDong and detai.MaDeTai = detai_trangthai.MaDeTai and detai_trangthai.MaTrangThai = trangthai.MaTrangThai and (detai_trangthai.matrangthai = 7 or detai_trangthai.matrangthai = 8) and detai_sinhvien.MaSinhVien =  " + manguoidung + " and detai_sinhvien.MaDeTai = " + madetai;
				    Statement stmt = (Statement) c.createStatement();
				    ResultSet rs = stmt.executeQuery(sql);
				    
				    while (rs.next()) {
				    DanhSachDeTai kqpb = new DanhSachDeTai(rs.getInt("MaDeTai"), rs.getString("TenDeTai"), rs.getString("TenTrangThai"), rs.getFloat("trungbinh"));
				    ketquaphanbien.add(kqpb);
				    }
				    
				} catch (SQLException e) {
				    throw new ServletException(e);
			    }
		    }
			
			

		    request.setAttribute("ketquaphanbien", ketquaphanbien);
		    request.getRequestDispatcher("/WEB-INF/ketquaphanbien.jsp").forward(request, response);
		} else
			response.sendRedirect("dangnhap");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
