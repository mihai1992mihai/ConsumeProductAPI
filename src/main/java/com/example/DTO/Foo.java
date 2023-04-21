package com.example.DTO;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class Foo {

    private Meta meta;
    private List<Customer> customers;


    public Meta getMeta() {
        return meta;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }



}