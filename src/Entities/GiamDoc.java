package Entities;

public class GiamDoc extends NhanVien{
    private double phanTramCoPhan;

    public double getPhanTramCoPhan() {
        return phanTramCoPhan;
    }

    public void setPhanTramCoPhan(double phanTramCoPhan) {
        this.phanTramCoPhan = phanTramCoPhan;
    }

    public GiamDoc(String maSo, String hoTen, String soDienThoai, int soNgayLam, double luongMotNgay, double phanTramCoPhan) {
        super(maSo, hoTen, soDienThoai, soNgayLam, luongMotNgay);
        this.phanTramCoPhan = phanTramCoPhan;
    }

    public GiamDoc() {
        setLuongMotNgay(300);
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong();
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("So co phan: " + this.getPhanTramCoPhan());
    }
}
