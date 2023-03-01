package com.ll.boj.silver.p2644;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    private static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken()); Y = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        visit = new int[N+1];
        Arrays.fill(visit, -1);
        graph = new List[N+1];

        // Graph 초기화
        for (int i = 0; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 값 입력
        for(int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }
    }
    static int N,M,X,Y;
    static int[] visit;
    static List<Integer>[] graph;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    private static void rec_func(int start, int depth) {
        visit[start] = depth;
        for(int node : graph[start]) {
            if(visit[node] == -1) {
                rec_func(node, depth+1);
            }
        }

    }
    public static void main(String[] args) throws IOException{
        input();
        rec_func(X, 0); // 시작노드, 깊이(촌수)
        System.out.println(visit[Y]);
    }
}
