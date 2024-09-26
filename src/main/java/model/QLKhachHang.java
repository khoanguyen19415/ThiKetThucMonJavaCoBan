package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import util.FileHelper;

/*
  Tác giả: Nguyễn Cảnh Đăng Khoa
 */
public class QLKhachHang {

    private ArrayList<KhachHang> dsKhachHang;

    public QLKhachHang() {
        dsKhachHang = new ArrayList<>();
    }

    public QLKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    public ArrayList<KhachHang> getDsKhachHang() {
        return dsKhachHang;
    }

    public void setDsKhachHang(ArrayList<KhachHang> dsKhachHang) {
        this.dsKhachHang = dsKhachHang;
    }

    //sinh viên cải đặt cho các phương thức xử lý sau
    public void DocKhachHang(String filename) {

        ArrayList<String> data = FileHelper.readFileText(filename); //doc file

        dsKhachHang.clear();
        for (String item : data) {
            String[] arr = item.split(";");
            KhachHang kh = new KhachHang();
            kh.setMaso(arr[0]);
            kh.setHoten(arr[1]);
            kh.setLoai(Integer.parseInt(arr[2]));
            kh.setChisocu(Double.parseDouble(arr[3]));
            kh.setChisomoi(Double.parseDouble(arr[4]));

            dsKhachHang.add(kh);
        }
    }

    public boolean GhiHoaDon(String filename) {

        //sinh viên viết code 
        ArrayList<String> data = new ArrayList<>();
        for (KhachHang kh : dsKhachHang) {
            String info = kh.getMaso() + ";" + kh.getHoten() + ";" + kh.getChisocu() + ";" + kh.getChisomoi() + ";" + kh.getTieuThu() + ";" + kh.getTienTra();
            data.add(info);
        }
        return FileHelper.writeFileText(filename, data);
    }

    public void sapXepTheoLoaiHinh() {
        Comparator<KhachHang> cmp = (kh1, kh2) -> {
            return Double.compare(kh1.getLoai(), kh2.getLoai());
        };
        Collections.sort(dsKhachHang, cmp);
    }

    public double getTieuThuCaoNhat() {
        Comparator<KhachHang> cmp = (kh1, kh2) -> {
            return Double.compare(kh1.getTieuThu(), kh2.getTieuThu());
        };
        Collections.sort(dsKhachHang, cmp);
        return 0;
    }

    public double getTieuThuThapNhat() {

        return 0;
    }

    public double getTieuThuTrungBinh() {

        return 0;
    }
}
