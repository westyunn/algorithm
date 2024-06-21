class Solution {
    public int solution(int a, int b, int n) {
        int emptyBottle = n;
        int answer = 0;
        // 보유중인 빈 병의 개수가 a개 이상이어야 함 
        while(emptyBottle >= a) {
             // b가 2이상이면..? 
            int share = emptyBottle / a * b; // 6 2 1 
            int rest = emptyBottle % a; // 2 
            emptyBottle = share + rest; // 
            answer += share; 
        }
        
        return answer;
    }
}