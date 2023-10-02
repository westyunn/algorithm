import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] rgb;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine()); // 집 수

		rgb = new int[N + 1][3];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				rgb[i][j] = Integer.parseInt(st.nextToken());
			}
		} // 정보 입력
		for (int i = 1; i <= N; i++) {
			rgb[i][0] += Math.min(rgb[i - 1][1], rgb[i - 1][2]); // R
			rgb[i][1] += Math.min(rgb[i - 1][0], rgb[i - 1][2]);
			rgb[i][2] += Math.min(rgb[i - 1][0], rgb[i - 1][1]);
		}
		int result = Math.min(Math.min(rgb[N][0], rgb[N][1]), rgb[N][2]); // min은 두개까지만 비교 가넝
		System.out.println(result);
	}

}