import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int H, W;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); // 높이
            W = Integer.parseInt(st.nextToken()); // 너비

            map = new char[H][W];
            visited = new boolean[H][W];
            int cnt = 0;
            for(int i=0; i<H; i++){
                String str=br.readLine();
                for(int j=0; j<W; j++){
                    map[i][j] = str.charAt(j);
                }
            }
            for(int i=0; i<H; i++){
                for(int j=0; j<W; j++)  {
                    if(!visited[i][j] && map[i][j] == '#') {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }
            System.out.println(cnt);

        } // testcase

    } // main
    public static void dfs(int x, int y){
        visited[x][y] = true;
        for(int d=0; d<4; d++){
            int nr = x + dr[d];
            int nc = y + dc[d];
            if(nr < 0 || nr >= H || nc < 0 || nc >= W ) {
                continue;
            }
            if( map[nr][nc] == '.' || visited[nr][nc] ){
                continue;
            }
            dfs(nr, nc);
        }
    }
}