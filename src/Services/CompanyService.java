package Services;

import Entities.*;

import java.util.*;

public class CompanyService {
    StaffService staffService = new StaffService();

    public CongTy inputComanyInfo(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhap ten cong ty:");
        String companyName = scanner.nextLine();

        System.out.println("Nhap ma so thue:");
        String taxID = scanner.nextLine();

        System.out.println("Nhap thu nhap: ");
        double revenue = scanner.nextDouble();
        scanner.nextLine();

        return new CongTy(companyName, taxID, revenue);
    }

    public void displayCompanyInfo(CongTy ct) {
        System.out.printf("Company name: %-20s Tax id: %-10s Revenue: %-10.1f\n",
                ct.getTenCongTy(),ct.getMaSoThue(),ct.getDoanhThu());
    }

   public void allocateEmployeesToDepartmentHead(List<NhanVien> ls){
        Scanner scanner = new Scanner(System.in);
       System.out.println("Nhap ma nhan vien: ");
       String id = scanner.nextLine();
       NhanVienThuong nv = (NhanVienThuong) staffService.findStaffByID(ls, id);
       if(nv==null){
           System.out.println("Khong ton tai nhan vien nay!");
       }else {
           System.out.println("Nhap ma truong phong: ");
           String idManager = scanner.nextLine();
           TruongPhong tp = (TruongPhong) staffService.findManagerByID(ls, idManager);
           if(tp == null){
               System.out.println("Khong ton tai truong phong nay");
           }else {
               nv.setMaTruongPhong(idManager);
               tp.tiepNhanNhanVien(nv);
               System.out.println("Phan bo thanh cong");
           }
       }
   }

    public List<NhanVien> inputEmployee(){
        Scanner scanner = new Scanner(System.in);
        List<NhanVien> ls = new ArrayList<>();

        System.out.println("Enter Employee Information:");

        System.out.print("Employee ID: ");
        String employeeID = scanner.nextLine();

        System.out.print("Full Name: ");
        String fullName = scanner.nextLine();

        System.out.print("Phone Number: ");
        String phoneNumber = scanner.nextLine();

        System.out.print("Working Days: ");
        int workingDays = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Daily wage: ");
        double wage = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Do you want to input employee or manager or director");
        System.out.println("1. Employee");
        System.out.println("2. Director");

        int num = scanner.nextInt();
        scanner.nextLine();

        switch (num){
            case 1:{
                NhanVien e = new NhanVienThuong(employeeID, fullName, phoneNumber, workingDays, wage, null );
                ls.add(e);
                break;
            }
            case 2:{
                System.out.println("Enter shares");
                double shares = scanner.nextDouble();
                scanner.nextLine();

                NhanVien d = new GiamDoc(employeeID, fullName, phoneNumber, workingDays, wage, shares);
                ls.add(d);
                break;
            }
            default:{
                System.out.println("error");
                break;
            }
        }

        return ls;
    }

    public void removeStaff(List<NhanVien> ls, NhanVienThuong nv){
        if(nv.getMaTruongPhong() != null){
            TruongPhong tp = (TruongPhong)staffService.findManagerByID(ls, nv.getMaTruongPhong());
            if(tp != null){
                tp.loaiBoNhanVien(nv);
            }
        }
        ls.remove(nv);
    }

    public void removeManager(List<NhanVien> ls, TruongPhong tp){
        for (NhanVien nv:ls){
            if(nv instanceof TruongPhong ){
                if(((NhanVienThuong)nv).getMaTruongPhong() != null){
                    if(((NhanVienThuong)nv).getMaTruongPhong().equalsIgnoreCase(tp.getMaSo())){
                        ((NhanVienThuong)nv).setMaTruongPhong(null);
                    }
                }
            }
        }
        ls.remove(tp);
    }
    public  void removeDirector(List<NhanVien> ls, GiamDoc giamDoc){
        ls.remove(giamDoc);
    }

    public double sumSalary(List<NhanVien> listNV){
        double s = 0.0;
        for(NhanVien emp : listNV){
            s+= emp.tinhLuong();
        }
        return s;
    }

    public NhanVien findStaffWithMaxSalary(List<NhanVien> ls){
        NhanVien max = ls.get(0);

        for (NhanVien nv : ls) {
            if (nv.tinhLuong() > max.tinhLuong() && nv instanceof NhanVienThuong) {
                max = nv;
            }
        }

        return max;
    }


    public NhanVien findHeadWithMostSubordinates(List<NhanVien> ls){
        int num = 0;
        for (NhanVien nv: ls)
            if(nv instanceof TruongPhong && ((TruongPhong) nv).getSoLuongNV() > num)
                num = ((TruongPhong) nv).getSoLuongNV();

        NhanVien max = ls.get(0);

        for (NhanVien nv : ls) {
            if(nv instanceof  TruongPhong){
                if(((TruongPhong) nv).getSoLuongNV() == num){
                    max =  nv;
                }
            }
        }
        return max;
    }

    public void sortToAbc(List<NhanVien> ls){
        Collections.sort(ls, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return o1.getHoTen().compareTo(o2.getHoTen());
            }
        });
    }

    public void sortToSalary(List<NhanVien> ls){
        Collections.sort(ls, new Comparator<NhanVien>() {
            @Override
            public int compare(NhanVien o1, NhanVien o2) {
                return Double.compare(o2.tinhLuong(),(o1.tinhLuong()));
            }
        });
    }

    public NhanVien findStaffWithMaxShares(List<NhanVien> ls){
        NhanVien max = ls.get(0);

        for (NhanVien nv : ls) {
            if (nv.tinhLuong() > max.tinhLuong() && nv instanceof GiamDoc) {
                max = nv;
            }
        }

        return max;
    }

    public void calculateDirectorSalary(double revenue, double allSalary, List<NhanVien> ls){
        double result = revenue -  allSalary;
        System.out.printf("Doanh thu: %-10.1f Tong luong: %-10.1f\n",revenue, allSalary);
        for(NhanVien nv:ls){
            if(nv instanceof GiamDoc){
                nv.xuatThongTin();
                double salary = ((GiamDoc)nv).tinhLuong() +  ((GiamDoc)nv).getPhanTramCoPhan() * result;
                System.out.println("Luong: "+salary);
            }
        }
    }

    public void showMenu(){
        System.out.println("\n==========MENU==========");
        System.out.println("1. Nhap thong tin cong ty.");
        System.out.println("2. Phan bo nhan vien vao truong phong.");
        System.out.println("3. Them nhan su.");
        System.out.println("4. Xoa nhan su.");
        System.out.println("5. Xuat thong tin toan bo nguoi trong cong ty.");
        System.out.println("6. Tinh va xuat tong luong cho toan cong ty.");
        System.out.println("7. Tim nhan vien thuong co luong cao nhat.");
        System.out.println("8. Tim truong phong co so luong nhan vien duoi quyen nhieu nhat.");
        System.out.println("9. Sap xep nhan vien toan cong ty theo thu tu abc");
        System.out.println("10. Sap xep nhan vien toan cong ty theo thu tu luong giam dan.");
        System.out.println("11. Tim giam doc co so luong co phan nhieu nhat");
        System.out.println("12. Tinh va xuat tong thu nhap cua tung giam doc.");
        System.out.println("0. Thoat chuong trinh.");
        System.out.println("==========MENU==========");
        System.out.println("Nhap lua chon: ");
    }

    public void displayAllStaff(List<NhanVien> listNV){
        System.out.println("---------Employee---------\n");
        for (NhanVien nv: listNV){
            if(nv instanceof NhanVienThuong)
            {
                String id = nv.getMaSo();
                String fullname = nv.getHoTen();
                String phone = nv.getSoDienThoai();
                int workDays = nv.getSoNgayLam();
                double dailyWage = nv.getLuongMotNgay();
                double salary = nv.tinhLuong();

                System.out.printf("ID: %-10s Full name: %-20s Phone: %-15s Working days: %-10d Daily wage: %-10.1f salary: %-10.1f\n",
                        id, fullname, phone, workDays, dailyWage, salary);
            }
        }
        System.out.println("---------Manager----------\n");
        for(NhanVien emp: listNV){
            if(emp instanceof TruongPhong){
                String id = emp.getMaSo();
                String fullname = emp.getHoTen();
                String phone = emp.getSoDienThoai();
                int workDays = emp.getSoNgayLam();
                double dailyWage = emp.getLuongMotNgay();
                int num = ((TruongPhong) emp).getSoLuongNV();
                double salary = emp.tinhLuong();

                System.out.printf("ID: %-10s Full name: %-20s Phone: %-15s Working days: %-10d Daily wage: %-10.1f Num: %-10d Salary: %-10.1f\n",
                        id, fullname, phone, workDays, dailyWage, num, salary);
            }
        }
        System.out.println("---------Director----------\n");
        for(NhanVien emp: listNV){
            if(emp instanceof GiamDoc){
                String id = emp.getMaSo();
                String fullname = emp.getHoTen();
                String phone = emp.getSoDienThoai();
                int workDays = emp.getSoNgayLam();
                double dailyWage = emp.getLuongMotNgay();
                double share = ((GiamDoc) emp).getPhanTramCoPhan();
                double salary = emp.tinhLuong();

                System.out.printf("ID: %-10s Full name: %-20s Phone: %-15s Working days: %-10d Daily wage: %-10.1f share: %-10.1f Salary: %-10.1f\n",
                        id, fullname, phone, workDays, dailyWage, share, salary);
            }
        }

    }
}
