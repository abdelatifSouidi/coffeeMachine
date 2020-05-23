
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class OrderDrinkTest {

    Order orderTeaWithOneSugar ;
    Order orderChocolateWithoutSugar ;
    Order orderCoffeeWithTwoSugar ;
    Order orderMessage ;
    CustomerMessage message;

    @Before
    public void init (){
        orderTeaWithOneSugar = new Order(Drink.TEA, 1);
        orderChocolateWithoutSugar=new Order(Drink.CHOCOLATE);
        orderCoffeeWithTwoSugar =  new Order(Drink.COFFEE, 2);
        orderMessage = new Order("message-content");
        message = new CustomerMessage();
    }

    @Test
    public void shouldReceiveAvailableInstructionAndSendAvailableCustomerMessage(){
        assertEquals("T:1:0",orderTeaWithOneSugar.translateToCoffeeMaker());
        assertEquals("Drink maker makes 1 tea with 1 sugar and a stick"
                ,message.displayCustomerMessage(orderTeaWithOneSugar));
        assertEquals("H::",orderChocolateWithoutSugar.translateToCoffeeMaker());
        assertEquals("Drink maker makes 1 chocolate with no sugar - and therefore no stick"
                ,message.displayCustomerMessage(orderChocolateWithoutSugar));
        assertEquals("C:2:0",orderCoffeeWithTwoSugar.translateToCoffeeMaker());
        assertEquals("Drink maker makes 1 coffee with 2 sugars and a stick"
                ,message.displayCustomerMessage(orderCoffeeWithTwoSugar));
        assertEquals("M:message-content",orderMessage.translateToCoffeeMaker());
        assertEquals("Drink maker forwards any message received onto the coffee machine interface for the customer to see"
                ,message.displayCustomerMessage(orderMessage));
    }
}
