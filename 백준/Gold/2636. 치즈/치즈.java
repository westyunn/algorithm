import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int R, C; // 세로 가로
	static int[][] map;
	static boolean[][] visited;
	static int time, count;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 정보 입력받기 끗

		int cheese = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 1) {
					count++; // 치즈 개수 세기

				}
			}
		}
		while (true) {
			time++;
			cheese = count; // 치즈 저장 변수 
		    bfs();
		    melting();
		    if (count == 0) {
		        break;
		    }
		}

		System.out.println(time);
		System.out.println(cheese);
		
	} // main

	public static void bfs() {
		Queue<Point> queue = new LinkedList<>();
		queue.add(new Point(0, 0));
		visited = new boolean[R][C]; // **************************
		visited[0][0] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			int nowr = p.x;
			int nowc = p.y;

			for (int d = 0; d < 4; d++) {
				int nr = nowr + dr[d];
				int nc = nowc + dc[d];

				if (nr >= 0 && nc >= 0 && nr < R && nc < C && !visited[nr][nc]) {
					if (map[nr][nc] == 1) { // 치즈 만났다
						map[nr][nc] = 2; // 테두리 2로 만들어주고
						count--;
					} else {
						queue.add(new Point(nr, nc));
					}
					visited[nr][nc] = true; // 공기든 머든 방문처리는 꼬옥
				}

			}

		}

	}

	public static void melting() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 2) {
					map[i][j] = 0;
				}
			}
		}
	}

}