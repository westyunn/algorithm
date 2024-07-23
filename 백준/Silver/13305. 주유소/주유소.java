import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class GasStation {
    int dist;
    int cost;
    GasStation(int dist, int cost) {
        this.dist = dist;
        this.cost = cost;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[2][N];
        for(int i=0; i<2; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                if(i == 0 && j == N-1) continue;
                info[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        ArrayList<GasStation> oils = new ArrayList<>();
        for(int i=0; i<N; i++) {
            oils.add(new GasStation(info[0][i], info[1][i]));
        }

        int first = oils.get(0).dist * oils.get(0).cost; // 첫번째 값 저장
        int min = 0;
        // 이전 주유소 충전 비용 * 현 거리랑 현재 주유소 충전 비용 * 현 거리 값 비교해서 작은 거 더해주기
        for(int i=1; i<N; i++) {
            min += Math.min(oils.get(i-1).cost * oils.get(i).dist, oils.get(i).cost * oils.get(i).dist);
        }
        min += first;

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }
}