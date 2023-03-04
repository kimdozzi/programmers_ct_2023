package com.ll.boj.silver.p14926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        visit = new boolean[N][N];
        graph = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(i==j) visit[i][j] = true;
                graph[i][j] = j+1;
            }
        }
        visit[N-1][0] = true;
        visit[0][N-1] = true;
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static boolean[][] visit;
    static int[][] graph;
    static void rec_func(int x, int y) {
        visit[x][y] = true;
        visit[y][x] = true;
        System.out.print("a"+(x+1) + " ");
        for(int i=0; i<N; i++) {
            if(y==i) continue; // 자기자신이라면 continue
            if(!visit[y][i]) {
                rec_func(y,i);
            }
        }
    }
    public static void main(String[] args) throws IOException{
        input();
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(!visit[i][j]) {
                    rec_func(i,j);
                }
            }
        }
        System.out.print("a"+N+" "+"a"+1);
    }
}
