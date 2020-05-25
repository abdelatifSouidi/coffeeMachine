package com.domain;

public class Order {

    private int numberOfSugar;
    private String stick;
    private Drink drink;
    private Double money;

    public Order (Drink drink, Double money){
        this.drink= drink;
        stick="";
        this.money = money;
    }

    public Order(Drink drink, int numberOfSugar, Double money) {
        this.drink= drink;
        this.numberOfSugar = numberOfSugar;
        stick = numberOfSugar > 0 ? "0" : "";
        this.money = money;
    }

    public int getNumberOfSugar() {
        return numberOfSugar;
    }

    public Drink getDrink() {
        return drink;
    }

    public Double getMoney() {
        return money;
    }

    public String getStick() {
        return stick;
    }
}
