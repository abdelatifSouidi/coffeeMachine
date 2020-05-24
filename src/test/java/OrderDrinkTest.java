
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class OrderDrinkTest {

    private CustomerMessage message;
    private CoffeeMaker coffeeMaker;
    private Order orderTeaWithOneSugar ;
    private Order orderChocolateWithoutSugar ;
    private Order orderCoffeeWithTwoSugar ;
    private Order orderMessage ;
    private Order OrderTeaWithOneSugarAndEnoughMoney;
    private Order orderChocolateWithoutSugarAndWithoutEnoughMoney ;
    private Order orderCoffeeWithTwoSugarAndWithoutEnoughMoney ;
    private Order orderOrangeJuice ;

    @Before
    public void init (){
        message = new CustomerMessage();
        coffeeMaker = new CoffeeMaker();
        orderTeaWithOneSugar = new Order(Drink.TEA, 1,0.4);
        orderChocolateWithoutSugar=new Order(Drink.CHOCOLATE,0.5);
        orderCoffeeWithTwoSugar =  new Order(Drink.COFFEE, 2,0.6);
        orderMessage = new Order("message-content");
        OrderTeaWithOneSugarAndEnoughMoney = new Order(Drink.TEA, 1,0.4);
        orderChocolateWithoutSugarAndWithoutEnoughMoney=new Order(Drink.CHOCOLATE,0.2);
        orderCoffeeWithTwoSugarAndWithoutEnoughMoney=  new Order(Drink.COFFEE,2, 0.1);
        orderOrangeJuice = new Order(Drink.ORANGE_JUICE,0.6);
    }

    @Test
    public void shouldReceiveAvailableInstructionAndSendAvailableCustomerMessage(){
        assertEquals("Th:1:0",coffeeMaker.sendOrder(orderTeaWithOneSugar));
        assertEquals("Drink maker will make an extra hot tea with 1 sugar and a stick"
                ,message.displayCustomerMessage(orderTeaWithOneSugar));
        assertEquals("Hh::",coffeeMaker.sendOrder(orderChocolateWithoutSugar));
        assertEquals("Drink maker will make an extra hot chocolate with no sugar - and therefore no stick"
                ,message.displayCustomerMessage(orderChocolateWithoutSugar));
        assertEquals("Ch:2:0",coffeeMaker.sendOrder(orderCoffeeWithTwoSugar));
        assertEquals("Drink maker will make an extra hot coffee with 2 sugars and a stick"
                ,message.displayCustomerMessage(orderCoffeeWithTwoSugar));
        assertEquals("M:message-content",coffeeMaker.sendMessage(orderMessage));
        assertEquals("Drink maker forwards any message received onto the coffee machine interface for the customer to see"
                ,message.displayCustomerMessage(orderMessage));
    }

    @Test
    public void shouldMakeDrinkOnlyIfHasEnoughMoney (){
        assertEquals("Th:1:0",coffeeMaker.sendOrder(OrderTeaWithOneSugarAndEnoughMoney));
        assertEquals("Drink maker will make an extra hot tea with 1 sugar and a stick"
                ,message.displayCustomerMessage(orderTeaWithOneSugar));
        assertEquals("missing money",coffeeMaker.sendOrder(orderChocolateWithoutSugarAndWithoutEnoughMoney));
        assertEquals("not enough money, missing 0.3 euro plesae top up"
                ,message.displayCustomerMessage(orderChocolateWithoutSugarAndWithoutEnoughMoney));;
        assertEquals("missing money",coffeeMaker.sendOrder(orderCoffeeWithTwoSugarAndWithoutEnoughMoney));
        assertEquals("not enough money, missing 0.5 euro plesae top up"
                ,message.displayCustomerMessage(orderCoffeeWithTwoSugarAndWithoutEnoughMoney));
    }

    @Test
    public void shouldMakeDrinkHotOrCold(){
        assertEquals("O::",coffeeMaker.sendOrder(orderOrangeJuice));
        assertEquals("Drink maker will make one orange juice"
                ,message.displayCustomerMessage(orderOrangeJuice));
    }
}
