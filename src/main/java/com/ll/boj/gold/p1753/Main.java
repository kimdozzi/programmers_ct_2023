package com.ll.boj.gold.p1753;

import java.util.*;

public class Main {
    static class Edge { // from 에서 to 정점까지의 가중치(weight)를 담는 클래스
        public int to;
        public int weight;
        public Edge(int _to, int _weight) {
            this.to = _to;
            this.weight = _weight;
        }
    }

    static class Info { // v, d 를 담는 클래스
        public int idx;
        public int dist;
        public Info(int _idx, int _dist) {
            this.idx = _idx;
            this.dist = _dist;
        }
    }
    static List<Edge>[] edges;
    static int[] dist;
    static int V, E, K;
    static Scanner sc = new Scanner(System.in);
    static void input() {
        V = sc.nextInt(); E = sc.nextInt();
        K = sc.nextInt();
        dist = new int[V+1];
        edges = new List[V+1];
        for(int i = 1; i <= V; i++) edges[i] = new ArrayList<>();
        for(int i = 1; i <= E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            edges[from].add(new Edge(to, weight));
        }
    }

    static void dijkstra(int start) {
        // 1. dist 배열 초기화 및 D[S,0] 넣기
        for(int i = 1; i <= V; i++) dist[i] = Integer.MAX_VALUE;


        // 최소 힙 생성
        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist)); // 거리(d) 순으로 정렬 최소힙

        // 시작점에 대한 정보(info)을 기록에 추가하고, 거리 배열(dist) 갱신
        pq.add(new Info(start, 0));
        dist[start] = 0;

        // 2. D가 비어있냐?
        while (!pq.isEmpty()) {

            // 3. 비어있지 않다면 min(v, d) 추출
            Info info = pq.poll();

            // 4. (v,d)가 가치가 있냐?
            if(dist[info.idx] != info.dist) continue;

            // 가치가 있다면 연결된 모든 간선들을 통해서 다른 정점들에 대한 정보 갱신
            for(Edge e : edges[info.idx]) {
                if(dist[info.idx] + e.weight >= dist[e.to]) continue;

                // 5. v, d를 통해 새로운 정보를 D에 추가
                dist[e.to] = dist[info.idx] + e.weight;
                pq.add(new Info(e.to, dist[e.to]));
            }
        }
    }
    static void pro() {
        dijkstra(K);
        for(int i = 1; i <= V; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else
                System.out.println(dist[i]);
        }
    }
    public static void main(String[] args) {
        input();
        pro();
    }
}
