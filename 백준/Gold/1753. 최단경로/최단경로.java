import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node {
    int v, w;

    public Node(int v, int w) {
        this.v = v;
        this.w = w;
    }
}

public class Main {
    // 가중치가 다르기 때문에 다익스트라를 써주자 !
    static int V, E; // 정점과 간선 수
    static int start;
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<Node>[] adjList; // 인접리스트
    static int[] dist; // 최단 시간 저장 배열
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        V = Integer.parseInt(st.nextToken()); // 정점
        E = Integer.parseInt(st.nextToken()); // 간선
        start = Integer.parseInt(br.readLine()); // 시작점
        adjList = new ArrayList[V+1];
        for(int i=0; i<=V; i++) {
            adjList[i] = new ArrayList<>(); // 그래프 초기화
        }
        dist = new int [V+1];
        Arrays.fill(dist, INF);

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjList[from].add(new Node(to, weight));
        }

        dijkstra(start);
        for(int i=1; i<=V; i++) {
            if(dist[i] == INF) {
                bw.write("INF");
                bw.newLine();
            } else {
                bw.write(String.valueOf(dist[i]));
                bw.newLine();
            }
        }
        bw.flush();
        bw.close();
    }

    public static void dijkstra(int start) {
        boolean[] visited = new boolean[V+1];
        dist[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.w - o2.w);
        pq.add(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int idx = curr.v;

            if(visited[idx]) {
                continue;
            }
            visited[idx] = true;

            for(Node n: adjList[idx]) {
                if(dist[n.v] > dist[idx] + n.w) {
                    dist[n.v] = dist[idx] + n.w;
                    pq.add(new Node(n.v, dist[n.v]));
                }
            }
        }
    }
}