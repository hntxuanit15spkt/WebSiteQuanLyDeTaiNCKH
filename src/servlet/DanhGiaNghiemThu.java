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
			List<DanhSachDeTai> detainghiemthu = new ArrayList<DanhSachDeTai>();
			List<DanhSachDeTai> detaimatrangthai = new ArrayList<DanhSachDeTai>();
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
					String sql = "select HoTen, detai.MaDeTai, TenDeTai, detai_trangthai.MaTrangThai, TenTrangThai, ThoiGianPhanBien, (select max(MaTrangThai) from detai_trangthai where MaDeTai = " + madetai + ") as maxtrangthai from nguoidung, detai_sinhvien, detai, detai_trangthai, trangthai where nguoidung.MaNguoiDung = detai_sinhvien.MaSinhVien and detai_sinhvien.MaDeTai = detai.MaDeTai and detai.MaDeTai = detai_trangthai.MaDeTai and detai_trangthai.MaTrangThai = trangthai.MaTrangThai and detai_trangthai.MaTrangThai = 8 and detai_trangthai.MaDeTai = " + madetai;
				    Statement stmt = (Statement) c.createStatement();
				    ResultSet rs = stmt.executeQuery(sql);
				    while (rs.next()) {
				    DanhSachDeTai dtnt = new DanhSachDeTai(rs.getInt("MaDeTai"), rs.getString("HoTen"), rs.getString("TenDeTai"), rs.getString("TenTrangThai"), rs.getDate("ThoiGianPhanBien"), rs.getInt("maxtrangthai"));
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
		Integer madetai = Integer.valueOf(request.getParameter("madetai"));
		Integer tieuchi1 = Integer.valueOf(request.getParameter("tieuchi1"));
		Integer tieuchi2 = Integer.valueOf(request.getParameter("tieuchi2"));
		Integer tieuchi3 = Integer.valueOf(request.getParameter("tieuchi3"));
		Integer tieuchi4 = Integer.valueOf(request.getParameter("tieuchi4"));
		Integer tieuchi5 = Integer.valueOf(request.getParameter("tieuchi5"));
		Integer tieuchi6 = Integer.valueOf(request.getParameter("tieuchi6"));
		Integer tieuchi7 = Integer.valueOf(request.getParameter("tieuchi7"));
		Integer TongDiem = tieuchi1 + tieuchi2 + tieuchi3 + tieuchi4 + tieuchi5 + tieuchi6 + tieuchi7;
		Connection c = null;
		
		try {
			c = connect.DBConnect.getConnection();
			String sql = "insert into detai_trangthai (MaDeTai, MaTrangThai, ThoiGianThayDoi) values (" + madetai + ", 9, curdate())";
			PreparedStatement pstmt = (PreparedStatement) c.prepareStatement(sql);
		    pstmt.executeUpdate();

		}
		catch (Exception e) {
			throw new ServletException(e);
		}
		
		try {
			c = connect.DBConnect.getConnection();
			String sql = "update detai set TongDiem = " + TongDiem + " where MaDeTai = " + madetai;
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
		response.sendRedirect("DanhGiaNghiemThu");
	}

}
