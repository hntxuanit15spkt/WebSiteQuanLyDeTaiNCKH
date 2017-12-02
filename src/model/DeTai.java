package model;

public class DeTai {
    private int MaDeTai;
    private String TenDeTai;
    private String PhuongPhapThucHien;
    private String KinhPhi;
    private String LoaiDeTai;

    public DeTai() {
	super();
    }

    public DeTai(int maDeTai, String tenDeTai, String phuongPhapThucHien, String kinhPhi, String loaiDeTai) {
	super();
	MaDeTai = maDeTai;
	TenDeTai = tenDeTai;
	PhuongPhapThucHien = phuongPhapThucHien;
	KinhPhi = kinhPhi;
	LoaiDeTai = loaiDeTai;
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
