import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Set<String> set = new HashSet<>(); // 중복 걸러야하니까 해쉬셋 쓰기 ㅎㅋ 문제 똑바로 읽자..
		int N = Integer.parseInt(br.readLine());
		String[] word = new String[N];
		for (int i = 0; i < N; i++) {
			word[i] = br.readLine();
			set.add(word[i]);
		}
		ArrayList<String> list = new ArrayList<>(set); // HashSet은 정렬 불가라 얘 담을 list생성해주기

		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				int cc = o1.length() - o2.length(); // 문자열길이로 비교

				if (cc == 0) { // 문자열 같으면
					return o1.compareTo(o2); // 사전순
				} else {
					return cc; // 아니면 걍 원래대로 문자열 길이로
				}
			}

		});

		for (String str : list) {
			System.out.println(str);
		}

	}

}