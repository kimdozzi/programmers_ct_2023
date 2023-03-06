package com.ll.boj.gold.p17352;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    static boolean[] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N+1];
        graph = new List[N+1];
        for(int i=0;i<=N;i++) graph[i] = new ArrayList<>();
        if (N <= 2) {
            System.out.println("1 2");
            System.exit(0);
        }
        else {
            for (int i = 0; i < N - 2; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }
        }
    }
    static void pro() {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            for(int y : graph[x]) {
                if(visit[y]) continue;
                q.add(y);
                visit[y] = true;
            }
        }
        boolean flag = visit[1];
        for(int i = 2; i < visit.length; i++) {
            if(visit[i] != flag) {
                System.out.printf("1 %d",i);
                break;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        pro();
    }
}