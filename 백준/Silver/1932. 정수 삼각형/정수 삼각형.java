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
                triangle[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = -1;
            }
        }
        System.out.println(dp(1, 1)); // 시작점

    }
    public static int dp(int r, int c) {
        if(r == N) {
            return triangle[r][c]; // 마지막 행은 원본배열로 반환 -> 위로 올라가면서 최적화 값 구해주면 됨 
        }

        if(dp[r][c] == -1) {
            return dp[r][c] = Math.max(dp(r+1, c), dp(r+1, c+1)) + triangle[r][c];
        }

        return dp[r][c];
    }
}