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

@WebServlet("/DanhGiaPhanBien")
public class DanhGiaPhanBien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DanhGiaPhanBien() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
			Integer manguoidung = (Integer) session.getAttribute("manguoidung");
			List<DanhSachDeTai> detaiphanbien = new ArrayList<DanhSachDeTai>();
			List<DanhSachDeTai> detaimatrangthai = new ArrayList<DanhSachDeTai>();
			Connection c = null;
			
			// Get list madetai
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
					String sql = "select HoTen, detai.MaDeTai, TenDeTai, TenTrangThai, ThoiGianPhanBien, chitiethoidongphanbien.DiemDanhGia, (select max(MaTrangThai) from detai_trangthai where MaDeTai = " + madetai + ") as maxtrangthai from nguoidung, detai_sinhvien, detai, chitiethoidongphanbien, detai_trangthai, trangthai where nguoidung.MaNguoiDung = detai_sinhvien.MaSinhVien and detai_sinhvien.MaDeTai = detai.MaDeTai and detai.MaHoiDong = chitiethoidongphanbien.MaHoiDong and detai.MaDeTai = detai_trangthai.MaDeTai and detai_trangthai.MaTrangThai = trangthai.MaTrangThai and detai_trangthai.MaTrangThai = 6 and detai_trangthai.MaDeTai = " + madetai + " and chitiethoidongphanbien.MaGiangVien = " + manguoidung;
				    Statement stmt = (Statement) c.createStatement();
				    ResultSet rs = stmt.executeQuery(sql);
				    while (rs.next()) {
				    DanhSachDeTai dtpb = new DanhSachDeTai(rs.getInt("MaDeTai"), rs.getString("HoTen"), rs.getString("TenDeTai"), rs.getString("TenTrangThai"), rs.getDate("ThoiGianPhanBien"), rs.getInt("maxtrangthai"), rs.getInt("DiemDanhGia"));
				    detaiphanbien.add(dtpb);
				    }
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
		    request.setAttribute("detaiphanbien", detaiphanbien);
		    request.getRequestDispatcher("/WEB-INF/danhgiaphanbien.jsp").forward(request, response);
		} else
			response.sendRedirect("dangnhap");
	}

	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		HttpSession session = request.getSession();
		Integer manguoidung = (Integer) session.getAttribute("manguoidung");
		Integer madetai = Integer.valueOf(request.getParameter("madetai"));
		Integer diem = Integer.valueOf(request.getParameter("diem"));
		String noidung = request.getParameter("noidung");
		float diemtrungbinh = 0;
		Integer mahoidong = 0;
		Integer soluongphanbien = 0;
		Integer soluongdaphanbien = 0;
		
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
			String sql = "update chitiethoidongphanbien set DiemDanhGia = " + diem + ", NoiDungDanhGia = '" + noidung + "' where MaHoiDong = " +  mahoidong + " and MaGiangVien = " + manguoidung;
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
		    	soluongphanbien = rs.getInt("sum");
		    }
		} catch (SQLException e) {
		    throw new ServletException(e);
		}
		
		try {
			c = connect.DBConnect.getConnection();
			String sql = "select count(*) as sum from detai, chitiethoidongphanbien where detai.mahoidong = chitiethoidongphanbien.mahoidong and chitiethoidongphanbien.diemdanhgia is not null and madetai = " + madetai;
		    Statement stmt = (Statement) c.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    while (rs.next()) {
		    	soluongdaphanbien = rs.getInt("sum");
		    }
		} catch (SQLException e) {
		    throw new ServletException(e);
		}
		if (soluongphanbien == soluongdaphanbien) {
			try {
				c = connect.DBConnect.getConnection();
				String sql = "select avg(diemdanhgia) as trungbinh from detai, chitiethoidongphanbien where detai.mahoidong = chitiethoidongphanbien.mahoidong and madetai = " + madetai;
			    Statement stmt = (Statement) c.createStatement();
			    ResultSet rs = stmt.executeQuery(sql);
			    while (rs.next()) {
			    	diemtrungbinh = rs.getFloat("trungbinh");
			    }
			} catch (SQLException e) {
			    throw new ServletException(e);
			}
			
			if (diemtrungbinh >= 5) {
				try {
					c = connect.DBConnect.getConnection();
					String sql = "insert into detai_trangthai (madetai, matrangthai, thoigianthaydoi) values (" + madetai + ", 8, curdate())";
					PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
				    pstmt.executeUpdate();
				} catch (SQLException e) {
				    throw new ServletException(e);
				}
			}
			else {
				try {
					c = connect.DBConnect.getConnection();
					String sql = "insert into detai_trangthai (madetai, matrangthai, thoigianthaydoi) values (" + madetai + ", 7, curdate())";
					PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
				    pstmt.executeUpdate();
				} catch (SQLException e) {
				    throw new ServletException(e);
				}
			}
			
		}
		
		response.sendRedirect("DanhGiaPhanBien");
	}

}
