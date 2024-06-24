import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        int n = score.length;
        int[] answer = new int[n];
        int minor = 0;
        // 우선순위큐를 통해서 가장 작은 값 우선 제거 
        PriorityQueue<Integer> result = new PriorityQueue<Integer>();
        for(int i=0; i<n; i++) {
            result.add(score[i]);
            if(result.size() > k) {
                result.poll();
            }
            answer[i] = result.peek(); 
        } 
        
        return answer;
    }
}