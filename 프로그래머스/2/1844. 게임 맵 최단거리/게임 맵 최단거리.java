import java.util.*;
import java.awt.*;

class Solution {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};
    static boolean[][] visited;
    static int n; static int m;
    static Point p = new Point();
    
    public int solution(int[][] maps) {
        int answer = 0;
        n = maps.length;
        m = maps[0].length;
        
        visited = new boolean[n][m];
        answer = bfs(maps, 0, 0);
        
        return answer;
    }
    public static int bfs(int[][] maps, int x, int y) {
        visited[x][y] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        
        while(!queue.isEmpty()) {
            Point now = queue.poll();
            int nowr = now.x;
            int nowc = now.y;
            for(int d=0; d<4; d++) {
                int nr = nowr + dr[d];
                int nc = nowc + dc[d];
                if(nr >= 0 && nc >= 0 && nr < n && nc < m && !visited[nr][nc] && maps[nr][nc] == 1) {
                    queue.add(new Point(nr, nc));
                    maps[nr][nc] = maps[nowr][nowc] + 1;
                    visited[nr][nc] = true;
                } 
            }
        }
        if(maps[n-1][m-1] == 1) {
            return -1;
        } else {
            return maps[n-1][m-1];
        }
        
    }
}