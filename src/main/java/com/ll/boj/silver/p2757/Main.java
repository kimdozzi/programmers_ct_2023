package com.ll.boj.silver.p2757;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder ans = new StringBuilder();
    public static void main(String[] args) throws Exception {
        while (true) {
            st = new StringTokenizer(br.readLine(), "C");
            String R = st.nextToken().substring(1);
            int C = Integer.parseInt(st.nextToken());

            if (R.equals("0") && C == 0) break;
            StringBuilder sb = new StringBuilder();
            while (C > 0) {
                C--;
                //System.out.println('A' + C % 26);
                sb.append((char)('A' + C % 26));
                C /= 26;
            }
            ans.append(sb.reverse()).append(R).append('\n');
        }
        System.out.print(ans);
    }
}