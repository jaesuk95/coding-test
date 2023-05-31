package com.example.greedy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class GreedyApplication {

    public static void main(String[] args) {
        int[] coins = {500,100,50,10,1};
        int amount = 876;

        List<Integer> changes = makeChanges(amount, coins);
        System.out.println("Change for " + amount + " cents: " + changes);
    }

    public static List<Integer> makeChanges(int amount, int[] coins) {
        List<Integer> change = new ArrayList<>();

        // sorting the coins array in descending order
        java.util.Arrays.sort(coins);
        int index = coins.length - 1;

        while (amount > 0 && index >= 0) {
            if (coins[index] <= amount) {
                change.add(coins[index]);
                amount -= coins[index];
            } else {
                index--;
            }
        }
        if (amount > 0) {
            throw new RuntimeException("Cannot make exact change");
        }
        return change;

    }

}
