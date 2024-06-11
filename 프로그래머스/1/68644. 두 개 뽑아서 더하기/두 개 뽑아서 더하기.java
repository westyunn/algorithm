import java.util.*;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        int N = numbers.length;
        HashSet<Integer> set = new HashSet<>();
        // i가 0일땐 0,1 0,2 0,3 0,4
        // i가 1일땐 1,2 1,3 1,4
        // i가 2일땐 2,3 2,4
        // i가 3일땐 3,4 
        
        for(int i=0; i<N-1; i++) {
            int result = 0;
            for(int j=i+1; j<N; j++) {
                result = numbers[i] + numbers[j];
                set.add(result);
            }
        }
        ArrayList<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);    
        }
        return answer;
    }
}