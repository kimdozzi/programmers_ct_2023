package com.ll.boj.gold.p16236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Fish {
        int row;
        int col;
        int sharkSize;
        int eatenFish;
        int moveCount;
        public Fish(int _row, int _col, int _sharkSize, int _eatenFish, int _moveCount) {
            this.row = _row;
            this.col = _col;
            this.sharkSize = _sharkSize;
            this.eatenFish = _eatenFish;
            this.moveCount = _moveCount;
        }
    }
    static Fish shark;
    static List<Fish> feeds = new ArrayList<>(); // 먹이 좌표담는 리스트
    static int N, ans;
    static int[][] dir = {{-1,0}, {1,0}, {0,-1}, {0,1}};
    static int[][] grid;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static void input() throws IOException {
        N = Integer.parseInt(br.readLine());
        // visit = new boolean[N][N];
        grid = new int[N][N];

        for(int i = 0; i < N; i++) {
            String[] temp = br.readLine().split(" ");
            for(int j = 0; j < N; j++) {
                if(Integer.parseInt(temp[j]) == 9) {
                    shark = new Fish(i, j, 2, 0, 0);
                    grid[i][j] = 0;
                    continue;
                }
                if(Integer.parseInt(temp[j]) == 1) {
                    feeds.add(new Fish(i, j, 0, 0, 0));
                }
                grid[i][j] = Integer.parseInt(temp[j]);
            }
        }
    }
    static void pro() {
        // pq를 이용해 먹을 수 있는 먹이들의 위치를 저장 ! 중요
        PriorityQueue<Fish> pq = new PriorityQueue<Fish>(new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                // if 만약 서로 같은 거리라면?
                if (o1.moveCount == o2.moveCount) {

                    // if 행도 같다면 ? 왼쪽 -> 오른쪽
                    if (o1.row == o2.row)
                        return o1.col - o2.col;

                        // else 위 -> 아래 순서
                    else
                        return o1.row - o2.row;
                }

                // else 거리순으로
                else
                    return o1.moveCount - o2.moveCount;
            }
        });
        bfs(pq);
    }
    private static void bfs(PriorityQueue<Fish> pq) {
        Queue<Fish> q = new LinkedList<>();
        q.add(shark);
        while (true) {
            // 상어가 계속 움직여야하기 때문에 돌때마다 초기화.
            boolean[][] visit = new boolean[N][N];
            visit[q.peek().row][q.peek().col] = true;

            while (!q.isEmpty()) {
                Fish fish = q.poll();
                int x = fish.row;
                int y = fish.col;
                for(int i = 0; i < 4; i++) {
                    int nx = x + dir[i][0];
                    int ny = y + dir[i][1];
                    if(nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                    if(grid[nx][ny] > fish.sharkSize) continue;
                    if(visit[nx][ny]) continue;

                    if(grid[nx][ny] < fish.sharkSize && grid[nx][ny] != 0) {
                        pq.offer(new Fish(nx, ny, fish.sharkSize, fish.eatenFish+1, fish.moveCount+1));
                    }
                    q.offer(new Fish(nx, ny, fish.sharkSize, fish.eatenFish, fish.moveCount+1));
                    visit[nx][ny] = true;
                }
            }
            if(pq.isEmpty()) {
                System.out.println(ans);
                return;
            }
            else {
                Calculator(pq, q);
            }
        }
    }

    private static void Calculator(PriorityQueue<Fish> pq, Queue<Fish> q) {
        Fish tmpFish = pq.poll();
        if(tmpFish.sharkSize == tmpFish.eatenFish) {
            tmpFish.sharkSize++;
            tmpFish.eatenFish = 0;
        }
        grid[tmpFish.row][tmpFish.col] = 0;
        ans += tmpFish.moveCount;
        q.offer(new Fish(tmpFish.row, tmpFish.col, tmpFish.sharkSize, tmpFish.eatenFish, 0));
        pq.clear();
    }

    public static void main(String[] args) throws IOException{
        input();
        if(feeds.isEmpty()) System.out.println(0);
        else pro();
    }
}
