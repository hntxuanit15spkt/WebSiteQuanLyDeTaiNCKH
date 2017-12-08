package view_model;

import java.math.BigDecimal;

public class SinhVien_DeTai {

    public SinhVien_DeTai() {
	super();
	// TODO Auto-generated constructor stub
    }

    private int MaDeTai;
    private String TenDeTai;
    private String MucTieu;
    private String MoTaYTuong;
    private String TinhCapThiet;
    private String LinhVucNghienCuu;
    private String PhuongPhapThucHien;
    private BigDecimal KinhPhi;
    private String LoaiDeTai;
    private String ThoiGianBatDau;
    private String ThoiGianKetThuc;
    private String ThoiGianPhanBien;
    private int MaGiangVienHuongDan;
    private int MaNguoiDuyetDeTai;
    private int MaHoiDong;
    private int MaDeTaiDuocCap;
    private String TenDangNhap, MatKhau;
    private Integer MaNguoiDung, MaBoMon, MaLoaiNguoiDung;
    private String HoTen, DiaChi, SoTaiKhoanNganHang, SoDienThoai, Email, MaSo, Lop, KhoaHoc, TenLoaiNguoiDung;
    private String NgaySinh;
    private Boolean GioiTinh, TrangThaiNguoiDung;

    public SinhVien_DeTai(String tenDeTai, String mucTieu, String moTaYTuong, String tinhCapThiet,
	    String linhVucNghienCuu, String phuongPhapThucHien, BigDecimal kinhPhi, String thoiGianBatDau,
	    String thoiGianKetThuc, String hoTen, String diaChi, String soTaiKhoanNganHang, String soDienThoai,
	    String email, String maSo, String lop, String khoaHoc, String ngaySinh, Boolean gioiTinh) {
	super();
	TenDeTai = tenDeTai;
	MucTieu = mucTieu;
	MoTaYTuong = moTaYTuong;
	TinhCapThiet = tinhCapThiet;
	LinhVucNghienCuu = linhVucNghienCuu;
	PhuongPhapThucHien = phuongPhapThucHien;
	KinhPhi = kinhPhi;
	ThoiGianBatDau = thoiGianBatDau;
	ThoiGianKetThuc = thoiGianKetThuc;
	HoTen = hoTen;
	DiaChi = diaChi;
	SoTaiKhoanNganHang = soTaiKhoanNganHang;
	SoDienThoai = soDienThoai;
	Email = email;
	MaSo = maSo;
	Lop = lop;
	KhoaHoc = khoaHoc;
	NgaySinh = ngaySinh;
	GioiTinh = gioiTinh;
    }

    public SinhVien_DeTai(int maDeTai, String tenDeTai, String mucTieu, String moTaYTuong, String tinhCapThiet,
	    String linhVucNghienCuu, String phuongPhapThucHien, BigDecimal kinhPhi, String loaiDeTai,
	    String thoiGianBatDau, String thoiGianKetThuc, String thoiGianPhanBien, int maGiangVienHuongDan,
	    int maNguoiDuyetDeTai, int maHoiDong, int maDeTaiDuocCap, String tenDangNhap, String matKhau,
	    Integer maNguoiDung, Integer maBoMon, Integer maLoaiNguoiDung, String hoTen, String diaChi,
	    String soTaiKhoanNganHang, String soDienThoai, String email, String maSo, String lop, String khoaHoc,
	    String tenLoaiNguoiDung, String ngaySinh, Boolean gioiTinh, Boolean trangThaiNguoiDung) {
	super();
	MaDeTai = maDeTai;
	TenDeTai = tenDeTai;
	MucTieu = mucTieu;
	MoTaYTuong = moTaYTuong;
	TinhCapThiet = tinhCapThiet;
	LinhVucNghienCuu = linhVucNghienCuu;
	PhuongPhapThucHien = phuongPhapThucHien;
	KinhPhi = kinhPhi;
	LoaiDeTai = loaiDeTai;
	ThoiGianBatDau = thoiGianBatDau;
	ThoiGianKetThuc = thoiGianKetThuc;
	ThoiGianPhanBien = thoiGianPhanBien;
	MaGiangVienHuongDan = maGiangVienHuongDan;
	MaNguoiDuyetDeTai = maNguoiDuyetDeTai;
	MaHoiDong = maHoiDong;
	MaDeTaiDuocCap = maDeTaiDuocCap;
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

    public SinhVien_DeTai(Integer MaGiangVienHuongDan, Integer maDeTai, String TenDeTai, String ThoiGianBatDau,
	    String ThoiGianKetThuc) {
	this.MaGiangVienHuongDan = MaGiangVienHuongDan;
	this.MaDeTai = maDeTai;
	this.TenDeTai = TenDeTai;
	this.ThoiGianBatDau = ThoiGianBatDau;
	this.ThoiGianKetThuc = ThoiGianKetThuc;
    }

    public int getMaDeTai() {
	return MaDeTai;
    }

    public void setMaDeTai(int maDeTai) {
	MaDeTai = maDeTai;
    }

    public String getTenDeTai() {
	return TenDeTai;
    }

    public void setTenDeTai(String tenDeTai) {
	TenDeTai = tenDeTai;
    }

    public String getMucTieu() {
	return MucTieu;
    }

    public void setMucTieu(String mucTieu) {
	MucTieu = mucTieu;
    }

    public String getMoTaYTuong() {
	return MoTaYTuong;
    }

    public void setMoTaYTuong(String moTaYTuong) {
	MoTaYTuong = moTaYTuong;
    }

    public String getTinhCapThiet() {
	return TinhCapThiet;
    }

    public void setTinhCapThiet(String tinhCapThiet) {
	TinhCapThiet = tinhCapThiet;
    }

    public String getLinhVucNghienCuu() {
	return LinhVucNghienCuu;
    }

    public void setLinhVucNghienCuu(String linhVucNghienCuu) {
	LinhVucNghienCuu = linhVucNghienCuu;
    }

    public String getPhuongPhapThucHien() {
	return PhuongPhapThucHien;
    }

    public void setPhuongPhapThucHien(String phuongPhapThucHien) {
	PhuongPhapThucHien = phuongPhapThucHien;
    }

    public BigDecimal getKinhPhi() {
	return KinhPhi;
    }

    public void setKinhPhi(BigDecimal kinhPhi) {
	KinhPhi = kinhPhi;
    }

    public String getLoaiDeTai() {
	return LoaiDeTai;
    }

    public void setLoaiDeTai(String loaiDeTai) {
	LoaiDeTai = loaiDeTai;
    }

    public String getThoiGianBatDau() {
	return ThoiGianBatDau;
    }

    public void setThoiGianBatDau(String thoiGianBatDau) {
	ThoiGianBatDau = thoiGianBatDau;
    }

    public String getThoiGianKetThuc() {
	return ThoiGianKetThuc;
    }

    public void setThoiGianKetThuc(String thoiGianKetThuc) {
	ThoiGianKetThuc = thoiGianKetThuc;
    }

    public String getThoiGianPhanBien() {
	return ThoiGianPhanBien;
    }

    public void setThoiGianPhanBien(String thoiGianPhanBien) {
	ThoiGianPhanBien = thoiGianPhanBien;
    }

    public int getMaGiangVienHuongDan() {
	return MaGiangVienHuongDan;
    }

    public void setMaGiangVienHuongDan(int maGiangVienHuongDan) {
	MaGiangVienHuongDan = maGiangVienHuongDan;
    }

    public int getMaNguoiDuyetDeTai() {
	return MaNguoiDuyetDeTai;
    }

    public void setMaNguoiDuyetDeTai(int maNguoiDuyetDeTai) {
	MaNguoiDuyetDeTai = maNguoiDuyetDeTai;
    }

    public int getMaHoiDong() {
	return MaHoiDong;
    }

    public void setMaHoiDong(int maHoiDong) {
	MaHoiDong = maHoiDong;
    }

    public int getMaDeTaiDuocCap() {
	return MaDeTaiDuocCap;
    }

    public void setMaDeTaiDuocCap(int maDeTaiDuocCap) {
	MaDeTaiDuocCap = maDeTaiDuocCap;
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
