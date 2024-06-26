import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		HashSet<String> nolisten = new HashSet<>();
		List<String> nols = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			nolisten.add(br.readLine());
		}
		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			if (nolisten.contains(str)) {
				nols.add(str);
			}
		}
		Collections.sort(nols);
		System.out.println(nols.size());
		for (String name : nols) {
			System.out.println(name);
		}
	}
}