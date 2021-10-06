package com.project.parkingtime;

public class Inst_Data {
    public String name,city,state,email;
    public int slots,price;

    public Inst_Data(){

    }

    public Inst_Data(String name, String city, String state, int slots, int price, String email)
    {
        this.name=name;
        this.city=city;
        this.state=state;
        this.slots=slots;
        this.price=price;
        this.email=email;
    }
}