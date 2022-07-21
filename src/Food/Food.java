/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Food;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 *
 * @author Admin
 */
public class Food implements Comparable<Food>, Serializable {

    private String ID;
    private String name;
    private int weight;
    private String type;
    private String place;
    private Date expriedDate;
    private double price;

    public Food(String id) {
        this.ID = id;
    }

    public Food() {
    }

    public Food(String ID, String name, int weight, String type, String place, Date expriedDate, double price) {
        this.ID = ID;
        this.name = name;
        this.weight = weight;
        this.type = type;
        this.place = place;
        this.expriedDate = expriedDate;
        this.price = price;
    }

    public Date getExpriedDate() {
        return expriedDate;
    }

    public void setExpriedDate(Date expriedDate) {
        this.expriedDate = expriedDate;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    @Override
    public String toString() {
        return "Food{" + "ID=" + ID + ", name=" + name + ", weight=" + weight + ", type=" + type + ", place=" + place + ", expriedDate=" + expriedDate + ", price=" + price + '}';
    }

    @Override
    public int compareTo(Food o) {
        return this.ID.compareTo(o.ID);
    }

    public void output() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        String expried = formatter.format(expriedDate);
        System.out.printf("%-10s %-15s %-14d %-13s %-12s %-14s %-14f\n", ID, name, weight, type, place, expried, price);

    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
