class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        char[] abc = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'}; 
        char[] word = s.toCharArray();
        char[] except = skip.toCharArray();
        boolean[] counts = new boolean[26];
        
        for(Character w: except) {
            for(int i=0; i<abc.length; i++) {
                if(w == abc[i]) {
                    counts[i] = true;
                }
            }
        }
        for(Character w: word) {
            int idx = 0;
            for(int i=0; i<26; i++) {
                if(abc[i] == w) {
                    idx = i;
                    break;
                }
            }
            int count = 0;
            // 25 -> 다시 0으로 가야함 
            while(count < index) {
                idx++;
                if(!counts[idx % 26]) {
                    count++;
                } 
                
            }
            answer += abc[idx%26];
        }
        return answer;
    }
}