package com.ll.SWEA.p2072;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int ans = 0;
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 10; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 != 0) ans += num;
            }
            System.out.printf("#%d %d\n",i+1,ans);
        }
    }
}
