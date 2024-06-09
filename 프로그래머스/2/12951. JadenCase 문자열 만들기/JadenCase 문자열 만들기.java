class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split("\\s", -1); // 공백기준으로 자르기 limit idx가 음수인 경우 공백 포함 원본 문자열 완전 분할 
        for(String str: arr) {
            if (str.length() > 0) {
                str = str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase(); // 첫 문자 대문자, 나머지 소문자
            }
            answer += str+ " "; 
        }
        answer = answer.substring(0, answer.length()-1);
        return answer;
    }
}