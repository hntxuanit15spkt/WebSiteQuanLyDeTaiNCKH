package DataAccessObject;

import javax.servlet.ServletException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DongYHuongDan_DAO {
    public void InsertDeTai_TrangThai(int maDeTai, int maTrangThai) throws ServletException {
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
