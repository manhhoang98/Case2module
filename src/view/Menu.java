package view;

import controller.ManagerAccount;
import controller.ManagerProduct;
import models.Account;
import models.Product;

import java.util.Scanner;

public class Menu {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    Scanner scanner = new Scanner(System.in);
    ManagerAccount managerAccount = new ManagerAccount();

    Account account = new Account();
    ManagerProduct managerProduct = new ManagerProduct();

    public void menu() {
        while (true) {
            System.out.println(ANSI_GREEN);
            System.out.println("╔===========================╗\n" +
                               "║    Chào mừng Admin Mạnh   ║\n" +
                               "╠===========================╣\n" +
                               "║>[1]. Quản lí Account      ║\n" +
                               "║>[2]. Quản lí bán hàng     ║\n" +
                               "║>[0]. Đăng xuất            ║\n" +
                               "╚===========================╝");
            System.out.println(ANSI_RESET);
            System.out.println("Mời bạn nhập lựa chọn :");
            int choice = -1;
            while (choice < 0 || choice > 3) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 2) {
                        System.err.println("Vui lòng chọn số từ 0-2");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Vui lòng nhập số !");
                }


            switch (choice) {
                case 1:
                    menuAccount();
                    break;
                case 2:
                    menuProduct();
                    break;
                case 0:
                    menuLogin();
                    break;
            }

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
                               "║>[0]. Thoát                       ║\n" +
                               "╚==================================╝");
            System.out.println("" + ANSI_RESET);
            System.out.println("Mời bạn nhập lựa chọn :");
            int choice = -1;
            while (choice < 0 || choice > 2) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 2) {
                        System.err.println("Vui lòng chọn số từ 0-2");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Vui lòng nhập số !");
                }
                switch (choice) {
                    case 1:
                        Account account = managerAccount.login();
                        if (account != null && account.getRole().equals("admin")) {
                            System.out.println("Đăng nhập thành công!");
                            menu();
                        } else if (account != null && account.getRole().equals("user")) {
                            MenuUser();
                        } else {
                            System.err.println("Không tìm thấy tài khoản !");
                        }
                        break;
                    case 2:
                        Account account1 = managerAccount.register();
                        managerAccount.addAccount(account1);
                        break;
                    case 0:
                        return;
                }
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
                               "║>[0]. Back                       ║\n" +
                               "╚=================================╝");
            System.out.println(ANSI_RESET);
            System.out.println("Mời bạn nhập lựa chọn :");
            int choice = -1;
            while (choice < 0 || choice > 3) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 3) {
                        System.err.println("Vui lòng chọn số từ 0-3");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Vui lòng nhập số !");
                }
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
                    case 0:
                        menu();
                        break;

                }

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
                               "║>[5]. Thống kê doanh thu            ║\n" +
                               "║>[6]. Sắp xếp sản phẩm tăng dần     ║\n" +
                               "║>[7]. Sắp xếp sản phẩm giảm dần     ║\n" +
                               "║>[0]. Back                          ║\n" +
                               "╚====================================╝");
            System.out.println(ANSI_RESET);
            System.out.println("Mời bạn nhập lựa chọn :");
            int choice = -1;
            while (choice < 0 || choice > 7) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 7) {
                        System.err.println("Vui lòng chọn số từ 0-7");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Vui lòng nhập số !");
                }
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
                        break;
                    case 6:
                        managerProduct.sortProductsByPriceAscending();
                        break;
                    case 7:
                        managerProduct.sortProductsByPriceDescending();
                        break;
                    case 0:
                        menu();
                        break;
                }
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
                               "║>[2]. Hiển thị sản phẩm tăng dần   ║\n" +
                               "║>[3]. Hiển thị sản phẩm giảm dần   ║\n" +
                               "║>[4]. Xem giỏ hàng và tổng tiền    ║\n" +
                               "║>[5]. Sửa sản phẩm trong giỏ hàng  ║\n" +
                               "║>[6]. Thêm sản phẩm vào giỏ hàng   ║\n" +
                               "║>[7]. Thanh toán                   ║\n" +
                               "║>[0]. Đăng xuất                    ║\n" +
                               "╚===================================╝");
            System.out.println(ANSI_RESET);
            System.out.println("Mời bạn nhập lựa chọn :");
            int choice = -1;
            while (choice < 0 || choice > 7) {
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    if (choice < 0 || choice > 7) {
                        System.err.println("Vui lòng chọn số từ 0-7");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Vui lòng nhập số !");
                }
                switch (choice) {
                    case 1:
                        managerProduct.show();
                        break;
                    case 2:
                        managerProduct.sortProductsByPriceAscending();
                        break;
                    case 3:
                        managerProduct.sortProductsByPriceDescending();
                        break;
                    case 4:
                        managerProduct.showProduct();
                        break;
                    case 5:
                        managerProduct.editProduct();
                        break;
                    case 6:
                        managerProduct.buyProduct();
                        break;
                    case 7:
                        managerProduct.pay();
                        break;
                    case 0:
                        menuLogin();
                        break;
                }
            }
        }
    }
}