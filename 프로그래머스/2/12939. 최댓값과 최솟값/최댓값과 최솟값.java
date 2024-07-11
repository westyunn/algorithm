import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        String[] num = s.split(" ");
        int n = num.length;
        int[] nums = new int[n];
        
        for(int i = 0; i < n; i++ ) {
            nums[i] = Integer.parseInt(num[i]);
        }
        
        Arrays.sort(nums);
        answer = nums[0]+" "+nums[n-1]; 
        
        return answer;
    }
}