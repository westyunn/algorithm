import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, R; // 정점 수, 간선 수, 시작 정점
	static int[] visited;
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static Queue<Integer> queue = new LinkedList<>();
	static int cnt = 1;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());

		visited = new int[N + 1];

		for (int i = 0; i <= N; i++) {
			visited[i] = 0;
			graph.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			graph.get(u).add(v);
			graph.get(v).add(u);
		}

		for (int i = 1; i < graph.size(); i++) {
			Collections.sort(graph.get(i));
		}

		bfs(R);

		for (int i = 1; i <= N; i++) {
			sb.append(visited[i] + " ");
		}
		sb.append('\n');

		System.out.println(sb);
	}

	public static void bfs(int v) {
		queue.add(v);
		visited[v] = cnt++; // 큐에 넣고 바로 방문처리 해주기
		// 큐가 공백이 아니라면 반복문 수행
		while (!queue.isEmpty()) {
			int idx = queue.poll();
			for (int i : graph.get(idx)) {
				if (visited[i] == 0) {
					queue.add(i);
					visited[i] = cnt++; // 방문처리 해주기 
				}
			}

		}

	}

}