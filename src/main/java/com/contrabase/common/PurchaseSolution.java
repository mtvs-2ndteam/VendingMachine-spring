package com.contrabase.common;

import com.contrabase.section01.ContextConfigration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

public class PurchaseSolution {
    CoffeeDAO coffeeDAO=new CoffeeDAO();
    public Coffee card(int sequence,int money,String purchase){
        return coffeeDAO.buyCoffee(sequence,money,purchase);
    }
}
