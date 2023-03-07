package com.ll.boj.silver.p12437;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int idx = 1;
        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken()), c = Integer.parseInt(st.nextToken());
            int ans = 0, tmp = 0;
            for(int j = 0; j < a; j++) {
                ans += (b + tmp) / c;
                if((b+tmp)%c!=0) {
                    ans++;
                    tmp = (b + tmp) % c;
                }
                else
                    tmp = 0;
            }
            System.out.printf("Case #%d: %d\n",idx++,ans);
        }
    }
}
