

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N =sc.nextInt(); // 설탕kg
		
		if(N==4 || N==7) {
			System.out.println(-1);
		} else if(N%5 == 1 | N%5 == 3) {
			System.out.println(N/5+1);
		} else if(N%5 == 2 | N%5 == 4) {
			System.out.println(N/5+2);
		} else if(N%5 == 0) {
			System.out.println(N/5);
		}
	}

}
