import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        ArrayList<Character> list = new ArrayList<>();
        int zero = 0; int one = 0;
        for(int i=0; i<str.length(); i++) {
            Character c = str.charAt(i);
            if( c == '0' ) {
                zero++;
            } else if( c == '1') {
                one++;
            }
            list.add(c);
        }
        zero = zero / 2;
        one = one / 2;
        // 문자열 살려서 제거하는 거였음 ㅎ;; 0은 뒤에서부터 제거 1은 앞에서부터 제거
        removeHalf(list, zero, one);
        for(int i=0; i<list.size(); i++) {
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
    public static void removeHalf(ArrayList<Character> list, int zero, int one) {
        int zeroCount = 0; int oneCount = 0;
        for(int i=0; i<list.size(); i++) {
            if(list.get(i) == '1') {
                if(oneCount < one) {
                    oneCount++;
                    list.remove(i);
                    i--;
                }
            }
        }
        for(int i=list.size()-1; i>=0; i--) {
            if(list.get(i) == '0') {
                if(zeroCount < zero) {
                    zeroCount++;
                    list.remove(i);
                }
            }
        }

    }
}