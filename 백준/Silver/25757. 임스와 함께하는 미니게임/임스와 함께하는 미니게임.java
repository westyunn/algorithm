import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 같이 플레이 할 횟수
        String game = st.nextToken(); // 플레이할 게임
        Set<String> set = new HashSet<>();
        for(int i=0; i< N; i++) {
            String name = br.readLine();
            set.add(name);
        }
        ArrayList<String> list = new ArrayList<>(set);
        int countF = 1; int countO = 1;
        int answerF = 0; int answerO = 0;
        switch(game) {
            case "Y":
                System.out.println(list.size());
                break;
            case "F":
                for(int i=0; i<list.size(); i++) {
                    countF++;
                    if(countF == 3) {
                        answerF++;
                        countF = 1;
                    }
                }
                System.out.println(answerF);
                break;
            case "O":
                for(int i=0; i<list.size(); i++) {
                    countO++;
                    if(countO == 4) {
                        answerO++;
                        countO = 1;
                    }
                }
                System.out.println(answerO);
                break;
        }
    }
}