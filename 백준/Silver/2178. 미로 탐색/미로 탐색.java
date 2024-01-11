import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int cnt;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static int[][] map;
    static boolean[][] visited;
    static Point p = new Point();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }

        BFS(0, 0);
        System.out.println(map[N-1][M-1]);

    }
    public static void BFS(int x, int y){
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Point(x, y));

        while(!queue.isEmpty()){
            Point now = queue.poll();
            int nowr = now.x;
            int nowc = now.y;
            for(int d=0; d<4; d++){
                int nr = nowr + dr[d];
                int nc = nowc + dc[d];
                if(nr >= 0 && nc >= 0 && nr < N && nc < M && !visited[nr][nc] && map[nr][nc] == 1){
                    queue.add(new Point(nr, nc));
                    map[nr][nc] = map[nowr][nowc] + 1;
                    visited[nr][nc] = true;
                }
            }
        }
    }
}