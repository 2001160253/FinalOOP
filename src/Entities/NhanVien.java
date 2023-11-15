package Entities;

public class NhanVien {
    private String maSo;
    private String hoTen;
    private String soDienThoai;
    private int soNgayLam;
    private double luongMotNgay;

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public int getSoNgayLam() {
        return soNgayLam;
    }

    public void setSoNgayLam(int soNgayLam) {
        this.soNgayLam = soNgayLam;
    }

    public double getLuongMotNgay() {
        return luongMotNgay;
    }

    public void setLuongMotNgay(double luongMotNgay) {
        this.luongMotNgay = luongMotNgay;
    }

    public NhanVien(String maSo, String hoTen, String soDienThoai, int soNgayLam, double luongMotNgay) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.soDienThoai = soDienThoai;
        this.soNgayLam = soNgayLam;
        this.luongMotNgay = luongMotNgay;
    }

    public NhanVien() {
    }

    public double tinhLuong(){
        return this.soNgayLam * this.luongMotNgay;
    }
    public void xuatThongTin(){
        System.out.printf("Ma so: %-10s Ho ten: %-20s SDT: %-10s So ngay lam: %-10d Luong 1 ngay: %-10.1f Thu nhap: %-10.1f\n"
                ,maSo, hoTen,soDienThoai, soNgayLam, luongMotNgay, tinhLuong());
    }
}
