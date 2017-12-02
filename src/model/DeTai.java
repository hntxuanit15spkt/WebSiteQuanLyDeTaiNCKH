package model;

import java.util.Date;

public class DeTai {
    private int MaDeTai;
    private String TenDeTai;
    private String MucTieu;
    private String MoTaYTuong;
    private String TinhCapThiet;
    private String LinhVucNghienCuu;
    private String PhuongPhapThucHien;
    private String KinhPhi;
    private String LoaiDeTai;
    private Date ThoiGianBatDau;
    private Date ThoiGianKetThuc;
    private Date ThoiGianPhanBien;
    private int MaGiangVienHuongDan;
    private int MaNguoiDuyetDeTai;
    private int MaHoiDong;
    private int MaDeTaiDuocCap;

    public DeTai() {
	super();
    }

    public DeTai(int maDeTai, String tenDeTai, String mucTieu, String moTaYTuong, String tinhCapThiet,
	    String linhVucNghienCuu, String phuongPhapThucHien, String kinhPhi, String loaiDeTai, Date thoiGianBatDau,
	    Date thoiGianKetThuc, Date thoiGianPhanBien, int maGiangVienHuongDan, int maNguoiDuyetDeTai, int maHoiDong,
	    int maDeTaiDuocCap) {
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
    }

    public DeTai(int maDeTai, String tenDeTai, String phuongPhapThucHien, String kinhPhi, String loaiDeTai) {
	super();
	MaDeTai = maDeTai;
	TenDeTai = tenDeTai;
	PhuongPhapThucHien = phuongPhapThucHien;
	KinhPhi = kinhPhi;
	LoaiDeTai = loaiDeTai;
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

    public String getPhuongPhapThucHien() {
	return PhuongPhapThucHien;
    }

    public void setPhuongPhapThucHien(String phuongPhapThucHien) {
	PhuongPhapThucHien = phuongPhapThucHien;
    }

    public String getKinhPhi() {
	return KinhPhi;
    }

    public void setKinhPhi(String kinhPhi) {
	KinhPhi = kinhPhi;
    }

    public String getLoaiDeTai() {
	return LoaiDeTai;
    }

    public void setLoaiDeTai(String loaiDeTai) {
	LoaiDeTai = loaiDeTai;
    }

}
