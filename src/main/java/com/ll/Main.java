package com.ll;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write('\n');
        bw.write("hello");
        bw.write("world");
        bw.flush();

        System.out.println(2);
        System.out.println(2);
        System.out.println(2);
        bw.close();
    }
}