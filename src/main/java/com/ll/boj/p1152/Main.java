package com.ll.boj.p1152;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<>();
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            int num = sc.nextInt();
            if (num == -1) {
                System.out.println("입력을 종료합니다.");
                break;
            }
            numbers.add(num);
        }

        String str = numbers
                .stream()
                .sorted()
                .map(e -> "" + e)
                .collect(Collectors.joining(", "));
        System.out.printf("입력한 숫자(오름차순) : %s\n", str);
        System.out.println("프로그램을 종료합니다.");
    }
}
