package com.ll.programmers.level0.p120906;

public class Main {
    public static void main(String[] args) {
    }
}

class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = n + "";
        for(int i = 0; i < s.length(); i++) {
            answer += Character.getNumericValue(s.charAt(i));
        }
        return answer;
    }
}