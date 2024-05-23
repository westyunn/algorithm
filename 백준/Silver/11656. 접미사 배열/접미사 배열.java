import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine(); // 문자열 받기
        List<String> list = new ArrayList<>(); // 사전순 정렬을 위한 ArrayList
        for(int i=0; i<S.length(); i++) {
            list.add(S.substring(i));// substring 사용해서 맨 앞 글자씩 잘라서 문자열 배열에 담기
        }
        Collections.sort(list); // 사전순 정렬(오름차순)
        for(int i=0; i<list.size(); i++) {
            System.out.println(list.get(i));
        }


    }



}