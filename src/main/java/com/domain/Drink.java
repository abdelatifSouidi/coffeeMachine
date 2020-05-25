package com.domain;

public enum Drink {

    TEA('T',0.4),

    COFFEE('C',0.6),

    CHOCOLATE('H',0.5),

    ORANGE_JUICE('O',0.6);

    char code;
    double price;

    Drink(char code, Double price) {
        this.code = code;
        this.price = price;
    }

    public boolean hasNotEnoughMoney(Double money) {
        return price > money;
    }

    public boolean isHotDrink() {
        return code != Drink.ORANGE_JUICE.code;
    }
}