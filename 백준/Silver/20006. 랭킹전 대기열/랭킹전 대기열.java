import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class WaitingRoom {
    int count;
    int minLevel;
    int maxLevel;
    boolean isFull;
    ArrayList<Players> p;
    WaitingRoom(int count, int minLevel, int maxLevel, boolean isFull, ArrayList<Players> p) {
        this.count = count;
        this.minLevel = minLevel;
        this.maxLevel = maxLevel;
        this.isFull = isFull;
        this.p = p;
    }
}

class Players {
    int level;
    String nickname;
    Players(int level, String nickname) {
        this.level = level;
        this.nickname = nickname;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int nums = Integer.parseInt(st.nextToken()); // 플레이어 수
        int limit = Integer.parseInt(st.nextToken()); // 각 방의 정원 수
        ArrayList<WaitingRoom> list = new ArrayList<>();
        ArrayList<Players> player = new ArrayList<>();
        for(int i=0; i<nums; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String nickname = st.nextToken();
            player.add(new Players(level, nickname));
        }

        for(int i=0; i<nums; i++) {
            int level = player.get(i).level;
            String nickname = player.get(i).nickname;
            boolean flag = false;
            for(WaitingRoom w: list) {
                if(w.minLevel <= level && w.maxLevel >= level && w.count < limit) {
                    flag = true;
                    w.count++;
                    if(w.count == limit) {
                        w.isFull = true;
                    }
                    w.p.add(new Players(level, nickname));
                    break;
                }
            }
            if(!flag) {
                ArrayList<Players> p = new ArrayList<>();
                p.add(new Players(level, nickname));
                if(limit == 1) {
                    list.add(new WaitingRoom(1, level - 10, level +10, true, p));
                } else {
                    list.add(new WaitingRoom(1, level - 10, level +10, false, p));
                }
            }
        };

        // 사전순 정렬
        for(int i=0; i<list.size(); i++) {
            Collections.sort(list.get(i).p, new Comparator<Players>() {
                @Override
                public int compare(Players o1, Players o2) {
                    return o1.nickname.compareTo(o2.nickname);
                }
            });
        }
        // 출력
        for(WaitingRoom w: list) {
            if(w.isFull) {
                sb.append("Started!").append('\n');
            } else {
                sb.append("Waiting!").append('\n');
            }
            for(int j=0; j<w.p.size(); j++) {
                sb.append(w.p.get(j).level+" "+w.p.get(j).nickname).append('\n');
            }
        }
        System.out.println(sb);


    }
}