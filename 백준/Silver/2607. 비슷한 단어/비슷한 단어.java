import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String standard = br.readLine(); // 첫번째 단어 기준
        HashMap<Character, Integer> stan = new HashMap<>();
        // 알파벳 카운트 할 해시맵
        for(int i=0; i<standard.length(); i++) {
            Character ch = standard.charAt(i);
            stan.put(ch, stan.getOrDefault(ch, 0)+1);
        }
        int ans = 0;
        for(int i=0; i<N-1; i++) {
            HashMap<Character, Integer> tmp = new HashMap<>(stan);
            // 비교 문자열
            String str = br.readLine();
            int count = 0; // 알파벳 개수 세기
            for(int j=0; j<str.length(); j++) {
                char temp = str.charAt(j);
                // 있으면 카운트 횟수 줄이기
                if(tmp.containsKey(temp) && tmp.get(temp) > 0) {
                    tmp.put(temp, tmp.get(temp) - 1);
                    count++;
                }
            }
            // ABAAC랑 ABAB, ABAA 둘을 비교할때 전자는 count 3번, 후자는 4번 -> 길이가 짧으면 모든 문자 카운트가 다 들어가야함
            if(str.length() + 1 == standard.length()) {
                if(count == str.length()){
                    ans++;
                }
                // ABAAC <-> ABAACD일때
            } else if(str.length() - 1 == standard.length()) {
                if(count == standard.length()){
                    ans++;
                }
            } else if(str.length() == standard.length()) {
                if(count == str.length() || count == str.length() - 1) {
                    ans++;
                }
            }
        }
        System.out.println(ans);


    }
}