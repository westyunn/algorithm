import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M, stR, stC, fnR, fnC;
    static char[][] map;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M];
        stR = -1; stC = -1; fnR = -1; fnC = -1;

        for(int i=0; i<N; i++){
            String str = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = str.charAt(j);
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == '.'){
                    if( i == 0 || i == N-1 || j == 0 || j == M-1 ) {
                        if(stR == -1) {
                            stR = i;
                            stC = j;
                        } else {
                        fnR = i;
                        fnC = j;
                        }

                    }
                    map[i][j] = '@';
                }
            }
        }
        DFS(stR, stC);
        System.out.print(sb.toString());

    }

    public static void DFS(int x, int y){
        visited[x][y] = true;
        map[x][y] = '.';
        if(x == fnR && y == fnC ){
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    sb.append(map[i][j]);
                }
                sb.append('\n');
            }
        }
        for(int d=0; d<4; d++) {
            int nr = x + dr[d];
            int nc = y + dc[d];
            if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && map[nr][nc] == '@') {
                map[nr][nc] = '.';
                DFS(nr, nc);
                map[nr][nc] = '@';
                visited[nr][nc] = false;
            }
        }
    }
}