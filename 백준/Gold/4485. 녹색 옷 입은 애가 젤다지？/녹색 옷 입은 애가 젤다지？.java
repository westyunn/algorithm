import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] cost;
    static boolean[][] visited;
    static int[] dr = {-1, 1, 0, 0};

    static int[] dc = {0, 0, -1, 1};
    static int value = Integer.MAX_VALUE;
    static Point p = new Point();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = 0;
        while(true) {
            tc++; // 테캐
            int n = Integer.parseInt(br.readLine());
            if(n == 0) break; // 0 입력받을때 종료
            map = new int[n][n];
            visited = new boolean[n][n];
            cost = new int[n][n];
            for(int i=0; i<n; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    cost[i][j] = Integer.MAX_VALUE; // 최댓값으로 초기화시켜주기
                }
            }
            System.out.println("Problem "+tc+": "+bfs(0, 0, n));
        }
    }
    public static int bfs(int x, int y, int size) {
        // 우선순위큐로 구현 (point 값 cost배열 참조해서 비교)
        PriorityQueue<Point> queue = new PriorityQueue<>((a, b)-> cost[a.x][a.y] - cost[b.x][b.y]);
        visited[x][y] = true;
        queue.add(new Point(x, y));
        cost[0][0] = map[0][0];
        while (!queue.isEmpty()) {
            Point now = queue.poll();
            int nowr = now.x;
            int nowc = now.y;
            for (int d = 0; d < 4; d++) {
                int nr = nowr + dr[d];
                int nc = nowc + dc[d];
                if (nr >= 0 && nc >= 0 && nr < size && nc < size && !visited[nr][nc]) {
                    visited[nr][nc] = true; // 방문 표시
                    // 루피값 
                    int newCost = cost[nowr][nowc] + map[nr][nc];
                    if(newCost < cost[nr][nc]) {
                        // 루피 최솟값 갱신 
                        cost[nr][nc] = newCost;
                        queue.add(new Point(nr, nc));
                    }

                }
            }
        }
        return cost[size-1][size-1];
    }
}