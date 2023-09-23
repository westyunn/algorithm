import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static Stack<Integer> stack = new Stack<>();
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static int[] degree;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		degree = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			degree[b]++;
		}

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				dfs(i);
			}
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop() + " ");
		}

	}

	public static void dfs(int idx) {
		visited[idx] = true;

		for (int v : graph.get(idx)) {
			if (!visited[v]) {
				dfs(v);
			}
		}
		stack.add(idx);
	}

}