package com.ll.boj.silver.p1326;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, a, b;
    static int[] visit;
    static int[] arr;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());

        visit = new int[N];
        Arrays.fill(visit, -1);
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken()); b = Integer.parseInt(st.nextToken());

    }
    static int rec_func() {
        Queue<Integer> q = new LinkedList<>();
        q.add(a-1);
        visit[a-1] = 0;
        while (!q.isEmpty()) {
            int x = q.poll();
            for(int i = x; i < N; i += arr[x]) {
                if (visit[i] == -1) {
                    q.add(i);
                    visit[i] = visit[x] + 1;
                    if(i == b-1) return visit[i];
                }
            }
            for(int i = x; i >= 0; i -= arr[x]) {
                if (visit[i] == -1) {
                    q.add(i);
                    visit[i] = visit[x] + 1;
                    if(i == b-1) return visit[i];
                }
            }
        }
        return -1;

    }
    public static void main(String[] args) throws IOException{
        input();
        int ans = rec_func();
        System.out.println(ans);
    }
}
