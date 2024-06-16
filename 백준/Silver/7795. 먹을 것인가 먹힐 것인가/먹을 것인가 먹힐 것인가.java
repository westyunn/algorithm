import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        for(int t=0; t<tc; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int[] arr = new int[A];
            int[] brr = new int[B];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<A; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<B; i++) {
                brr[i] = Integer.parseInt(st.nextToken());
            }
            int res = 0;
            Arrays.sort(arr); Arrays.sort(brr);
            for(int i=0; i<A; i++) {
                for(int j=0; j<B; j++) {
                    if(arr[i] > brr[j]) {
                        res++;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(res);
        }
    }
}