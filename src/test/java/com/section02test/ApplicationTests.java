package com.section02test;

import com.contrabase.common.CoffeeDAO;
import com.contrabase.section02.ContextConfiguration;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringJUnitConfig(classes = ContextConfiguration.class)
public class ApplicationTests {
    @Autowired
    private CoffeeDAO coffeeDAO;

    @DisplayName("CoffeeDAO 생성 테스트")
    @Test
    public void testCreateCoffeeDAO() {
        assertNotNull(coffeeDAO);
    }

    @DisplayName("2500원 미만 투입 커피 메뉴 테스트")
    @Test
    public void testOverCash() {
        int userPrice = 1000;
        String coffee = "";
        for (int i = 0; i < coffeeDAO.getCoffee(userPrice).size(); i++) {
            if (i == 0) {
                coffee = coffee + coffeeDAO.getCoffee(userPrice).get(i);
                continue;
            }
            coffee = coffee + "," + coffeeDAO.getCoffee(userPrice).get(i);
        }

        assertEquals("레쓰비", coffee);
        assertEquals("레쓰비", coffeeDAO.selectCoffee(1));
    }

    @DisplayName("3000원 미만 투입 커피 메뉴 테스트")
    @Test
    public void testOverCash2() {
        int userPrice = 2600;
        String coffee = "";
        for (int i = 0; i < coffeeDAO.getCoffee(userPrice).size(); i++) {
            if (i == 0) {
                coffee = coffee + coffeeDAO.getCoffee(userPrice).get(i);
                continue;
            }
            coffee = coffee + "," + coffeeDAO.getCoffee(userPrice).get(i);
        }

        assertEquals("레쓰비,크래프트", coffee);
        assertEquals("크래프트", coffeeDAO.selectCoffee(2));
    }

    @DisplayName("3000원 이상 투입 커피 메뉴 테스트")
    @Test
    public void testOverCash3() {
        int userPrice = 4000;
        String coffee = "";
        for (int i = 0; i < coffeeDAO.getCoffee(userPrice).size(); i++) {
            if (i == 0) {
                coffee = coffee + coffeeDAO.getCoffee(userPrice).get(i);
                continue;
            }
            coffee = coffee + "," + coffeeDAO.getCoffee(userPrice).get(i);
        }

        assertEquals("레쓰비,크래프트,콘트라베이스", coffee);
        assertEquals("콘트라베이스", coffeeDAO.selectCoffee(3));
    }

    @DisplayName("1,2,3 이외의 값 입력 시 예외 테스트")
    @Test
    public void testException() {

        assertEquals("에러", coffeeDAO.selectCoffee(4));
    }


}
