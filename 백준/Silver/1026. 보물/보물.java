import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine()); // 길이가 N인 정수 배열 A, B의 크기

		int[] arr_a = new int[N];
		int[] arr_b = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr_a[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr_b[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr_a);
		Arrays.sort(arr_b);
		
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += arr_a[i] * arr_b[N - 1 - i];
		}

		System.out.println(sum);

	}

}