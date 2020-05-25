package com.domain.Management;

public class EmailNotifierImpl implements EmailNotifier {
    @Override
    public void notifyMissingDrink(String drink) {
        System.out.println(new StringBuilder("there is no more ").append(drink.toLowerCase()).append(" please order"));
    }
}
