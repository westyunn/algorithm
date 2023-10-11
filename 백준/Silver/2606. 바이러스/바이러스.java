import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int cnt=0;
	static boolean[] visited;
	static int[][] virus;
	// 인접 행렬 이용해서도 풀어보기 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[N+1];
		virus = new int[N+1][N+1];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			virus[u][v]=virus[v][u]=1;
		}
		dfs(1);
		System.out.println(cnt);
		
		
	}
	public static void dfs(int idx) {
		visited[idx] = true;
		for(int i=1; i<=N; i++) {
			if(!visited[i]&&virus[idx][i]==1) {
				cnt++;
				dfs(i);
			}
		}
		
	}

}