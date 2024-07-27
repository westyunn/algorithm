import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();
        char[] nums = num.toCharArray();
        int start = 1; // 시작점
        int idx = 0; // 배열 요소 있는지 확인 카운팅
        while(idx < nums.length) {
            String str = String.valueOf(start);
            // 두자리 이상일 경우 한자리씩 다 검사해야함
            for(int i=0; i<str.length(); i++) {
                if(nums[idx] == str.charAt(i)) {
                    idx++; // 배열에 있으면 다음 인덱스로 넘겨서 확인
                }
                // 에러 방지 
                if(idx == nums.length) {
                    break;
                }
            }
            start++;
        }
        System.out.println(start-1);


    }
}