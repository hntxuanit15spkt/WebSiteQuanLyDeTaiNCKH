package DataAccessObject;

import java.sql.ResultSet;

import javax.servlet.ServletException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class DongYDuyet_DAO {
    public void CapNhatDeTai(int maDeTai, int maNguoiDuyet, String ngayPhanBien) throws ServletException {
	Connection c = null;
	try {
	    c = connect.DBConnect.getConnection();
	    String sql = "update detai set MaNguoiDuyetDeTai=?, ThoiGianPhanBien=? where MaDeTai=?";
	    PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
	    ps.setInt(1, maNguoiDuyet);
	    ps.setString(2, ngayPhanBien);
	    ps.setInt(3, maDeTai);
	    ps.executeUpdate();
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

    public int LayMaNguoiDuyet(String username) throws ServletException {
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

    public void CapNhatTrangThai(int maDeTai, int maTrangThai) throws ServletException {
	Connection c = null;
	try {
	    c = connect.DBConnect.getConnection();
	    String sql = "insert into detai_trangthai (MaDeTai, MaTrangThai, ThoiGianThayDoi) values (?,?, CURDATE())";
	    PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
	    ps.setInt(1, maDeTai);
	    ps.setInt(2, maTrangThai);
	    ps.executeUpdate();
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