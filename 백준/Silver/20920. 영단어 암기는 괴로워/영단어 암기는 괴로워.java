import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            int isValid = word.length();
            // 단어 길이가 m이상 되는 애들만 집어넣기
            if (isValid >= m) {
                // 빈도수 카운트
                map.put(word, map.getOrDefault(word, 0)+1);
            }
        }
        // 리스트에 단어 넣기
        List<String> list = new ArrayList<>(map.keySet());

       // 자주 나오는 단어 > 빈도수 같으면 단어 길이 긴 것부터 > 단어 길이까지 같으면 사전순
        list.sort((o1, o2)-> {
            int count1 = map.get(o1); // 빈도수 
            int count2 = map.get(o2);
            if(count1 == count2) { // 빈도수 같으면
                if(o1.length() == o2.length()) { // 단어 길이마저 같으면
                    return o1.compareTo(o2); //사전순 배치 
                }
                return o2.length() - o1.length(); // 단어 길이 긴 것부터 배치 
            }
            return count2 - count1; // 빈도수 많은 것부터 배치 
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i)).append('\n');
        }
        System.out.println(sb);







    }
}