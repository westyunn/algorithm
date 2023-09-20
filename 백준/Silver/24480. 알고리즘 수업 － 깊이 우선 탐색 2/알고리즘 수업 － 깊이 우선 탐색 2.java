import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, R;
	public static int[] visited;
	public static int cnt = 1;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		visited = new int[N + 1];
		graph = new ArrayList<>();

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		} // 초기화

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}
		
		for(int i=1; i<graph.size(); i++) {
			Collections.sort(graph.get(i), Collections.reverseOrder());;
		}
		
		dfs(R);
		
		for(int i=1; i<=N; i++) {
			sb.append(visited[i]+" ");
		}
		sb.append('\n');
		
		System.out.println(sb);
	}

	public static void dfs(int idx) {
		visited[idx] = cnt;
		
		for(int i: graph.get(idx)) {
			
			if(visited[i]==0) {
				cnt++;
				dfs(i);
			}
		}
		

	}

}