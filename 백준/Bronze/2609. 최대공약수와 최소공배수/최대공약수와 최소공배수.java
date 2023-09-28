import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		int max = Math.max(n1, n2);
		int min = Math.min(n1, n2);

		for (int i = max; i >= 0; i--) {
			if ((n1 % i) == 0 && (n2 % i) == 0) {
				System.out.println(i);
				break;
			}
		}
		for (int i = 1; i <= 10000; i++) {
			if ((max * i) % min == 0) {
				System.out.println(max * i);
				break;
			}
		}

	}

}