package DataAccessObject;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class XacNhanGiaHan_DAO {
    public void CapNhatTrangThaiChoGiaHan(int maDeTai, int maTrangThai, int maSinhVien, String ngayXinGiaHan)
	    throws ServletException {
	Connection c = null;
	try {
	    c = connect.DBConnect.getConnection();
	    String sql = "insert into detai_trangthai (MaTrangThai,MaDeTai, ThoiGianThayDoi) values (?,?,curdate())";
	    PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
	    ps.setInt(1, maTrangThai);
	    ps.setInt(2, maDeTai);
	    ps.executeUpdate();
	    sql = "update detai_sinhvien set NgayXinGiaHan = ? where MaDeTai=? and MaSinhVien=?";
	    ps = (PreparedStatement) c.prepareStatement(sql);
	    ps.setString(1, ngayXinGiaHan);
	    ps.setInt(2, maDeTai);
	    ps.setInt(3, maSinhVien);
	    ps.executeUpdate();
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

    public int LayMaSinhVien(String username) throws ServletException {
	Connection c = null;
	try {
	    c = connect.DBConnect.getConnection();
	    String sql = "select * from nguoidung,taikhoan where taikhoan.MaNguoiDung=nguoidung.MaNguoiDung and TenDangNhap='"
		    + username + "'";
	    Statement stmt = (Statement) c.createStatement();
	    ResultSet rs = stmt.executeQuery(sql);
	    if (rs.next()) {
		return rs.getInt("MaNguoiDung");
	    }
	    return 0;
	} catch (Exception e) {
	    throw new ServletException(e);
	} finally {
	    try {
		if (c != null)
		    c.close();
	    } catch (Exception e) {
		throw new ServletException(e);
	    }
	}
    }
}
