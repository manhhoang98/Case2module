package view;

import controller.ManagerAccount;
import controller.ManagerProduct;
import models.Account;
import models.Product;

import java.util.Scanner;

public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    Scanner scanner = new Scanner(System.in);
    ManagerAccount managerAccount = new ManagerAccount();

    Account account = new Account();
    ManagerProduct managerProduct = new ManagerProduct();

    public void menu() {
        while (true) {
            System.out.println(ANSI_GREEN+"");
            System.out.println("╔===========================╗\n" +
                               "║    Chào mừng Admin Mạnh   ║\n" +
                               "╠===========================╣\n" +
                               "║>[1]. Quản lí Account      ║\n" +
                               "║>[2]. Quản lí bán hàng     ║\n" +
                               "║>[3]. Đăng xuất            ║\n" +
                               "╚===========================╝");
            System.out.println(""+ANSI_RESET);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuAccount();
                    break;
                case 2:
                    menuProduct();
                    break;
                case 3:
                    menuLogin();
                    break;
            }

        }
    }

    public void menuLogin() {
        while (true) {
            System.out.println(ANSI_CYAN + "");
            System.out.println("╔==================================╗\n" +
                               "║    Chào mừng đến với ManhMart    ║\n" +
                               "╠==================================╣\n" +
                               "║>[1]. Đăng nhập                   ║\n" +
                               "║>[2]. Đăng kí                     ║\n" +
                               "║>[3]. Thoát                       ║\n" +
                               "╚==================================╝");
            System.out.println("" + ANSI_RESET);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Account account = managerAccount.login();
                    if (account != null && account.getRole().equals("admin")) {
                        menu();
                    }else {
                        MenuUser();
                    }
                    break;
                case 2:
                    Account account1 = managerAccount.register();
                    managerAccount.addAccount(account1);
                    break;
                case 3:
                    return;
            }
        }
    }
    public void menuAccount() {
        while (true) {
            System.out.println(ANSI_PURPLE);
            System.out.println("╔=================================╗\n" +
                               "║        Quản lí người dùng       ║\n" +
                               "╠=================================╣\n" +
                               "║>[1]. Hiển thị toàn bộ Account   ║\n" +
                               "║>[2]. Sửa Account theo tên       ║\n" +
                               "║>[3]. Xóa Account theo tên       ║\n" +
                               "║>[4]. Back                       ║\n" +
                               "╚=================================╝");
            System.out.println(ANSI_RESET);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerAccount.showAccount();
                    break;
                case 2:
                    managerAccount.editAccount();
                    break;
                case 3:
                    managerAccount.deleteAccount();
                    break;
                case 4:
                    menu();
                    break;

            }


        }
    }

    public void menuProduct() {
        while (true) {
            System.out.println(ANSI_PURPLE);
            System.out.println("╔====================================╗\n" +
                               "║       Menu quản lí sản phẩm        ║\n" +
                               "╠====================================╣\n" +
                               "║>[1]. Hiển thị toàn phẩm            ║\n" +
                               "║>[2]. Thêm sản phẩm                 ║\n" +
                               "║>[3]. Sửa sản phẩm theo id          ║\n" +
                               "║>[4]. Xóa sản phẩm theo id          ║\n" +
                               "║>[5]. Hiển thị danh sách account    ║\n" +
                               "║>[6]. Back                          ║\n" +
                               "╚====================================╝");
            System.out.println(ANSI_RESET);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerProduct.show();
                    break;
                case 2:
                    Product product = managerProduct.create();
                    managerProduct.add(product);
                    break;
                case 3:
                    managerProduct.edit();
                    break;
                case 4:
                    managerProduct.delete();
                    break;
                case 5:
                    managerProduct.money();
                case 6:
                    menu();
            }
        }
    }
//Menu mua hàng
    public void MenuUser() {
        while (true) {
            System.out.println(ANSI_YELLOW);
            System.out.println("╔===================================╗\n" +
                               "║          Menu khách hàng          ║\n" +
                               "╠===================================╣\n" +
                               "║>[1]. Hiển thị toàn bộ sản phẩm    ║\n" +
                               "║>[2]. Xem giỏ hàng và tổng tiền    ║\n" +
                               "║>[3]. Sửa sản phẩm trong giỏ hàng  ║\n" +
                               "║>[4]. Thêm sản phẩm vào giỏ hàng   ║\n" +
                               "║>[5]. Thanh toán                   ║\n" +
                               "║>[6]. Đăng xuất                    ║\n" +
                               "╚===================================╝");
            System.out.println(ANSI_RESET);
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    managerProduct.show();
                    break;
                case 2:
                    managerProduct.showProduct();
                    break;
                case 3:
                    managerProduct.editProduct();
                    break;
                case 4:
                    managerProduct.buyProduct();
                    break;
                case 5:
                    managerProduct.pay();
                    break;
                case 6:
                    menuLogin();
                    break;

            }
        }
    }
}