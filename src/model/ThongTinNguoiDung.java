package model;

import java.util.Date;

public class ThongTinNguoiDung {
	private String TenDangNhap, MatKhau;
	private Integer MaNguoiDung, MaBoMon, MaLoaiNguoiDung;
	private String HoTen, DiaChi, SoTaiKhoanNganHang, SoDienThoai, Email, MaSo, Lop, KhoaHoc, TenLoaiNguoiDung;
	private Date NgaySinh;
	private Boolean GioiTinh, TrangThaiNguoiDung;

	public ThongTinNguoiDung(String hoTen, String tenLoaiNguoiDung) {
		super();
		HoTen = hoTen;
		TenLoaiNguoiDung = tenLoaiNguoiDung;
	}

	public ThongTinNguoiDung(String tenDangNhap, String matKhau, Integer maNguoiDung, Integer maBoMon,
			Integer maLoaiNguoiDung, String hoTen, String diaChi, String soTaiKhoanNganHang, String soDienThoai,
			String email, String maSo, String lop, String khoaHoc, String tenLoaiNguoiDung, Date ngaySinh,
			Boolean gioiTinh, Boolean trangThaiNguoiDung) {
		super();
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		MaNguoiDung = maNguoiDung;
		MaBoMon = maBoMon;
		MaLoaiNguoiDung = maLoaiNguoiDung;
		HoTen = hoTen;
		DiaChi = diaChi;
		SoTaiKhoanNganHang = soTaiKhoanNganHang;
		SoDienThoai = soDienThoai;
		Email = email;
		MaSo = maSo;
		Lop = lop;
		KhoaHoc = khoaHoc;
		TenLoaiNguoiDung = tenLoaiNguoiDung;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		TrangThaiNguoiDung = trangThaiNguoiDung;
	}

	public ThongTinNguoiDung() {
		super();
	}

	public String getTenDangNhap() {
		return TenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public Integer getMaNguoiDung() {
		return MaNguoiDung;
	}

	public void setMaNguoiDung(Integer maNguoiDung) {
		MaNguoiDung = maNguoiDung;
	}

	public Integer getMaBoMon() {
		return MaBoMon;
	}

	public void setMaBoMon(Integer maBoMon) {
		MaBoMon = maBoMon;
	}

	public Integer getMaLoaiNguoiDung() {
		return MaLoaiNguoiDung;
	}

	public void setMaLoaiNguoiDung(Integer maLoaiNguoiDung) {
		MaLoaiNguoiDung = maLoaiNguoiDung;
	}

	public String getHoTen() {
		return HoTen;
	}

	public void setHoTen(String hoTen) {
		HoTen = hoTen;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSoTaiKhoanNganHang() {
		return SoTaiKhoanNganHang;
	}

	public void setSoTaiKhoanNganHang(String soTaiKhoanNganHang) {
		SoTaiKhoanNganHang = soTaiKhoanNganHang;
	}

	public String getSoDienThoai() {
		return SoDienThoai;
	}

	public void setSoDienThoai(String soDienThoai) {
		SoDienThoai = soDienThoai;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMaSo() {
		return MaSo;
	}

	public void setMaSo(String maSo) {
		MaSo = maSo;
	}

	public String getLop() {
		return Lop;
	}

	public void setLop(String lop) {
		Lop = lop;
	}

	public String getKhoaHoc() {
		return KhoaHoc;
	}

	public void setKhoaHoc(String khoaHoc) {
		KhoaHoc = khoaHoc;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public Boolean getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(Boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}

	public Boolean getTrangThaiNguoiDung() {
		return TrangThaiNguoiDung;
	}

	public void setTrangThaiNguoiDung(Boolean trangThaiNguoiDung) {
		TrangThaiNguoiDung = trangThaiNguoiDung;
	}

	public String getTenLoaiNguoiDung() {
		return TenLoaiNguoiDung;
	}

	public void setTenLoaiNguoiDung(String tenLoaiNguoiDung) {
		TenLoaiNguoiDung = tenLoaiNguoiDung;
	}
}
