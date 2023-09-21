import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static int R, C;// 가로 세로 
	public static int maxDepth=0;
	public static char[][] board;
	public static boolean[] visited;
	public static int[] dx = {0, 1, 0, -1};
	public static int[] dy = {1, 0, -1, 0};
//	public static ArrayList<Character> alpha = new ArrayList<>(); 어레이리스트 왜 쓰면 안되지 
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		board = new char[R][C];
		visited = new boolean[26]; // 알파벳 방문 처리 배열 

		
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				board[i][j] = str.charAt(j);
			}
		}
		
		
		dfs(0,0,1);
		System.out.println(maxDepth);
	}
	
	public static void dfs(int x, int y, int depth) {
		visited[board[x][y]-'A'] = true;
		maxDepth = Math.max(depth, maxDepth);
		for(int d =0 ; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx >=R || nx < 0 || ny >=C || ny < 0) {
				continue;
			} 
			if (visited[board[nx][ny]-'A'] || board[nx][ny] == board[x][y]) {
				continue;
			} 

			visited[board[nx][ny]-'A'] = true;
			dfs(nx, ny, depth+1);
			visited[board[nx][ny]-'A'] = false;
			
			
		}
		
		
		
	}
	
}