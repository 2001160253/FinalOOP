package Main;

import Entities.*;
import Services.CompanyService;
import Services.StaffService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        CompanyService companyService = new CompanyService();
        StaffService staffService = new StaffService();
        List<NhanVien> listNV = new ArrayList<>();
        listNV = staffService.createData();

        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag){
            companyService.showMenu();
            int choose = scanner.nextInt();
            scanner.nextLine();

            switch (choose){
                case 1:{
                    CongTy ct = new CongTy();
                    ct = companyService.inputComanyInfo();
                    companyService.displayCompanyInfo(ct);
                    break;
                }
                case 2:{
                    System.out.println("Phan bo nhan vien vao truong phong");
                   companyService.allocateEmployeesToDepartmentHead(listNV);
                    break;
                }
                case 3:{
                    System.out.println("\nNhap thong tin nhan vien\n");
                    List<NhanVien> newNV = new ArrayList<>();
                    newNV = companyService.inputEmployee();
                    listNV.addAll(newNV);
                    break;
                }
                case 4:{
                    System.out.println("Xoa nhan su");
                    System.out.println("Nhap id nhan vien can xoa: ");
                    String id = scanner.nextLine();
                    NhanVien nv = staffService.findAllStaff(listNV, id);
                    if(nv == null){
                        System.out.println("Khong tim thay nhan vien");
                    }
                    else if (nv instanceof NhanVienThuong){
                            companyService.removeStaff(listNV, ((NhanVienThuong)nv) );
                        System.out.println("Da xoa nhan vien thuong");
                        }
                    else if(nv instanceof  TruongPhong){
                            companyService.removeManager(listNV, ((TruongPhong) nv));
                        System.out.println("Da xoa truong phong");
                        }
                    else if(nv instanceof GiamDoc){
                            companyService.removeDirector(listNV, ((GiamDoc) nv));
                        System.out.println("Da xoa giam doc");
                        }
                    break;
                }
                case 5:{
                    System.out.println("Hien thi thong tin toan cong ty");
                    companyService.displayAllStaff(listNV);
                    break;
                }
                case 6:{
                    System.out.println("Tinh tong luong toan cong ty");
                    double sum = companyService.sumSalary(listNV);
                    System.out.println("Sum: "+sum);
                    break;
                }
                case 7:{
                    System.out.println("Nhan vien co luong cao nhat");
                    NhanVien nv = companyService.findStaffWithMaxSalary(listNV);
                    nv.xuatThongTin();
                    break;
                }
                case 8:{
                    System.out.println("Truong phong nhieu nhan vien nhat");
                    NhanVien nv = companyService.findHeadWithMostSubordinates(listNV);
                    nv.xuatThongTin();
                    break;
                }
                case 9:{
                    System.out.println("Sap xep theo abc ");
                    companyService.sortToAbc(listNV);
                    companyService.displayAllStaff(listNV);
                    break;
                }
                case 10:{
                    System.out.println("Sap xep theo luong giam dan ");
                    companyService.sortToSalary(listNV);
                    companyService.displayAllStaff(listNV);
                    break;
                }
                case 11:{
                    System.out.println("Giam doc co luong co phan cao nhat");
                    NhanVien nv = companyService.findStaffWithMaxShares(listNV);
                    nv.xuatThongTin();
                    break;
                }
                case 12:{
                    System.out.println("Nhap doanh thu cua cong ty: ");
                    double revenue = scanner.nextDouble();
                    scanner.nextLine();
                    double allSalary = companyService.sumSalary(listNV);
                    companyService.calculateDirectorSalary(revenue,allSalary,listNV);

                    break;
                }
                case 0:{
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Choose again! ");
                    break;
                }
            }
        }
    }
}