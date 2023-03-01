package com.ll.CodeUp.p3004;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /* 시간초과
        int n = sc.nextInt();
        int[] arr = new int[n];
        Arrays.fill(arr,-1);
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < n; i++)
            list.add(sc.nextInt());

        List<Integer> res = new ArrayList<>(list);
        Collections.sort(list);

        for(int i = 0; i < list.size(); i++)
            arr[i] = list.indexOf(res.get(i));

        System.out.println();
        for(int num : arr)
            System.out.print(num + " ");
            */

        int count = sc.nextInt();

        List<NoData> noDatum = new ArrayList<>();
        for(int i = 0; i < count; i++) {
            int id = 0;
            int no = sc.nextInt();

            noDatum.add(new NoData(id, no));
        }
        List<NoData> result = noDatum.stream()
                .sorted(Comparator.comparing(NoData::getNo))
                .collect(Collectors.toList());


        for(int i = 0; i < result.size(); i++) {
            result.get(i).setId(i);
        }

        String ans = noDatum
                .stream()
                .map(e -> e.getId() + "")
                .collect(Collectors.joining(" "));
        System.out.println(ans);

        sc.close();
    }
}
class NoData {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public NoData(int id, int no) {
        this.id = id;
        this.no = no;
    }

    private int id;
    private int no;

    @Override
    public String toString() {
        return "NoData{" +
                "id=" + id +
                ", no=" + no +
                '}';
    }
}


