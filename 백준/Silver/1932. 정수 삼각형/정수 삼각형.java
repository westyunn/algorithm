import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[][] triangle, dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        triangle = new int[N+1][N+1];
        dp = new int[N+1][N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());;
            }
        }
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                dp[i][j] = Math.max(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j];
            }
        }

        int ans = 0;

        for(int i=1; i<=N; i++) {
            for(int j=1; j<=i; j++) {
                if(ans < dp[i][j]) {
                    ans = dp[i][j];
                }
            }
        }
        System.out.println(ans);

    }
}