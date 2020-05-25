package com.domain;

public enum Drink {

    TEA('T',0.4,5),

    COFFEE('C',0.6,6),

    CHOCOLATE('H',0.5,7),

    ORANGE_JUICE('O',0.6,8),

    WATER('W',0.2,0),

    MILK('M',0.3,0);

    char code;
    double price;
    int stock;

    Drink(char code, Double price) {
        this.code = code;
        this.price = price;
    }

    Drink(char code, Double price,int stock) {
        this(code,price);
        this.stock = stock;
    }

    public boolean hasNotEnoughMoney(Double money) {
        return price > money;
    }

    public boolean isHotDrink() {
        return code != Drink.ORANGE_JUICE.code;
    }

    public int getStock() {
        return stock;
    }

    public char getCode() {
        return code;
    }
}