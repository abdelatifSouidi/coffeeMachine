package com.domain.Management;

import com.domain.Drink;

public class BeverageQuantityCheckerImpl  implements BeverageQuantityChecker{

    public boolean hasEmptyStock(Drink drink) {
        return drink.getStock() > 0? isEmpty(null) :isEmpty(String.valueOf(drink.getCode()));
    }

    @Override
    public boolean isEmpty(String drink) {
        return drink != null;
    }
}
