import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

class Cow {
    int enterT;
    int checkT;

    Cow(int enterT, int checkT) {
        this.enterT = enterT;
        this.checkT = checkT;
    }

}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());
        Cow[] cows = new Cow[num];
        for(int i=0; i<num; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int enter = Integer.parseInt(st.nextToken());
            int check = Integer.parseInt(st.nextToken());
            cows[i] = new Cow(enter, check);
        }
        int now = 0;
        // 입장 순서대로 정렬
        Arrays.sort(cows, Comparator.comparing(c->c.enterT));
        for(Cow cow: cows) {
            // 입장 초보다 현재가 더 빠르면 무조건 입장초가 현재가 되어줘야 함
            if(now < cow.enterT) {
                now = cow.enterT;
            }
            now += cow.checkT;
        }
        System.out.println(now);
    }
}