import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static int N, M, cnt;
	public static int[][] maze;
	public static boolean[][] visited;
	public static int[] dx = { 1, 0, -1, 0 };
	public static int[] dy = { 0, 1, 0, -1 };
	public static Point p = new Point(); // Point 우왕
	public static Queue<Point> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 세로
		M = Integer.parseInt(st.nextToken()); // 가로

		maze = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				maze[i][j] = str.charAt(j) - '0';
			}
		}

		cnt = 1;
		visited[0][0] = true;
		bfs(0, 0);
		System.out.println(cnt);

	}

	public static void bfs(int x, int y) {
		queue.add(new Point(x, y)); // Point로 좌표 저장하기
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Point cp = queue.poll();
			int xx = cp.x; // 현재의 x
			int yy = cp.y; // 현재의 y

			if (xx == N - 1 && yy == M - 1) {
				break;
			}
			for (int d = 0; d < 4; d++) {
				int nx = xx + dx[d]; // nx는  현재의 x좌표 +사방탐색해서 갈 만한 곳
				int ny = yy + dy[d];

				if (nx >= N || nx < 0 || ny >= M || ny < 0) {
					continue;
				}
				if (visited[nx][ny] || maze[nx][ny] == 0) {
					continue;
				}
				queue.add(new Point(nx, ny)); // 큐에 넣고 
				maze[nx][ny] = maze[xx][yy] + 1; // 현재 좌표는 (xx, yy)로 저장했으니까 (nx,ny)로 가면 칸수 하나씩 +해줘서 카운트 해주기
				visited[nx][ny] = true; // 방문처리 

			}

		} // while
		cnt = maze[N-1][M-1];

	}

}