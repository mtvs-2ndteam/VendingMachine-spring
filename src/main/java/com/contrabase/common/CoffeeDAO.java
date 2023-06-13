package com.contrabase.common;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class CoffeeDAO {
    private final Map<Integer, Coffee> coffeeMap;

    public CoffeeDAO() {
        this.coffeeMap = new HashMap<>();

        this.coffeeMap.put(1, new Coffee(1, "레쓰비", 500));
        this.coffeeMap.put(2, new Coffee(2, "크래프트", 2500));
        this.coffeeMap.put(3, new Coffee(3, "콘트라베이스", 3000));
    }

    public List<String> getCoffee(int userMoney) {
        List<String> coffeeList = new ArrayList<>();
        if (userMoney < 3000) {
            if (userMoney < 2500) {
                coffeeList.add(coffeeMap.get(1).getName());
                return coffeeList;
            }
            coffeeList.add(coffeeMap.get(1).getName());
            coffeeList.add(coffeeMap.get(2).getName());
            return coffeeList;
        }
        coffeeList.add(coffeeMap.get(1).getName());
        coffeeList.add(coffeeMap.get(2).getName());
        coffeeList.add(coffeeMap.get(3).getName());
        return coffeeList;
    }

    public String selectCoffee(int select) {
        if (select == 1) {
            return "레쓰비";
        }
        if (select == 2) {
            return "크래프트";
        }
        if (select == 3) {
            return "콘트라베이스";
        }
        return "에러"; // 예외 처리 해줘야 하는데 아직 안함
    }

}
