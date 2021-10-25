package SinhVien;


public class sinhvien {
    private static int id = 0;
    private int mssv;
    private String name;
    private String phone;
    private String lop;
    private String khoa;
    private static String noihoc = "DHSG";
    private float diemToan;
    private float diemHoa;
    private float diemLy;
    
    //Boolean for check is set diem 
    private boolean isSetToan = false;
    private boolean isSetLy = false;
    private boolean isSetHoa = false;
    private boolean isSet = false;

    private void checkState() {
        if (isSetToan && isSetLy && isSetHoa) {
            isSet = true;
        } else {
            isSet = false;
        }
    }

    public boolean getisSet() {
        return this.isSet;
    }

    public sinhvien() {
        this.mssv = ++id;
    }

    public sinhvien(String name, String phone, String lop, String khoa, float diemToan, float diemHoa, float diemLy) {
        this.mssv = ++id;
        setInfo(name, phone, lop, khoa);
        setPoint(diemToan, diemHoa, diemLy);
    }

    public sinhvien(String name, String phone, String lop, String khoa) {
        this.mssv = ++id;
        setInfo(name, phone, lop, khoa);
    }
    
    public sinhvien(int mssv, String name, String phone, String lop, String khoa) {
        setMssv(mssv);
        setInfo(name, phone, lop, khoa);
    }
    
    public sinhvien(int mssv,String name, String phone, String lop, String khoa, float diemToan, float diemHoa, float diemLy) {
        setMssv(mssv);
        setInfo(name, phone, lop, khoa);
        setPoint(diemToan, diemHoa,diemLy);
    }

    public static int getTotal() {
        return sinhvien.id;
    }

    public void setMssv(int mssv) {
        if (mssv > 0) {
            this.mssv = mssv;
            id = mssv;
        }
    }

    public int getMssv() {
        return this.mssv;
    }

    public void setInfo(String name, String phone, String lop, String khoa) {
        setName(name);
        setPhone(phone);
        setLop(lop);
        setKhoa(khoa);
    }

    public void setPoint(float diemToan,float diemHoa,float diemLy){
        setDiemToan(diemToan);
        setDiemLy(diemLy);
        setDiemHoa(diemHoa);
    }

    public void setName(String name) {
        if (name != "")
            this.name = name;
        else this.name = "Chua co ten";

    }

    public String getName() {
        return this.name;
    }

    public void setPhone(String phone) {
        if (phone.length() >= 9 && phone.length() <= 11) {
            this.phone = phone;
        }
        else this.phone = "So dien thoai khong hop le";
    }

    public String getPhone() {
        return this.phone;
    }

    public void setLop(String lop) {
        if (lop.length() >= 2)
            this.lop = lop;
        else this.lop = "Trong";
    }

    public String getLop() {
        return this.lop;
    }

    public void setKhoa(String khoa) {
        if (khoa.length() >= 2)
            this.khoa = khoa;
        else this.khoa = "Trong";
    }

    public String getKhoa() {
        return this.khoa;
    }

    public void setNoiHoc(String noihoc) {
        if (khoa.length() >= 2)
            sinhvien.noihoc = noihoc;
        else
            sinhvien.noihoc = "Trong";

    }
    
    public String getNoiHoc() {
        return sinhvien.noihoc;
    }

    public void setDiemToan(float diemToan) {
        if (diemToan >= 0 && diemToan <= 10) {
            this.diemToan = diemToan;
            isSetToan = true;
            checkState();
        }     
        else this.diemToan = 0;
    }

    public float getDiemToan() {
        return this.diemToan;
    }

    public void setDiemLy(float diemLy) {
        if (diemLy >= 0 && diemLy <= 10) {
            this.diemLy = diemLy;
            isSetLy = true;
            checkState();
        }
        else this.diemLy = 0;
    }

    public float getDiemLy() {
        return this.diemLy;
    }

    public void setDiemHoa(float diemHoa) {
        if (diemHoa >= 0 && diemHoa <= 10) {
            this.diemHoa = diemHoa;
            isSetHoa = true;
            checkState();
        }    
        else this.diemHoa = 0;
    }

    public float getDiemHoa() {
        return this.diemHoa;
    }

    public float getDiemTrungBinh() {
        return (this.diemHoa + this.diemToan + this.diemLy) / 3;
    }

    public void showInformation() {
        System.out.println("MSSV: " + mssv);
        System.out.println("Ho va ten: " + name);
        System.out.println("Lop: " + lop);
        System.out.println("Khoa: " + khoa);
        System.out.println("Noi hoc: " + noihoc);
        if (isSet) {
            System.out.println("Diem toan: " + diemToan);
            System.out.println("Diem hoa: " + diemHoa);
            System.out.println("Diem ly: " + diemLy);
            System.out.println("Diem trung binh cua sinh vien: " + getDiemTrungBinh());
        } else {
            System.out.println("Sinh vien chua duoc nhap diem!");
        }

    }
    
    public void showInList() {
        // System.out.println(
        //         "MSSV: " + mssv + ", name: " + name + ", lop: " + lop + ", khoa: " + khoa + ", noi hoc: " + noihoc);
        System.out.printf("%-15d%-25s%-10s%-15s%-8.01f%-8.01f%-8.01f%-8.01f\n",this.mssv,this.name,this.lop,this.khoa,this.diemToan,this.diemLy,this.diemHoa,this.getDiemTrungBinh());
    }
}


