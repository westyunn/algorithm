import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] pipe;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 집의 크기

		pipe = new int[N + 1][N + 1]; // 1부터 시작 !

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				pipe[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// pipe의 끝점을 봐야하니까 (1, 2)에서 시작해서 끝점이 (N, N)이 되는 순간을 카운트 해야함
		if (pipe[N][N] != 1) {
			dfs(1, 2, 1);
		}
		System.out.println(cnt);

	} // main

	public static void dfs(int x, int y, int dir) {
		// 기저 조건
		if (x == N && y == N) {
			cnt++;
			return;
		}

		// dir 1: 가로, dir 2: 세로, dir3: 대각선 ㄱㄱ
		// 기본적으로 집을 벗어나지 말아야 함!!!!!!!
		if (dir == 1) {
			if (y + 1 <= N && pipe[x][y + 1] == 0) { // 가로->가로로 갈 때 다음에 갈 곳이 0이면 탐색 가능
				dfs(x, y + 1, 1);
			}
			if (x + 1 <= N && y + 1 <= N && pipe[x + 1][y + 1] == 0 && pipe[x][y+1] == 0 && pipe[x+1][y] == 0) { // 가로->대각선으로 갈 경우
				dfs(x + 1, y + 1, 3);
			}
		}
		else if (dir == 2) { // 세로일 경우
			if (x + 1 <= N && pipe[x + 1][y] == 0) { // 세로->세로
				dfs(x + 1, y, 2);
			}
			if (x + 1 <= N && y + 1 <= N && pipe[x + 1][y + 1] == 0 && pipe[x][y+1] == 0 && pipe[x+1][y] == 0) { // 세로->대각선
				dfs(x + 1, y + 1, 3);
			}
		} else if (dir == 3) { // 대각선일 경우
			if (y + 1 <= N && x <= N && pipe[x][y + 1] == 0) { // 대각선->가로
				dfs(x, y + 1, 1);
			}
			if (x + 1 <= N && y <= N && pipe[x + 1][y] == 0) { // 대각선->세로
				dfs(x + 1, y, 2);
			}
			if (x + 1 <= N && y + 1 <= N && pipe[x + 1][y + 1] == 0&& pipe[x][y+1] == 0 && pipe[x+1][y] == 0) { // 대각선->대각선
				dfs(x + 1, y + 1, 3);
			}
		}

	}

}