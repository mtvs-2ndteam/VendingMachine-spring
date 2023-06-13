package com.contrabase.common;

import com.contrabase.section01.ContextConfigration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import java.util.HashMap;
import java.util.Map;

@Repository
public class CoffeeDAO {
    private final Map<Integer,Coffee> coffeeMap;
    VendingMachineResult vendingMachineResult=new VendingMachineResult();

    public CoffeeDAO(){
        this.coffeeMap=new HashMap<>();
        coffeeMap.put(1,new Coffee(1,"아메리카노",1500));
        coffeeMap.put(2,new Coffee(2,"에스프레소",2000));
        coffeeMap.put(3,new Coffee(3,"카페라뗴",3000));
    }

    public Coffee buyCoffee(int sequence,int money,String purchase){
        int amount=coffeeMap.get(sequence).amount;
        if (amount >= money) {
            throw new NoSearchError("잔액이 부족합니다");
        }
        switch (purchase) {
            case "card" :
                System.out.println("card");
                vendingMachineResult.cardAmount += amount;
                break;
            case "coin" :
                System.out.println("coin");
                vendingMachineResult.moneyAmount +=amount;
                break;
        }
        return coffeeMap.get(sequence);
    }
}
