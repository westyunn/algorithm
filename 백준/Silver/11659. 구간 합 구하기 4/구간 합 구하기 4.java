import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] nums = new int[n+1]; // 숫자 배열
        int[] sums = new int[n+1]; // 합 배열
        for(int i=0; i<n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        for(int i=0; i<n; i++) {
           sums[i+1] = sums[i] + nums[i];
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int answer = sums[end] - sums[start-1];
            sb.append(answer).append('\n');
        }
        System.out.println(sb);

    }
}