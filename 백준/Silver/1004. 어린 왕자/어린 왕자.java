import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Planet {
    int x;
    int y;
    int radius;
    Planet(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        // 출발점(도착점)이 원 안에 있는지 체크 두 점이 같은 원 안에 있으면 해당X
        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int stX = Integer.parseInt(st.nextToken());
            int stY = Integer.parseInt(st.nextToken());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(br.readLine()); // 행성 개수
            ArrayList<Planet> planets = new ArrayList<>();
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                planets.add(new Planet(x, y, r));
            }
            // 점과 점 사이의 거리 계산해서 해당 원 반지름과 비교
            int cnt = 0;
            for(int i=0; i<planets.size(); i++) {
                int x2 = planets.get(i).x;
                int y2 = planets.get(i).y;
                int r = planets.get(i).radius;

                if(isIn(stX, stY, x2, y2, r) && !isIn(endX, endY, x2, y2, r)) {
                    cnt++;
                } else if(!isIn(stX, stY, x2, y2, r) && isIn(endX, endY, x2, y2, r)) {
                    cnt++;
                }
            }
            sb.append(cnt).append('\n');

        }
        System.out.println(sb);
    }
    public static boolean isIn(int x1, int y1, int x2, int y2, int r) {
        double dist = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        return dist<=r; // true면 범위 안 false면 범위 밖
    }

}