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

        long currentPrice = oils.get(0).cost; // 첫번째 충전값 저장
        long answer = 0;
       
        for(int i=0; i<N-1; i++) {
            answer += currentPrice * oils.get(i).dist;
            if(currentPrice > oils.get(i+1).cost) {
                currentPrice = oils.get(i+1).cost;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }
}