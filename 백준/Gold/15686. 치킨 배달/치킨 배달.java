import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int N, M, dist, temp;
	static int[][] city;
	static boolean[] visited;
	static int result = Integer.MAX_VALUE;
	static List<Point> ch = new ArrayList<>();
	static List<Point> home = new ArrayList<>();

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		city = new int[N + 1][N + 1];

		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= N; j++) {
				city[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 정보 입력 받ㄱㅣ

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (city[i][j] == 2) {
					ch.add(new Point(i, j)); // 치킨집 좌표 저장
				} 
				if (city[i][j] == 1) {
					home.add(new Point(i, j)); // 집 좌표 저장
				}

			}
		}

		visited = new boolean[ch.size()];
		
		dfs(0, 0);
		
		System.out.println(result);

	}

	// 조합으로
	public static void dfs(int cnt, int idx) {
		if (cnt == M) {
			calculateD();
			return;
		}
		for (int i = idx; i < ch.size(); i++) {
			visited[i] = true;
			dfs(cnt + 1, i + 1);
			visited[i] = false;
		}

	}

	public static void calculateD() {
		temp = 0; // temp 값 초기화
		for (int i = 0; i < home.size(); i++) {
			int min = Integer.MAX_VALUE;
			for (int j = 0; j < ch.size(); j++) {
				if(visited[j]) { // 선택된 치킨집만 ******
					int tmp = Math.abs(home.get(i).x - ch.get(j).x) + Math.abs(home.get(i).y - ch.get(j).y);
					min = Math.min(tmp, min);					
				}
			}
			temp += min;
		}
		
		result = Math.min(result, temp);
	}

}