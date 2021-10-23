import SinhVien.*;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.lang.NumberFormatException;


public class Main {
    static Scanner sc = new Scanner(System.in);
    static LinkedList<sinhvien> listSV = new LinkedList<sinhvien>();
    // Variable using for check student exist or not 
    static boolean isHasStudent = false;

    
    public static void main(String argv[]) {
        loadData();
        int choice = 0;
        boolean isLoop = true;
        try{
            while (isLoop) {
            System.out.println("");
            System.out.println("-----------------MENU QUAN LY SINH VIEN-----------------");
            System.out.println("1. Them sinh vien");
            System.out.println("2. Xoa sinh vien");
            System.out.println("3. Sua sinh vien");
            System.out.println("4. Nhap diem cho sinh vien");
            System.out.println("5. Xem thong tin va diem cua sinh vien");
            System.out.println("6. Xuat ra danh dach sinh vien (theo mssv tang dan)");
            System.out.println("7. Tim kiem sinh vien theo MSSV, ten sinh vien");
            System.out.println("8. In ra danh sach sinh vien (dang phat trien)");
            System.out.println("9. Thoat va save");
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
                    isExist = searchSutdent();
                    checkExistStudent(isExist);
                    break;
                case 8: //code 
                    inUpdate();
                    break;
                case 9: //code 
                    isLoop = false;
                    saveData();
                    break;
                default://code
                    System.out.println("Lua chon cua ban khong hop le! Vui long chon lai");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Chuong trinh bi loi, tu dong dung ...");
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
        System.out.print("> Nhap MSSV de xem thong tin: ");
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
        System.out.println("Danh sach co "+ sinhvien.getTotal() +" sinh vien: ");
        listSV.forEach(item -> {
            item.showInList();
        });
    }

    public static boolean searchSutdent(){
        System.out.print("> Nhap MSSV hoac ten de xem thong tin: ");
        String input = sc.nextLine();
        int mssv=0;
        boolean isMssv = true;
        try{
            mssv = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            isMssv = false;
            input.toLowerCase();
        }
        if (isMssv) {
            //Neu la mssv
            if (mssv < 1 || mssv > sinhvien.getTotal()) {
                return false;
            }
            for (sinhvien sv:listSV) {
                if (sv.getMssv() == mssv) {
                    isHasStudent = true;
                    sv.showInformation();
                }
            }
        }
        else { 
            for (sinhvien sv : listSV) {
                if (sv.getName().toLowerCase().contains(input)) {
                    isHasStudent = true;
                    sv.showInformation();
                }
            }
        }

        if (isHasStudent) {
            isHasStudent = false;
            return true;
        }
        return false;
    }

    public static void checkExistStudent(boolean isHasStudent) {
        if (!isHasStudent) {
            System.out.println("Sinh vien khong ton tai!");
        }
    }

    public static void inUpdate() {
        System.out.println("Chuc nang nay dang duoc phat trien!");
    }

    public static void loadData() {
        String path = "data.txt";
        File myFile = new File(path);
        try {
            Scanner myReader = new Scanner(myFile);
            String mydata;
            String[] myDataArr;

            while (myReader.hasNextLine()) {
                mydata = myReader.nextLine();
                myDataArr = mydata.split(",", -2);
                int mssv = Integer.parseInt(myDataArr[0]);
                if (myDataArr.length == 5) {
                    listSV.add(new sinhvien(mssv, myDataArr[1], myDataArr[2], myDataArr[3], myDataArr[4]));
                } else if (myDataArr.length == 8) {
                    float toan = Float.parseFloat(myDataArr[5]);
                    float hoa = Float.parseFloat(myDataArr[6]);
                    float ly = Float.parseFloat(myDataArr[7]);
                    listSV.add(
                            new sinhvien(mssv, myDataArr[1], myDataArr[2], myDataArr[3], myDataArr[4], toan, hoa, ly));
                }
            }
            myReader.close();
        } catch (FileNotFoundException e) {

        } catch (NumberFormatException e) {
            System.out.println("Loi doc file!");
        }
    }
    
    public static void saveData() {
        String path = "data.txt";
        File myFile = new File(path);
        try {
            
            if (!myFile.exists()) {
                myFile.createNewFile();
            }
            if (myFile.exists()) {
                FileWriter writer = new FileWriter(myFile);
                // writer.write("\n");
                listSV.forEach(item -> {
                    if (item.getisSet()) {
                        try{
                            writer.write(item.getMssv() + "," + item.getName() + "," + item.getPhone() + ","
                                    + item.getLop() + "," + item.getKhoa() + "," + item.getDiemToan() + ","
                                    + item.getDiemHoa() + "," + item.getDiemLy() + "\n");
                        } catch (IOException e) {
                            System.out.println("Khong the ghi du lieu, loi: "+e.getMessage());
                        }
                    }
                    else {
                        try {
                            writer.write(item.getMssv() + "," + item.getName() + "," + item.getPhone() + ","
                                    + item.getLop() + "," + item.getKhoa() + "\n");
                        } catch (IOException e) {
                            System.out.println("Khong the ghi du lieu, loi: " + e.getMessage());
                        }
                    }
                });
                writer.close();
            }
        } catch (IOException e) {
            System.out.println("Khong the tao file, loi: " + e.getMessage());
        }
    }
}
