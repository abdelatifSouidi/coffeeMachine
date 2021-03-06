package com.domain;

import com.domain.Management.BeverageQuantityCheckerImpl;
import com.domain.Management.EmailNotifier;
import com.domain.Management.EmailNotifierImpl;

import java.util.EnumMap;

public class CoffeeMaker {

    private StringBuilder message;
    private EnumMap<Drink,String> drinks;
    private BeverageQuantityCheckerImpl beverageQuantityChecker;
    private EmailNotifier emailNotifier;

    public CoffeeMaker() {
        initDrinks();
    }

    public void initDrinks(){
        drinks = new EnumMap<>(Drink.class);
        drinks.put(Drink.TEA,"tea");
        drinks.put(Drink.CHOCOLATE,"chocolate");
        drinks.put(Drink.COFFEE,"coffee");
        drinks.put(Drink.ORANGE_JUICE, "orange juice");
    }

    public String makeDrink(CoffeeMakerDriver coffeeMaker){
        message = new StringBuilder();
        beverageQuantityChecker = new BeverageQuantityCheckerImpl();
        Order order = coffeeMaker.getOrder();

        if(beverageQuantityChecker.hasEmptyStock(order.getDrink())){
            emailNotifier = new EmailNotifierImpl();
            emailNotifier.notifyMissingDrink(order.getDrink().toString());
            return new  StringBuilder("Sorry, there's no more ")
                    .append(order.getDrink().toString().toLowerCase())
                    .append(" a notification has been sent.").toString();
        }

        if(order.getDrink().hasNotEnoughMoney(order.getMoney()))
            return cantMakeDrink(order);

        message.append("Drink maker will make ");

        if(!order.getDrink().isHotDrink())
            return message.append("one ")
                    .append(drinks.get(order.getDrink())).toString();
        message.append("an extra hot ")
                .append(drinks.get(order.getDrink()))
                .append(" with ");

        if (order.getNumberOfSugar() > 0) {
            message.append(order.getNumberOfSugar())
                    .append(" sugar")
                    .append(order.getNumberOfSugar() > 1 ? "s" : "")
                    .append(" and a stick");
        } else {
            message.append("no sugar - and therefore no stick");
        }
        return message.toString();
    }

    private String cantMakeDrink(Order order){
            return message.append("not enough money, missing ")
                    .append(order.getDrink().price - order.getMoney())
                    .append(" euro plesae top up").toString();
    }

    public String receiveMessage() {
         message = new StringBuilder();
         message.append("Drink maker forwards any message received")
                .append(" onto the coffee machine interface")
                .append(" for the customer to see");
        return message.toString();
    }
}
