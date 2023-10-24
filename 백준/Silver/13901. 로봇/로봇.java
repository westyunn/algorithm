import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int R, C, k, c;
	static int sr, sc;
	static int[] d ;
	static int[][] del = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	// 원점 상 하 좌 우 
	static int[][] map;
	

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken()); // 맵의 세로
		C = Integer.parseInt(st.nextToken()); // 맵의 가로 
		
		map = new int[R][C];
		
		st = new StringTokenizer(br.readLine()); 
		
		k = Integer.parseInt(st.nextToken()); // 장애물 개수 

		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int kr = Integer.parseInt(st.nextToken());
			int kc = Integer.parseInt(st.nextToken());
			
			map[kr][kc] = 1;
			
		}
		st = new StringTokenizer(br.readLine());
		
		sr = Integer.parseInt(st.nextToken()); // 시작점 
		sc = Integer.parseInt(st.nextToken());	
		
		map[sr][sc] = 1;
		
		st = new StringTokenizer(br.readLine());
		
		d = new int[4];
		
		for(int i=0; i<4; i++) {
			d[i] = Integer.parseInt(st.nextToken());
		} // 입력하다 시간 다 가겟어 
		
		robot(sr, sc);
		
		System.out.println(sr+" "+sc);
		
		
	}
	
	public static void robot(int x, int y) {
		int currx = x;
		int curry = y;
		int cnt =0 ;
		while(true) {
			int nx = currx + del[d[cnt]-1][0];
			int ny = curry + del[d[cnt]-1][1];
			
			if(nx < R && ny < C && nx >= 0 && ny >= 0 && map[nx][ny] == 0) {
				map[nx][ny] = 1;
				currx = nx;
				curry = ny;
				c = 0; // 방향 카운트 초기화시켜줭 
			} else { // 못가면 방향 돌려야지 머
				cnt = (cnt+ 1) % 4; // 다른 방향 ㄱ 
				c++;
			}
			
			if(c == 4) { // 4방향 다 돌았으면 더 이상 돌 곳 없는 
				break;
			}
			
			
		}
		
		sr = currx;
		sc = curry;

		
		
			
			
			
			
		
		
		
		
	}

}