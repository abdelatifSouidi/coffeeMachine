import java.util.EnumMap;

public class CustomerMessage {

    private StringBuilder message;
    private EnumMap<Drink,String> drinks;

    public void initDrinks(){
        drinks = new EnumMap<>(Drink.class);
        drinks.put(Drink.TEA,"tea");
        drinks.put(Drink.CHOCOLATE,"chocolate");
        drinks.put(Drink.COFFEE,"coffee");
        drinks.put(Drink.ORANGE_JUICE, "orange juice");
    }

    public String displayCustomerMessage(Order order){
        message = new StringBuilder();
        if(order.getMessage() != null)
            return message.append("Drink maker forwards any message received")
                    .append(" onto the coffee machine interface")
                    .append(" for the customer to see")
                    .toString();

        if(order.getDrink().hasNotEnoughMoney(order.getMoney()))
            return message.append("not enough money, missing ")
                          .append(order.getDrink().price - order.getMoney())
                          .append(" euro plesae top up").toString();

        initDrinks();
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
}
