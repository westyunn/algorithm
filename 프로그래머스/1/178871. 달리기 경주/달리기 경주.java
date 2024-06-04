import java.util.*;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap <String, Integer> map = new HashMap<>();
        String[] answer = {};
        int pn = players.length;
        int cn = callings.length;
        
        // players는 이미 정렬된 상태 (현재 순위)
        // callings 배열 반복문으로 돌리면서 players 배열 내에서 요소의 인덱스 번호를 알아낼 수 있는 방법이 뭘까
        // 인덱스 배열에 callings에 들어간 players 인덱스 번호 
        // for(int i=0; i<cn; i++) {
        //     index[i] = Arrays.asList(players).indexOf(callings[i]);
        // } // <- 이렇게 하니까 인덱스 배열 이용하는 것 자체가 답없음 
        
        // 걍 이중 포문 돌려서 callings의 첫번째 요소부터 players에 있는지 검사 후 순서를 바꿔주자 > 시간초과

//         for(int i=1; i<cn; i++) {
//             for(int j=1; j<pn; j++) {
//                 // if(callings[i].get(map[]) {
//                 //     String temp = players[j-1]; // 앞 번호 poe 
//                 //     players[j-1] = players[j]; // poe 자리에 kai 들어가고 
//                 //     // kai 자리엔 poe 들어가면 됨 
//                 //     players[j] = temp;
//                 // }
//             }
//         }
                // 시간초과 해결을 위한 HashMap 
        for(int i=0; i<pn; i++) {
            map.put(players[i], i);
        }
        
        for(int i=0; i<cn; i++) {
            int index = map.get(callings[i]); // 이름 불린 players 인덱스 번호 추출 
            String front = players[index-1]; // 앞자리 아이 이름 
            // 위치 바꿔주기 
            players[index-1] = players[index];
            players[index] = front;
            // map도 위치 바꿔주기 
            map.put(callings[i], index -1);
            map.put(front, index);
            
        }
        
        return players;
    }
}