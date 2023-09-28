import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();

		int N = Integer.parseInt(br.readLine());
		int[] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(br.readLine());
		}
		int st = 0;
		for (int i = 0; i < N; i++) {

			if (num[i] > st) {
				for (int j = st + 1; j <= num[i]; j++) {
					stack.push(j);
					sb.append('+').append('\n');
				}
				st = num[i];
			}

			if (stack.isEmpty() || stack.pop() != num[i]) {
				System.out.println("NO");
				return;
			}
			sb.append('-').append('\n');

		}

		System.out.println(sb);

	}
}