package model;

import java.math.BigDecimal;

public class DeTai {
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
    private String NgayXinGiaHan;
    private String ThoiGianThayDoi;

    public DeTai() {
	super();
    }

    public DeTai(String tendetai2, String muctieu2, String motaytuong2, String tinhcapthiet2, String linhvucnghiencuu2,
	    String phuongphapthuchien2, BigDecimal kinhphi2, String thoiGianBatDau2, String thoiGianKetThuc2,
	    int maGiangVienHuongDan2) {
	TenDeTai = tendetai2;
	MucTieu = muctieu2;
	MoTaYTuong = motaytuong2;
	TinhCapThiet = tinhcapthiet2;
	LinhVucNghienCuu = linhvucnghiencuu2;
	PhuongPhapThucHien = phuongphapthuchien2;
	KinhPhi = kinhphi2;
	ThoiGianBatDau = thoiGianBatDau2;
	ThoiGianKetThuc = thoiGianKetThuc2;
	MaGiangVienHuongDan = maGiangVienHuongDan2;
    }

    public DeTai(int MaDeTai, String TenDeTai, String MucTieu, String MoTaYTuong, String TinhCapThiet,
	    String LinhVucNghienCuu, String PhuongPhapThucHien, BigDecimal KinhPhi, String ThoiGianBatDau,
	    String ThoiGianKetThuc) {
	this.MaDeTai = MaDeTai;
	this.TenDeTai = TenDeTai;
	this.MucTieu = MucTieu;
	this.MoTaYTuong = MoTaYTuong;
	this.TinhCapThiet = TinhCapThiet;
	this.LinhVucNghienCuu = LinhVucNghienCuu;
	this.PhuongPhapThucHien = PhuongPhapThucHien;
	this.KinhPhi = KinhPhi;
	this.ThoiGianBatDau = ThoiGianBatDau;
	this.ThoiGianKetThuc = ThoiGianKetThuc;
    }

    public DeTai(int MaDeTai, int MaGiangVienHuongDan, String TenDeTai, String MucTieu, String MoTaYTuong,
	    String LinhVucNghienCuu, String TinhCapThiet, String PhuongPhapThucHien, BigDecimal KinhPhi,
	    String LoaiDeTai, String ThoiGianBatDau, String ThoiGianKetThuc, String ThoiGianPhanBien) {
	this.MaDeTai = MaDeTai;
	this.MaGiangVienHuongDan = MaGiangVienHuongDan;
	this.TenDeTai = TenDeTai;
	this.MucTieu = MucTieu;
	this.MoTaYTuong = MoTaYTuong;
	this.LinhVucNghienCuu = LinhVucNghienCuu;
	this.TinhCapThiet = TinhCapThiet;
	this.LinhVucNghienCuu = LinhVucNghienCuu;
	this.PhuongPhapThucHien = PhuongPhapThucHien;
	this.KinhPhi = KinhPhi;
	this.LoaiDeTai = LoaiDeTai;
	this.ThoiGianBatDau = ThoiGianBatDau;
	this.ThoiGianKetThuc = ThoiGianKetThuc;
	this.ThoiGianPhanBien = ThoiGianPhanBien;
    }

    public DeTai(int MaDeTai, int MaGiangVienHuongDan, String TenDeTai, String MucTieu, String MoTaYTuong,
	    String LinhVucNghienCuu, String TinhCapThiet, String PhuongPhapThucHien, BigDecimal KinhPhi,
	    String LoaiDeTai, String ThoiGianBatDau, String ThoiGianKetThuc) {
	this.MaDeTai = MaDeTai;
	this.MaGiangVienHuongDan = MaGiangVienHuongDan;
	this.TenDeTai = TenDeTai;
	this.MucTieu = MucTieu;
	this.MoTaYTuong = MoTaYTuong;
	this.LinhVucNghienCuu = LinhVucNghienCuu;
	this.TinhCapThiet = TinhCapThiet;
	this.LinhVucNghienCuu = LinhVucNghienCuu;
	this.PhuongPhapThucHien = PhuongPhapThucHien;
	this.KinhPhi = KinhPhi;
	this.LoaiDeTai = LoaiDeTai;
	this.ThoiGianBatDau = ThoiGianBatDau;
	this.ThoiGianKetThuc = ThoiGianKetThuc;
    }

    public DeTai(int MaDeTai, int MaGiangVienHuongDan, String TenDeTai, String MucTieu, String MoTaYTuong,
	    String LinhVucNghienCuu, String TinhCapThiet, String PhuongPhapThucHien, BigDecimal KinhPhi,
	    String LoaiDeTai, String ThoiGianBatDau, String ThoiGianKetThuc, String ngayXinGiaHan,
	    String thoiGianThayDoi) {
	this.MaDeTai = MaDeTai;
	this.MaGiangVienHuongDan = MaGiangVienHuongDan;
	this.TenDeTai = TenDeTai;
	this.MucTieu = MucTieu;
	this.MoTaYTuong = MoTaYTuong;
	this.LinhVucNghienCuu = LinhVucNghienCuu;
	this.TinhCapThiet = TinhCapThiet;
	this.LinhVucNghienCuu = LinhVucNghienCuu;
	this.PhuongPhapThucHien = PhuongPhapThucHien;
	this.KinhPhi = KinhPhi;
	this.LoaiDeTai = LoaiDeTai;
	this.ThoiGianBatDau = ThoiGianBatDau;
	this.ThoiGianKetThuc = ThoiGianKetThuc;
	NgayXinGiaHan = ngayXinGiaHan;
	ThoiGianThayDoi = thoiGianThayDoi;
    }

    public String getMucTieu() {
	return MucTieu;
    }

    public String getThoiGianThayDoi() {
	return ThoiGianThayDoi;
    }

    public void setThoiGianThayDoi(String thoiGianThayDoi) {
	ThoiGianThayDoi = thoiGianThayDoi;
    }

    public String getNgayXinGiaHan() {
	return NgayXinGiaHan;
    }

    public void setNgayXinGiaHan(String ngayXinGiaHan) {
	NgayXinGiaHan = ngayXinGiaHan;
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

}
