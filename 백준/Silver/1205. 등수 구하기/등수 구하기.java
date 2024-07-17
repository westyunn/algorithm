import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Ranks {
    int score;
    int rank;
    int isNew;
    int index;
    Ranks (int score, int rank, int isNew, int index) {
        this.score = score;
        this.rank = rank;
        this.isNew = isNew;
        this.index = index;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 리스트 점수 개수
        int newScore = Integer.parseInt(st.nextToken()); // 새로운 점수
        int P = Integer.parseInt(st.nextToken()); // 랭킹 리스트에 올라갈 수 있는 점수 개수
        ArrayList<Ranks> list = new ArrayList<>();
        if(N > 0) {
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++) {
                list.add(new Ranks(Integer.parseInt(st.nextToken()), 0, 0, 0));
            }
        }
        list.add(new Ranks(newScore, 0, 1, 0));
        Collections.sort(list, new Comparator<Ranks>() {
            @Override
            public int compare(Ranks o1, Ranks o2) {
                if(o1.score == o2.score) {
                    return Integer.compare(o1.isNew, o2.isNew);
                }
                return Integer.compare(o2.score, o1.score);
            }
        });
        int currentRank = 1; int sameRank = 0; int previousScore = -1;
        for(int i=0; i<list.size(); i++) {
            Ranks now = list.get(i);
            if(now.score == previousScore) {
                sameRank++;
            } else {
                currentRank += sameRank;
                sameRank = 1;
            }

            previousScore = now.score;
            list.get(i).rank = currentRank;
            list.get(i).index = i+1;

            if(list.get(i).isNew == 1) {
                if(list.get(i).index > P) {
                    System.out.println(-1);
                    break;
                } else {
                    System.out.println(list.get(i).rank);
                    break;
                }
            }
        }
    }
}