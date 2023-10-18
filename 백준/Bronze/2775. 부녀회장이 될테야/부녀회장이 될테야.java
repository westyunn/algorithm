import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// 점화식 이용해서 풀기

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());

			int[][] D = new int[15][15]; // 1층~14층
			for (int i = 1; i < D.length; i++) {
				D[0][i] = i;
			} // 0층 채워주기 

			for (int i = 1; i < D.length; i++) {
				for (int j = 1; j < D.length; j++) {
					D[i][1] = 1;
					D[i][j] = D[i][j - 1] + D[i - 1][j];
				}
			}
			System.out.println(D[K][N]);

		} // tc

	}

}