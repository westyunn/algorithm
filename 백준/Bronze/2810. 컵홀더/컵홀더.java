

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// *S *L L *S* S* -> N=5, max = 5 커플 한쌍일 땐 그대로 
		// * S * L L * L L * S * S * -> N=7, max= 6 두쌍일땐 S 개수 상관없이 -1씩
		// * L L  * L L * -> N=4, max=3 
		// *L L *S* L L* -> N=5, max=4  
		// * L L * L L*  L L*  S* -> N=7, max =5 세쌍일땐 -2
		// * L L * L L * S * L L * L L * -> N=9, max=6 네쌍일땐 -3
		// max값은 N-커플수+1(홀짝수 상관ㄴㄴ) 해주면 됨 근데 한쌍일 경우면 n고대로 출력 가넝.
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt(); // 좌석 수(사람 수)
		String str = sc.next();
		int co = 0; // 커플 수 세어주기
		
		for(int i=0;i<N;i++) {
			str.charAt(i);
			
			if(str.charAt(i) == 'L') {
				co++;
				i++; // LL은 한묶음이니까 인덱스 하나 넘겨 
			}
		}
		if(co>1) {
			System.out.println(N-co+1);
		} else {
			System.out.println(N);
		}
		
		
		

	}

}
