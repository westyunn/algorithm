import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	public static Queue<Integer> queue = new LinkedList<>();
	public static int[] degree, ans;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}

		degree = new int[N + 1];
		ans = new int[N + 1];

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph.get(a).add(b);
			degree[b]++;
		}

		for (int i = 1; i <= N; i++) {
			if (degree[i] == 0) {
				queue.add(i);
				ans[i] = 1; // 1학기부터 시작 
			}
		}

		while (!queue.isEmpty()) {
			int idx = queue.poll();

			for (int v : graph.get(idx)) {
				degree[v]--;
				if (degree[v] == 0) {
					queue.add(v);
					ans[v] = ans[idx] + 1; // 1은 진입차수 0이라 바로 1-> 1은 진입차수 1-1 0돼서 1+1...
				}
			}

		} // while
		for (int i = 1; i <= N; i++) {
			sb.append(ans[i] + " ");
		}
		System.out.println(sb);

	}
}