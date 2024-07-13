import java.util.*;
class Solution {
    public int solution(int k, int m, int[] score) {
        int answer = 0;
        int n = score.length;
        Arrays.sort(score);
        int a = n % m;
        int sum = 0; 
        for(int i=a; i<n; i+=m) {
            int min = 10;
            for(int j=i; j<i+m; j++) {
                min = Math.min(score[j], min);
                sum = min * m;
            }
            answer += sum;
        }
        
        return answer;
    }
}