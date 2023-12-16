import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		String[] input = br.readLine().split(" ");
		int pn = Integer.parseInt(input[0]);
		int an = Integer.parseInt(input[1]);

		Map<Integer, String> problem = new HashMap<>();
		Map<String, Integer> problem2 = new HashMap<>();

		for (int i = 1; i <= pn; i++) {
			String pro = br.readLine();
			problem.put(i, pro);
			problem2.put(pro, i);
		}

		for (int i = 0; i < an; i++) {
			String str = br.readLine();
			if (str.charAt(0)-'0' >= 0 && str.charAt(0)-'0' <= 9 ) {
				sb.append(problem.get(Integer.parseInt(str))).append('\n');
			} else {
				sb.append(problem2.get(str)).append('\n');
			}

		}

		System.out.println(sb);
	}

}