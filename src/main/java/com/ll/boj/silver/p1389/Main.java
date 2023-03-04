package com.ll.boj.silver.p1389;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    public static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new List[N];
        total = new int[N];
        Arrays.fill(total, 0);
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken()) - 1;
            int v = Integer.parseInt(st.nextToken()) - 1;
            graph[u].add(v);
            graph[v].add(u);
        }
    }

    static int N, M;
    static int[] visit;
    static List<Integer>[] graph;

    static int[] total;

    public static void rec_func(int start, int count) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(start, count));
        visit[start] = count;
        while (!q.isEmpty()) {
            Pair x = q.poll();
            for (int node : graph[x.A]) {
                if (visit[node] == -1) {
                    visit[node] = x.Count + 1;
                    q.add(new Pair(node, x.Count + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        input();
        for (int i = 0; i < N; i++) {
            visit = new int[N];
            Arrays.fill(visit, -1);
            rec_func(i, 0);
            int res = 0;
            for (int j = 0; j < N; j++) {
                res += visit[j];
            }
            total[i] = res;
        }

        int mn = Integer.MAX_VALUE;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if (mn > total[i]) {
                mn = Math.min(mn, total[i]);
                ans = i;
            }
        }
        System.out.println(ans + 1);
    }
}

class Pair {
    int A;
    int Count;

    public Pair(int A, int Count) {
        this.A = A;
        this.Count = Count;
    }
}