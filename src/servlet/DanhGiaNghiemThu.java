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
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import model.DanhSachDeTai;

@WebServlet("/DanhGiaNghiemThu")
public class DanhGiaNghiemThu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DanhGiaNghiemThu() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			Integer manguoidung = (Integer) session.getAttribute("manguoidung");
			List<DanhSachDeTai> detainghiemthu = new ArrayList<DanhSachDeTai>();
			List<DanhSachDeTai> detaimatrangthai = new ArrayList<DanhSachDeTai>();
			Connection c = null;
			
			try {
				c = connect.DBConnect.getConnection();
				String sql = "select MaDeTai, max(id) as maxid, ThoiGianThayDoi from detai_trangthai group by MaDeTai;";
			    Statement stmt = (Statement) c.createStatement();
			    ResultSet rs = stmt.executeQuery(sql);
			    while (rs.next()) {
			    DanhSachDeTai max = new DanhSachDeTai(rs.getInt("MaDeTai"), rs.getDate("ThoiGianThayDoi"), rs.getInt("maxid"));
			    detaimatrangthai.add(max);
			    }
			} catch (SQLException e) {
			    throw new ServletException(e);
			}
			
			for (DanhSachDeTai list : detaimatrangthai) {
				int madetai = list.getMaDeTai();
				try {
					c = connect.DBConnect.getConnection();
					String sql = "select HoTen, detai.MaDeTai, TenDeTai, TenTrangThai, ThoiGianPhanBien, chitiethoidongphanbien.DiemNghiemThu, (select max(MaTrangThai) from detai_trangthai where MaDeTai = " + madetai + ") as maxtrangthai from nguoidung, detai_sinhvien, detai, chitiethoidongphanbien, detai_trangthai, trangthai where nguoidung.MaNguoiDung = detai_sinhvien.MaSinhVien and detai_sinhvien.MaDeTai = detai.MaDeTai and detai.MaHoiDong = chitiethoidongphanbien.MaHoiDong and detai.MaDeTai = detai_trangthai.MaDeTai and detai_trangthai.MaTrangThai = trangthai.MaTrangThai and detai_trangthai.MaTrangThai = 8 and detai_trangthai.MaDeTai = " + madetai + " and chitiethoidongphanbien.MaGiangVien = " + manguoidung;
				    Statement stmt = (Statement) c.createStatement();
				    ResultSet rs = stmt.executeQuery(sql);
				    while (rs.next()) {
				    DanhSachDeTai dtnt = new DanhSachDeTai(rs.getInt("MaDeTai"), rs.getString("HoTen"), rs.getString("TenDeTai"), rs.getString("TenTrangThai"), rs.getDate("ThoiGianPhanBien"), rs.getInt("maxtrangthai"), rs.getInt("DiemNghiemThu"));
				    detainghiemthu.add(dtnt);
				    }
				} catch (SQLException e) {
				    throw new ServletException(e);
				} 
				finally {
				    try {
					if (c != null) {
					    c.close();
					}
				    } catch (SQLException e) {
					throw new ServletException(e);
				    }
				}
			}
			
		    request.setAttribute("detainghiemthu", detainghiemthu);
		    request.getRequestDispatcher("/WEB-INF/danhgianghiemthu.jsp").forward(request, response);
		} else
			response.sendRedirect("dangnhap");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Integer madetai = Integer.valueOf(request.getParameter("madetai"));
		Integer tieuchi1 = Integer.valueOf(request.getParameter("tieuchi1"));
		Integer tieuchi2 = Integer.valueOf(request.getParameter("tieuchi2"));
		Integer tieuchi3 = Integer.valueOf(request.getParameter("tieuchi3"));
		Integer tieuchi4 = Integer.valueOf(request.getParameter("tieuchi4"));
		Integer tieuchi5 = Integer.valueOf(request.getParameter("tieuchi5"));
		Integer tieuchi6 = Integer.valueOf(request.getParameter("tieuchi6"));
		Integer tieuchi7 = Integer.valueOf(request.getParameter("tieuchi7"));
		Integer TongDiem = tieuchi1 + tieuchi2 + tieuchi3 + tieuchi4 + tieuchi5 + tieuchi6 + tieuchi7;
		
		Integer mahoidong = 0;
		Integer manguoidung = (Integer) session.getAttribute("manguoidung");
		Integer soluongnghiemthu = 0;
		Integer soluongdanghiemthu = 0;
		float diemtrungbinh = -1;
		
		Connection c = null;
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
		
		try {
			c = connect.DBConnect.getConnection();
			String sql = "update chitiethoidongphanbien set DiemNghiemThu = " + TongDiem + " where MaHoiDong = " +  mahoidong + " and MaGiangVien = " + manguoidung;
			PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
		    pstmt.executeUpdate();
		} catch (SQLException e) {
		    throw new ServletException(e);
		}
		
		try {
			c = connect.DBConnect.getConnection();
			String sql = "select count(*) as sum from detai, chitiethoidongphanbien where detai.mahoidong = chitiethoidongphanbien.mahoidong and madetai = " + madetai;
		    Statement stmt = (Statement) c.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    while (rs.next()) {
		    	soluongnghiemthu = rs.getInt("sum");
		    }
		} catch (SQLException e) {
		    throw new ServletException(e);
		}
		
		try {
			c = connect.DBConnect.getConnection();
			String sql = "select count(*) as sum from detai, chitiethoidongphanbien where detai.mahoidong = chitiethoidongphanbien.mahoidong and chitiethoidongphanbien.diemnghiemthu is not null and madetai = " + madetai;
		    Statement stmt = (Statement) c.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    while (rs.next()) {
		    	soluongdanghiemthu = rs.getInt("sum");
		    }
		} catch (SQLException e) {
		    throw new ServletException(e);
		}
		
		if (soluongnghiemthu == soluongdanghiemthu) {
			
			try {
				c = connect.DBConnect.getConnection();
				String sql = "insert into detai_trangthai (madetai, matrangthai, thoigianthaydoi) values (" + madetai + ", 9, curdate())";
				PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
			    pstmt.executeUpdate();
			} catch (SQLException e) {
			    throw new ServletException(e);
			}
		}
		
		request.setAttribute("diemtrungbinh", diemtrungbinh);
		response.sendRedirect("DanhGiaNghiemThu");
	}

}
