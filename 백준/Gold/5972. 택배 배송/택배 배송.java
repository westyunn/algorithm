import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
    int v;
    int w;
    Edge(int v, int w) {
        this.v = v;
        this.w = w;
    }
}
public class Main {
    static int V, E;
    static ArrayList<Edge>[] graph;
    static int[] dist;
    static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점 수
        E = Integer.parseInt(st.nextToken()); // 간선 수

        graph = new ArrayList[V+1];
        for(int i=0; i<=V; i++) {
            graph[i] = new ArrayList<>(); // 그래프 초기화
        }

        dist = new int [V+1];
        Arrays.fill(dist, INF);

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph[to].add(new Edge(from, weight)); // 양방향
            graph[from].add(new Edge(to, weight));
        }
        dijkstra(1);
        System.out.println(dist[V]);

    }

    public static void dijkstra (int start) {
        boolean[] visited = new boolean[V+1];
        dist[start] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new Edge(start, 0));

        while(!pq.isEmpty()) {
            Edge current = pq.poll();
            int idx = current.v;

            if(visited[idx]) {
                continue;
            }
            visited[idx] = true;

            for(Edge e: graph[idx]) {
                if(dist[e.v] > dist[idx] + e.w) {
                    dist[e.v] = dist[idx] + e.w;
                    pq.add(new Edge(e.v, dist[e.v]));
                }
            }


        }
    }
}