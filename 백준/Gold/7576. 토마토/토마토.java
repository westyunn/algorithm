import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static int[][] tomato;
	static int[][] visited;
	static Queue<Point> queue = new LinkedList<>();
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken()); // 상자 가로 크기
		N = Integer.parseInt(st.nextToken()); // 상자 세로 크기

		tomato = new int[N][M];
		visited = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				tomato[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 토마토 입력받기

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 1) {
					queue.add(new Point(i, j));
				}
			}
		}

		bfs();

	} // main

	public static void bfs() {
		while (!queue.isEmpty()) {
			Point cp = queue.poll();
			int cx = cp.x;
			int cy = cp.y;

			for (int d = 0; d < 4; d++) {

				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx < N && nx >= 0 && ny < M && ny >= 0) {
					if (tomato[nx][ny] == 0) {
						tomato[nx][ny] = 1;
						visited[nx][ny] = visited[cx][cy] + 1;
						cnt = visited[nx][ny];
						queue.add(new Point(nx, ny));
					}
				}

			}
		} // while

		if (checkTomato()) {
			System.out.println(cnt);
		} else {
			System.out.println(-1);
		}

	} // bfs

	public static boolean checkTomato() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tomato[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

}