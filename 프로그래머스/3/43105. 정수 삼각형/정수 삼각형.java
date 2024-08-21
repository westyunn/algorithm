import java.util.*;
class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int N = triangle.length;
        for(int i=N-2; i>=0; i--) {
            for(int j=0; j<=i; j++) {
                triangle[i][j] = Math.max(triangle[i+1][j], triangle[i+1][j+1]) + triangle[i][j];
            }
        }
        answer = triangle[0][0];
        return answer;
    }
}