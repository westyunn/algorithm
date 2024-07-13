import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        String word = br.readLine().toUpperCase();
        String[] words = word.split("");
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int max = -1;
        for(String s: words) {
            map.put(s, map.getOrDefault(s, 0) + 1);
            max = Math.max(max, map.get(s));
        }
        for(Map.Entry<String, Integer> entry: map.entrySet()) {
            if(entry.getValue() == max) {
                list.add(entry.getKey());
            }
        }
        if(list.size() > 1) {
            sb.append('?');
        } else {
            sb.append(list.get(0));
        }
        System.out.println(sb);

    }
}