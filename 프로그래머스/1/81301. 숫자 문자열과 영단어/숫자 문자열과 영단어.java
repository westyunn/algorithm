class Solution {
    public int solution(String s) {
        int answer = 0;
        String[] numbers = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero"};
        String[] nnum = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        for(int i=0; i<numbers.length; i++) {
            if(s.contains(numbers[i])) {
                s = s.replace(numbers[i], nnum[i]);
            }
        }
        
        answer = Integer.parseInt(s);
        
        return answer;
    }
}