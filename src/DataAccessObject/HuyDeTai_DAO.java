package DataAccessObject;

import java.sql.SQLException;

import javax.servlet.ServletException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class HuyDeTai_DAO {
    public void CapNhatTrangThaiDeTaiHuy(int maDeTai, int maTrangThai) throws ServletException {
	Connection c = null;
	try {
	    c = connect.DBConnect.getConnection();
	    String sql = "update detai_trangthai set MaTrangThai=?,ThoiGianThayDoi=CURDATE() where MaDeTai=?";
	    PreparedStatement ps = (PreparedStatement) c.prepareStatement(sql);
	    ps.setInt(1, maTrangThai);
	    ps.setInt(2, maDeTai);
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
}
