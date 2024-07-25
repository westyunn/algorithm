import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        // 1일때 1 2일때 2 3일 때 3, 4일때 5, 5일때 8.. 피보나치 함수
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
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[N]);
    }
}