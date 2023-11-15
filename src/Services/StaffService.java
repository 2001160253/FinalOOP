package Services;

import Entities.GiamDoc;
import Entities.NhanVien;
import Entities.NhanVienThuong;
import Entities.TruongPhong;

import java.util.ArrayList;
import java.util.List;

public class StaffService {
    public NhanVien findAllStaff(List<NhanVien> listNV, String id){
        for(NhanVien nv : listNV){
            if( nv.getMaSo().equalsIgnoreCase(id)){
                return nv;
            }
        }
        return null;
    }

    public NhanVien findStaffByID(List<NhanVien> listNV, String id){
        for(NhanVien nv : listNV){
            if(nv instanceof NhanVienThuong && nv.getMaSo().equalsIgnoreCase(id)){
                return nv;
            }
        }
        return null;
    }

    public NhanVien findManagerByID(List<NhanVien> listNV, String id) {
        for (NhanVien nv: listNV)
            if(nv instanceof TruongPhong && nv.getMaSo().equalsIgnoreCase(id))
                return nv;
        return null;
    }

    public List<NhanVien> createData() {
        List<NhanVien> data = new ArrayList<>();

        NhanVien nv11 = new NhanVienThuong();
        nv11.setMaSo("nv11");
        nv11.setHoTen("Nguyen Van Khang a");
        nv11.setSoDienThoai("0325478165");
        nv11.setSoNgayLam(30);
        data.add(nv11);

        NhanVien nv1 = new NhanVienThuong();
        nv1.setMaSo("nv1");
        nv1.setHoTen("Nguyen Van Khang c");
        nv1.setSoDienThoai("0325478165");
        nv1.setSoNgayLam(23);
        data.add(nv1);
        ((NhanVienThuong)nv1).setMaTruongPhong("TP02 b");

        NhanVien nv2 = new NhanVienThuong();
        nv2.setMaSo("nv2");
        nv2.setHoTen("Nguyen Van Khang b");
        nv2.setSoDienThoai("0325478165");
        nv2.setSoNgayLam(28);
        data.add(nv2);
        ((NhanVienThuong)nv2).setMaTruongPhong("TP01");

        NhanVien nv3 = new NhanVienThuong();
        nv3.setMaSo("nv3");
        nv3.setHoTen("Nguyen Van Khang 3");
        nv3.setSoDienThoai("0325478165");
        nv3.setSoNgayLam(10);
        ((NhanVienThuong)nv3).setMaTruongPhong("TP01");
        data.add(nv3);

        NhanVien nv4 = new TruongPhong();
        nv4.setMaSo("TP01");
        nv4.setHoTen("Le Van An");
        nv4.setSoDienThoai("555");
        nv4.setSoNgayLam(10);
        data.add(nv4);

        NhanVien nv6 = new TruongPhong();
        nv6.setMaSo("TP02");
        nv6.setHoTen("Le Van An TP");
        nv6.setSoDienThoai("555");
        nv6.setSoNgayLam(10);
        data.add(nv6);

        NhanVien nv5 = new GiamDoc();
        nv5.setMaSo("nv000004");
        nv5.setHoTen("Le Hoang Dieu GD 1");
        nv5.setSoDienThoai("0325478456");
        nv5.setSoNgayLam(12);
        ((GiamDoc)nv5).setPhanTramCoPhan(20);
        data.add(nv5);

        NhanVien nv55 = new GiamDoc();
        nv55.setMaSo("nv000004");
        nv55.setHoTen("Le Hoang Dieu GD 2");
        nv55.setSoDienThoai("0325478456");
        nv55.setSoNgayLam(12);
        ((GiamDoc)nv55).setPhanTramCoPhan(10);
        data.add(nv55);

        return data;
    }
}
