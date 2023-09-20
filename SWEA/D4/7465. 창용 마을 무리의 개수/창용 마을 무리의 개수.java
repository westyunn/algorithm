import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static int N, M, cnt;
	public static int[][] vilage;
	public static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());

		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			cnt = 0;
			vilage = new int[N + 1][N + 1];
			visited = new boolean[N + 1];
			
			for(int i=0; i<M; i++) {
				 st = new StringTokenizer(br.readLine());
				 int a = Integer.parseInt(st.nextToken());
				 int b = Integer.parseInt(st.nextToken());
				 
				 vilage[a][b] = vilage[b][a] = 1;
			}
			for(int i=1; i<=N; i++) {
				if(!visited[i]) {
					dfs(i);
					cnt++;
				}
			}
			System.out.println("#"+tc+" "+cnt);
		} // for

	} // main

	public static void dfs(int idx) {
		visited[idx] = true;
		
		for(int i=1; i<=N; i++) {
			if(!visited[i] && vilage[idx][i] == 1) {
				dfs(i);
			}
		}
	}

}