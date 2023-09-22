import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int V, E, R, d; // 정점 개수, 간선 개수, 시작
	public static long sum;
	public static int cnt = 1;
	public static int[] visited, depth;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static Queue<Integer> queue = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		visited = new int [V+1];
		depth = new int [V+1];
		
		for(int i=0; i<=V;i ++) {
			graph.add(new ArrayList<>());
			depth[i] = -1;
		}
		
		for(int i=0; i<E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u); // 양방향 간선
		}
		
		for(int i=1; i<graph.size(); i++) {
			Collections.sort(graph.get(i));		
		}
		depth[R] = 0;
		bfs(R);
		for(int i=1; i<=V; i++) {
			sum += (long) visited[i] * depth[i];
		}
		sb.append(sum);

		System.out.println(sb);
		
		
	} // main
	
	public static void bfs(int idx) {
		// 큐에 먼저 넣어주고 
		queue.add(idx);
		visited[idx] = cnt++;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			for(int v: graph.get(x)) {
				if(visited[v] == 0) {
					queue.add(v);
					visited[v] = cnt++;
					depth[v] = depth[x]+1;
				}
			}
		}
		
	}
	
	

}