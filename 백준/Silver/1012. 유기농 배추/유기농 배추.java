import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int T, N, M, P, cnt;
	public static int[][] farm;
	public static boolean[][] visited;
	public static int[] dx = { 0, 0, -1, 1 };
	public static int[] dy = { -1, 1, 0, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken()); // 테캐 개수

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken()); // 가로
			N = Integer.parseInt(st.nextToken()); // 세로
			P = Integer.parseInt(st.nextToken()); // 배추 위치 개수

			farm = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < P; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				farm[b][a] = 1;
			}

			cnt = 0;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (farm[i][j] == 1 && !visited[i][j] ) {
						dfs(i, j);
						cnt++;
					}
				}
			}

			System.out.println(cnt);
		} // tc

	} // main

	public static void dfs(int x, int y) {

		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}
			if (visited[nx][ny] || farm[nx][ny] == 0) {
				continue;
			}

			visited[nx][ny] = true;
			dfs(nx, ny);

		}

	}


}