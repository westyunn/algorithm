import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dr = {-1, 1, 0, 0, -1, 1, -1, 1};
    static int[] dc = {0, 0, -1, 1, -1, 1, 1, -1};
    static int cnt;
    static int w, h;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken()); // 너비
            h = Integer.parseInt(st.nextToken()); // 높이
            cnt = 0;
            if(w == 0 && h ==0) break;
            map = new int[h][w];
            visited = new boolean[h][w];
            for(int i=0; i<h; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i=0; i<h; i++) {
                for(int j=0; j<w; j++) {
                    if(map[i][j] == 1 && !visited[i][j]) {
                        dfs(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append('\n');
        } // while
        System.out.println(sb);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for(int d=0; d<8; d++) {
            int nr = x + dr[d];
            int nc = y + dc[d];
            if(nr >= 0 && nc >= 0 && nr < h && nc < w && !visited[nr][nc] && map[nr][nc] == 1) {
                dfs(nr, nc);
            }
        }
    }
}