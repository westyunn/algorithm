import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt0, cnt1;
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++) {
            cnt0 = 0; cnt1 = 0;
            int num = Integer.parseInt(br.readLine());
            fibo(num);
            sb.append(cnt0+" "+cnt1).append("\n");
        }

        System.out.println(sb);
    } // main


    public static int fibo(int n) {
        int[] dp = new int[n+1];
        if(n==0) {
            cnt0++;
            return 0;
        } else if(n == 1) {
            cnt1++;
            return 1;
        } else if(n >= 2){
            dp[0] = 0;
            dp[1] = 1;
            for(int i=2; i<=n; i++){
                dp[i] = dp[i-2] + dp[i-1];
                cnt0 = dp[i-1];
                cnt1 = dp[i];
            }
        }
        return dp[n];
    }
}