package Entities;

import java.util.ArrayList;

public class TruongPhong extends NhanVien{
    private int soLuongNV;
    private ArrayList<NhanVienThuong> listNVThuong = new ArrayList<>();

    public int getSoLuongNV() {
        return soLuongNV;
    }

    public void setSoLuongNV(int soLuongNV) {
        this.soLuongNV = soLuongNV;
    }

    public ArrayList<NhanVienThuong> getListNVThuong() {
        return listNVThuong;
    }

    public void setListNVThuong(ArrayList<NhanVienThuong> listNVThuong) {
        this.listNVThuong = listNVThuong;
    }

    public TruongPhong(String maSo, String hoTen, String soDienThoai, int soNgayLam, double luongMotNgay, int soLuongNV, ArrayList<NhanVienThuong> listNVThuong) {
        super(maSo, hoTen, soDienThoai, soNgayLam, luongMotNgay);
        this.soLuongNV = soLuongNV;
        this.listNVThuong = listNVThuong;
    }

    public TruongPhong() {
        setLuongMotNgay(200);
    }

    @Override
    public double tinhLuong() {
        return super.tinhLuong() + 100 * listNVThuong.size();
    }

    @Override
    public void xuatThongTin() {
        super.xuatThongTin();
        System.out.println("So nhan vien duoi quyen: "+this.soLuongNV);
    }

    public void tiepNhanNhanVien(NhanVienThuong nv) {
        listNVThuong.add(nv);
        setSoLuongNV(getListNVThuong().size());
    }

    public void loaiBoNhanVien(NhanVienThuong nv) {
        listNVThuong.remove(nv);
        setSoLuongNV(getListNVThuong().size());
    }
}
