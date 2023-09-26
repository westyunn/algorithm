import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

class Tomato {
	int x;
	int y;
	int z;
	int day;

	public Tomato(int x, int y, int z, int day) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
		this.day = day;
	}

}

public class Main {
	static int N, M, H, day, ans;
	static int[][][] tomato;
	static int[][][] visited;
	static int[] dz = { 0, 0, 0, 0, -1, 1 };
	static int[] dx = { -1, 1, 0, 0, 0, 0 };
	static int[] dy = { 0, 0, -1, 1, 0, 0 };
	static Queue<Tomato> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt(); // 상자 가로 크기
		N = sc.nextInt(); // 상자 세로 크기
		H = sc.nextInt(); // 상자 층수

		tomato = new int[N][M][H];
		visited = new int[N][M][H];
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					tomato[i][j][h] = sc.nextInt();
				}
			} // 토마토 입력받기
		}
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tomato[i][j][h] == 1) {
						queue.add(new Tomato(i, j, h, day));
					}
				}
			}
		}

		bfs();

	} // main

	public static void bfs() {
		while (!queue.isEmpty()) {
			Tomato now = queue.poll();
			int cx = now.x;
			int cy = now.y;
			int cz = now.z;
			int cd = now.day;
			if (cd >= ans)
				ans = cd;

			for (int d = 0; d < 6; d++) {

				int nx = cx + dx[d];
				int ny = cy + dy[d];
				int nz = cz + dz[d];

				if (nx < N && nx >= 0 && ny < M && ny >= 0 && nz >= 0 && nz < H) {
					if (tomato[nx][ny][nz] == 0) {
						tomato[nx][ny][nz] = 1;
						queue.add(new Tomato(nx, ny, nz, cd + 1));
					}
				}

			}
		} // while

		if (checkTomato()) {
			System.out.println(ans);
		} else {
			System.out.println(-1);
		}

	} // bfs

	public static boolean checkTomato() {
		for (int h = 0; h < H; h++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (tomato[i][j][h] == 0) {
						return false;
					}
				}
			}
		}
		return true;
	}

}