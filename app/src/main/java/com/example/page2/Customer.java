package com.example.page2;

import android.graphics.drawable.Drawable;

public class Customer {
    String name;
    String phone;
    String gender;
    Drawable image;


    Customer(String name, String phone, String gender, Drawable image){
        this.name = name;
        this.phone = phone;
        this.gender = gender;
        this.image=image;
    }

    public String getName(){
        return name;
    }

    public String getGender(){
        return gender;
    }
    public Drawable getImage(){return image;}

    public String getPhone(){
        return phone;
    }

    public void setName(String Name){
        name = Name;
    }
    public void setGender(String Gender){
        gender = Gender;
    }
    public void setPhone(String Phone){
        phone = Phone;
    }
    public void setImage(Drawable Image){ image=Image;}
}