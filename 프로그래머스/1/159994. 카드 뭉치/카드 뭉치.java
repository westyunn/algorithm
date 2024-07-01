import java.util.*;
class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "Yes";
        Map<String, Integer> map1 = new LinkedHashMap<>();
        // 목표배열부터 순차적으로 돌면서 역으로 순서 저장 
        for(String card: goal) {
            for(int i=0; i<cards1.length; i++) {
                if(card.equals(cards1[i])) {
                    map1.put(card, i);
                }
            }
        }
        Map<String, Integer> map2 = new LinkedHashMap<>();
        for(String card: goal) {
            for(int i=0; i<cards2.length; i++) {
                if(card.equals(cards2[i])) {
                    map2.put(card, i); 
                }
            }
        }
        // card1, cards2를 저장한 HashMap 넘버랑 비교하면서 cards1에 있는 애랑 순차 비교 
        int idx = 0; 
        for(String card: map1.keySet()) {
            if(card.equals(cards1[idx])) {
                idx++;
            } else {
                answer = "No";
                break;
            }
        }
        int idx2 = 0; 
        for(String card: map2.keySet()) {
            if(card.equals(cards2[idx2])) {
                idx2++;
            } else {
                answer = "No";
                break;
            }
        }
        
        
        return answer;
    }
}