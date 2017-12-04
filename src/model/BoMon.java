package model;

public class BoMon {
    private int MaBoMon;
    private String TenBoMon;
    private int MaTruongBoMon;

    public int getMaBoMon() {
	return MaBoMon;
    }

    public void setMaBoMon(int maBoMon) {
	MaBoMon = maBoMon;
    }

    public String getTenBoMon() {
	return TenBoMon;
    }

    public void setTenBoMon(String tenBoMon) {
	TenBoMon = tenBoMon;
    }

    public int getMaTruongBoMon() {
	return MaTruongBoMon;
    }

    public void setMaTruongBoMon(int maTruongBoMon) {
	MaTruongBoMon = maTruongBoMon;
    }

    public BoMon(int maBoMon, String tenBoMon, int maTruongBoMon) {
	super();
	MaBoMon = maBoMon;
	TenBoMon = tenBoMon;
	MaTruongBoMon = maTruongBoMon;
    }

    public BoMon() {
	super();
	// TODO Auto-generated constructor stub
    }

}
