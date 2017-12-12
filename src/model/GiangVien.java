package model;

public class GiangVien {
    private String TenDangNhap, MatKhau;
    private Integer MaNguoiDung, MaBoMon, MaLoaiNguoiDung, SoLuongSinhVien, SoLuongGiaoVien;
    private String HoTen, DiaChi, SoTaiKhoanNganHang, SoDienThoai, Email, MaSo, Lop, KhoaHoc, TenLoaiNguoiDung;
    private String NgaySinh, TenBoMon;

    public String getTenBoMon() {
	return TenBoMon;
    }

    public void setTenBoMon(String tenBoMon) {
	TenBoMon = tenBoMon;
    }

    private Boolean GioiTinh, TrangThaiNguoiDung;

    public GiangVien() {
	super();
    }

    public GiangVien(int MaNguoiDung, int maGiangVienHuongDan, String HoTen, String TenBoMon) {
	this.TenBoMon = TenBoMon;
	MaNguoiDung = maGiangVienHuongDan;
	this.HoTen = HoTen;
	this.MaNguoiDung = MaNguoiDung;
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

    public String getTenLoaiNguoiDung() {
	return TenLoaiNguoiDung;
    }

    public void setTenLoaiNguoiDung(String tenLoaiNguoiDung) {
	TenLoaiNguoiDung = tenLoaiNguoiDung;
    }

    public String getNgaySinh() {
	return NgaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
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

}
