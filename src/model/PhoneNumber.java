package model;

import java.io.Serializable;

public class PhoneNumber implements Serializable {
    private String name;
    private String gender;
    private GroupType group;
    private String phoneNumber;
    private String address;
    private String email;

    public PhoneNumber() {
    }

    public PhoneNumber(String name, String gender, GroupType group, String phoneNumber, String address, String email) {
        this.name = name;
        this.gender = gender;
        this.group = group;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public GroupType getGroup() {
        return group;
    }

    public void setGroup(GroupType group) {
        this.group = group;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", group=" + group +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
