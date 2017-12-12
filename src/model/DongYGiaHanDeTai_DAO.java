package model;

import javax.servlet.ServletException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DongYGiaHanDeTai_DAO {
    public void DongYGiaHan(int maDeTai, int maSinhVien, int maTrangThai, String thoiGianPhanBienMoi)
	    throws ServletException {
	Connection c = null;
	try {
	    c = connect.DBConnect.getConnection();
	    String sql = "insert into detai_trangthai (MaDeTai, MaTrangThai, ThoiGianThayDoi) values (?,?, CURDATE())";
	    PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
	    ps.setInt(1, maDeTai);
	    ps.setInt(2, maTrangThai);
	    ps.executeUpdate();
	    sql = "update detai set ThoiGianPhanBien = ? where MaDeTai=?";
	    ps = (PreparedStatement) c.prepareStatement(sql);
	    ps.setString(1, thoiGianPhanBienMoi);
	    ps.setInt(2, maDeTai);
	    ps.executeUpdate();
	    sql = "update detai_sinhvien set NgayXinGiaHan = null where MaDeTai = ? and MaSinhVien = ?";
	    ps = (PreparedStatement) c.prepareStatement(sql);
	    ps.setInt(1, maDeTai);
	    ps.setInt(2, maSinhVien);
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
