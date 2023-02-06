package Models;

import Models.Products.Product;

import java.util.ArrayList;

public class Order {
    private int ID;
    private User customer;
    private ArrayList<Product> products;
    private String dateAndTime;

    public Order(User customer, ArrayList<Product> p) {
        this.customer = customer;
        this.ID = Tools.getInstance().UniqueIdGenerator();
        this.dateAndTime = Tools.getInstance().getDateAndTime();
        this.products = p;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public User getCustomer() {
        return customer;
    }

    public void setCustomer(User customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Order{" + "\n" +
                "\t"+"ID='" + ID + "'\n" +
                "\t"+"customer=" + customer.toString() + "\n" +
                "\t"+"products=" + products + "\n" +
                "\t"+"dateAndTime='" + dateAndTime + '\'' + "\n"
                +'}';
    }

    public void setDateAndTime(String dateAndTime) {
        this.dateAndTime = dateAndTime;
    }

    public String getDateAndTime() {
        return dateAndTime;
    }
}
