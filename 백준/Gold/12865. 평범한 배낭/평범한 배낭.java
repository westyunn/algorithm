import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, K;
	static int[] weight, cost;
	static int[][] dp;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 가방 개수
		K = Integer.parseInt(st.nextToken()); // 무게

		weight = new int[N + 1];
		cost = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());

			weight[i] = Integer.parseInt(st.nextToken());
			cost[i] = Integer.parseInt(st.nextToken());
		}
		dp = new int[N + 1][K + 1];

		for (int i = 1; i <= N; i++) {

			for (int w = 0; w <= K; w++) {
				if (weight[i] <= w) {
					dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + cost[i]);
				} else {
					dp[i][w] = dp[i - 1][w];
				}
			}
		}
		System.out.println(dp[N][K]);
	}

}