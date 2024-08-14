import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int ver, par, psize;
	static int[][] painting;
	static boolean[][] visited;
	static int max = 0; // 제일 큰 거  
	static int cnt = 0; // 그림 개수 
	static int[] dx = {0, 1, 0, -1};
	static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ver = Integer.parseInt(st.nextToken());
		par = Integer.parseInt(st.nextToken());
		
		painting = new int[ver][par];
		visited = new boolean[ver][par];
		psize = 0;
		
		for(int i=0; i<ver; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<par; j++) {
				painting[i][j] = Integer.parseInt(st.nextToken());
			}
		}
	
		for(int i=0; i<ver; i++) {
			for(int j=0; j<par; j++) {
				if(!visited[i][j] && painting[i][j] == 1) {
					psize = 1;
					cnt ++;
					dfs(i, j);
					if(max<psize) {
						max = psize;
					}
				}
			}
		}
		System.out.println(cnt);
		System.out.println(max);

	} // main 
	
	public static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int d=0; d<4; d++) {
			int nx = x+dx[d];
			int ny = y+dy[d];
			
			
			if(nx>=ver || nx < 0 || ny >= par || ny < 0) {
				continue;
			}
			if(painting[nx][ny] == 0 || visited[nx][ny]) {
				continue;
			}
			
			visited[nx][ny] = true;
			psize++;
			dfs(nx, ny);
			
			
		}
		
		
	}

}