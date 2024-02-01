class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int all = brown + yellow; 
        int min = 3;
        for(int w=min; w<all; w++){
            int h = all / w;
            // 둘 다 sum으로 나눴을 때 약수여야댐 
            if(all % w == 0){
                // yellow는 어케 구하ㅑㄴ 일단 테캐 4 -2 * 3 -2 오 애ㅒ 맞다
                if((w-2) * (h-2) == yellow){
                    answer[0] = w;
                    answer[1] = h;
                } 
            }
            
        }
        
        return answer;
    }
}