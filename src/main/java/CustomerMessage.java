import java.util.EnumMap;

public class CustomerMessage {

    private StringBuilder message;
    EnumMap<Drink,String> drinks;

    public void initDrinks(){
        drinks = new EnumMap<>(Drink.class);
        drinks.put(Drink.TEA,"tea");
        drinks.put(Drink.CHOCOLATE,"chocolate");
        drinks.put(Drink.COFFEE,"coffee");
    }

    public String displayCustomerMessage(Order order){
        message = new StringBuilder();
        if(order.message != null)
            return message.append("Drink maker forwards any message received")
                    .append(" onto the coffee machine interface")
                    .append(" for the customer to see")
                    .toString();

        initDrinks();
        message.append("Drink maker makes 1 ")
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
