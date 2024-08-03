import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static ArrayList<Character> tanos;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        tanos = new ArrayList<>();
        int zero = 0; int one = 0;
        for(int i=0; i<str.length(); i++) {
            Character c = str.charAt(i);
            if( c == '0' ) {
                zero++;
            } else if( c == '1') {
                one++;
            }
            tanos.add(c);
        }
        Collections.sort(tanos);
        removeHalf(tanos, zero, one);
        for(int i=0; i<tanos.size(); i++) {
            sb.append(tanos.get(i));
        }
        System.out.println(sb);
    }
    public static void removeHalf(ArrayList<Character> tanos, int zero, int one) {
        int zeroCount = 0; int oneCount = 0;
        for(int i=0; i<tanos.size(); i++) {
            if(tanos.get(i) == '0') {
                if(zeroCount == zero / 2) {
                    continue;
                }
                zeroCount++;
                tanos.remove(i);

            } else if(tanos.get(i) == '1') {
                if(oneCount == one / 2) {
                    continue;
                }
                oneCount++;
                tanos.remove(i);
            }
        }

    }
}