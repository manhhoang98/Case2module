package controller;

import io.ReadAndWrite;
import models.Product;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerProduct {
    File file = new File("C:\\Users\\admin\\Desktop\\casestudy\\src\\filetext\\product.txt");

    File file1 = new File("C:\\Users\\admin\\Desktop\\casestudy\\src\\filetext\\giohang.txt");
    ReadAndWrite<Product> readAndWrite = new ReadAndWrite<>();
    ArrayList<Product> products = readAndWrite.read(file);
    ArrayList<Product> Giohang = readAndWrite.read(file1);
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
            System.out.println("Nhập id :");
            id = Integer.parseInt(scanner.nextLine());
            index = findIndexById(id);
            if (index == -1) {
                break;
            }
            System.out.println("Nhập trùng id rồi.");
        }
        System.out.println("Nhập name");
        String name = scanner.nextLine();
        System.out.println("Nhập price");
        int price = Integer.parseInt(scanner.nextLine());
        return new Product(id, name, price);
    }

    public void edit() {
        int id;
        int index;
        while (true){
            System.out.println("Nhập id :");
            id = Integer.parseInt(scanner.nextLine());
            index = findIndexById(id);
            if (index != -1) {
                products.set(index, create());
                System.out.println("Sửa thành công");
                break;
            }else {
                System.out.println("Không tìm thấy id sản phẩm ");
            }
        }

    }

    public  void delete(){
        int id;
        int index;
        while (true){
            System.out.println("Nhập id sản phẩm muốn xóa");
            id = Integer.parseInt(scanner.nextLine());
            index = findIndexById(id);
            if (index != -1){
                products.remove(index);
                System.out.println("Xóa thành công ");
                break;
            }else{
                System.err.println("Không có id sản phẩm cần xóa");
            }
        }
        readAndWrite.write(file,products);


    }

    public void money() {

    }


    public void buyProduct() {
        System.out.println("Nhập tên sản phẩm muốn thêm vào giỏ hàng :");
        String name = scanner.nextLine();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                Giohang.add(products.get(i));
                System.out.println("Thêm sản phẩm thành công");
            } else {
                System.out.println("Sản phẩm không tồn tại!");
            }
        }
        readAndWrite.write(file1,Giohang);
    }

    public void editProduct() {
        System.out.println("Nhập tên sản phẩm muốn xóa khỏi cửa hàng :");
        String name = scanner.nextLine();

        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getName().equals(name)) {
                Giohang.remove(i);
                System.out.println("Xóa sản phẩm thành công");
            } else {
                System.out.println("Sản phẩm không tồn tại!");
            }
        }
     readAndWrite.write(file1,Giohang);
    }


    public void showProduct() {
        for (int i = 0; i < Giohang.size(); i++) {
            System.out.println(Giohang.get(i).toString());
        }
        System.out.println("Tổng tiền giỏ hàng :"+ allmoney());
    }

    public double allmoney() {
        double tongTien = 0.0;

        for (int i = 0; i < Giohang.size(); i++) {
            tongTien += Giohang.get(i).getPrice();
        }
        return tongTien;
    }

    public void pay(){
        System.out.println("Bạn có muốn mua hàng không ?");
        System.out.println("Y/N");
        String x = scanner.nextLine();
        if (x.equalsIgnoreCase("Y")){
        System.err.println("Thanh toán thành công !");
        }
        Giohang = new ArrayList<>();
        readAndWrite.write(file1,Giohang);

    }

}

