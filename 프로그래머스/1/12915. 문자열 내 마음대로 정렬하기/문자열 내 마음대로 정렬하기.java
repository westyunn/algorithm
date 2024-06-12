import java.util.*;
class Solution {
    public String[] solution(String[] strings, int n) {
        String[] answer = {};
        // 모음만 추출한 해당 인덱스를 제일 앞에다가 놓은 임의의 문자열 배치 후 정렬 
        ArrayList<String> tmparr = new ArrayList<>();
        for(String str: strings) {
            String[] tmp = str.split("");
            str = tmp[n] + str;
            tmparr.add(str);
        }
        Collections.sort(tmparr);
        answer = new String[tmparr.size()];
        for(int i=0; i<tmparr.size(); i++) {
            answer[i] = tmparr.get(i).substring(1);
        }
        return answer;
    }
}