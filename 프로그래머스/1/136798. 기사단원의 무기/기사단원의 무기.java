import java.util.*;
class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        Map<Integer, Integer> scores = new HashMap<>();
        for(int i=1; i<=number; i++) {
            int cnt = 0;
            for(int j=1; j<=Math.sqrt(i); j++) {
                if(i % j == 0) {
                    if(i / j == j) {
                        cnt++;
                    } else {
                        cnt += 2; 
                    }
                }
            }
            scores.put(i, cnt);
        }
        for(int i=1; i<=number; i++) {
            if(scores.get(i) > limit) {
                scores.put(i, power);
            }
        }
        for(int i=1; i<=number; i++) {
            answer += scores.get(i);
        }
        return answer;
    }
}