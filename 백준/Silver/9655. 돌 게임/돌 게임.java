import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int stone = Integer.parseInt(st.nextToken()); // 돌 개수
    String answer = "SK"; // 디폴트 대답 설정 (상근)
        if(stone == 2) {
            answer = "CY";
        }
        if(stone >= 3) {
            if(stone % 2 == 0) {
                answer = "CY";
            } else {
                answer = "SK";
            }
        }

System.out.println(answer);

    }
}