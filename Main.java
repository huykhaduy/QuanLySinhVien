import SinhVien.*;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    static LinkedList<sinhvien> listSV = new LinkedList<sinhvien>();
    // Variable using for check student exist or not 
    static boolean isHasStudent = false; 

    public static void main(String argv[]) {
        int choice = 0;
        boolean isLoop = true;
        while (isLoop) {
            System.out.println("");
            System.out.println("-----------------MENU QUAN LY SINH VIEN-----------------");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Xoa sinh vien");
            System.out.println("3. Sua sinh vien");
            System.out.println("4. Nhap diem cho sinh vien");
            System.out.println("5. Xem thong tin va diem cua sinh vien");
            System.out.println("6. Xuat ra danh dach sinh vien (theo mssv tang dan)");
            System.out.println("7. Tim kiem sinh vien co diem theo dieu kien (dang phat trien)");
            System.out.println("8. In ra danh sach sinh vien (dang phat trien)");
            System.out.println("9. Thoat");
            System.out.print("> Lua chon cua ban: ");
            choice = sc.nextInt();
            sc.nextLine();
            boolean isExist = false;
            switch (choice) {
            case 1: //Them sinh vien
                listSV.add(createStudent());
                break;
            case 2: // Xoa sinh vien
                isExist = removeStudent();
                checkExistStudent(isExist);
                break;
            case 3: // Thay doi thong tin
                isExist = changeSinhVien();
                checkExistStudent(isExist);
                break;
            case 4: // Them diem
                isExist = addPointSinhVien();
                checkExistStudent(isExist);
                break;
            case 5: // code
                isExist = showStudentInfo();
                checkExistStudent(isExist);
                break;
            case 6: // code
                showListOfStudent();
                break;
            case 7: // code
                inUpdate();
                break;
            case 8: //code 
                inUpdate();
                break;
            case 9: //code 
                isLoop = false;
                break;
            default://code
                System.out.println("Lua chon cua ban khong hop le! Vui long chon lai");
                break;
            }
        }
        sc.close();
    }

    public static sinhvien createStudent() {
        System.out.print("+ Nhap ho va ten sinh vien: ");
        String name = sc.nextLine();
        System.out.print("+ Nhap so dien thoai: ");
        String phone = sc.nextLine();
        System.out.print("+ Nhap lop: ");
        String lop = sc.nextLine();
        System.out.print("+ Nhap khoa: ");
        String khoa = sc.nextLine();
        sinhvien sv = new sinhvien(name, phone, lop, khoa);
        System.out.println("Them sinh vien thanh cong!");
        return sv;
    }

    public static boolean removeStudent() {
        System.out.print("> Nhap MSSV muon xoa: ");
        int pos = sc.nextInt();
        if (pos < 1 || pos > sinhvien.getTotal()) {
            return false;
        }
        listSV.forEach(item -> {
            if (item.getMssv() == pos) {
                isHasStudent = true;
                System.out.println(
                        "Ban co muon xoa sinh vien " + item.getName() + " (mssv: " + item.getMssv() + ") khong ?");
                System.out.println("1. Co");
                System.out.println("2. Khong");
                System.out.print("> Lua chon cua ban: ");
                int confirm = sc.nextInt();
                sc.nextLine();
                if (confirm == 1) {
                    if (listSV.remove(item) == true) {
                        System.out.println("Xoa thanh cong " + item.getName() + " !");
                    }
                } else {
                    System.out.println("Huy xoa thanh cong!");
                }
            }
        });
        if (isHasStudent) {
            isHasStudent = false;
            return true;
        }
        return false;
    }
    
    public static boolean changeSinhVien() {
        System.out.print("> Nhap mssv muon thay doi: ");
        int pos = sc.nextInt();

        if (pos < 1 || pos > sinhvien.getTotal()) {
            return false;
        }
        listSV.forEach(item -> {
            if (item.getMssv() == pos) {
                isHasStudent = true;
                System.out.println("Ban co muon thay doi sinh vien " + item.getName() + " (mssv: " + item.getMssv()
                        + " ) khong ?");
                System.out.println("1. Co");
                System.out.println("2. Khong");
                System.out.print("> Lua chon cua ban: ");
                int confirm = sc.nextInt();
                sc.nextLine();
                if (confirm == 1) {
                    System.out.print("+ Nhap ho va ten sinh vien: ");
                    String name = sc.nextLine();
                    System.out.print("+ Nhap so dien thoai: ");
                    String phone = sc.nextLine();
                    System.out.print("+ Nhap lop: ");
                    String lop = sc.nextLine();
                    System.out.print("+ Nhap khoa: ");
                    String khoa = sc.nextLine();
                    item.setInfo(name, phone, lop, khoa);
                    System.out.println("Thay doi thong tin sinh vien thanh cong!");
                } else {
                    System.out.println("Huy thay doi thanh cong!");
                }
            }
        });
        if (isHasStudent) {
            isHasStudent = false;
            return true;
        }
        return false;
    }
    
    public static boolean addPointSinhVien() {
        System.out.print("> Nhap mssv muon them diem: ");
        int pos = sc.nextInt();
        sc.nextLine();
        if (pos < 1 || pos > sinhvien.getTotal()) {
            return false;
        }
        listSV.forEach(item -> {
            if (item.getMssv() == pos) {
                isHasStudent = true;
                System.out.println("Sinh vien: " + item.getName() + " (mssv: " + item.getMssv() + ")");
                System.out.print("+ Nhap diem toan: ");
                int diemToan = sc.nextInt();
                System.out.print("+ Nhap diem hoa: ");
                int diemHoa = sc.nextInt();
                System.out.print("+ Nhap diem ly: ");
                int diemLy = sc.nextInt();
                sc.nextLine();
                item.setPoint(diemToan, diemHoa, diemLy);
                System.out.println("Them diem thanh cong!");
            }
        });
        if (isHasStudent) {
            isHasStudent = false;
            return true;
        }
        return false;
    }

    public static boolean showStudentInfo() {
        System.out.print("> Nhap mssv de xem thong tin: ");
        int pos = sc.nextInt();
        sc.nextLine();
        if (pos < 1 || pos > sinhvien.getTotal()) {
            return false;
        }
        listSV.forEach(item -> {
            if (item.getMssv() == pos) {
                isHasStudent = true;
                item.showInformation();
            }
        });
        if (isHasStudent) {
            isHasStudent = false;
            return true;
        }
        return false;
    }

    public static void showListOfStudent() {
        System.out.println("Danh sach sinh vien: ");
        listSV.forEach(item ->{
            item.showInList();
        });
    }

    public static void checkExistStudent(boolean isHasStudent) {
        if (!isHasStudent) {
            System.out.println("Ma so sinh vien khong ton tai!");
        }
    }

    public static void inUpdate() {
        System.out.println("Chuc nang nay dang duoc phat trien!");
    }
}
