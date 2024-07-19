import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

class CrossCountry {
    int team;
    int count;
    int score;
    int fourthScore;
    int fifth;
    CrossCountry(int team, int count, int score, int fourthScore, int fifth) {
        this.team = team;
        this.count = count;
        this.score = score;
        this.fourthScore = fourthScore;
        this.fifth = fifth;
    }
}

public class Main {
    static HashMap<Integer, Integer> counts = new HashMap<>();
    static ArrayList<CrossCountry> valid = new ArrayList<>();
    static ArrayList<Integer> list = new ArrayList<>();
    static ArrayList<Integer> remove = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());// 테캐
        for(int t=0; t<tc; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 팀 중에서 자격이 안되는 팀은 빼고 다시 점수를 매겨야함 <- 이걸 놓쳐서 fourthScore값이 이상하게 나온 거 
            // counts 세어주고 list에 점수 넣어주기
            valid = new ArrayList<>();
            counts = new HashMap<>();
            list = new ArrayList<>();
            remove = new ArrayList<>();
            for(int i=1; i<=n; i++) {
                int num = Integer.parseInt(st.nextToken());
                counts.put(num, counts.getOrDefault(num, 0)+1);
                list.add(num);
            }
            // hashmap 순회 후 참가 자격되는 팀들로 재정렬
            isRightTeam(counts, list);
            // 4번째 선수까지의 합, 다섯 번째 선수 점수 값 넣기
            putScore(list, valid);
            // 기준 맞춰서 정렬
            sortList(valid);
            bw.write(String.valueOf(valid.get(0).team));
            bw.newLine();

        }
        bw.flush();
        bw.close();
    }

    public static void isRightTeam(HashMap<Integer, Integer> counts, ArrayList<Integer> list) {
        for(Map.Entry<Integer, Integer> entry: counts.entrySet()) {
            if(entry.getValue() == 6) {
                int index = entry.getKey();
                valid.add(new CrossCountry(index, 0,0, 0, 0));
            } else {
                int index2 = entry.getKey();
                remove.add(index2);
            }
        }
        list.removeAll(remove);
    }

    public static void putScore(ArrayList<Integer> list, ArrayList<CrossCountry> valid) {
        for(int i = 0; i<list.size(); i++) {
            for(CrossCountry team: valid) {
                if(team.team == list.get(i)) {
                    team.count++;
                    team.score += i+1;
                    if(team.count == 4) {
                        team.fourthScore = team.score;
                    }
                    if(team.count == 5) {
                        team.fifth = i+1;
                    }
                }

            }
        }
    }

    public static void sortList(ArrayList<CrossCountry> valid) {
        Collections.sort(valid, new Comparator<CrossCountry>() {
            @Override
            public int compare(CrossCountry o1, CrossCountry o2) {
                if(o1.fourthScore == o2.fourthScore) {
                    return Integer.compare(o1.fifth, o2.fifth);
                }
                return Integer.compare(o1.fourthScore, o2.fourthScore);
            }
        });
    }
}