package com.ll.boj.silver.p14671;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Pair {
        int x;
        int y;
        public Pair(int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }
    }

    static int N,M,K;
    static boolean[][] visit;
    static List<Pair> monster;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static void input() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visit = new boolean[2][2];
        monster = new ArrayList<>();
        for(int i=0;i<K;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            monster.add(new Pair(a%2,b%2));
        }
    }

    public static void main(String[] args) throws IOException{
        input();
        for(Pair pair : monster) {
            visit[pair.x % 2][pair.y % 2] = true;
        }
        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++) {
                if(!visit[i][j]) {
                    System.out.println("NO");
                    System.exit(0);
                }
            }
        }
        System.out.println("YES");
    }
}
