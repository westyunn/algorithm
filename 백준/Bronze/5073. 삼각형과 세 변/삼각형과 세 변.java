import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            String str = br.readLine();
            if(str.equals("0 0 0")) break;

            String[] tmp = str.split(" ");
            int isSame = 0;
            int[] triangle = new int[3];
            for(int i=0 ;i<3; i++) {
                triangle[i] = Integer.parseInt(tmp[i]);
            }
            Arrays.sort(triangle);
            if(triangle[2] >= triangle[0] + triangle[1]) {
                    System.out.println("Invalid");
                    continue;
            }
            // 총 세번 비교해서 카운트가 3번되면 Equilateral, 2번이면 Isosceles, 1번이면 어쩌구, 변 길이에 따라서 조건 부합안하면 invalid
            // 01 02 12
            for(int i=0; i<2; i++) {
                for(int j=i+1; j<3; j++) {
                    if(triangle[i] == triangle[j]) {
                        isSame++;
                    }
                }
            }
            if(isSame == 3) {
                System.out.println("Equilateral");
            } else if(isSame == 1) {
                System.out.println("Isosceles");
            } else if(isSame == 0) {
                System.out.println("Scalene");
            }
        }
    }
}