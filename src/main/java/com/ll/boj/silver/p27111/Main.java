package com.ll.boj.silver.p27111;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Pair {
        int x;
        int y;
        public Pair(int _x, int _y) {
            this.x=_x;
            this.y =_y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int[] visit = new int[200_001];
        Arrays.fill(visit, 0);
        List<Pair> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()),  b = Integer.parseInt(st.nextToken());
            arr.add(new Pair(a,b));
        }
        int ans = 0;
        for(Pair pair : arr) {
            if(visit[pair.x] == pair.y) {

                ans++;
                continue;
            }
            if(visit[pair.x] == 0 && pair.y == 1) {
                visit[pair.x] = 1;
            }
            else if(visit[pair.x] == 1 && pair.y == 0) {
                visit[pair.x] = 0;
            }
        }
        for(int i = 0; i < visit.length; i++) {
            if(visit[i] == 1) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
