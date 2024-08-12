import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        if(N >= 1) {
            dp[1] = 1;
        }
        if(N >= 2) {
            dp[2] = 3;
        }
        if(N >= 3) {
            dp[3] = 5;
        }
        for(int i=4; i<=N; i++) {
            dp[i] = dp[i-1] + dp[i-2] * 2;
            dp[i] = dp[i] % 10007;
        }
        System.out.println(dp[N]);

    }
}