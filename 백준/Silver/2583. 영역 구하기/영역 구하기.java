import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[] dr = {0, 0, -1 ,1};
    static int[] dc = {-1, 1, 0, 0};
    static boolean visited[][];
    static int square[][];
    static ArrayList<Integer> area = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

       square = new int[M][N]; visited = new boolean[M][N];
        for(int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            for(int r=y1; r<y2; r++) {
                for(int c=x1; c<x2; c++) {
                    square[r][c] = 1;
                    visited[r][c] = true;
                }
            }
        }

        for(int i=0; i<M; i++) {
            for(int j=0; j<N; j++) {
                if(!visited[i][j] && square[i][j] == 0) {
                    area.add(bfs(i, j, M, N));
                }
            }
        }
        Collections.sort(area);
       sb.append(area.size()).append('\n');
       for(int i=0; i<area.size(); i++) {
           sb.append(area.get(i)+" ");
       }
        System.out.println(sb);
    }

    public static int bfs (int r, int c, int M, int N) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(r, c));
        visited[r][c] = true;
        int area = 1;
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int nowr = now.x;
            int nowc = now.y;
            for(int d=0; d<4; d++) {
                int nr = nowr + dr[d];
                int nc = nowc + dc[d];
                if( nr >= 0 && nc >= 0 && nr < M && nc < N && !visited[nr][nc] && square[nr][nc] == 0) {
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    area++;
                }
            }
        }
        return area;
    }
}