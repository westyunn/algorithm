import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, V;
	public static boolean[] visited, visit;
	public static int[][] graph;
	public static int cnt = 1;
	public static Queue<Integer> queue = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new int[N + 1][N + 1];
		visited = new boolean[N + 1];
		visit = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph[u][v] = graph[v][u] = 1;
		}
		dfs(V);

		sb.append('\n');

		bfs(V);
		System.out.println(sb);

	}

	public static void dfs(int v) {
		visited[v] = true;
		sb.append(v + " ");

		for (int d = 1; d <= N; d++) {
			if (!visited[d] && graph[v][d] == 1) {
				cnt++;
				dfs(d);
			}
		}

	}

	public static void bfs(int idx) {
		queue.add(idx);
		visit[idx] = true;
		while (!queue.isEmpty()) {
			int t = queue.poll();
			sb.append(t + " ");

			for (int i = 1; i <= N; i++) {
				if (!visit[i] && graph[t][i] == 1) {
					queue.add(i);
					visit[i] = true;
				}
			}
		}
	}

}