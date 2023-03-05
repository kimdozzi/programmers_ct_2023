package com.ll.boj.gold.p23749;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arrX = new ArrayList<>();
        List<Integer> arrO = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));
        int count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= N*2; i++) {
            String s = st.nextToken();
            if(s.equals("X")) arrX.add(i);
            //else arrO.add(i);
            else pq.add(i);
        }

        for(int i = 0; i < arrX.size(); i++) {
            if(arrX.get(i) % 2 != 0) {
                int tmp = arrX.get(i);
                //arrX.set(i, arrO.get(i));
                arrX.set(i, pq.poll());
                arrO.set(i, tmp);
                count++;
            }
        }
        /*for(int i = 0; i < 2; i++) {
            System.out.print(arrX.get(i) + " ");
        }
        System.out.println();
        for(int i = 0; i < 2; i++) {
            System.out.print(arrO.get(i) + " ");
        }*/
        System.out.println(count);
    }
}
