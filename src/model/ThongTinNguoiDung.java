package model;

import java.util.Date;

public class ThongTinNguoiDung {
    private String TenDangNhap, MatKhau;
    private Integer MaNguoiDung, MaBoMon, MaLoaiNguoiDung, SoLuongSinhVien, SoLuongGiaoVien;
    private String HoTen, DiaChi, SoTaiKhoanNganHang, SoDienThoai, Email, MaSo, Lop, KhoaHoc, TenLoaiNguoiDung;
    private Date NgaySinh;
    private Boolean GioiTinh, TrangThaiNguoiDung;
    private java.sql.Date NgayXinGiaHan;

    public ThongTinNguoiDung(Integer soLuongSinhVien) {
	super();
	SoLuongSinhVien = soLuongSinhVien;
    }

    public java.sql.Date getNgayXinGiaHan() {
	return NgayXinGiaHan;
    }

    public void setNgayXinGiaHan(java.sql.Date ngayXinGiaHan) {
	NgayXinGiaHan = ngayXinGiaHan;
    }

    public ThongTinNguoiDung(String tenDangNhap, String matKhau, String hoTen, String soDienThoai, Date ngaySinh,
	    Boolean trangThaiNguoiDung, Integer maLoaiNguoiDung) {
	super();
	TenDangNhap = tenDangNhap;
	MatKhau = matKhau;
	HoTen = hoTen;
	SoDienThoai = soDienThoai;
	NgaySinh = ngaySinh;
	TrangThaiNguoiDung = trangThaiNguoiDung;
	MaLoaiNguoiDung = maLoaiNguoiDung;
    }

    public ThongTinNguoiDung(String hoTen, Integer maLoaiNguoiDung, String tenLoaiNguoiDung) {
	super();
	HoTen = hoTen;
	MaLoaiNguoiDung = maLoaiNguoiDung;
	TenLoaiNguoiDung = tenLoaiNguoiDung;
    }

    public ThongTinNguoiDung(String tenDangNhap, String matKhau, String hoTen, String soDienThoai, String email,
	    Boolean trangThaiNguoiDung) {
	super();
	TenDangNhap = tenDangNhap;
	MatKhau = matKhau;
	HoTen = hoTen;
	SoDienThoai = soDienThoai;
	Email = email;
	TrangThaiNguoiDung = trangThaiNguoiDung;
    }

    public ThongTinNguoiDung(String tenDangNhap, String matKhau, String hoTen, String soDienThoai, Date ngaySinh,
	    Boolean trangThaiNguoiDung) {
	super();
	TenDangNhap = tenDangNhap;
	MatKhau = matKhau;
	HoTen = hoTen;
	SoDienThoai = soDienThoai;
	NgaySinh = ngaySinh;
	TrangThaiNguoiDung = trangThaiNguoiDung;
    }

    public ThongTinNguoiDung(String tenDangNhap, String matKhau, Integer maNguoiDung, Integer maBoMon,
	    Integer maLoaiNguoiDung, String hoTen, String diaChi, String soTaiKhoanNganHang, String soDienThoai,
	    String email, String lop, String khoaHoc, String tenLoaiNguoiDung, Date ngaySinh, Boolean gioiTinh,
	    Boolean trangThaiNguoiDung) {
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

    public ThongTinNguoiDung(int maNguoiDung, String hoTen, String diaChi, String soTaiKhoanNganHang,
	    String soDienThoai, String email, String maSo, String lop, String khoaHoc, java.sql.Date ngaySinh,
	    boolean gioiTinh) {
	MaNguoiDung = maNguoiDung;
	HoTen = hoTen;
	DiaChi = diaChi;
	SoTaiKhoanNganHang = soTaiKhoanNganHang;
	SoDienThoai = soDienThoai;
	Email = email;
	Lop = lop;
	KhoaHoc = khoaHoc;
	NgaySinh = ngaySinh;
	GioiTinh = gioiTinh;
	MaSo = maSo;
    }

    public ThongTinNguoiDung(String hoTen, String diaChi, String soTaiKhoanNganHang, String soDienThoai, String email,
	    String maSo, String lop, String khoaHoc, java.sql.Date ngaySinh, boolean gioiTinh,
	    java.sql.Date ngayXinGiaHan) {
	HoTen = hoTen;
	DiaChi = diaChi;
	SoTaiKhoanNganHang = soTaiKhoanNganHang;
	SoDienThoai = soDienThoai;
	Email = email;
	Lop = lop;
	KhoaHoc = khoaHoc;
	NgaySinh = ngaySinh;
	GioiTinh = gioiTinh;
	MaSo = maSo;
	NgayXinGiaHan = ngayXinGiaHan;
    }

    public ThongTinNguoiDung(String hoTen, String tenLoaiNguoiDung) {
	HoTen = hoTen;
	TenLoaiNguoiDung = tenLoaiNguoiDung;
	// TODO Auto-generated constructor stub
    }

    public ThongTinNguoiDung(String TenDangNhap, String MatKhau, int MaNguoiDung, int MaBoMon, int MaLoaiNguoiDung,
	    String HoTen, String DiaChi, String SoTaiKhoanNganHang, String SoDienThoai, String Email, String MaSo,
	    String Lop, String KhoaHoc, String TenLoaiNguoiDung, java.sql.Date NgaySinh, boolean GioiTinh,
	    boolean TrangThaiNguoiDung) {
	this.TenDangNhap = TenDangNhap;
	this.MatKhau = MatKhau;
	this.MaNguoiDung = MaNguoiDung;
	this.MaBoMon = MaBoMon;
	this.MaLoaiNguoiDung = MaLoaiNguoiDung;
	this.HoTen = HoTen;
	this.DiaChi = DiaChi;
	this.SoTaiKhoanNganHang = SoTaiKhoanNganHang;
	this.SoDienThoai = SoDienThoai;
	this.Email = Email;
	this.MaSo = MaSo;
	this.Lop = Lop;
	this.KhoaHoc = KhoaHoc;
	this.TenLoaiNguoiDung = TenLoaiNguoiDung;
	this.NgaySinh = NgaySinh;
	this.GioiTinh = GioiTinh;
	this.TrangThaiNguoiDung = TrangThaiNguoiDung;
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

    public Integer getSoLuongSinhVien() {
	return SoLuongSinhVien;
    }

    public void setSoLuongSinhVien(Integer soLuongSinhVien) {
	SoLuongSinhVien = soLuongSinhVien;
    }

    public Integer getSoLuongGiaoVien() {
	return SoLuongGiaoVien;
    }

    public void setSoLuongGiaoVien(Integer soLuongGiaoVien) {
	SoLuongGiaoVien = soLuongGiaoVien;
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
