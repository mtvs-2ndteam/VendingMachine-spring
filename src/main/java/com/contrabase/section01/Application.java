package com.contrabase.section01;

import com.contrabase.common.PurchaseSolution;
import com.contrabase.common.VendingMachineResult;

public class Application {
    public static void main(String[] args) {
        int money=2000;
        int sequence= 1;

        PurchaseSolution purchaseSolution = new PurchaseSolution();
        VendingMachineResult vendingMachineResult = new VendingMachineResult();

        purchaseSolution.card(sequence,money,"card");
        vendingMachineResult.allResultProduce();
    }
}
