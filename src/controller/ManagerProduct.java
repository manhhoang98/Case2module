package controller;

import io.ReadAndWrite;
import models.MotelRoom;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagerMotelRoom {
    File file = new File("C:\\Users\\admin\\Desktop\\casestudy\\src\\filetext\\product.txt");
    ReadAndWrite<MotelRoom> readAndWrite = new ReadAndWrite<>();
    ArrayList<MotelRoom> motelRooms = readAndWrite.read(file);
    Scanner scanner = new Scanner(System.in);

    public void show() {
        for (int i = 0; i < motelRooms.size(); i++) {
            System.out.println(motelRooms.get(i).toString());
        }
    }

    public void add(MotelRoom motelRoom) {
        motelRooms.add(motelRoom);
        readAndWrite.write(file, motelRooms);
    }

    public int findIndexById(int id) {
        for (int i = 0; i < motelRooms.size(); i++) {
            if (motelRooms.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public MotelRoom create() {
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
        return new MotelRoom(id, name, price);
    }

    public void edit() {
        System.out.println("Nhập id :");
        int id = Integer.parseInt(scanner.nextLine());
        int index = findIndexById(id);
        if (index != -1) {
            motelRooms.set(index, create());
        }
    }

    public  void delete(){
        int id;
        int index;
        while (true){
            System.out.println("Nhập id phòng muốn xóa");
            id = Integer.parseInt(scanner.nextLine());
            index = findIndexById(id);
            if (index != -1){
                motelRooms.remove(index);
                System.out.println("Xóa thành công ");
                break;
            }else{
                System.out.println("Không có id phòng cần xóa");
            }
        }
        readAndWrite.write(file,motelRooms);


    }

    public void money() {
    }


    public void turnover() {
    }
}

