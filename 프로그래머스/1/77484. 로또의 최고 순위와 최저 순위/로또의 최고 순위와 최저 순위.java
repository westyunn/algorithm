import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0; int zeroCount = 0;
        for(int i=0; i<6; i++) {
            for(int j=0; j<6; j++) {
                if(win_nums[i] == lottos[j]) {
                    count++;
                }
            }
            if(lottos[i] == 0) {
                zeroCount++;
            }
            
        } 
         switch (count) {
            case 6:
                answer = new int[]{1, 1};
                break;
            case 5:
                if (zeroCount == 1) {
                    answer = new int[]{1, 2};
                } else {
                    answer = new int[]{2, 2};
                }
                break;
            case 4:
                if (zeroCount > 1) {
                    answer = new int[]{1, 3};
                } else if (zeroCount == 1) {
                    answer = new int[]{2, 3};
                } else {
                    answer = new int[]{3, 3};
                }
                break;
            case 3:
                if (zeroCount > 2) {
                    answer = new int[]{1, 4};
                } else if (zeroCount == 2) {
                    answer = new int[]{2, 4};
                } else if (zeroCount == 1) {
                    answer = new int[]{3, 4};
                } else {
                    answer = new int[]{4, 4};
                }
                break;
            case 2:
                if (zeroCount > 3) {
                    answer = new int[]{1, 5};
                } else if (zeroCount == 3) {
                    answer = new int[]{2, 5};
                } else if (zeroCount == 2) {
                    answer = new int[]{3, 5};
                } else if (zeroCount == 1) {
                    answer = new int[]{4, 5};
                } else {
                    answer = new int[]{5, 5};
                }
                break;
            case 1:
                if (zeroCount > 4) {
                    answer = new int[]{1, 6};
                } else if (zeroCount == 4) {
                    answer = new int[]{2, 6};
                } else if (zeroCount == 3) {
                    answer = new int[]{3, 6};
                } else if (zeroCount == 2) {
                    answer = new int[]{4, 6};
                } else if (zeroCount == 1) {
                    answer = new int[]{5, 6};
                } else {
                    answer = new int[]{6, 6};
                }
                break;
            case 0:
                if (zeroCount > 5) {
                    answer = new int[]{1, 6};
                } else if (zeroCount == 5) {
                    answer = new int[]{2, 6};
                } else if (zeroCount == 4) {
                    answer = new int[]{3, 6};
                } else if (zeroCount == 3) {
                    answer = new int[]{4, 6};
                } else if (zeroCount == 2) {
                    answer = new int[]{5, 6};
                } else {
                    answer = new int[]{6, 6};
                }
                break;
        }
        return answer;
    }
}