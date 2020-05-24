public enum Drink {

    TEA('T',0.4),

    COFFEE('C',0.6),

    CHOCOLATE('H',0.5);

    char code;
    double price;

    Drink(char code, Double price) {
        this.code = code;
        this.price = price;
    }

    public boolean hasNotEnoughMoney(Double money) {
        return price > money;
    }
}