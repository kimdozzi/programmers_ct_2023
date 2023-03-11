package com.ll.boj.silver.p4375;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int num = 0;
            int n = sc.nextInt();
            for(int i = 1; ; i++) {
                num = num * 10 + 1;
                num = num % n;
                if(num == 0) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
