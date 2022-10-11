package view;

import controller.ManagerAccount;
import models.Account;

import java.util.Scanner;

public class MenuLogin {
    Scanner scanner = new Scanner(System.in);
    ManagerAccount managerAccount = new ManagerAccount();
    MenuProduct menuProduct = new MenuProduct();
    Account account = new Account();

    public void menu() {
        while (true) {
            System.out.println("Chào mừng admin " + account.getName());
            System.out.println("1. Quản lí account ");
            System.out.println("2. Quản lí bán hàng");
            System.out.println("3. Đăng xuất");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    menuProduct.menuAccount();
                    break;
                case 2:
                    menuProduct.menuProduct();
                    break;
                case 3:
                    menuLogin();
                    break;
            }

        }
    }

    public void menuLogin() {
        while (true) {
            System.out.println("===========================================");
            System.out.println("=     Chào mừng bạn đến với chúng tôi     =");
            System.out.println("= Bấm phím 1 để đăng nhập                 =");
            System.out.println("= Bấm phím 2 để đăng kí                   =");
            System.out.println("= Thoát khỏi menu bấm phím 3              =");
            System.out.println("===========================================");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    Account account = managerAccount.login();
                    if (account != null && account.getRole().equals("admin")) {
                        menu();
                    }
                    break;
                case 2:
                    managerAccount.register();
                    break;
                case 3:
                    return;
            }
        }
    }
}