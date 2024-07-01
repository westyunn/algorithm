import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] one = {1, 2, 3, 4, 5};
        int[] two = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] three = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int idx = 0;
        int[] count = new int[3];
        for(int num: answers) {
            if(num == one[idx % one.length]) {
                count[0]++;
            } if(num == two[idx % two.length]) {
                count[1]++;
            } if(num == three[idx % three.length]) {
                count[2]++;
            }
            idx++;
        }
        int max = Math.max(Math.max(count[0], count[1]), count[2]);
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<3; i++) {
            if(max == count[i]) {
                list.add(i+1);
            }
        }
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}