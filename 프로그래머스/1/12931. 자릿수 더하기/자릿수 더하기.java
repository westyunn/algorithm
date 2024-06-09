import java.util.*;

public class Solution {
    public int solution(int n) {
        String num = n + "";
        char[] arr = num.toCharArray();
        int answer = 0;
        for(int i=0; i<arr.length; i++) {
            answer += arr[i] - '0';
        }
        return answer;
    }
}