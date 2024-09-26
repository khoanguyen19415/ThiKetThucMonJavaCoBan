package gui;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import model.QLKhachHang;
/*
  Tác giả: Nguyễn Cảnh Đăng Khoa
*/
public class FrmQLKhachHang extends JFrame {

    private JTable tblKhachHang;  
    private JButton btDocFile, btGhiFile;

    private DefaultTableModel model;
    private JTextField txtMax, txtMin, txtTB;
  
    private JCheckBox chkSapXep;

    private static final String FILE_NHAP = "input.txt";
    private static final String FILE_XUAT = "output.txt";

    private QLKhachHang qlkh = new QLKhachHang();

    public FrmQLKhachHang(String title) {
        super(title);
        createGUI();        
        processEvent();
        //setSize(900, 500);
        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void createGUI() {

        //tạo JTable
        String[] columnNames = {"Mã số", "Họ tên", "Loại hình", "Chỉ số cũ (kWh)", "Chỉ số mới(kWh)","Tiêu thụ(kWh)","Tiền trả(đồng)"};
        model = new DefaultTableModel(null, columnNames);
        tblKhachHang = new JTable(model);
        //tạo thành phần quản lý cuộn cho Jtable
        JScrollPane scrollTable = new JScrollPane(tblKhachHang);      
        //tạo các nút lệnh
        JPanel p1 = new JPanel();
        p1.add(btDocFile = new JButton("Nhập dữ liệu khách hàng"));
        p1.add(btGhiFile = new JButton("Xuất hóa đơn thanh toán"));

         //tạo các nút JTextField thống kê 
        JPanel p2 = new JPanel();
        p2.add(new JLabel("Mức tiêu thụ thấp nhất:"));
        p2.add(txtMin = new JTextField(10));
        
        p2.add(new JLabel("Mức tiêu thụ cao nhất:"));
        p2.add(txtMax = new JTextField(10));
        
        p2.add(new JLabel("Mức tiêu thụ trung bình:"));
        p2.add(txtTB = new JTextField(10));
        
        p2.add(chkSapXep = new JCheckBox("Sắp xếp theo loại hình"));
        //add các thành phần vào cửa sổ
        add(p1, BorderLayout.NORTH);
        add(scrollTable, BorderLayout.CENTER);
        add(p2, BorderLayout.SOUTH);
    }
     private void processEvent() {

        btDocFile.addActionListener((e) -> {

            qlkh.DocKhachHang(FILE_NHAP);
            
            loadDataToJTable();
        });
        
        chkSapXep.addItemListener((e) -> {

            if (chkSapXep.isSelected()) {
                qlkh.sapXepTheoLoaiHinh();
                loadDataToJTable();
            }
        });
        btGhiFile.addActionListener((e) -> {

            if (qlkh.GhiHoaDon(FILE_XUAT)) {
                JOptionPane.showMessageDialog(this, "Đã ghi dữ liệu thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            }else {           
                JOptionPane.showMessageDialog(this, "Đã ghi dữ liệu thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
            }
        });
    }   

    private void loadDataToJTable() {
        model.setRowCount(0);
        for (KhachHang kh : qlkh.getDsKhachHang()) {
            model.addRow(new Object[]{kh.getMaso(), kh.getHoten(),kh.getLoai() == 1 ? "Kinh doanh" : "Sinh hoạt" , kh.getChisocu(),kh.getChisomoi(),kh.getTieuThu(),kh.getTienTra()});
        }
    }
}
