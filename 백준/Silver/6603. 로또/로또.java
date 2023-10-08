import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static int S;
	public static int R = 6;
	public static int[] arr;
	public static int[] lotto; // 내가 선택한 로또번호 넣는 배열

	public static void main(String[] args) {
		// 전체 S개의 원소 중에서 6개 뽑는 거니까 조합
		Scanner sc = new Scanner(System.in);
		while (true) {
			S = sc.nextInt(); // 원소 수
			if (S == 0) {
				break;
			}
			arr = new int[S];
			lotto = new int[R];

			for (int i = 0; i < S; i++) {
				arr[i] = sc.nextInt();
			}
			combination(0, 0);
			System.out.println();
		} // while
		
		sc.close(); // 얘 넣어줘야 닫아짐..

	} // main

	public static void combination(int idx, int sidx) {
		// 기저파트
		// sidx가 6이면 다 뽑은거
		if (sidx == R) {
			for (int i = 0; i < R; i++) {
				System.out.print(lotto[i] + " ");
			}
			System.out.println();
			return;
		}
		if (idx == S) {
			return;
		}

		// 재귀파트

		lotto[sidx] = arr[idx];
		combination(idx + 1, sidx + 1); // idx번째 뽑
		combination(idx + 1, sidx); // 안뽑
	}

}