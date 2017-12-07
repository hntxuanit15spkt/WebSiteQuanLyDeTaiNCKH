package DataAccessObject;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import connect.DBConnect;
import model.DeTai;

public class DangKyDeTai_DAO {
    public void InsertDeTai(DeTai detai, String tenDangNhapNCV) throws ServletException, SQLException {
	Connection c = null;
	PreparedStatement psmt = null;
	Statement stmt = null;
	ResultSet rs = null;
	int maDeTai = 0;
	int maNghienCuuVien = 0;
	try {
	    c = (Connection) DBConnect.getConnection();
	    String sql = "insert into detai(tendetai, muctieu, MoTaYTuong, TinhCapThiet, LinhVucNghienCuu, phuongphapthuchien, kinhphi,thoigianbatdau, thoigianketthuc,"
		    + " magiangvienhuongdan) values (?,?,?,?,?,?,?,?,?,?)";
	    psmt = c.prepareStatement(sql);
	    psmt.setString(1, detai.getTenDeTai());
	    psmt.setString(2, detai.getMucTieu());
	    psmt.setString(3, detai.getMoTaYTuong());
	    psmt.setString(4, detai.getTinhCapThiet());
	    psmt.setString(5, detai.getLinhVucNghienCuu());
	    psmt.setString(6, detai.getPhuongPhapThucHien());
	    psmt.setBigDecimal(7, detai.getKinhPhi());
	    psmt.setString(8, detai.getLoaiDeTai());
	    psmt.setString(8, detai.getThoiGianBatDau());
	    psmt.setString(9, detai.getThoiGianKetThuc());
	    psmt.setInt(10, detai.getMaGiangVienHuongDan());
	    psmt.executeUpdate();
	    stmt = (Statement) c.createStatement();
	    rs = stmt.executeQuery("SELECT MaDeTai FROM detai ORDER BY MaDeTai DESC LIMIT 1");
	    while (rs.next()) {
		maDeTai = rs.getInt("MaDeTai");
	    }
	    stmt = (Statement) c.createStatement();
	    psmt = c.prepareStatement(
		    "SELECT nguoidung.MaNguoiDung FROM nguoidung, taikhoan where taikhoan.MaNguoiDung=nguoidung.MaNguoiDung and taikhoan.TenDangNhap=?");
	    psmt.setString(1, tenDangNhapNCV);
	    rs = psmt.executeQuery();
	    while (rs.next()) {
		maNghienCuuVien = rs.getInt("MaNguoiDung");
	    }
	    sql = "insert into detai_sinhvien (MaDeTai, MaSinhVien) values (?,?)";
	    psmt = c.prepareStatement(sql);
	    psmt.setInt(1, maDeTai);
	    psmt.setInt(2, maNghienCuuVien);
	    psmt.executeUpdate();

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

    public static void main(String[] args) {

    }

}
