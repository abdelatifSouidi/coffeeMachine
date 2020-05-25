package com.domain;


import java.util.LinkedHashMap;
import java.util.Map;

public class Report {

    Map<Drink,Integer> soldDrinks;
    Double totalPrice;

    public Report() {
        totalPrice =  0D;
        soldDrinks = new LinkedHashMap<>();
    }

    public String print() {
        StringBuilder soldResult = new StringBuilder();
        if(soldDrinks.size()>0){
            soldResult.append("sold ");
            soldDrinks.entrySet().stream().forEach(drink ->{
                soldResult.append(drink.getValue())
                .append(" ").append(drink.getKey())
                .append(" and ");
            });
            soldResult.append("earned ").append(String.format("%.1f", totalPrice))
                    .append(" euros");
            return soldResult.toString();
        }
        return "No drinks Sold";
    }

   public void addDrink(Drink drink) {
        if(soldDrinks.containsKey(drink)){
            soldDrinks.put(drink, soldDrinks.get(drink) + 1);
        }else {
            soldDrinks.put(drink,1);
        }
        totalPrice += drink.price;
    }
}
