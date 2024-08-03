import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] str = s.split("");
        String first = str[0];
        
        int yesX = 0; // x인 글자 횟수 
        int noX = 0; // x가 아닌 글자 횟수 
        
        int n = s.length(); 
        int idx = 0; int count = 0;
        for(int i=0; i<n-1; i++) {
            if(str[i].equals(first)) { // first: a / b 
                yesX ++; // 1) 1 
            } else {
                noX++; // 1) 1 
            }
                
            if(yesX == noX) { 
                answer++; // 1 
                idx = i+1; // idx = 1 
                first = str[idx]; // first = str[1] b 
            }
        } 
        
        
        
        return answer+1;
    }
}