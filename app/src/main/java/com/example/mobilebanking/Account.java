package com.example.mobilebanking;

public class Account {
    private int Id;
    private String Fullname;
    private String Passport_num;
    private String Email;
    private String Password;
    private double Money;

    public Account(int id, String fullname, String passport_num, String email, String password, double money) {
        Id = id;
        Fullname = fullname;
        Passport_num = passport_num;
        Email = email;
        Password = password;
        Money = money;
    }

    public Account(String fullname, String passport_num, String email, String password, double money) {
        Fullname = fullname;
        Passport_num = passport_num;
        Email = email;
        Password = password;
        Money = money;
    }


    public Account(String fullname, String passport_num, String email, String password) {
        Fullname = fullname;
        Passport_num = passport_num;
        Email = email;
        Password = password;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public String getPassport_num() {
        return Passport_num;
    }

    public void setPassport_num(String passport_num) {
        Passport_num = passport_num;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public double getMoney() {
        return Money;
    }

    public void setMoney(double money) {
        Money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "Id=" + Id +
                ", Fullname='" + Fullname + '\'' +
                ", Passport_num='" + Passport_num + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
