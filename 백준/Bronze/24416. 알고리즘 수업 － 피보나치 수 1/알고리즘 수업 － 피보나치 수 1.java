import java.util.Scanner;

public class Main {
	static int callFibo1, callFibo2;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		fibo1(N);
		fibo2(N);

		System.out.println(callFibo1 + " " + callFibo2);

	}

	public static int fibo1(int n) {
		if (n == 1 || n == 2) {
			callFibo1++;
			return 1;
		} else {
			return (fibo1(n - 1) + fibo1(n - 2));
		}
	}

	public static int fibo2(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		dp[2] = 1;
		for (int i = 3; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
			callFibo2++;
		}
		return dp[n];
	}

}