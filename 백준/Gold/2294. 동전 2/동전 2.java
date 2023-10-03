import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 동전 개수
		int k = Integer.parseInt(st.nextToken()); // 동전 가치

		int[] coin = new int[n];
		int[] cost = new int[k + 1];

		Arrays.fill(cost, Integer.MAX_VALUE - 1);
		cost[0] = 0;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			coin[i] = Integer.parseInt(st.nextToken());

			for (int j = coin[i]; j <= k; j++) {

				cost[j] = Math.min(cost[j], cost[j - coin[i]] + 1);

			}
		}

		if (cost[k] == Integer.MAX_VALUE - 1) {
			System.out.println(-1);
		} else {
			System.out.println(cost[k]);
		}

	}
}