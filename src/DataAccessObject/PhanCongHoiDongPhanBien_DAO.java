package DataAccessObject;

import java.sql.ResultSet;

import javax.servlet.ServletException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class PhanCongHoiDongPhanBien_DAO {
    public void TaoHoiDongVaThemGiangVien(String tenHoiDongPhanBien, int maGiangVien) throws ServletException {
	Connection c = null;
	int maHoiDong = 0;
	try {
	    c = connect.DBConnect.getConnection();
	    String sql = "insert into hoidongphanbien(TenHoiDongPhanBien) values (?)";
	    PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
	    ps.setString(1, tenHoiDongPhanBien);
	    ps.executeUpdate();
	    Statement stmt = (Statement) c.createStatement();
	    sql = "select MAX(MaHoiDong) as MaxMaHoiDong from hoidongphanbien";
	    ResultSet rs = stmt.executeQuery(sql);
	    while (rs.next()) {
		maHoiDong = rs.getInt("MaxMaHoiDong");
	    }
	    sql = "insert into chitiethoidongphanbien(MaHoiDong, MaGiangVien) values (?,?)";
	    ps = (PreparedStatement) c.prepareStatement(sql);
	    ps.setInt(1, maHoiDong);
	    ps.setInt(2, maGiangVien);
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

    public void CapNhatDeTai(int maDeTai) throws ServletException {
	Connection c = null;
	try {
	    c = connect.DBConnect.getConnection();
	    String sql = "update detai set MaHoiDong = (select MAX(MaHoiDong) as MaxMaHoiDong from hoidongphanbien)"
		    + "where MaDeTai = ?";
	    PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
	    ps.setInt(1, maDeTai);
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

    /*
     * public void ThemDanhSachGiangVien(int maGiangVien, int maHoiDong) throws
     * ServletException { Connection c = null; try { c =
     * connect.DBConnect.getConnection(); String sql =
     * "insert into chitiethoidongphanbien(MaHoiDong, MaGiangVien) values (?,?)";
     * PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
     * ps.setInt(1, maHoiDong); ps.setInt(2, maGiangVien); ps.executeUpdate(); }
     * catch (Exception e) { throw new ServletException(e); } finally { try { if (c
     * != null) c.close(); } catch (Exception e) { throw new ServletException(e); }
     * } }
     */
}
