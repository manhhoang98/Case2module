package view;

import javax.swing.*;

public class giaodien extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton đăngKíButton;
    private JTextField textField2;
    private JButton đăngNhậpButton;
    public giaodien(){
        this.setContentPane(panel1);
        this.setTitle("Hơn 400 vd cho ae");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        System.out.println("╔===================================================╗");
        System.out.println("║         ▂ ▃ ▅ ▆ █ HỆ THỐNG STAFF █ ▆ ▅ ▃ ▂        ║");
        System.out.println("╠===================================================╣");
        System.out.println("║>[1]. Hiển thị danh sách phòng                     ║");
        System.out.println("║>[2]. Hiển thị danh sách account                   ║");
        System.out.println("║>[3]. Tìm kiếm phòng còn trống theo giá            ║");
        System.out.println("║>[4]. Quản lý phòng                                ║");
        System.out.println("║>[5]. Hiển thị danh sách account                   ║");
        System.out.println("║>[0]. Đăng xuất                                    ║");
        System.out.println("╚===================================================╝");
    }
}
