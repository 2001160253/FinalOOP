package Entities;

public class CongTy {
    private String tenCongTy;
    private String maSoThue;
    private double doanhThu;

    public String getTenCongTy() {
        return tenCongTy;
    }

    public void setTenCongTy(String tenCongTy) {
        this.tenCongTy = tenCongTy;
    }

    public String getMaSoThue() {
        return maSoThue;
    }

    public void setMaSoThue(String maSoThue) {
        this.maSoThue = maSoThue;
    }

    public double getDoanhThu() {
        return doanhThu;
    }

    public void setDoanhThu(double doanhThu) {
        this.doanhThu = doanhThu;
    }

    public CongTy(String tenCongTy, String maSoThue, double doanhThu) {
        this.tenCongTy = tenCongTy;
        this.maSoThue = maSoThue;
        this.doanhThu = doanhThu;
    }

    public CongTy() {
    }
}
