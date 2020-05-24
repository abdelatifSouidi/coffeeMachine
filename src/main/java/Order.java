public class Order {

    private int numberOfSugar;
    private String stick;
    private Drink drink;
    private Double money;
    private String message;

    public Order (String message){
        this.message = message;
    }

    public Order (Drink drink, Double money){
        this.drink= drink;
        stick="";
        this.money = money;
    }

    public Order(Drink drink, int numberOfSugar, Double money) {
        this.drink= drink;
        this.numberOfSugar = numberOfSugar;
        stick = numberOfSugar > 0 ? "0" : "";
        this.money = money;
    }

    public String translateOrderToCoffeeMaker() {
        StringBuilder Instruction = new StringBuilder();

        Instruction.append(drink.code)
                .append(":");
        if(numberOfSugar > 0)
            Instruction.append(numberOfSugar);
        Instruction.append(":").append(stick);

        return Instruction.toString();
    }

    public String translateMessageToCoffeeMaker(){
        return "M:"+ message;
    }

    public int getNumberOfSugar() {
        return numberOfSugar;
    }

    public Drink getDrink() {
        return drink;
    }

    public Double getMoney() {
        return money;
    }

    public String getMessage() {
        return message;
    }
}
