import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R;
	static int cnt = 0;
	static long sum;
	static int[] d, visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		visited = new int[N+1];
		d = new int [N+1];
		
		for(int i=0; i<N+1; i++) {
			visited[i] = -1;
			graph.add(new ArrayList<>());
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
		dfs(R, 0);
		System.out.println(sum);
	}
	public static void dfs(int idx, int depth) {
		visited[idx] = depth;
		d[idx] = ++cnt;
		sum += (long) depth * d[idx]; // 방문 노드 * 깊이 
		for(int i: graph.get(idx)) {
			if(visited[i] == -1) {
				dfs(i, depth+1);
			}
		}
		
	}

}