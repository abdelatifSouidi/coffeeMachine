package com.domain;

public class CoffeeMakerDriver {

    private Order order;
    private String message;

    public CoffeeMakerDriver(Order order) {
        this.order = order;
    }

    public CoffeeMakerDriver(String message) {
        this.message = message;
    }

    public String send(){
        if(message !=null)
            return "M:"+ message;
        if(!order.getDrink().hasNotEnoughMoney(order.getMoney()))
            return translateOrderToCoffeeMaker();
        return "missing money";
    }



    public String translateOrderToCoffeeMaker() {
        StringBuilder Instruction = new StringBuilder();

        Instruction.append(order.getDrink().code);
        if(order.getDrink().isHotDrink())
            Instruction.append("h");
        Instruction.append(":");
        if(order.getNumberOfSugar() > 0)
            Instruction.append(order.getNumberOfSugar() );
        Instruction.append(":").append(order.getStick() );

        return Instruction.toString();
    }

    public Order getOrder() {
        return order;
    }
}
