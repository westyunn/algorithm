import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] dr = {-1, 1, 0, 0, 1, -1, 1, -1};
    static int[] dc = {0, 0, -1, 1, 1, 1, -1, -1};
    static int[][] map;
    static boolean[][] visited;
    static int cnt;
    static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); // 세로
        M = Integer.parseInt(st.nextToken()); // 가로

        map = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] != 0 && !visited[i][j]){
                    flag = true;
                    BFS(i, j, map[i][j]);
                    if(flag) cnt++;
                }
            }
        }

        System.out.println(cnt);

    }

    public static void BFS(int x, int y, int height){
        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.add(new Point(x, y));
        while(!queue.isEmpty()){
            Point now = queue.poll();
            int nowr = now.x;
            int nowc = now.y;
            for(int d=0; d<8; d++){
                int nr = nowr + dr[d];
                int nc = nowc + dc[d];
                if(nr >= 0 && nr < N && nc >= 0 && nc < M){ // 범위 내에 있음 - 조건1
                    if(map[nr][nc] > height){ // 다음으로 갈 좌표값이 현재값보다 크면 현재값은 산봉우리가 아님. 돌아가~
                        flag = false;
                    } else if(!visited[nr][nc] && map[nr][nc] == height){
                        queue.add(new Point(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
        }


    }
}