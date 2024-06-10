import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 블로그 시작하고 지난 일수
        int X = Integer.parseInt(st.nextToken()); // 탐색할 기간
        int[] visit = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            visit[i] = Integer.parseInt(st.nextToken());
        } // 하루동안 방문한 배열
//        int[] popular = new int[N-X+1]; // 최대 방문수를 구하기 위한 배열
        int max = 0;
        // 이중포문 쓰니 시간초과 난당
//        for(int i=0; i<=N-X; i++) {
//            for(int j=0; j<X; j++) {
//                popular[i] += visit[i+j];
//            }
//            if(popular[i] > max) {
//                max = popular[i]; // 최대 방문자 수 구하기
//            }
//        }
        // 슬라이딩 윈도우 로직 활용
        // 윈도우 설정 (첫 윈도우)
        int sum = 0;
        for(int i=0; i<X; i++) {
            sum += visit[i];
        }
        max = sum;
        int count = 1; // 기간을 1로 초기화해야함 (제일 처음에 설정한 윈도우가 최대일수도 있기때문에)
        for(int i=0; i<N-X; i++) {
            // 초기 윈도우 5에서 한칸씩 이동해서 합 계산 후 max값 구해주기 !
            sum += visit[i+X];
            sum -= visit[i];
            if(max == sum) {
                count++;
            }
            if(max < sum) {
                max = sum; // 최대방문자수 갱신
                count = 1;
            }
        }

        if(max == 0) {
            System.out.println("SAD");
        } else {
            System.out.println(max);
            System.out.println(count);
        }

    }
}