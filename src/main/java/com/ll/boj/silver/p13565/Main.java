package com.ll.boj.silver.p13565;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        // 첫째줄 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        // 그래프 및 방문 배열 초기화
        visit = new boolean[N][M];
        graph = new List[N];
        for(int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0;i<N;i++){
            String s = br.readLine();
            for(int j=0;j<M;j++) {
                graph[i].add(s.charAt(j)-'0');
            }
        }
        /*for(int i=0;i<N;i++){
            for(int j=0;j<M;j++) {
                System.out.print(graph[i].get(j) + " ");
            }
            System.out.println();
        }*/
    }
    static int N, M;
    static int[][] dir = {{1,0}, {-1,0}, {0,-1}, {0,1}};
    static boolean[][] visit;
    static List<Integer>[] graph;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static void rec_func(int row, int col) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(row, col));
        visit[row][col] = true;
        while (!q.isEmpty()) {
            Pair pos = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = pos.x + dir[i][0];
                int ny = pos.y + dir[i][1];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(visit[nx][ny]) continue;
                if(graph[nx].get(ny) == 1) continue;
                q.add(new Pair(nx, ny));
                visit[nx][ny] = true;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        for(int i = 0; i < M; i++) {
            if(!visit[0][i]) {
                rec_func(0, i);
            }
        }

        for(int i=0;i<M;i++) {
            if(visit[N-1][i]) {
                System.out.println("YES");
                System.exit(0);
            }
        }
        System.out.println("NO");
    }
}

class Pair {
    int x;
    int y;
    Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
