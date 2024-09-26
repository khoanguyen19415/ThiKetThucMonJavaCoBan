package model;

import java.util.Objects;

/*
  Tác giả: Nguyễn Cảnh Đăng Khoa
*/
public class KhachHang {
    private String maso;
    private String hoten;
    private int loai;
    private double chisocu;
    private double chisomoi;            

    public KhachHang() {
    }

    public KhachHang(String maso) {
        this.maso = maso;
    }

    public KhachHang(String maso, String hoten, int loai, double chisocu, double chisomoi) {
        this.maso = maso;
        this.hoten = hoten;
        this.loai = loai;
        this.chisocu = chisocu;
        this.chisomoi = chisomoi;
    }
    
    public String getMaso() {
        return maso;
    }

    public void setMaso(String maso) {
        this.maso = maso;
    }

    public String getHoten() {
        return hoten;
    }

    public void setHoten(String hoten) {
        this.hoten = hoten;
    }

    public int getLoai() {
        return loai;
    }

    public void setLoai(int loai) {
        this.loai = loai;
    }

    public double getChisocu() {
        return chisocu;
    }

    public void setChisocu(double chisocu) {
        this.chisocu = chisocu;
    }

    public double getChisomoi() {
        return chisomoi;
    }

    public void setChisomoi(double chisomoi) {
        this.chisomoi = chisomoi;
    }

    //sinh viên cài đặt xử lý cho các phương thức sau    
    public double getTieuThu()
    {
       return chisomoi - chisocu;
       
    }
   
    public double getTienTra()
    {       
       return 0;
    }         
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHang other = (KhachHang) obj;
        return Objects.equals(this.maso, other.maso);
    }    
}
