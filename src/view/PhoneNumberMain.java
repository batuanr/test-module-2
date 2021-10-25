package view;

import controller.PhoneBook;
import model.GroupType;
import model.PhoneNumber;


import java.util.List;
import java.util.Scanner;

public class PhoneNumberMain {

    Scanner s = new Scanner(System.in);
    private PhoneBook phoneBook = new PhoneBook();

    public PhoneNumber getNewNumber(){
        System.out.println("1 Nhập tên");
        String name = s.nextLine();
        System.out.println("2 Nhập giới tính");
        String gender = s.nextLine();
        System.out.println("3 Nhập nhóm");
        GroupType group = selectGroup();
        String phoneNumber = checkNumber();
        String email = checkMail();
        System.out.println("5 Nhập địa chỉ");
        String address = s.nextLine();


        return new PhoneNumber(name, gender, group, phoneNumber, address, email);
    }

    private String checkMail() {
        do {
            System.out.println(" Nhập email");
            String email = s.nextLine();
            if (phoneBook.checkEmail(email)){
                System.out.println("email ok");
                return email;
            }
            else System.out.println("Sai rồi, nhập lại");
        }while (true);
    }

    private String checkNumber() {
        do {
            System.out.println(" Nhập số điện thoại");
            String phoneNumber = s.nextLine();
            if (phoneBook.checkNumber(phoneNumber)){
                System.out.println("số điện thoại ok");
                return phoneNumber;
            }
            else System.out.println("Sai rồi, nhập lại");
        }while (true);
    }

    public GroupType selectGroup(){
        System.out.println("1 Nhóm công ty");
        System.out.println("2 nhóm gia đình");
        System.out.println("3 nhóm bạn bè");
        System.out.println("4 nhóm khác");
        String choice = s.nextLine();
        switch (choice){
            case "1": return GroupType.company;
            case "2": return GroupType.family;
            case "3": return GroupType.friend;
            default: return GroupType.other;
        }
    }
    public void delete(){
        PhoneNumber phoneNUmber = phoneBook.find(checkNumber());
        if (phoneNUmber != null){
            phoneBook.delete(phoneNUmber);
        }
        else System.out.println("Số không tồn tại");


    }
    public void edit(){
        PhoneNumber phoneNUmber = phoneBook.find(checkNumber());
        if (phoneNUmber != null){
            phoneBook.edit(checkNumber(), getNewNumber());
        }
        else System.out.println("số không tồn tại");
    }
    public void writeFile(){
        System.out.println("chắc chứ");
        System.out.println("chọn Y để tiếp tục");
        String choice = s.nextLine();
        if (choice.equals("Y")){
            phoneBook.writeFile();
        }
    }
    public void showPhoneNumber(){
        List<PhoneNumber> phoneNumberList = phoneBook.getPhoneNUmberList();
        for (PhoneNumber phoneNumber: phoneNumberList){
            System.out.println(phoneNumber);
        }
    }
    public void find(){
        PhoneNumber phoneNUmber = phoneBook.find(checkNumber());
        if (phoneNUmber != null){
            System.out.println(phoneNUmber);
        }
        else System.out.println("số không tồn tại");
    }
    public void addPhoneNumber(){
        phoneBook.add(getNewNumber());
    }
}
