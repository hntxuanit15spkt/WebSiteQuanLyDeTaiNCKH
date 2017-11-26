package model;

public class DeTai {
    private String TenDeTai;
    private String PhuongPhapThucHien;
    private String KinhPhi;
    private String LoaiDeTai;

    public DeTai() {
	super();

    }

    public DeTai(String TenDeTai, String phuongPhapThucHien, String kinhPhi, String loaiDeTai) {
	super();
	this.TenDeTai = TenDeTai;
	PhuongPhapThucHien = phuongPhapThucHien;
	KinhPhi = kinhPhi;
	LoaiDeTai = loaiDeTai;
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
