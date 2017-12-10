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

@WebServlet("/ThongTinDeTai")
public class ThongTinDeTai extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ThongTinDeTai() {
	super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
	HttpSession session = request.getSession();
	String username = (String) session.getAttribute("username");

	if (username != null) {
	    request.setCharacterEncoding("utf-8");
	    response.setCharacterEncoding("utf-8");

	    List<ThongTinNguoiDung> soluongsinhvien = new ArrayList<ThongTinNguoiDung>();

	    List<DanhSachDeTai> quanlydetai = new ArrayList<DanhSachDeTai>();

	    List<ThongTinNguoiDung> soluonggiangvien = new ArrayList<ThongTinNguoiDung>();

	    List<DanhSachDeTai> soluongdetai = new ArrayList<DanhSachDeTai>();

	    Connection c = null;

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
		String slql = "select * from nguoidung, detai, detai_trangthai, trangthai where nguoidung.MaNguoiDung = detai.manghiencuuvien and detai.MaDeTai = detai_trangthai.MaDeTai and detai_trangthai.MaTrangThai = trangthai.MaTrangThai";

		Statement stmt = (Statement) c.createStatement();

		ResultSet rs = stmt.executeQuery(slql);

		while (rs.next()) {
		    DanhSachDeTai quanlydt = new DanhSachDeTai(rs.getString("HoTen"), rs.getString("TenDeTai"),
			    rs.getString("TenTrangThai"), rs.getDate("ThoiGianBatDau"), rs.getDate("ThoiGianKetThuc"),
			    rs.getDate("ThoiGianPhanBien"));
		    quanlydetai.add(quanlydt);
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

		String sldt = "select COUNT(*) as sldt from detai";
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
	    request.setAttribute("quanlydetai", quanlydetai);
	    request.getRequestDispatcher("/WEB-INF/thongtindetai.jsp").forward(request, response);
	} else
	    response.sendRedirect("dangnhap");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException {
    }

}
