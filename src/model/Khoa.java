package model;

public class Khoa {
    private int MaKhoa;
    private String TenKhoa;
    private int MaTruongKhoa;

    public int getMaKhoa() {
	return MaKhoa;
    }

    public void setMaKhoa(int maKhoa) {
	MaKhoa = maKhoa;
    }

    public String getTenKhoa() {
	return TenKhoa;
    }

    public void setTenKhoa(String tenKhoa) {
	TenKhoa = tenKhoa;
    }

    public int getMaTruongKhoa() {
	return MaTruongKhoa;
    }

    public void setMaTruongKhoa(int maTruongKhoa) {
	MaTruongKhoa = maTruongKhoa;
    }

    public Khoa() {
	super();
	// TODO Auto-generated constructor stub
    }

    public Khoa(int maKhoa, String tenKhoa, int maTruongKhoa) {
	super();
	MaKhoa = maKhoa;
	TenKhoa = tenKhoa;
	MaTruongKhoa = maTruongKhoa;
    }

}
