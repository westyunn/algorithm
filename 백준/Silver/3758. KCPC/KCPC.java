import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class KCPC {
    int teamId;
    int problemId;
    int score;
    int time;
    KCPC(int teamId, int problemId, int score, int time) {
        this.teamId = teamId;
        this.problemId = problemId;
        this.score = score;
        this.time = time;
    }
}

class WC {
    int teamId;
    Map<Integer, Integer> proScore;
    int wholeScore;
    int count;
    int lastCommit;
    WC(int teamId, Map<Integer, Integer> proScore, int wholeScore, int count, int lastCommit) {
        this.teamId = teamId;
        this.proScore = proScore;
        this.wholeScore = wholeScore;
        this.count = count;
        this.lastCommit = lastCommit;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine()); // 테캐
        for(int t=0; t<tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 팀 개수
            int K = Integer.parseInt(st.nextToken()); // 문제 개수
            int teamN = Integer.parseInt(st.nextToken()); // 우리팀 id
            int M = Integer.parseInt(st.nextToken()); // 로그 엔트리 개수
            ArrayList<KCPC> list = new ArrayList<>();
            ArrayList<WC> scoreList = new ArrayList<>();
            for(int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken()); // 팀 아이디
                int proId = Integer.parseInt(st.nextToken()); // 문제 번호
                int score = Integer.parseInt(st.nextToken()); // 점수
                list.add(new KCPC(id, proId, score, i)); // 일단 리스트에 다 집어넣기
            }

            // 분류는 여기서
            for(KCPC kcpc: list) {
                int id = kcpc.teamId;
                int proId = kcpc.problemId; // 문제별 아이디
                int score = kcpc.score; // 문제별 점수
                int time = kcpc.time;
                boolean found = false;
                boolean proFound = false;
                for(WC wc: scoreList) {
                    if(wc.teamId == id) {
                        found = true;
                        wc.count++;
                        wc.lastCommit = time;
                        if(wc.proScore.get(proId) != null) {
                            proFound = true;
                            if(score > wc.proScore.get(proId)) {
                                // 총점은 문제당 갱신된 점수 - 구점수의 차이값만 더해주면 됨
                                wc.wholeScore += score - wc.proScore.get(proId);
                                wc.proScore.put(proId, score);
                            }
                        }
                        if(!proFound) {
                            wc.proScore.put(proId, score);
                            wc.wholeScore += score;
                        }
//                        System.out.println(id+"팀의 "+proId+"번 점수는 "+wc.proScore.get(proId)+", 총점수는"+wc.wholeScore);
                    }
                }
                if(!found) {
                    Map<Integer, Integer> map = new HashMap<>();
                    map.put(proId, score);
                    scoreList.add(new WC(id, map, score, 1, time));
                }

            }

            sortedList(scoreList);
            int ans = 0;
            for(int i=0; i<scoreList.size(); i++) {
                if(scoreList.get(i).teamId == teamN) {
                    ans = i + 1;
                    break;
                }
            }
            sb.append(ans).append('\n');
        } // tc
        System.out.println(sb);
    } // main

    public static void sortedList(ArrayList<WC> scoreList) {
        Collections.sort(scoreList, new Comparator<WC>() {
            @Override
            public int compare(WC o1, WC o2) {
                if(o2.wholeScore == o1.wholeScore) {
                    if(o1.count == o2.count) {
                        return Integer.compare(o1.lastCommit, o2.lastCommit);
                    }
                    return Integer.compare(o1.count, o2.count);
                }
                return o2.wholeScore - o1.wholeScore;
            }
        });
    }


}