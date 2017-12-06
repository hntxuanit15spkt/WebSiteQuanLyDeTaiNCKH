package DataAccessObject;

import com.sun.corba.se.pept.transport.Connection;

import connect.DBConnect;
import model.DeTai;

public class DangKyDeTai_DAO {

    public void InsertDeTai(DeTai detai) {
	Connection c = (Connection) DBConnect.getConnection();
	String sql = "insert into detai(tendetai, muctieu, MoTaYTuong, TinhCapThiet, LinhVucNghienCuu, phuongphapthuchien, kinhphi, loaidetai, thoigianbatdau, thoigianketthuc, thoigianphanbien,"
		+ " magiangvienhuongdan, manguoiduyetdetai, mahoidong, madetaiduoccap) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    }

    public static void main(String[] args) {

    }

}
