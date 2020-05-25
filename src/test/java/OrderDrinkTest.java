
import com.domain.CoffeeMaker;
import com.domain.CoffeeMakerDriver;
import com.domain.Drink;
import com.domain.Order;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class OrderDrinkTest {

    private CoffeeMaker coffeeMaker;
    private CoffeeMakerDriver coffeeMakerDriver;
    private Order orderTeaWithOneSugar ;
    private Order orderChocolateWithoutSugar ;
    private Order orderCoffeeWithTwoSugar ;
    private Order OrderTeaWithOneSugarAndEnoughMoney;
    private Order orderChocolateWithoutSugarAndWithoutEnoughMoney ;
    private Order orderCoffeeWithTwoSugarAndWithoutEnoughMoney ;
    private Order orderOrangeJuice ;

    @Before
    public void init (){
        coffeeMaker = new CoffeeMaker();
        orderTeaWithOneSugar = new Order(Drink.TEA, 1,0.4);
        orderChocolateWithoutSugar=new Order(Drink.CHOCOLATE,0.5);
        orderCoffeeWithTwoSugar =  new Order(Drink.COFFEE, 2,0.6);
        OrderTeaWithOneSugarAndEnoughMoney = new Order(Drink.TEA, 1,0.4);
        orderChocolateWithoutSugarAndWithoutEnoughMoney=new Order(Drink.CHOCOLATE,0.2);
        orderCoffeeWithTwoSugarAndWithoutEnoughMoney=  new Order(Drink.COFFEE,2, 0.1);
        orderOrangeJuice = new Order(Drink.ORANGE_JUICE,0.6);
    }

    @Test
    public void shouldReceiveAvailableInstructionAndSendAvailableCustomerMessage(){
        coffeeMakerDriver = new CoffeeMakerDriver(orderTeaWithOneSugar);
        assertEquals("Th:1:0",coffeeMakerDriver.send());
        assertEquals("Drink maker will make an extra hot tea with 1 sugar and a stick"
                , coffeeMaker.makeDrink(coffeeMakerDriver));
        coffeeMakerDriver = new CoffeeMakerDriver(orderChocolateWithoutSugar);
        assertEquals("Hh::",coffeeMakerDriver.send());
        assertEquals("Drink maker will make an extra hot chocolate with no sugar - and therefore no stick"
                , coffeeMaker.makeDrink(coffeeMakerDriver));
        coffeeMakerDriver = new CoffeeMakerDriver(orderCoffeeWithTwoSugar);
        assertEquals("Ch:2:0",coffeeMakerDriver.send());
        assertEquals("Drink maker will make an extra hot coffee with 2 sugars and a stick"
                , coffeeMaker.makeDrink(coffeeMakerDriver));
        coffeeMakerDriver = new CoffeeMakerDriver("coffeeMaker-content");
        assertEquals("M:coffeeMaker-content",coffeeMakerDriver.send());
        assertEquals("Drink maker forwards any message received onto the coffee machine interface for the customer to see"
                , coffeeMaker.receiveMessage());
    }

    @Test
    public void shouldMakeDrinkOnlyIfHasEnoughMoney (){
        coffeeMakerDriver = new CoffeeMakerDriver(OrderTeaWithOneSugarAndEnoughMoney);
        assertEquals("Th:1:0",coffeeMakerDriver.send());
        assertEquals("Drink maker will make an extra hot tea with 1 sugar and a stick"
                , coffeeMaker.makeDrink(coffeeMakerDriver));
        coffeeMakerDriver = new CoffeeMakerDriver(orderChocolateWithoutSugarAndWithoutEnoughMoney);
        assertEquals("missing money",coffeeMakerDriver.send());
        assertEquals("not enough money, missing 0.3 euro plesae top up"
                , coffeeMaker.makeDrink(coffeeMakerDriver));
        coffeeMakerDriver = new CoffeeMakerDriver(orderCoffeeWithTwoSugarAndWithoutEnoughMoney);
        assertEquals("missing money",coffeeMakerDriver.send());
        assertEquals("not enough money, missing 0.5 euro plesae top up"
                , coffeeMaker.makeDrink(coffeeMakerDriver));
    }

    @Test
    public void shouldMakeDrinkHotOrCold(){
        coffeeMakerDriver = new CoffeeMakerDriver(orderOrangeJuice);
        assertEquals("O::",coffeeMakerDriver.send());
        assertEquals("Drink maker will make one orange juice"
                , coffeeMaker.makeDrink(coffeeMakerDriver));
    }


}
