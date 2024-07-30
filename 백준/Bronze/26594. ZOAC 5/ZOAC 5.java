import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        Map<Character, Integer> map = new HashMap<>();
        for(int i=0; i<str.length(); i++) {
            char tmp = str.charAt(i);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
        }
        int ans = 0;
        for(char c: map.keySet()) {
            ans = map.get(c);
        }
        System.out.println(ans);
    }
}