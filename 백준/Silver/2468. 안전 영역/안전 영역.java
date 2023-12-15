import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int cnt, res, max, N;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int[][] zone; 
	static boolean[][] visited;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		zone = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				zone[i][j] = Integer.parseInt(st.nextToken());
				if(max < zone[i][j]) {
					max = zone[i][j];
				}	
			}
		} // 맵 입력받기 + 최대 높이 구하기 
		
		for(int i=0; i<max+1; i++) { 
			// 최소높이인 1(이 아니라 0부터 시작..물 없는 경우도 생각해야댐)부터 높이 하나씩 반복문 돌려가면서 최대 안전영역 구하기 
			cnt = 0; 
			visited = new boolean[N][N]; // 방문배열은 높이 반복문 돌릴때마다 초기화해주기 
			for(int j=0; j<N; j++) {
				for(int k=0; k<N; k++) {
					if(!visited[j][k] && zone[j][k] > i) { // 잠기지 않아야 댐 
						dfs(j, k, i);
						cnt++;
					}
				}
			} 
			
			res = Math.max(cnt, res);
			
			
		}
	
		System.out.println(res);
		
		
	} // main
	
	static void dfs(int x, int y, int h) {
		visited[x][y] = true;
		
		for(int d=0; d<4; d++) {
			int nx = x + dr[d];
			int ny = y + dc[d];
			
			if(nx >= N || nx < 0 || ny >= N || ny < 0 || visited[nx][ny]) {
				continue;
			}
			
			if(zone[nx][ny] > h ) {
				visited[nx][ny] = true;				
				dfs(nx, ny, h);
			}
			
		}
	}
	
}