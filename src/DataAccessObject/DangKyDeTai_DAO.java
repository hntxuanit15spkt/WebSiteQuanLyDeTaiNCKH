package DataAccessObject;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;

import com.mysql.jdbc.Connection;

import connect.DBConnect;
import model.DeTai;

public class DangKyDeTai_DAO {

    public void InsertDeTai(DeTai detai) throws ServletException {
	Connection c = null;
	try {
	    c = (Connection) DBConnect.getConnection();
	    String sql = "insert into detai(tendetai, muctieu, MoTaYTuong, TinhCapThiet, LinhVucNghienCuu, phuongphapthuchien, kinhphi, loaidetai, thoigianbatdau, thoigianketthuc, thoigianphanbien,"
		    + " magiangvienhuongdan, manguoiduyetdetai, mahoidong, madetaiduoccap, MaNghienCuuVien, TrangThai) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	    PreparedStatement psmt = ((java.sql.Connection) c).prepareStatement(sql);
	    psmt.setString(1, detai.getTenDeTai());
	    psmt.setString(2, detai.getMucTieu());
	    psmt.setString(3, detai.getMoTaYTuong());
	    psmt.setString(4, detai.getTinhCapThiet());
	    psmt.setString(5, detai.getLinhVucNghienCuu());
	    psmt.setString(6, detai.getPhuongPhapThucHien());
	    psmt.setString(7, detai.getKinhPhi());
	    psmt.setString(8, detai.getLoaiDeTai());
	    psmt.setDate(9, (Date) detai.getThoiGianBatDau());
	    psmt.setDate(10, (Date) detai.getThoiGianKetThuc());
	    psmt.setDate(11, (Date) detai.getThoiGianPhanBien());
	    psmt.setInt(12, detai.getMaGiangVienHuongDan());
	    psmt.setInt(13, detai.getMaNguoiDuyetDeTai());
	    psmt.setInt(14, detai.getMaHoiDong());
	    psmt.setInt(15, detai.getMaDeTaiDuocCap());
	    psmt.setInt(16, detai.getMaNghienCuuVien());
	    psmt.setString(17, detai.getTrangThai());
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
