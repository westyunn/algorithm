import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int res = -1;
	static int aa, bb;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		aa = Integer.parseInt(st.nextToken());
		bb = Integer.parseInt(st.nextToken());

		M = Integer.parseInt(br.readLine());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			graph.get(b).add(a);
		}
		dfs(aa, bb, 0);
		System.out.println(res);

	}

	public static void dfs(int x, int y, int cnt) {
		visited[x] = true;

		for (int idx : graph.get(x)) {
			if (!visited[idx]) {
				if (idx == bb) {
					res = cnt + 1;
					return;
				}
				dfs(idx, y, cnt + 1);
			}
		}
	}

}