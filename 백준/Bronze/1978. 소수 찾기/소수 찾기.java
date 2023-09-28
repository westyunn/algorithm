import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int st = 0;
		int cnt = 0;
		int[] num = new int[N];

		for (int i = 0; i < N; i++) {
			num[i] = sc.nextInt();
		}
		for (int i = 0; i < N; i++) {
			if (num[i] <= 1)
				continue;

			boolean prime = true;
			for (int j = 2; j * j <= num[i]; j++) {
				if (num[i] % j == 0) {
					prime = false;
					break;
				}
			}
			if (prime) {
				cnt++;
			}
		}

		System.out.println(cnt);

	}

}