class Solution {
    public String solution(String number, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        // number.length - k 가 최대 자릿수니까 얘만큼 for문(외부) 돌려줘야함 
        // 일단 index 0~k-1 수 중에서 제일 큰 수를 찾아줘야 이후에 수들을 이어 붙일 수 잇음 
        // 순서는 못 바꿈
        // 2번 예제로 예시 들면 0~3 중에 큰 수를 찾고 그 인덱스 번호 기억한 후 다음 인덱스 번호부터 탐색해서 최댓값찾기 
        int idx = 0;
        char max = '0';
        for(int i=0; i<number.length() - k; i++) {
            max = '0'; // 각 자릿값 구할 때마다 초기화 ㄱㄱ
            for(int j=idx; j<=i+k; j++) {
                if( max < number.charAt(j)) { 
                    max = number.charAt(j) ;
                    idx = j + 1; 
                }
                
            }
            sb.append(max);
        }
        answer = sb.toString();
        
        return answer;
    }
}