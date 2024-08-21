import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // 1 -> 1 // 2 -> 00 11 2 // 3-> 001 100 101 // 4-> 5
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        if(N >= 1) {
            dp[1] = 1;
        }
        if(N >= 2) {
            dp[2] = 2;
        }
        if(N >= 3) {
            dp[3] = 3;
        }
        for(int i=4; i<=N; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 15746;
        }
        System.out.println(dp[N]);
    }
}