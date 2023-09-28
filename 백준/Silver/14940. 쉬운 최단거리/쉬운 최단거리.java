import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M; // N:세로 M:가로
	static int[][] map, visited;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int cnt = 0;
	static Queue<Point> queue = new LinkedList<>();
	static Point p = new Point();
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new int[N][M];
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 맵 정보 입력받기

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 2) {
					bfs(i, j);
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && visited[i][j] == 0) {
					sb.append(-1).append(" ");
				} else {
					sb.append(visited[i][j]).append(" ");
				}
			}
			sb.append('\n');
		}

		System.out.println(sb);
	} // main

	public static void bfs(int x, int y) {
		queue.add(new Point(x, y));
		visited[x][y] = 0;

		while (!queue.isEmpty()) {
			Point cp = queue.poll();
			int xx = cp.x;
			int yy = cp.y;
			for (int d = 0; d < 4; d++) {
				int nx = xx + dx[d];
				int ny = yy + dy[d];

				if (nx < N && nx >= 0 && ny < M && ny >= 0 && map[nx][ny] == 1 && visited[nx][ny] == 0) {
					queue.add(new Point(nx, ny));
					visited[nx][ny] = visited[xx][yy] + 1;
				}
			}

		}

	}
}

// 제발 문제 좀 잘 읽자 ^^^^^^^^^^,,,,,,,,,,,