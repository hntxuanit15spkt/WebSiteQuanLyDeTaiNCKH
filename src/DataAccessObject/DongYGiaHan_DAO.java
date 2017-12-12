package DataAccessObject;

import javax.servlet.ServletException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

public class DongYGiaHan_DAO {
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
}
