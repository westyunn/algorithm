import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

       int n = Integer.parseInt(st.nextToken());
        int[][] dung = new int[n][2];
        int[] person = new int[n];
       for(int i=0; i<n; i++) {
           st = new StringTokenizer(br.readLine());
           for(int j=0; j<2; j++) {
               dung[i][j] = Integer.parseInt(st.nextToken());
           }
       } // 입력받기

       for(int i=0; i<n; i++) {
           int rank = 1;
           for(int j=0; j<n; j++) {
                if(i == j) {
                    continue;
                }
                if(dung[i][0] < dung[j][0] && dung[i][1] < dung[j][1]) {
                    // 키랑 덩치가 나보다 크면 내 등수는 하나씩 밀려감
                    rank++;
                }
               person[i] = rank;

           }
       }

       for(int i=0; i<n; i++) {
           System.out.print(person[i]+" ");
       }







    }
}