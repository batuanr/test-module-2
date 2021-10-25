package controller;

import model.EmailExample;
import model.NumberExample;
import model.PhoneNumber;
import storage.NumberFile;

import java.io.IOException;
import java.util.List;

public class PhoneBook {
    private NumberExample numberExample = new NumberExample();
    private EmailExample emailExample = new EmailExample();
    private NumberFile numberFile = NumberFile.getInstance();
    private List<PhoneNumber> phoneNumberList;

    public PhoneBook() {
        try {
            this.phoneNumberList = numberFile.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<PhoneNumber> getPhoneNUmberList() {
        return phoneNumberList;
    }

    public void setPhoneNUmberList(List<PhoneNumber> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }

    public void add(PhoneNumber phoneNUmber){
        phoneNumberList.add(phoneNUmber);
    }
    public void delete(PhoneNumber phoneNumber){
        phoneNumberList.remove(phoneNumber);
    }
    public PhoneNumber find(String phoneNumber){
        for (PhoneNumber phoneNUmber: phoneNumberList){
            if (phoneNUmber.getPhoneNumber().equals(phoneNumber)){
                return phoneNUmber;
            }
        }
        return null;
    }
    public void edit(String phoneNumber, PhoneNumber phoneNUmber){

    }
    public void readFile(){
        try {
            numberFile.readFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void writeFile(){
        try {
            numberFile.writeFile(phoneNumberList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public boolean checkNumber(String phoneNumber){
        return  numberExample.validate(phoneNumber);
    }
    public boolean checkEmail(String email){
        return emailExample.validate(email);
    }
}
