import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Medal {
    int country;
    int gold;
    int silver;
    int bronze;

    Medal(int country, int gold, int silver, int bronze) {
        this.country = country;
        this.gold = gold;
        this.silver = silver;
        this.bronze = bronze;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Medal> list = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken()); // 국가 수
        int K = Integer.parseInt(st.nextToken()); // 등수를 알고싶은 국가
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.add(new Medal(n, g, s, b));
        }
        Collections.sort(list, new Comparator<Medal>() {
            @Override
            public int compare(Medal o1, Medal o2) {
                if(o1.gold == o2.gold) {
                    if(o1.silver == o2.silver) {
                        return Integer.compare(o2.bronze, o1.bronze);
                    }
                    return Integer.compare(o2.silver, o1.silver);

                }
                return Integer.compare(o2.gold, o1.gold);
            }
        });

        int currentRank = 1; // 현재 등수
        int previousGold = -1; // 이전 국가의 금메달 수
        int previousSilver = -1; // 이전 국가의 은메달 수
        int previousBronze = -1; // 이전 국가의 동메달 수
        int sameRankCount = 0; // 공동 등수 카운트

        for(int i = 0; i<list.size(); i++) {
            Medal current = list.get(i);
            // 이전 국가와 메달이 모두 같다면 공동 등수 카운트
            if(current.gold == previousGold && current.silver == previousSilver && current.bronze == previousBronze) {
                sameRankCount++;
            } else {
                currentRank += sameRankCount;
                sameRankCount = 1; // 초기화
            }

            previousBronze = current.bronze;
            previousSilver = current.silver;
            previousGold = current.gold;

            if(list.get(i).country == K) {
                System.out.println(currentRank);
                break;
            }
        }
    }
}