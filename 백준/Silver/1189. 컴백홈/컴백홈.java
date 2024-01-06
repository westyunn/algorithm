import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int R, C, K;
    static int cnt, ans;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static char[][] map;
    static boolean [][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken()); // 세로
        C = Integer.parseInt(st.nextToken()); // 가로
        K = Integer.parseInt(st.nextToken()); // 거리 수
        map = new char [R][C];
        visited = new boolean[R][C];
        for(int i=0; i<R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);

            }
        } // 입력받기 완료

        dfs(R-1, 0, 1); // 출발점은 왼쪽 아래
        System.out.println(ans);

    }
    public static void dfs(int x, int y, int h){
       if(x == 0 && y == C - 1){ // 도착점인 오른쪽 위에 다다랐을 때 
           if(h == K) { // k만큼 높이가 쌓였으면 
               ans++; // 가짓수 +1 
               return; 
           }
       }

        visited[x][y] = true; // 방문처리해주기 

        for(int d=0; d<4; d++){
            int nr = x + dr[d]; 
            int nc = y + dc[d];
            if(nr < R && nr >= 0 && nc < C && nc >= 0 && map[nr][nc] != 'T' && !visited[nr][nc]){
                visited[nr][nc]=true;
            dfs(nr, nc, h+1);
            visited[nr][nc] = false;
            }


        }
    }
}