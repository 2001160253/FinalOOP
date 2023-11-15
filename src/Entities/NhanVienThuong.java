package Entities;

public class NhanVienThuong extends NhanVien{
    private String maTruongPhong;

    public String getMaTruongPhong() {
        return maTruongPhong;
    }

    public void setMaTruongPhong(String maTruongPhong) {
        this.maTruongPhong = maTruongPhong;
    }

    public NhanVienThuong(String maSo, String hoTen, String soDienThoai, int soNgayLam, double luongMotNgay, String maTruongPhong) {
        super(maSo, hoTen, soDienThoai, soNgayLam, luongMotNgay);
        this.maTruongPhong = maTruongPhong;
    }

    public NhanVienThuong() {
        super();
        setLuongMotNgay(100);
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong();
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
    }


}
