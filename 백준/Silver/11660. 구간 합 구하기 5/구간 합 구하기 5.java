import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 표 크기
        int m = Integer.parseInt(st.nextToken()); // 합 구해야하는 횟수
        int[][] map = new int[n+1][n+1]; // 원본 숫자 배열
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[][] sum = new int[n+1][n+1]; // 누적합 배열
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                sum[i][j] = map[i][j] + sum[i][j-1] + sum[i-1][j] - sum[i-1][j-1];
            }
        }

        ArrayList<Point[]> list = new ArrayList<>();
        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            list.add(new Point[]{new Point(x1, y1), new Point(x2, y2)});
        }
        int answer = 0;
        for(int i=0; i<list.size(); i++) {
            int r2 = list.get(i)[1].x;
            int c2 = list.get(i)[1].y;
            int r1 = list.get(i)[0].x;
            int c1 = list.get(i)[0].y;
            answer = sum[r2][c2] - (sum[r2][c1-1] + sum[r1-1][c2]) + sum[r1-1][c1-1];
            System.out.println(answer);
        }

    }
}