package com.ll.boj.silver.p4375;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            sb.append("1");
            int cnt = 1;
            while (true) {
                int n = sc.nextInt();
                if(Integer.parseInt(sb.toString())%n == 0) {
                    System.out.println(cnt);
                    break;
                }
                else {
                    cnt++;
                    sb.append("1");
                }
            }
        }
    }
}
