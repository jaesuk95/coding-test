package com.example.greedy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class GreedyApplication {

    public static void main(String[] args) throws IOException {
        Integer[] coins = {500, 100, 50, 10, 1};
        Integer amount = 876;

        List<Integer> changes = makeChanges(amount, coins);
        System.out.println("Total Amount = " + amount);
        System.out.println("changes = " + changes);
    }

    public static List<Integer> makeChanges(Integer amount, Integer[] coins) {
        List<Integer> changes = new ArrayList<>();
        Arrays.sort(coins);

        int index = coins.length - 1;

        while (amount > 0 && index >= 0) {
            if (coins[index] <= amount) {
                changes.add(coins[index]);
                amount -= coins[index];
            } else {
                index--;
            }
        }
        if (amount > 0) {
            throw new RuntimeException("Cannot make exact change");
        }
        return changes;
    }

}
