import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Power {
    String name;
    int power;
    int order;
    Power(String name, int power, int order) {
        this.name = name;
        this.power = power;
        this.order = order;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken()); // 칭호 개수
        int M = Integer.parseInt(st.nextToken()); // 캐릭터 개수

        ArrayList<Power> list = new ArrayList<>();

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            list.add(new Power(name, num, i));
        }
        Collections.sort(list, new Comparator<Power>() {
            @Override
            public int compare(Power o1, Power o2) {
                if(o1.power == o2.power) {
                    return Integer.compare(o1.order, o2.order);
                }
                return Integer.compare(o1.power, o2.power);
            }
        });
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(num, N, list)).append('\n');
        }
        System.out.println(sb);
    }
    public static String binarySearch(int num, int N, ArrayList<Power> list) {
        int start = 0;
        int end = N; // 3
        int mid = 0;
        while(start < end) {
            mid = ( start + end ) / 2;
            if(num <= list.get(mid).power) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return list.get(end).name;
    }
}