package com.ll.boj.silver.p8922;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] visit = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++) arr[j] = Integer.parseInt(st.nextToken());

            int count = 0, idx = 0;
            boolean flag = false;
            /* TODO */
            while (idx < 1000) {
                for(int j = 0; j < N; j++)
                    visit[j] = Math.abs(arr[j] - arr[(j+1) % N]);

                for(int j = 0; j < N; j++) {
                    arr[j] = visit[j];
                    if(arr[j] == 0) count++;
                }

                if(count == N) {
                    flag = true;
                    break;
                }
                count = 0;
                idx++;
            }
            if(flag) System.out.println("ZERO");
            else System.out.println("LOOP");
        }
    }
}
