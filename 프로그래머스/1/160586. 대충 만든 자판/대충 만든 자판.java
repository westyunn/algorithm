import java.util.*;
class Solution {
    public ArrayList<Integer> solution(String[] keymap, String[] targets) {
        ArrayList<Integer> answer = new ArrayList<>();
        Map<String, Integer> keys = new HashMap<>();
        for(String str: keymap) {
            String[] strs = str.split("");
            for(int i=0; i<strs.length; i++) {
                if(keys.get(strs[i]) != null) {
                    if(i < keys.get(strs[i])) {
                        keys.put(strs[i], i);
                    }
                } else {
                    keys.put(strs[i], i);
                }
            }
        }
        for(String str: targets) {
            int ans = str.length();
            boolean flag = false; 
            String[] strs = str.split("");
            for(int i=0; i<strs.length; i++) {
                if(keys.containsKey(strs[i])) {
                    flag = true; 
                    ans += keys.get(strs[i]);
                } else {
                    flag = false;
                    answer.add(-1);
                    break;
                }
            }
            if(flag) {
                answer.add(ans);
            }
        }
        return answer;
    }
}