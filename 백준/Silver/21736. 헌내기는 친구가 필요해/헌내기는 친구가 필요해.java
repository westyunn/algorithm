import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, cnt;
	static String ans;
	static char[][] friend;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 가로
		M = Integer.parseInt(st.nextToken()); // 세로
		cnt = 0;
		friend = new char[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				friend[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(friend[i][j] == 'I') {
					dfs(i, j);
					if(cnt>=1) {
						ans = String.valueOf(cnt);
					} else {
						ans = "TT";
					}
				}
			}
		}
		System.out.println(ans);

	} // main

	public static void dfs(int x, int y) {
		visited[x][y] = true;

		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];

			if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
				continue;
			}
			if(friend[nx][ny]=='X' || visited[nx][ny]) {
				continue;
			}
			
			if(friend[nx][ny] == 'P') {
				cnt++;
			} 
			
			visited[nx][ny] = true;
			dfs(nx, ny);
		}
	}

}