import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int T, N, finx, finy, cnt, currx, curry;
	public static int[][] chess;
	public static int[] dx = { -1, -2, -2, -1, 1, 2, 2, 1 };
	public static int[] dy = { -2, -1, 1, 2, 2, 1, -1, -2 };
	public static boolean[][] visited;
	public static Point p = new Point();
	public static Queue<Point> queue = new LinkedList<>();
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		T = Integer.parseInt(br.readLine());

		for (int tc = 1; tc <= T; tc++) {

			N = Integer.parseInt(br.readLine()); // 체스판 크기
			chess = new int[N][N];
			visited = new boolean[N][N];
			cnt = Integer.MAX_VALUE;
			StringTokenizer st = new StringTokenizer(br.readLine());
			currx = Integer.parseInt(st.nextToken()); // 가로값
			curry = Integer.parseInt(st.nextToken()); // 세로값

			st = new StringTokenizer(br.readLine());

			finx = Integer.parseInt(st.nextToken());
			finy = Integer.parseInt(st.nextToken());
			if (currx == finx && curry == finy) {
				System.out.println(0);
				continue;
			}
			bfs(currx, curry);
			System.out.println(cnt);
		} // tc

	} // main

	public static void bfs(int x, int y) {

		queue.add(new Point(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Point cp = queue.poll();

			int cx = cp.x; // 현재의 x, y값
			int cy = cp.y;

			for (int d = 0; d < 8; d++) {

				int nx = cx + dx[d];
				int ny = cy + dy[d];

				if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny]) {
					if (nx == finx && ny == finy) {
						cnt = Math.min(cnt, chess[cx][cy]+1);
					}
					chess[nx][ny] = chess[cx][cy] + 1;
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}

		}
	}

}