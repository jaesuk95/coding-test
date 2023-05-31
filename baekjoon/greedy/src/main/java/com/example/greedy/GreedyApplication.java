package com.example.greedy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Scanner;

@SpringBootApplication
public class GreedyApplication {
    // https://www.youtube.com/watch?v=nCcOTgrhgRU

    // N = Number of coin types
    // K = total outcome of coins for valuation
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        System.out.println("N = " + N);
        int K = sc.nextInt();
        System.out.println("K = " + K);

        int[] coins = new int[N];
        for (int i = 0; i < N; i++) {
            coins[i] = sc.nextInt();
        }
        Arrays.sort(coins);

        // 그리디 알고리즘 -> 최대한 큰 동전 먼저 사용하기
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (coins[i] <= K) {
                count += (K / coins[i]);
                K = K % coins[i];
            }
        }
        System.out.println("count = " + count);
    }


}
