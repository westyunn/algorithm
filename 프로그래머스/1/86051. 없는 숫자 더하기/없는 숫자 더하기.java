class Solution {
    public int solution(int[] numbers) {
        int[] ans = new int[10];
        int answer = 0;
        for(int i=0; i<numbers.length; i++){
            ans[numbers[i]] = 1;
        }
        for(int i=1; i<=9; i++){
            if(ans[i] == 0){
                answer += i;
            }
        }
        return answer;
    }
}