package com.ll.boj.silver.p4963;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] dir = {{-1,-1}, {-1,0}, {-1,1},{0,-1},{0,0},{0,1},{1,-1},{1,0},{1,1}};
    static List<Integer>[] grid;
    static boolean[][] visit;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        while(true) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if(x == 0 && y == 0) break;
            int ans = 0;
            grid = new List[x];
            for(int i = 0; i < x; i++) grid[i] = new ArrayList<>();
            visit = new boolean[x][y];

            for(int i = 0; i < x; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < y; j++) {
                    grid[i].add(Integer.parseInt(st.nextToken()));
                }
            }
            for(int i = 0; i < x; i++) {
                for(int j = 0; j < y; j++) {
                    if(grid[i].get(j) == 1 && !visit[i][j]) {

                        rec_func(x,y,i,j);
                        ans++;
                    }
                }
            }
            System.out.println(ans);
        }
    }

    private static void rec_func(int N, int M, int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        visit[x][y] = true;
        q.add(new Pair(x,y));
        while (!q.isEmpty()) {
            Pair pair = q.poll();
            for (int i = 0; i < 9; i++) {
                int nx = pair.x + dir[i][0];
                int ny = pair.y + dir[i][1];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visit[nx][ny]) continue;
                if(grid[nx].get(ny) == 1) {
                    q.add(new Pair(nx, ny));
                    visit[nx][ny] = true;
                }
            }
        }
    }
    static class Pair{
        int x;
        int y;
        public Pair(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }
}
