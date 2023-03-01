package com.ll.boj.silver.p24481;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N,M,R;
    static int[] visit;
    static List<Integer>[] graph;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException{
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        visit = new int[N+1];
        Arrays.fill(visit,-1);
        graph = new List[N+1];

        for(int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v); graph[v].add(u);
        }
        for(int i = 0; i <= N; i++) {
            graph[i].sort(Comparator.naturalOrder());
        }
    }
    static void rec_func(int start, int idx) {
        visit[start] = idx;
        for(int i = 0; i < graph[start].size(); i++) {
            if (visit[graph[start].get(i)] == -1) {
                rec_func(graph[start].get(i), idx + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        rec_func(R, 0);
        for(int i = 1; i <= N; i++) {
            System.out.println(visit[i]);
        }
    }
}
