import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M; // n은 상근이 동기수 m은 리스트 길이
    static int cnt;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        list = new ArrayList<>();
        N = Integer.parseInt(st.nextToken()); // 상동수
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken()); // 명단

        for(int i=0; i<=N; i++){
            list.add(new ArrayList<>());
        }
        visited = new int[N+1];
        visited[1] = 1; // 상근이
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }

        DFS(1, 0);
        for(int i=2; i<visited.length; i++) { // 1은 상근이마이셀프
            if(visited[i] == 1){
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    public static void DFS(int start, int depth){
        if(depth == 2) {
            return; // 친구의 친구까지만 ㄱㄴ
        }
        for(int st: list.get(start)){
//            if(visited[st] == 0){ // if를 없애야 친구의 친구 노드 방문 체크도 가능함 (1->2->3 체크되면 3은 4체크 못하고 2, 3만 방문노드로 찍힘)
                visited[st] = 1;
                DFS(st, depth+1);
//            }
        }
    }

}