package controller;

import io.ReadAndWrite;
import models.Product;
import soft.SoftByPriceAscending;
import soft.SoftByPriceDescending;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    File file = new File("C:\\Users\\admin\\Desktop\\casestudy\\src\\filetext\\product.txt");

    File file1 = new File("C:\\Users\\admin\\Desktop\\casestudy\\src\\filetext\\giohang.txt");

    File fileTurnover=new File("C:\\Users\\admin\\Desktop\\casestudy\\src\\filetext\\turnover.txt");
    ReadAndWrite<Product> readAndWrite = new ReadAndWrite<>();
    ArrayList<Product> products = readAndWrite.read(file);
    ArrayList<Product> cart = readAndWrite.read(file1);

    ArrayList<Product> turnover = readAndWrite.read(fileTurnover);
    Scanner scanner = new Scanner(System.in);

    public void show() {
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }

    public void add(Product product) {
        products.add(product);

        readAndWrite.write(file, products);
    }

    public int findIndexById(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public Product create() {
        int id;
        int index;
        while (true) {
            System.out.println(">Nhập id :");
            id = Integer.parseInt(scanner.nextLine());
            index = findIndexById(id);
            if (index == -1) {
                break;
            }
            System.err.println("Nhập trùng id rồi.");
        }
        System.out.println(">Nhập name");
        String name = scanner.nextLine();
        System.out.println(">Nhập price");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println(">Nhập số lượng sản phẩm:");
        int amount = Integer.parseInt(scanner.nextLine());
        return new Product(id, name, price,amount);
    }
    public  Product create1(){
        System.out.println(">Nhập id :");
        int   id = Integer.parseInt(scanner.nextLine());
        System.out.println(">Nhập name :");
        String name = scanner.nextLine();
        System.out.println(">Nhập price :");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println(">Nhập số lượng sản phẩm :");
        int amount = Integer.parseInt(scanner.nextLine());
        return new Product(id, name, price,amount);
    }

    public void edit() {
        int id;
        int index;
        while (true){
            System.out.println(">Nhập id :");
            id = Integer.parseInt(scanner.nextLine());
            index = findIndexById(id);
            if (index != -1) {
                products.set(index, create1());
                System.out.println("Sửa thành công");
                break;
            }else {
                System.err.println("Không tìm thấy id sản phẩm ");
            }
        }

    }

    public  void delete(){
        int id;
        int index;
        while (true){
            System.out.println(">Nhập id sản phẩm muốn xóa");
            id = Integer.parseInt(scanner.nextLine());
            index = findIndexById(id);
            if (index != -1){
                products.remove(index);
                System.out.println(">Xóa thành công ");
                break;
            }else{
                System.err.println("Không có id sản phẩm cần xóa!");
            }
        }
        readAndWrite.write(file,products);


    }

    public double money() {
        turnover = readAndWrite.read(fileTurnover);
        System.out.println("Lịch sử bán hàng : ");
        for (int i = 0; i < turnover.size(); i++) {
            System.out.println(turnover.get(i).toString());
        }
        double doanhthu=0.0;;
        for (int i = 0 ;i<turnover.size();i++){
            doanhthu+=turnover.get(i).getPrice();
        }
        System.out.println("Doanh thu là :" +doanhthu);
        return doanhthu;
    }


    public void buyProduct() {
        show();
        System.out.println(">Nhập tên sản phẩm muốn thêm vào giỏ hàng :");
        String name = scanner.nextLine();
        int choice = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                cart.add(products.get(i));
                turnover.add(products.get(i));
                products.remove(i);
                System.out.println("Thêm sản phẩm thành công");
                ++choice;
                break;
            }
        }if (choice==0){
            System.err.println("Sản phẩm không tồn tại!");
        }
        readAndWrite.write(fileTurnover,turnover);
        readAndWrite.write(file1, cart);
    }

    public void editProduct() {
        showProduct();
        System.out.println(">Nhập tên sản phẩm muốn xóa khỏi giỏ hàng :");
        String name = scanner.nextLine();
        int choice = 0 ;
        for (int i = 0; i < cart.size()+1; i++) {
            if (cart.get(i).getName().equals(name)) {
                System.out.print("Xác nhận xóa sản phẩm : ");
                System.out.print(" Y/N");
                String x = scanner.nextLine();
                if (x.equalsIgnoreCase("Y")){
                    cart.remove(i);
                    turnover.remove(i);
                    System.out.println("Xóa sản phẩm thành công");
                    ++choice;
                    break;
                }
            }
        }if(choice == 0){
            System.err.println("Sản phẩm không tồn tại!");
        }
        readAndWrite.write(fileTurnover,turnover);
        readAndWrite.write(file1, cart);
    }

//    public void  show1(){
//        for (int i = 0; i < products.size(); i++) {
//            System.out.println(products.get(i).toString());
//        }
//    }


    public void showProduct() {
        for (int i = 0; i < cart.size(); i++) {
            System.out.println(cart.get(i).toString());
        }
        System.out.println("Tổng tiền giỏ hàng :"+ allmoney());
    }

    public double allmoney() {
        int tongTien = 0;

        for (int i = 0; i < cart.size(); i++) {
            tongTien += cart.get(i).getPrice();
        }
        return tongTien;
    }

    public void pay(){
        System.out.println("Bạn có muốn mua hàng không ?");
        System.out.println("Y/N");
        String x = scanner.nextLine();
        if (x.equalsIgnoreCase("Y")){
        System.out.println("Thanh toán thành công !");
        }
        cart = new ArrayList<>();
        readAndWrite.write(file1,cart);
    }
    public void sortProductsByPriceAscending(){
        products.sort(new SoftByPriceAscending());
        System.out.println("Sắp xếp tăng dần thành công ");
        readAndWrite.write(file,products);
    }

    public void sortProductsByPriceDescending() {
        products.sort(new SoftByPriceDescending());
        System.out.println("Sắp xếp giảm dần thành công");
        readAndWrite.write(file,products);
    }

}

