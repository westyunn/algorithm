import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] left = new int[N];
        int[] ars = new int[N];
        boolean[] visited = new boolean[N];
        for(int i=0; i<N; i++) {
            left[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<N; i++) {
            int count = 0; // 이미 채워진 자리 수
            int position = left[i];
            for(int j=0; j<N; j++) {
                if(!visited[j] && count == position) {
                    ars[j] = i + 1;
                    visited[j] = true;
                    break;
                } else if (!visited[j]){
                    count++;
                }
            }
        }
        for(int i=0; i<N; i++) {
            System.out.print(ars[i]+" ");
        }
    }
}