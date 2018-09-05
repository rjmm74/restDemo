package com.robert.millar.hebDemo.model;

import java.util.Date;

public class Inventory {
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getLastSold() {
        return lastSold;
    }

    public void setLastSold(Date lastSold) {
        this.lastSold = lastSold;
    }

    public String getShelfLife() {
        return shelfLife;
    }

    public void setShelfLife(String shelfLife) {
        this.shelfLife = shelfLife;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getxFor() {
        return xFor;
    }

    public void setxFor(int xFor) {
        this.xFor = xFor;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public Inventory(Integer id, String description, Date lastSold, String shelfLife, String department, double price ,
                     String unit, int xFor, double cost
                     ) {
        super();
        this.id = id;
        this.description = description;
        this .lastSold = lastSold;
        this.shelfLife =  shelfLife;
        this.department = department;
        this.price = price;
        this.unit = unit;
        this.xFor = xFor;
        this.cost = cost;
    }

    public Inventory() {
        super();
    }
    private Integer id;
    String description;
    Date lastSold;
    String shelfLife;
    String department;
    double price;
    String unit;
    int xFor;
    double cost;


    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", lastSold=" + lastSold +
                ", ShelfLife='" + shelfLife + '\'' +
                ", department='" + department + '\'' +
                ", price=" + price +
                ", unit='" + unit + '\'' +
                ", xFor=" + xFor +
                ", cost=" + cost +
                '}';
    }
}
