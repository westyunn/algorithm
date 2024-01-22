import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        int[] dp = new int[num+1];
        // 3 1 1 1
        // 4면 1 1 1 1 or 2 2
        // 5면 1 1 1 1 1 or 2 1
        for(int i=1; i<=num; i++){
            dp[i] = i; // 기본적으로 1의 개수만큼 있음
            for(int j=1; j*j<=i; j++){
                if(dp[i] > dp[i-j*j] + 1){
                    dp[i] = dp[i-j*j]+1;
                }
            }
        }
        System.out.println(dp[num]);

    }
}