function solution(s){
    let answer = true;
    let stack = [];

    for(let i=0; i<s.length; i++) {
        let char = s.charAt(i);
        if(char == "(") {
            stack.push(char);
        } else if(char == ")") {
            if(stack.length > 0) {
                stack.pop();
            } else {
                answer = false;
                break;
            }
        }
    }
     // 스택에 남아 있는 여는 괄호가 있는지 확인
    if (stack.length > 0) {
        answer = false;
    }
    return answer;
}