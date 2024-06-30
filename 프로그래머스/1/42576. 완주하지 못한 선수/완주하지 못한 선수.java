import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        // count 저장 
        for(String part: participant) {
            if(map.containsKey(part)) {
                int cnt = map.get(part);
                cnt++;
                map.put(part, cnt);
            } else {
                map.put(part, 1);
            }
        }
        // 동명이인에 대한 처리는 -> 카운트 세서 0이 안된 애로 
        for(String part2: completion) {
            if(map.containsKey(part2)) {
                map.put(part2, map.get(part2) - 1);
            } 
        }
        for(String part: participant) {
            if(map.get(part) != 0) {
                answer = part;
            }
        }
        
        return answer;
    }
}