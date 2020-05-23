import java.util.EnumMap;

public class Order {

    private int numberOfSugar;
    private String stick;
    private Drink drink;
    public String message;

    public Order (String message){
        this.message= message;
    }

    public Order (Drink drink){
        this.drink= drink;
        stick="";
    }

    public Order(Drink drink, int numberOfSugar) {
        this.drink= drink;
        this.numberOfSugar = numberOfSugar;
        stick = numberOfSugar > 0 ? "0" : "";
    }


    public String translateToCoffeeMaker() {
        StringBuilder Instruction = new StringBuilder();
        if(message != null)
            return "M:"+ message;
        Instruction.append(drink)
                .append(":");
        if(numberOfSugar > 0)
            Instruction.append(numberOfSugar);
        Instruction.append(":").append(stick);

        return Instruction.toString();
    }

    public int getNumberOfSugar() {
        return numberOfSugar;
    }

    public Drink getDrink() {
        return drink;
    }
}
