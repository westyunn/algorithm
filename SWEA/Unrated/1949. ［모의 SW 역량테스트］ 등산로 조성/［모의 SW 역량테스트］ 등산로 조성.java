import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	static int N, K, highest, maxLens; // 지도 길이, 최대 공사 가능 깊이
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int[] dy = { 0, 0, -1, 1 };
	static List<Point> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {
			
			maxLens = 0; highest = 0; // 초기화
			
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			map = new int[N][N];
			visited = new boolean[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			} // 정보 입력받기

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (highest < map[i][j]) {
						highest = map[i][j]; // 가장 높은 산봉우리 찾기 
					}
				}
			}
			
			
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (highest == map[i][j]) {
						visited[i][j] = true;
						dfs(i, j, 0, 1, highest); // dfs 들어가 
						visited[i][j] = false;
					}
				}
			}

			System.out.println("#" + tc + " " + maxLens);
			
		} // tc

	} // main

	public static void dfs(int x, int y, int count, int lens, int h) {
		maxLens = Math.max(lens, maxLens);
		

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
				if (map[nx][ny] >= h) { // 다음 좌표값이 높이보다 높으면 원래 안되지만 !!
					if (count == 0) { // 아직 깎기가 한번도 시행안된 상태니 공사 가넝
						if (map[nx][ny] - K < h) {
							for (int k = 1; k <= K; k++) {
								visited[nx][ny] = true;
								dfs(nx, ny, count + 1, lens + 1, h - 1); // 1씩 깎아보면서 탐색하기 (h-k) 한번에 깎으면 가장 최적 경로 발견 어려우
								visited[nx][ny] = false;
							}
						}

					}

				} else { // 원래 정석 루트로 가보면
					visited[nx][ny] = true;
					dfs(nx, ny, count, lens + 1, map[nx][ny]); // 카운트는 그대로 두고, 길이는 +1, 높이는 h보다 무조건 작은 경우니까 map[nx][ny]를
																// 들고 탐색가기
					visited[nx][ny] = false;
				}
			}

		}

	}

}