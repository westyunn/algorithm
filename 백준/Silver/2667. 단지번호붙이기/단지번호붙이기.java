import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static int N, result, cnt;
	static int[][] vil;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static ArrayList<Integer> list = new ArrayList<>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		vil = new int[N][N];
		visited = new boolean[N][N];
		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				vil[i][j] = str.charAt(j) - '0';
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (vil[i][j] == 1 && !visited[i][j]) {
					result = 0; // 단지 별로 초기화 
					dfs(i, j);
					cnt++;
					list.add(result);
				}
			}
		}

		System.out.println(cnt);
		Collections.sort(list);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	} // main

	public static void dfs(int x, int y) {
		visited[x][y] = true;
		result++;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}
			if (visited[nx][ny] || vil[nx][ny] == 0) {
				continue;
			}
			visited[nx][ny] = true;
			dfs(nx, ny);
		}

	}

}