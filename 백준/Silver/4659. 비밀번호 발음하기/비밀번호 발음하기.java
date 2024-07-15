import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            String test = br.readLine();
            if(test.equals("end")) {
                break;
            }
            String[] words = test.split("");
            if (check(words)) {
                sb.append('<').append(test).append("> is acceptable.").append('\n');
            } else {
                sb.append('<').append(test).append("> is not acceptable.").append('\n');
            }

        }
        System.out.println(sb);

    }
    static boolean check (String[] words) {
        int vCount = 0; int cCount = 0; boolean vowelCheck = false;
        for(int i=0; i<words.length; i++) {
            if(words[i].equals("a") || words[i].equals("e") || words[i].equals("i") || words[i].equals("o") || words[i].equals("u")) {
                vowelCheck = true;
                vCount++; // 연속된 모음 체크
                cCount = 0;
            } else {
                vCount = 0; // 연속된 자음 체크
                cCount++;
            }
            if(vCount == 3 || cCount == 3) {
                return false;
            }
        }
        if(!vowelCheck) return false;

        for(int i=1; i<words.length; i++) {
            if(words[i-1].equals(words[i]) && !words[i-1].equals("e") && !words[i-1].equals("o")) {
                return false;
            }
        }
        return true;
    }
}