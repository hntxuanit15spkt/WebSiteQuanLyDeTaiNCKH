package model;

import java.math.BigDecimal;
import java.util.Date;

public class DanhSachDeTai {
    private int MaDeTai;
    private String HoTen;
    private String KhoaHoc;
    private String SoTaiKhoanNganHang;
    private String SoDienThoai;
    private String Email;
    private String Lop;
    private String DiaChi;
    private String TenDangNhap;
    private String TenLoaiNguoiDung;
    private String TenDeTai;
    private String MucTieu;
    private String TenTrangThai;
    private String MoTaYTuong;
    private String TinhCapThiet;
    private String LinhVucNghienCuu;
    private String PhuongPhapThucHien;
    private BigDecimal KinhPhi;
    private String LoaiDeTai;
    private Date NgaySinh;
    private Date ThoiGianBatDau;
    private Date ThoiGianKetThuc;
    private Date ThoiGianPhanBien;
    private Date ThoiGianThayDoi;
    private int MaGiangVienHuongDan;
    private int MaTrangThai;
    private int MaNguoiDuyetDeTai;
    private int MaHoiDong;
    private int MaDeTaiDuocCap;
    private int SoLuongDeTai;
    private int DiemDanhGia;
    private float DiemTrungBinh;
    private int ID;
    private Boolean GioiTinh;
    private int IDLonNhat;

    public DanhSachDeTai(int maDeTai, String tenDeTai, String tenTrangThai, float diemTrungBinh) {
	super();
	MaDeTai = maDeTai;
	TenDeTai = tenDeTai;
	TenTrangThai = tenTrangThai;
	DiemTrungBinh = diemTrungBinh;
    }

    public DanhSachDeTai(int maTrangThai, int maDeTai, String hoTen, String khoaHoc, String soTaiKhoanNganHang,
	    String soDienThoai, String email, String lop, String diaChi, String tenDangNhap, String tenDeTai,
	    String mucTieu, String moTaYTuong, String tinhCapThiet, String linhVucNghienCuu, String phuongPhapThucHien,
	    BigDecimal kinhPhi, Date ngaySinh, Date thoiGianBatDau, Date thoiGianKetThuc, int maGiangVienHuongDan,
	    Boolean gioiTinh) {
	super();
	MaTrangThai = maTrangThai;
	MaDeTai = maDeTai;
	HoTen = hoTen;
	KhoaHoc = khoaHoc;
	SoTaiKhoanNganHang = soTaiKhoanNganHang;
	SoDienThoai = soDienThoai;
	Email = email;
	Lop = lop;
	DiaChi = diaChi;
	TenDangNhap = tenDangNhap;
	TenDeTai = tenDeTai;
	MucTieu = mucTieu;
	MoTaYTuong = moTaYTuong;
	TinhCapThiet = tinhCapThiet;
	LinhVucNghienCuu = linhVucNghienCuu;
	PhuongPhapThucHien = phuongPhapThucHien;
	KinhPhi = kinhPhi;
	NgaySinh = ngaySinh;
	ThoiGianBatDau = thoiGianBatDau;
	ThoiGianKetThuc = thoiGianKetThuc;
	MaGiangVienHuongDan = maGiangVienHuongDan;
	GioiTinh = gioiTinh;
    }

    public int getIDLonNhat() {
	return IDLonNhat;
    }

    public DanhSachDeTai(String hoTen, String khoaHoc, String soTaiKhoanNganHang, String soDienThoai, String email,
	    String lop, String diaChi, String tenDangNhap, String tenDeTai, String mucTieu, String moTaYTuong,
	    String tinhCapThiet, String linhVucNghienCuu, String phuongPhapThucHien, BigDecimal kinhPhi, Date ngaySinh,
	    Date thoiGianBatDau, Date thoiGianKetThuc, int maGiangVienHuongDan, Boolean gioiTinh) {
	super();
	HoTen = hoTen;
	KhoaHoc = khoaHoc;
	SoTaiKhoanNganHang = soTaiKhoanNganHang;
	SoDienThoai = soDienThoai;
	Email = email;
	Lop = lop;
	DiaChi = diaChi;
	TenDangNhap = tenDangNhap;
	TenDeTai = tenDeTai;
	MucTieu = mucTieu;
	MoTaYTuong = moTaYTuong;
	TinhCapThiet = tinhCapThiet;
	LinhVucNghienCuu = linhVucNghienCuu;
	PhuongPhapThucHien = phuongPhapThucHien;
	KinhPhi = kinhPhi;
	NgaySinh = ngaySinh;
	ThoiGianBatDau = thoiGianBatDau;
	ThoiGianKetThuc = thoiGianKetThuc;
	MaGiangVienHuongDan = maGiangVienHuongDan;
	GioiTinh = gioiTinh;
    }

    public DanhSachDeTai(int maDeTai, Date thoiGianThayDoi, int iD) {
	super();
	MaDeTai = maDeTai;
	ThoiGianThayDoi = thoiGianThayDoi;
	ID = iD;
    }

    public DanhSachDeTai(int MaTrangThai, String hoTen, String tenLoaiNguoiDung, int maDeTai, String tenDeTai,
	    String mucTieu, String tenTrangThai, Date thoiGianBatDau, Date thoiGianKetThuc, Date thoiGianPhanBien) {
	super();
	this.MaTrangThai = MaTrangThai;
	HoTen = hoTen;
	TenLoaiNguoiDung = tenLoaiNguoiDung;
	MaDeTai = maDeTai;
	TenDeTai = tenDeTai;
	MucTieu = mucTieu;
	TenTrangThai = tenTrangThai;
	ThoiGianBatDau = thoiGianBatDau;
	ThoiGianKetThuc = thoiGianKetThuc;
	ThoiGianPhanBien = thoiGianPhanBien;
    }

    public DanhSachDeTai(int maDeTai, String hoTen, String tenDeTai, String tenTrangThai, Date thoiGianPhanBien,
	    int maTrangThai, int diemDanhGia) {
	super();
	MaDeTai = maDeTai;
	HoTen = hoTen;
	TenDeTai = tenDeTai;
	TenTrangThai = tenTrangThai;
	ThoiGianPhanBien = thoiGianPhanBien;
	MaTrangThai = maTrangThai;
	DiemDanhGia = diemDanhGia;
    }

    public DanhSachDeTai(int soLuongDeTai) {
	super();
	SoLuongDeTai = soLuongDeTai;
    }

    public DanhSachDeTai(String hoTen, int maTrangThai, String tenDeTai, String tenTrangThai, Date thoiGianPhanBien,
	    int tongDiem) {
	super();
	HoTen = hoTen;
	MaTrangThai = maTrangThai;
	TenDeTai = tenDeTai;
	TenTrangThai = tenTrangThai;
	ThoiGianPhanBien = thoiGianPhanBien;
	DiemDanhGia = tongDiem;
    }

    public DanhSachDeTai(String hoTen, String tenLoaiNguoiDung, int maDeTai, String tenDeTai, String mucTieu,
	    String tenTrangThai, Date thoiGianBatDau, Date thoiGianKetThuc, Date thoiGianPhanBien) {
	super();
	HoTen = hoTen;
	TenLoaiNguoiDung = tenLoaiNguoiDung;
	MaDeTai = maDeTai;
	TenDeTai = tenDeTai;
	MucTieu = mucTieu;
	TenTrangThai = tenTrangThai;
	ThoiGianBatDau = thoiGianBatDau;
	ThoiGianKetThuc = thoiGianKetThuc;
	ThoiGianPhanBien = thoiGianPhanBien;
    }

    public int getMaDeTai() {
	return MaDeTai;
    }

    public void setMaDeTai(int maDeTai) {
	MaDeTai = maDeTai;
    }

    public String getHoTen() {
	return HoTen;
    }

    public void setHoTen(String hoTen) {
	HoTen = hoTen;
    }

    public String getTenDangNhap() {
	return TenDangNhap;
    }

    public void setTenDangNhap(String tenDangNhap) {
	TenDangNhap = tenDangNhap;
    }

    public String getTenLoaiNguoiDung() {
	return TenLoaiNguoiDung;
    }

    public void setTenLoaiNguoiDung(String tenLoaiNguoiDung) {
	TenLoaiNguoiDung = tenLoaiNguoiDung;
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

    public String getTenTrangThai() {
	return TenTrangThai;
    }

    public void setTenTrangThai(String tenTrangThai) {
	TenTrangThai = tenTrangThai;
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

    public Date getThoiGianBatDau() {
	return ThoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
	ThoiGianBatDau = thoiGianBatDau;
    }

    public Date getThoiGianKetThuc() {
	return ThoiGianKetThuc;
    }

    public void setThoiGianKetThuc(Date thoiGianKetThuc) {
	ThoiGianKetThuc = thoiGianKetThuc;
    }

    public Date getThoiGianPhanBien() {
	return ThoiGianPhanBien;
    }

    public void setThoiGianPhanBien(Date thoiGianPhanBien) {
	ThoiGianPhanBien = thoiGianPhanBien;
    }

    public Date getThoiGianThayDoi() {
	return ThoiGianThayDoi;
    }

    public void setThoiGianThayDoi(Date thoiGianThayDoi) {
	ThoiGianThayDoi = thoiGianThayDoi;
    }

    public int getMaGiangVienHuongDan() {
	return MaGiangVienHuongDan;
    }

    public void setMaGiangVienHuongDan(int maGiangVienHuongDan) {
	MaGiangVienHuongDan = maGiangVienHuongDan;
    }

    public int getMaTrangThai() {
	return MaTrangThai;
    }

    public void setMaTrangThai(int maTrangThai) {
	MaTrangThai = maTrangThai;
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

    public int getSoLuongDeTai() {
	return SoLuongDeTai;
    }

    public void setSoLuongDeTai(int soLuongDeTai) {
	SoLuongDeTai = soLuongDeTai;
    }

    public int getDiemDanhGia() {
	return DiemDanhGia;
    }

    public void setTongDiem(int diemDanhGia) {
	DiemDanhGia = diemDanhGia;
    }

    public String getKhoaHoc() {
	return KhoaHoc;
    }

    public void setKhoaHoc(String khoaHoc) {
	KhoaHoc = khoaHoc;
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

    public String getLop() {
	return Lop;
    }

    public void setLop(String lop) {
	Lop = lop;
    }

    public String getDiaChi() {
	return DiaChi;
    }

    public void setDiaChi(String diaChi) {
	DiaChi = diaChi;
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

    public void setDiemDanhGia(int diemDanhGia) {
	DiemDanhGia = diemDanhGia;
    }

    public float getDiemTrungBinh() {
	return DiemTrungBinh;
    }

    public void setDiemTrungBinh(float diemTrungBinh) {
	DiemTrungBinh = diemTrungBinh;
    }

    public int getID() {
	return ID;
    }

    public void setID(int iD) {
	ID = iD;
    }
}
