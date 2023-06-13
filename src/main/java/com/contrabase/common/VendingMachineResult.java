package com.contrabase.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class VendingMachineResult {
    static int cardAmount;
    static int moneyAmount;

    public void allResultProduce(){
        System.out.println("cardAmount = " + cardAmount);
        System.out.println("moneyAmount = " + moneyAmount);
    }
}
