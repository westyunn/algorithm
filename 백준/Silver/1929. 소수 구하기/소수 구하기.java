import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> list = new ArrayList<>();

		int M = sc.nextInt();
		int N = sc.nextInt();
		int[] num = new int[N - M + 1];
		for (int i = 0; i < num.length; i++) {
			num[i] = i + M;
		}

		for (int i = 0; i < num.length; i++) {
			if (num[i] == 1) {
				continue;
			}
			boolean prime = true;
			for (int j = 2; j * j <= num[i]; j++) {
				if (num[i] % j == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				list.add(num[i]);
			}

		} // for
		Collections.sort(list);

		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}