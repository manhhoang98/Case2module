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
    ArrayList<Account> accounts =readAndWrite.read(file);
    Scanner scanner = new Scanner(System.in);
    ValidateAccount validateAccount = new ValidateAccount();
    Account admin = new Account("manh08112003","Manh@1234","mạnh","18","Male","0357061291","BacGiang","admin");

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
        return new Account(username,password,name,age,gender,phoneNumber,address,"user");

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
        accounts.add(admin);
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
                System.err.print("Xác nhận xóa tài khoản :");
                System.err.println("Y/N");
                String x = scanner.nextLine();
                if (x.equalsIgnoreCase("Y")){
                    accounts.remove(index);
                    System.out.println("Xóa thành công !!!");
                }
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

