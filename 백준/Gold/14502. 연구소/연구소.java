import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, sum;
	static int max = Integer.MIN_VALUE;
	public static int[][] lab, copy;
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		lab = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				lab[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 연구소 정보 입력받기

		dfs(0);

		System.out.println(max);

	} // main

	// 안전 지역 크기 계산
	public static void dfs(int wall) {
		// 기저조건은 벽이 3개 될 때 bfs로 안전영역 크기 구해주기
		if (wall == 3) {
			bfs();
			return;
		}
		// i, j에 벽 세워주고

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 0) {
					lab[i][j] = 1; // 벽 세우고
					dfs(wall + 1); // 탐색
					lab[i][j] = 0; // 벽 다시 없애
				}
			}
		}
	} // dfs

	public static void bfs() {

		Queue<Point> queue = new LinkedList<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (lab[i][j] == 2) {
					queue.add(new Point(i, j));
				}
			}
		} // 바이러스 체크해서 큐에 넣어주기

		copy = new int[N][M];
		// lab 복사한 copy맵 만들어주기(안그러면 lab 자체가 바껴버림)
		for (int i = 0; i < N; i++) {
			copy[i] = lab[i].clone();
		}

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			int currx = p.x;
			int curry = p.y;

			for (int d = 0; d < 4; d++) {
				int nx = currx + dx[d];
				int ny = curry + dy[d];

				if (nx < N && nx >= 0 && ny < M && ny >= 0 && copy[nx][ny] == 0) {
					queue.add(new Point(nx, ny));
					copy[nx][ny] = 2; // 0인거 바이러스로 만들어주고
				}

			}

		} // 바이러스 퍼뜨렷어

		checkSafe(copy);

	} // bfs

	private static void checkSafe(int[][] copy) {
		int safeCount = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (copy[i][j] == 0) {
					safeCount++;
				}
			}
		}
		max = Math.max(max, safeCount);

	}

}