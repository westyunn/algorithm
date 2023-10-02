import java.util.Scanner;

public class Main {
	static long[] dp = new long[101];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			System.out.println(padoban(N));
		}

	}

	public static long padoban(int n) {
		dp[1] = 1;
		dp[2] = 1;
		dp[3] = 1;

		for (int i = 4; i < 101; i++) {
			dp[i] = dp[i - 3] + dp[i - 2];
		}
		return dp[n];
	}

}