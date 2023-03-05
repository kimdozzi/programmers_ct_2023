package com.ll.boj.gold.p14502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair {
        int x;
        int y;
        public Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }
    static int N, M;
    static int[][] dir = {{0,1}, {0,-1}, {1,0},{-1,0}}; // 상,하,좌,우 확산
    static int[][] grid;
    static int mx = Integer.MIN_VALUE;
    static boolean[][] visit;
    static List<Pair> virusPos = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); M = Integer.parseInt(st.nextToken());
        grid = new int[N][M];
        visit = new boolean[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1)
                    visit[i][j] = true; // 벽 방문처리
                else if (num == 2)
                    virusPos.add(new Pair(i,j)); // 바이러스가 위치한 좌표 저장

                grid[i][j] = num;
            }
        }
    }
    static void init(int[][] virtualGrid, boolean[][] virtualVisit, List<Pair> virtualList) {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M ; j++) {
                virtualGrid[i][j] = grid[i][j];
                virtualVisit[i][j] = visit[i][j];
            }
        }
        for(Pair pair : virusPos) {
            virtualList.add(new Pair(pair.x, pair.y));
        }
    }

    static void rec_func(int wall) {
        if(wall == 3) {
            int[][] virtualGrid = new int[N][M];
            boolean[][] virtualVisit = new boolean[N][M];
            List<Pair> virtualList = new ArrayList<>();

            // 초기화
            init(virtualGrid, virtualVisit, virtualList);
            // 바이러스 발산
            spreadVirus(virtualGrid, virtualVisit, virtualList);
            // 최대값 갱신
            mx = Math.max(mx,safety(virtualGrid));
        }
        else {
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(grid[i][j] == 2 || grid[i][j] == 1) continue;
                    if(visit[i][j]) continue;
                    grid[i][j] = 1;
                    visit[i][j] = true;
                    rec_func(wall + 1);
                    grid[i][j] = 0;
                    visit[i][j] = false;
                }
            }
        }
    }

    private static void spreadVirus(int[][] virtualGrid, boolean[][] virtualVisit, List<Pair> virtualVirusPos) {
        Queue<Pair> q = new LinkedList<>(); // 바이러스 BFS로 확산.
        for(Pair pair : virtualVirusPos) {
            q.add(new Pair(pair.x, pair.y));
            virtualVisit[pair.x][pair.y] = true;
        }
        while (!q.isEmpty()) {
            Pair tmpPair = q.poll();
            for(int i = 0; i < 4; i++) {
                int nx = tmpPair.x + dir[i][0];
                int ny = tmpPair.y + dir[i][1];
                if(nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if(virtualVisit[nx][ny]) continue;
                if(virtualGrid[nx][ny] == 1 || virtualGrid[nx][ny] == 2) continue;
                virtualGrid[nx][ny] = 2;
                virtualVisit[nx][ny] = true;
                q.add(new Pair(nx,ny));
            }
        }
    }
    private static int safety(int[][] virtualGrid) {
        int ans = 0;
        for(int i = 0; i < N; i++)
            for(int j = 0; j < M; j++)
                if(virtualGrid[i][j] == 0)
                    ans++;

        return ans;
    }
    public static void main(String[] args) throws IOException{
        input();
        rec_func(0);
        System.out.println(mx);
    }
}
