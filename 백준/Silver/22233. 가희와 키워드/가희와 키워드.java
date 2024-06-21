import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // HashMap대신 HashSet
        Set<String> keyword = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); // 키워드 개수
        int M = Integer.parseInt(st.nextToken()); // 블로그에 쓴 글 개수
        for(int i=0; i<N; i++) {
            keyword.add(br.readLine());
        }
        for(int i=0; i<M; i++) {
            // 아예 stringTokenizer을 사용해 쉼표 기준으로 분리
            st = new StringTokenizer(br.readLine(),",");
            while(st.hasMoreTokens()) {
                String str = st.nextToken();
                keyword.remove(str);
            }
            sb.append(keyword.size()).append('\n');
        }
        System.out.println(sb);
    }
}