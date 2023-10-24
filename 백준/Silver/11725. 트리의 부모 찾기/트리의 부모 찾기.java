import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int N;
	static int[] parent;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		parent = new int[N+1];
		visited = new boolean[N+1];
		
		for(int i=0; i<N+1; i++) {
			graph.add(new ArrayList<>());
		}
		for(int i=0; i<N-1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			graph.get(u).add(v);
			graph.get(v).add(u);
			
		}
		
		dfs(1);
		
		for(int i=2; i<parent.length; i++) {
			System.out.println(parent[i]);
		}
	}
	
	public static void dfs(int idx) {
		visited[idx] = true;
		
		for(int i: graph.get(idx)) {
			if(!visited[i]) {
				visited[i] = true;
				parent[i] = idx;
				dfs(i);
			}
		}
	}

}