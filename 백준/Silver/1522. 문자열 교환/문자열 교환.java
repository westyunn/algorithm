import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        // a 개수만큼의 길이에서 b의 개수가 최소가 될때 교환
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        char[] word = str.toCharArray();
        int aMax = 0; int answer = Integer.MAX_VALUE;
        for(int i=0; i<word.length; i++) {
            if(word[i] == 'a') aMax++;
        }
        for(int i=0; i<word.length; i++) {
            int bMax = 0;
            for(int j=i; j<i+aMax; j++) {
                if(word[j % word.length] == 'b') bMax ++;
            }
            answer = Math.min(bMax, answer);
        }
        System.out.println(answer);
    }
}