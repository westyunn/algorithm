import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int min = Integer.MAX_VALUE;
	static int[][] cor;
	static boolean[] visited;
	static List<Integer> start, link;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		cor = new int[N][N];

		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				cor[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 회사 정보 입력받기

		combination(0, 0);
		System.out.println(min);

	} // main

	public static void combination(int count, int idx) {
		if (count == N / 2) {
			calculate();
			return;
		}

		for (int i = idx; i < N; i++) {
			visited[i] = true;
			combination(count + 1, i + 1);
			visited[i] = false;
		}

	}

	public static void calculate() {
		start = new ArrayList<>();
		link = new ArrayList<>();

		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++) { // 블랙잭처럼 브루트포스
				if (visited[i] && visited[j]) { // i랑 j가 둘다 true면 start팀에 속하니까 
					start.add(cor[i][j] + cor[j][i]); // start팀 능력치 더해주고 
				} else if(!visited[i] && !visited[j]) { 
					link.add(cor[i][j] + cor[j][i]);
				}

			}
		}

		int diff = 0;
		int sums = 0;
		int suml = 0;

		for (int i = 0; i < start.size(); i++) {
			sums += start.get(i);
			suml += link.get(i);
		}

		diff = Math.abs(sums - suml);

		min = Math.min(diff, min);

	}

}