package controller;

import io.ReadAndWrite;
import models.Account;
import validate.ValidateAccount;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerAccount {
    File file = new File("C:\\Users\\admin\\Desktop\\casestudy\\src\\filetext\\account.txt");
    ReadAndWrite<Account> readAndWrite = new ReadAndWrite<>();
    //Tạo list đọc dữ liệu trong file
    ArrayList<Account> accounts =readAndWrite.read(file);
    Scanner scanner = new Scanner(System.in);
    ValidateAccount validateAccount = new ValidateAccount();

    public Account login(){
        String username = validateAccount.UserName();
        String password = validateAccount.PassWord();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                return accounts.get(i);
            }
        }
        return null;
    }
    public Account register() {
        String username;
        while (true) {
            username = validateAccount.UserName();
            if (checkUserName(username)) {
                break;
            }
            System.out.println("Trùng username rồi");
        }
        String password = validateAccount.PassWord();
        String name = validateAccount.Name();
        String age = validateAccount.Age();
        String gender = validateAccount.gender();
        String phoneNumber = validateAccount.PhoneNumber();
        String address = validateAccount.Address();
        System.out.println("Nhập role");
        String role = scanner.nextLine();
        return new Account(username,password,name,age,gender,phoneNumber,address,role);

    }

    public boolean checkUserName(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }

    public void addAccount(Account account){
        accounts.add(account);
        readAndWrite.write(file,accounts);

    }

    public  void showAccount(){
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i).toString());
        }
    }

    public void editAccount() {
        String Name;
        int index;
        while (true){
            System.out.println("Nhập username người dùng :");
            Name = scanner.nextLine();
            index = Integer.parseInt(findIndexByName(Name));
            if (index != -1) {
                accounts.set(index,register());
                System.err.println("Sửa thành công");
                break;
            }else {
                System.err.println("Không tìm thấy tên tài khoản ");
            }
        }
    }

    public void deleteAccount() {
        String name;
        int index;
        while (true){
            System.out.println("Nhập tên người dùng muốn xóa :");
            name = scanner.nextLine();
            index = Integer.parseInt(findIndexByName(name));
            if(index != -1){
                accounts.remove(index);
                System.err.println("Xóa thành công !!!");
                break;
            }else {
                System.err.println("Không tìm thấy tài khoản");
            }
        }
    }

    public String findIndexByName(String Name){
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(Name)) {
                return String.valueOf(i);
            }
        }
        return String.valueOf(-1);
    }
}

