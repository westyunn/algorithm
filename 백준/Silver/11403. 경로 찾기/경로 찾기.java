import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] map;
    static int[][] result;
    static boolean[] visited;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        result = new int[N][N];
        visited = new boolean[N];
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 0 -> 1 1이고 1 -> 2 도 1이니까 0 -> 2 1이 됨
        for(int i=0; i<N; i++) {
            dfs(i);
            for(int j=0; j<N; j++) {
                if(visited[j]) result[i][j] = 1;
            }
            visited = new boolean[N];
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void dfs(int start) {
//        visited[start] = true;
        for(int i=0; i<N; i++) {
            if(map[start][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i);
            }
        }
    }
}