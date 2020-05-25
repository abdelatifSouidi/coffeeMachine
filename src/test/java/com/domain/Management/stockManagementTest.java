package com.domain.Management;

import com.domain.CoffeeMaker;
import com.domain.CoffeeMakerDriver;
import com.domain.Drink;
import com.domain.Order;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class stockManagementTest {


    private CoffeeMaker coffeeMaker;
    private CoffeeMakerDriver coffeeMakerDriver;
    private Order orderTeaWithOneSugar ;
    private Order orderMilk ;
    private Order orderWater;


    @Before
    public void init (){
        coffeeMaker = new CoffeeMaker();
        orderTeaWithOneSugar = new Order(Drink.TEA, 1,0.4);
        orderMilk = new Order(Drink.MILK, 0.4);
        orderWater = new Order(Drink.WATER,0.2);
    }

    @Test
    public void shouldEnsureThatNoMoreMilkAndNoWaterAndEmailSent(){
        coffeeMakerDriver = new CoffeeMakerDriver(orderTeaWithOneSugar);
        assertEquals("Drink maker will make an extra hot tea with 1 sugar and a stick"
                , coffeeMaker.makeDrink(coffeeMakerDriver));
        coffeeMakerDriver = new CoffeeMakerDriver(orderMilk);
        assertEquals("Sorry, there's no more milk a notification has been sent."
                , coffeeMaker.makeDrink(coffeeMakerDriver));
        coffeeMakerDriver = new CoffeeMakerDriver(orderWater);
        assertEquals("Sorry, there's no more water a notification has been sent."
                , coffeeMaker.makeDrink(coffeeMakerDriver));
    }
}
