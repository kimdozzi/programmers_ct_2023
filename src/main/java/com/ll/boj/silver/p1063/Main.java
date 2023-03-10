package com.ll.boj.silver.p1063;
import java.io.*;

public class Main {
    static int[][] map = new int[8][8];
    static int king_x, king_y, stone_x, stone_y, n;
    static int[] dx = {0, 0, 1, -1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static final int R = 0, L = 1, B = 3, T = 2, RT = 6, LT = 7, RB = 4, LB = 5;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        king_x = input[0].charAt(1)-'0'-1;
        king_y = input[0].charAt(0)-'A';
        stone_x = input[1].charAt(1)-'0'-1;
        stone_y = input[1].charAt(0)-'A';
        n = Integer.parseInt(input[2]);

        map[king_x][king_y] = 1;
        map[stone_x][stone_y] = 2;

        input = new String[n];
        for(int i=0;i<n;i++){
            input[i] = br.readLine();
        }

        int state = 0;
        for(int i=0;i<n;i++){
            if(input[i].equals("R")) state = R;
            else if(input[i].equals("L")) state = L;
            else if(input[i].equals("B")) state = B;
            else if(input[i].equals("T")) state = T;
            else if(input[i].equals("RT")) state = RT;
            else if(input[i].equals("LT")) state = LT;
            else if(input[i].equals("RB")) state = RB;
            else if(input[i].equals("LB")) state = LB;

            int king_nextX = king_x + dx[state];
            int king_nextY = king_y + dy[state];
            int stone_nextX = 0;
            int stone_nextY = 0;
            if(king_nextX < 0 || 8<= king_nextX || king_nextY < 0 || 8<=king_nextY) continue;

            if(king_nextX==stone_x && king_nextY==stone_y){
                stone_nextX = stone_x + dx[state];
                stone_nextY = stone_y + dy[state];

                if(stone_nextX < 0 || 8<= stone_nextX || stone_nextY < 0 || 8<=stone_nextY) continue;

                map[stone_x][stone_y] = 0;
                map[stone_nextX][stone_nextY] = 2;
                stone_x = stone_nextX;
                stone_y = stone_nextY;

                map[king_x][king_y] = 0;
                map[king_nextX][king_nextY] = 1;
                king_x = king_nextX;
                king_y = king_nextY;
            }
            else{
                map[king_x][king_y] = 0;
                map[king_nextX][king_nextY] = 1;
                king_x = king_nextX;
                king_y = king_nextY;
            }
        }

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(map[i][j]==1){
                    king_x = i+1;
                    king_y = j;
                }
                if(map[i][j]==2){
                    stone_x = i+1;
                    stone_y = j;
                }
            }
        }

        String line = ""+(char)(king_y+'A');
        System.out.println(line+String.valueOf(king_x));
        line =  ""+(char)(stone_y+'A');
        System.out.println(line+Integer.toString(stone_x));
    }

}