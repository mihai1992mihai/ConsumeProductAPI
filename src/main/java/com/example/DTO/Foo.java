package com.example.DTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Foo {

    private ArrayList<Customer> customers;
    private Meta meta;

    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }



    public List<Customer> getConsumers() {
        return customers;
    }

    public void setConsumers(ArrayList<Customer> customers) {
        this.customers = customers;
    }


    @Override
    public String toString() {
        return "Foo{" +
                "customers=" + customers +
                ", meta=" + meta +
                '}';
    }
}
