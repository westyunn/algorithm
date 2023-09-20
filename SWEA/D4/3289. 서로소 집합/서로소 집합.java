import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N, M;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		for (int tc = 1; tc <= T; tc++) {

			StringBuilder sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 정점 개수~ 1부터 시작하니까 arr 크기 +1 해주기
			M = Integer.parseInt(st.nextToken()); // 연산 개수
			arr = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				arr[i] = i;
			} // makeset

			for (int i = 0; i < M; i++) {

				st = new StringTokenizer(br.readLine());

				int op = Integer.parseInt(st.nextToken()); // 연산자(?)
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				if (op == 0) { // union 해주기
					union(a, b);
				} else if (op == 1) {
					if (check(a, b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}

				}

			}
			System.out.println("#" + tc + " " + sb);

		} // for

	} // main

	public static int findset(int x) {
		if (x != arr[x])
			arr[x] = findset(arr[x]);
		return arr[x];

	}

	public static void union(int x, int y) {
		x = findset(x);
		y = findset(y);
		if (x == y) {
			return;
		}
		arr[y] = x;
	}

	public static boolean check(int x, int y) {
		int px = findset(x);
		int py = findset(y);

		if (px == py) {
			return true;
		}
		return false;
	}

}