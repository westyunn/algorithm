import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    static int[] num; static int[] reverse;
    static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int t=0; t<tc; t++) {
            String str = br.readLine(); // 수행 함수 P
            String[] func = str.split(""); // 함수 쪼개기

            int N = Integer.parseInt(br.readLine()); // 배열에 들어가있는 수
            num = new int[N];
            String input = br.readLine();
            input = input.substring(1, input.length()-1); // 대괄호 제거
            if(N > 0) {
                String[] nnum = input.split(","); // 쉼표 기준으로 분리
                for(int i=0; i<nnum.length; i++) {
                    num[i] = Integer.parseInt(nnum[i]);
                }
            }
            for(int i: num) {
                list.add(i); // 리스트 넣기
            }
            boolean isError = false; // 에러 감지 플래그
            boolean isReverse = false; // 리버스 감지 플래그
            for(String s: func) {
                if(s.equals("R")) {
                    isReverse = !isReverse;
                }
                if (s.equals("D")) {
                    if (list.isEmpty()) { // 리스트 비어있으면 에러 감지
                        isError = true;
                        break;
                    }
                    if(isReverse) {
                        list.remove(list.size()-1);
                    } else {
                        list.remove(0);
                    }
                }
            }
            if(isError) {
                sb.append("error").append("\n");
            } else {
                if(isReverse) {
                    funcR();
                }
               sb.append(list.toString().replace(" ", "")).append("\n");
            }
            list.clear(); // 다음 테케를 위한 초기화

        }
        System.out.println(sb);
    }
    public static void funcR(){
        List<Integer> reverseList = new ArrayList<>();
        for(int i = list.size()-1; i>=0; i--) {
            reverseList.add(list.get(i));
        }
        list = reverseList;
    }
}