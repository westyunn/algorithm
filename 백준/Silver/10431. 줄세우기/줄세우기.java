import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int testcase = Integer.parseInt(st.nextToken()); // 테캐 개수
        int[] test = new int[testcase];
        int[][] child = new int[testcase][20];
        for (int tc = 0; tc < testcase; tc++) {
            st = new StringTokenizer(br.readLine());
            test[tc] = Integer.parseInt(st.nextToken());
            for(int i=0; i<20; i++) {
                child[tc][i] = Integer.parseInt(st.nextToken());
            }
        } // 입력 받기

        // 반복문 돌려서 나보다 큰 애 숫자 세어주면 됨

        for(int tc=0; tc<testcase; tc++) {
            int answer = 0;
            for(int i=1; i<20; i++) {
                for(int j=0; j<i; j++) {
                    if(child[tc][i] < child[tc][j]) {
                        answer++;
                    }
                }
            }
            System.out.println((tc+1)+" "+answer);
        }






    }
}