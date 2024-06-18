import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        int n = phone_book.length;
        
        Arrays.sort(phone_book);
       int index = 0;
        for(String str: phone_book) {
            if(index < n - 1) {
                if(phone_book[index+1].startsWith(str)) {
              answer = false; 
              break;
          }
            index++;        
            } 
          
        }
        
        
        
        return answer;
    }
}