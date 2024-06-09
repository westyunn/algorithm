import java.util.*;
class Solution
{
    public int solution(String s)
    {
        int answer = -1;
        Stack <String> stack = new Stack<>();
        String[] str = s.split("");
        for(String aa: str) {
            if(stack.isEmpty()) {
                // 스택 비어있다면 첫문자니까 push rksmd
                stack.push(aa);
            } else {
                if(stack.peek().equals(aa)) {
                    // stack의 top이 같다면 연속된 거니까 제거 
                    stack.pop();
                } else {
                    stack.push(aa);
                }
            
            }
        }
        
        if(stack.isEmpty()) {
            // 스택이 비어져있다면 짝지어 제거 완료 
            answer = 1;
        } else {
            answer = 0;
        }
        

        return answer;
    }
}