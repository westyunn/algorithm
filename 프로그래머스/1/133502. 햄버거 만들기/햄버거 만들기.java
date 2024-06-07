import java.util.*;
class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
// 스택으로 풀기 
        // 포문 돌면서 재료 스택에 집어넣고 햄버거 재료에 해당하는 애들 스택에서 pop하기 -> 이러면 문제 예시처럼 2번째부터 일곱번째 재료~9번째 재료 이용가능 
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i< ingredient.length; i++) {
            stack.push(ingredient[i]);
            // 4개가 있어야 햄버거 하나를 완성시킬 수 있는 거니까 스택의 크기 확인 필수
            
            if(stack.size() >= 4) {
                int n = stack.size();
                if(stack.get(n-1) == 1 && stack.get(n-2) == 3 && stack.get(n-3) == 2 && stack.get(n-4) == 1) {
                    answer++;
                    // 햄버거에  해당하는 애들은 이제 제거 
                   for(int j=0; j<4; j++) {
                       stack.pop();
                   }
                }  
            }
        }
        
        
        
        return answer;
    }
}