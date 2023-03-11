package com.ll.boj.silver.p23351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N,K,A,B;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        Arrays.fill(arr, K);

        int idx = 0, days = 0;
        boolean flag = false;
        while (!flag) {
            days++;
            for(int i = idx; i < idx + A; i++) {
                arr[i % N] += B;
            }
            idx+=A;
            for(int i = 0; i < N; i++) {
                arr[i]--;
                if(arr[i] == 0) {
                    flag = true;
                    break;
                }
            }
        }
        System.out.println(days);
    }
}
