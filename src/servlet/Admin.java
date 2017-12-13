package servlet;

import java.io.IOException;
import java.sql.ResultSet;
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
import model.ThongTinNguoiDung;

@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");
		if (username != null) {
		    request.setCharacterEncoding("utf-8");
		    response.setCharacterEncoding("utf-8");

		    List<ThongTinNguoiDung> thongtin = new ArrayList<ThongTinNguoiDung>();
		    
		    List<ThongTinNguoiDung> quanly = new ArrayList<ThongTinNguoiDung>();
		    
		    List<ThongTinNguoiDung> soluongsinhvien = new ArrayList<ThongTinNguoiDung>();
		    
		    List<ThongTinNguoiDung> soluonggiangvien = new ArrayList<ThongTinNguoiDung>();
		    
		    List<DanhSachDeTai> soluongdetai = new ArrayList<DanhSachDeTai>();
		    
		    Connection c = null;

		    try {
			c = connect.DBConnect.getConnection();
			String sql = "select * from taikhoan, nguoidung, loainguoidung where taikhoan.MaNguoiDung = nguoidung.MaNguoiDung and nguoidung.MaLoaiNguoiDung = loainguoidung.MaLoaiNguoiDung and taikhoan.tendangnhap = "
				+ "'" + username + "'";
			Statement stmt = (Statement) c.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
			    ThongTinNguoiDung tthoten = new ThongTinNguoiDung(rs.getString("HoTen"), rs.getInt("MaLoaiNguoiDung"),
				    rs.getString("TenLoaiNguoiDung"));
			    thongtin.add(tthoten);
			}

		    } catch (Exception e) {
			throw new ServletException(e);
		    }
		    
		    try {
				c = connect.DBConnect.getConnection();
				String slql = "select * from taikhoan,nguoidung where taikhoan.MaNguoiDung = nguoidung.MaNguoiDung and nguoidung.MaLoaiNguoiDung = 2";
				
				Statement stmt = (Statement) c.createStatement();
				
				ResultSet rs = stmt.executeQuery(slql);
				
				while (rs.next()) {
					ThongTinNguoiDung ttquanly = new ThongTinNguoiDung(rs.getString("TenDangNhap"), rs.getString("MatKhau"), rs.getString("HoTen"), rs.getString("SoDienThoai"), rs.getString("Email"), rs.getBoolean("TrangThaiNguoiDung"));
					quanly.add(ttquanly);
				}

		    } catch (Exception e) {
				throw new ServletException(e);
		    }
		    
		    try {
				c = connect.DBConnect.getConnection();
				String slsv = "select COUNT(*) as slsv from taikhoan, nguoidung where taikhoan.manguoidung = nguoidung.manguoidung and MaLoaiNguoiDung = 3";
				Statement stmt = (Statement) c.createStatement();
				ResultSet rs = stmt.executeQuery(slsv);
				
				while (rs.next()) {
					ThongTinNguoiDung soluongsv = new ThongTinNguoiDung(rs.getInt("slsv"));
					soluongsinhvien.add(soluongsv);
				}

			} catch (Exception e) {
				throw new ServletException(e);
			}
		    
		    try {
				c = connect.DBConnect.getConnection();
				
				String slgv = "select COUNT(*) as slgv from taikhoan, nguoidung where taikhoan.manguoidung = nguoidung.manguoidung and (MaLoaiNguoiDung = 4 or MaLoaiNguoiDung = 5)";
				Statement stmt = (Statement) c.createStatement();
				
				ResultSet rs = stmt.executeQuery(slgv);
				
				while (rs.next()) {
					ThongTinNguoiDung soluonggv = new ThongTinNguoiDung(rs.getInt("slgv"));
					soluonggiangvien.add(soluonggv);
				}

			} catch (Exception e) {
				throw new ServletException(e);
			}
		    
		    try {
				c = connect.DBConnect.getConnection();
				
				String sldt = "select count(*) as sldt from nguoidung, detai_sinhvien, detai where nguoidung.MaNguoiDung = detai_sinhvien.MaSinhVien and detai_sinhvien.madetai = detai.madetai";
				Statement stmt = (Statement) c.createStatement();
				
				ResultSet rs = stmt.executeQuery(sldt);
				
				while (rs.next()) {
					DanhSachDeTai soluongdt = new DanhSachDeTai(rs.getInt("sldt"));
					soluongdetai.add(soluongdt);
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
		    request.setAttribute("soluongsinhvien", soluongsinhvien);
		    request.setAttribute("soluonggiangvien", soluonggiangvien);
		    request.setAttribute("soluongdetai", soluongdetai);
		    request.setAttribute("quanly", quanly);
		    session.setAttribute("thongtin", thongtin);
		    request.getRequestDispatcher("/WEB-INF/admin.jsp").forward(request, response);
		} else
		    response.sendRedirect("dangnhap");
	    }

}
