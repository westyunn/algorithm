import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<ArrayList<Integer>> friends = new ArrayList<>();
    static boolean[] visited;
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 친구 수
        M = Integer.parseInt(st.nextToken()); // 간선 수

        // 그래프 초기화
        for(int i=0; i<N; i++) {
            friends.add(new ArrayList<Integer>());
        }

        visited = new boolean[N];

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            friends.get(a).add(b);
            friends.get(b).add(a);
        }

        for(int i=0; i<N; i++) {
            visited = new boolean[N];
            dfs(i, 1);
            if(flag) break;
        }

        if(!flag) System.out.println(0);
        else System.out.println(1);




    }

    public static void dfs(int start, int depth) {
        if(depth == 5) {
            flag = true;
            return;
        }
        visited[start] = true;
        for(int v: friends.get(start)) {
            if (!visited[v]) {
                dfs(v, depth+1);
            }
        }
        visited[start] = false;
    }
}