
public class CoffeeMaker {

    public String sendOrder (Order order){
        if(!order.getDrink().hasNotEnoughMoney(order.getMoney()))
            return order.translateOrderToCoffeeMaker();
        return "missing money";
    }

    public String sendMessage(Order order) {
        return order.translateMessageToCoffeeMaker();
    }
}
