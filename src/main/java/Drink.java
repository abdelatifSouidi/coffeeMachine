import java.util.HashMap;

public enum Drink {

    TEA('T'),

    COFFEE('C'),

    CHOCOLATE('H');

    char code;

    Drink(char code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return  String.valueOf(code);
    }
}