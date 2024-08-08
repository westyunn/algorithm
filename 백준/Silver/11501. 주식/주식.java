import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc=0; tc<T; tc++) {
            int N = Integer.parseInt(br.readLine()); // 날짜 수
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> stock = new ArrayList<>();
            for(int i=0; i<N; i++) {
                int num = Integer.parseInt(st.nextToken());
                stock.add(num);
            }
            long max = stock.get(N-1);
            long maxProfit = 0;
            for(int i=N-2; i>=0; i--) {
                if(max < stock.get(i)) {
                    max = stock.get(i);
                }
                maxProfit += max - stock.get(i);
            }
            sb.append(maxProfit).append('\n');
        } // tc
        System.out.println(sb);
    }
}