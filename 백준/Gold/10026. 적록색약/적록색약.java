import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, cnt_non, cnt;
	static char[][] area;
	static boolean[][] visited;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		area = new char[N][N];
		visited = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < N; j++) {
				area[i][j] = str.charAt(j);
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs_non(i, j);
					cnt_non++;
				}
			}
		}

		visited = new boolean[N][N]; // 다시 초기화 시켜주고 
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!visited[i][j]) {
					dfs(i, j);
					cnt++;
					
				}
			}
		}

		System.out.println(cnt_non + " " + cnt);

	} // main

	public static void dfs_non(int x, int y) {
		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= N || nx < 0 || ny >= N || ny < 0) {
				continue;
			}
			if (visited[nx][ny] || area[nx][ny] != area[x][y]) {
				continue;
			}

			visited[nx][ny] = true;
			dfs_non(nx, ny);

		}

	} // dfs_non

	public static void dfs(int x, int y) {

		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= N || nx < 0 || ny >= N || ny < 0 || visited[nx][ny]) {
				continue;
			}

			if ((area[x][y] == 'R' && area[nx][ny] == 'G') || (area[x][y] == 'G' && area[nx][ny] == 'R')) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			} else if (area[x][y] == area[nx][ny]) {
				visited[nx][ny] = true;
				dfs(nx, ny);
			}

		}

	} // dfs_non

}