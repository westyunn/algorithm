import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, Boolean> keyword = new HashMap<>();
        int N = Integer.parseInt(st.nextToken()); // 키워드 개수
        int M = Integer.parseInt(st.nextToken()); // 블로그에 쓴 글 개수
        for(int i=0; i<N; i++) {
            String str = br.readLine();
            keyword.put(str, false);
        }
        int answer = N;
        String[] notes = new String[0];
        for(int i=0; i<M; i++) {
            String str = br.readLine();
            if(str.contains(",")){
                notes = str.split(",");
            } else {
                notes = new String[1];
                notes[0] = str;
            }
            for(String notesWord : notes) {
                // 키워드에 포함되고, 아직 처리되지 않은 키워드일 경우
                if(keyword.containsKey(notesWord) && !keyword.get(notesWord)) {
                    keyword.put(notesWord, true);
                    answer--;
                }
            }
            System.out.println(answer);
        }
    }
}