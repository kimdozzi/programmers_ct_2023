package com.ll.boj.bronze.p1037;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;
        while (T-- > 0){
            int N = sc.nextInt();
            mx = Math.max(mx,N);
            mn = Math.min(mn,N);
        }
        System.out.println(mx*mn);
    }
}
