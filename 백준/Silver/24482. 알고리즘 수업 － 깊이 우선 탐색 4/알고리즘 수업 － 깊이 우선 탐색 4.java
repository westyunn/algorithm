import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int N, M, R; // 정점 / 간선 / 시작
	static int[] visited;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		visited = new int [N+1]; // 1번부터 시작이니까 
		
		graph = new ArrayList<>();
		for(int i=0; i<N+1; i++) {
			visited[i] = -1;
			graph.add(new ArrayList<>()); // 초기화 
		}
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for(int i=1; i<graph.size(); i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());
		}
		
		visited[R] = 0;
		
		dfs(R, 0);
		
		for(int i=1; i<=N; i++) {
			sb.append(visited[i]-visited[R]+" ").append('\n');
		}
		
		System.out.println(sb);
	
 
		
	} // main 
	
	public static void dfs(int idx, int depth) {
		visited[idx] = depth;
		
		for(int x: graph.get(idx)) {
			if(visited[x] == -1) {
				dfs(x, depth+1);
			}
		}
		
	}
	
	
	
	
	
	
}