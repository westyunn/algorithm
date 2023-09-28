import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
	// 크루스칼로 풀어보기
	static int N, M;
	static int[][] edges;
	static int[] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine()); // 컴퓨터 수
		M = Integer.parseInt(br.readLine()); // 간선ㅅㅜ

		edges = new int[M][3];
		for (int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			edges[i][0] = Integer.parseInt(st.nextToken()); // ㅅ지ㅏㄱ
			edges[i][1] = Integer.parseInt(st.nextToken()); // 끝
			edges[i][2] = Integer.parseInt(st.nextToken()); // 가중치
		}

		// 오름차순 정렬
		Arrays.sort(edges, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				return o1[2] - o2[2]; // 가중치를 중심으로
			}

		});
		arr = new int[N + 1]; // 정점(컴퓨터) 수
		for (int i = 1; i <= N; i++) {
			arr[i] = i; // make-set
		}

		int ans = 0; // 가중치 합 저장
		int pick = 0; // 간선 뽑기 횟수 저장

		for (int i = 0; i < M; i++) {
			int x = edges[i][0];
			int y = edges[i][1];

			if (findset(x) != findset(y)) {
				union(x, y);
				ans += edges[i][2];
				pick++;
			}
			if (pick == N - 1) { // 정점-1까지만
				break;
			}
		}

		System.out.println(ans);

	} // main

	static int findset(int x) {
		if (x != arr[x]) {
			arr[x] = findset(arr[x]);
		}
		return arr[x];
	}

	static void union(int x, int y) {
		int a = findset(x);
		int b = findset(y);

		arr[b] = a;
	}
}