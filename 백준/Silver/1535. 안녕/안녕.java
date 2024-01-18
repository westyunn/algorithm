import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] dp = new int[101]; // 세준이 기쁨(최대 100)
        int[] hp = new int[N]; // 체력
        int[] joy = new int[N]; // 기쁨
        for(int i=0; i<N; i++){
            hp[i] = sc.nextInt();
        }
        for(int i=0; i<N; i++){
            joy[i] = sc.nextInt();
        }
//        for(int i=1; i<=100; i++){
//            dp[i] = i;
//        }
        dp[0] = 0;
        for(int i=0; i<N; i++){
            for(int j=100; j>hp[i]; j--){ // 체력 한도 내에서
                    dp[j] = Math.max(dp[j], dp[j-hp[i]]+joy[i]);
            }
        }
        System.out.println(dp[100]);

    }
}