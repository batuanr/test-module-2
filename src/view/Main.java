package view;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static PhoneNumberMain phoneNumberMain = new PhoneNumberMain();
    public static void main(String[] args) {
        run();
    }
    public static void run(){
        while (true){
            System.out.println("1 xem danh sách");
            System.out.println("2 thêm mới");
            System.out.println("3 cập nhập");
            System.out.println("4 xóa");
            System.out.println("5 tìm kiếm");
            System.out.println("6 lưu file");
            System.out.println("0 exit");
            System.out.println();
            System.out.println();
            int choice = scanner.nextInt();
            switch (choice){
                case 1: phoneNumberMain.showPhoneNumber();
                break;
                case 2: phoneNumberMain.addPhoneNumber();
                break;
                case 3: phoneNumberMain.edit();
                break;
                case 4: phoneNumberMain.delete();
                break;
                case 5: phoneNumberMain.find();
                break;
                case 6: phoneNumberMain.writeFile();
                break;
                case 0: return;
            }
        }
    }
}
