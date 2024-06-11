import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 지방 수
        int[] region = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;
        int min = Integer.MAX_VALUE;

        for(int i=0; i<N; i++) {
            region[i] = Integer.parseInt(st.nextToken());
            sum += region[i];
            max = Math.max(max, region[i]);
            min = Math.min(min, region[i]);
        }
        int budget = Integer.parseInt(br.readLine()); // 배정된 예산
        // 각 지방이 요청한 예산 합 <= 배정된 예산이면 각 지방 예산요청 금액 중 최대 금액이 최댓값이 됨
        if(sum <= budget) {
            System.out.println(max);
            return;
        }
        Arrays.sort(region);
        // 방법을 모르겠어서 알고리즘 분류봄 이분탐색 < 을 이용해서 풀이해야댄다고 한다..^,ㅠ
        int low = 0;
        int high = region[N-1];
        int mid = 0;
        int res = 0;
        // 이분탐색 실행
        while(low <= high) {
            // 비교하면서 tmp가 예산보다 클 경우는 high의 값을 mid값에 -1해서 좁혀나가고 반대의 경우는 low값을 mid값에 +1해서 좁혀줘야
            mid = (high + low) / 2;
            int tmp = 0;
            // 상한액(mid) 기준으로 예산 합 설정
            // 상한액 vs 지방 예산 중 작은 값을 더해주기
            for(int cost: region) {
                tmp += Math.min(cost, mid);
            }
            // tmp값에 따라 상한액 다시 설정해서 ㄱㄱ
            if(tmp > budget) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(high);


    }
}