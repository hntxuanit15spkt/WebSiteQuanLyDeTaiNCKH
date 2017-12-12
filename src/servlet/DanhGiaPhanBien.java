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
			List<DanhSachDeTai> detaiphanbien = new ArrayList<DanhSachDeTai>();
			List<DanhSachDeTai> detaimatrangthai = new ArrayList<DanhSachDeTai>();
			Connection c = null;
			
			// Get list madetai
			try {
				c = connect.DBConnect.getConnection();
				String sql = "select MaDeTai, max(MaTrangThai) as maxmtt, ThoiGianThayDoi from detai_trangthai\n" + 
						"group by MaDeTai;";
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
					String sql = "select HoTen, detai.MaDeTai, TenDeTai, TenTrangThai, ThoiGianPhanBien, (select max(MaTrangThai) from detai_trangthai where MaDeTai = " + madetai + ") as maxtrangthai from nguoidung, detai_sinhvien, detai, detai_trangthai, trangthai where nguoidung.MaNguoiDung = detai_sinhvien.MaSinhVien and detai_sinhvien.MaDeTai = detai.MaDeTai and detai.MaDeTai = detai_trangthai.MaDeTai and detai_trangthai.MaTrangThai = trangthai.MaTrangThai and detai_trangthai.MaTrangThai = 6 and detai_trangthai.MaDeTai = " + madetai;
				    Statement stmt = (Statement) c.createStatement();
				    ResultSet rs = stmt.executeQuery(sql);
				    while (rs.next()) {
				    DanhSachDeTai dtpb = new DanhSachDeTai(rs.getInt("MaDeTai"), rs.getString("HoTen"), rs.getString("TenDeTai"), rs.getString("TenTrangThai"), rs.getDate("ThoiGianPhanBien"), rs.getInt("maxtrangthai"));
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
