import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); // 거스름돈 액수

		int[] dp = new int[100001];

		dp[0] = 0;
		for (int i = 1; i <= N; i++) {
			dp[i] = Integer.MAX_VALUE - 1;
			if (i >= 2) {
				dp[i] = Math.min(dp[i - 2] + 1, dp[i]);
			}
			if (i >= 5) {
				dp[i] = Math.min(dp[i - 5] + 1, dp[i]);
			}

		}
		if (dp[N] == Integer.MAX_VALUE - 1) {
			System.out.println(-1);
		} else {
			System.out.println(dp[N]);
		}

	}

}