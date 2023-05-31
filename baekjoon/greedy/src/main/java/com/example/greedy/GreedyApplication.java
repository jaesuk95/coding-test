package com.example.greedy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        int[] changes = new int[N]; // <- you are inserting how many arrays you are listing here
        for (int i = 0; i < N; i++) {
            changes[i] = sc.nextInt();
        }
        Arrays.sort(changes);

        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (changes[i] <= K) {
                count += (K / changes[i]);
                K = K % changes[i]; // 나머지 구하기
            }
        }

        System.out.println("count = " + count);
    }

    // N = Number of coin types
    // K = total outcome of coins for valuation
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int N = sc.nextInt();
//        System.out.println("N = " + N);
//        int K = sc.nextInt();
//        System.out.println("K = " + K);
//
//        int[] changes = new int[N];
//        for (int i = 0; i < N; i++) {
//            int each_coin = sc.nextInt();
//            changes[i] = each_coin;
//        }
//
//        Arrays.sort(changes);
//
//        int count = 0;
//        for (int i = N - 1; i >= 0; i--) {
//            if (K >= changes[i]) {
//                count += (K / changes[i]);
//                K = K % changes[i];
//            }
//        }
//
//        System.out.println("count = " + count);
//    }



}
