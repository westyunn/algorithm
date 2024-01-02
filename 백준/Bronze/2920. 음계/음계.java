import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[8];
        for(int i=0; i<8; i++){
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;
        }

        String res = "";
        for(int i=0; i<8; i++){
            if(arr[i] == i + 1 && arr[0] == 1 && arr[7] == 8){
                res = "ascending";
            } else if(arr[i] == 8 - i && arr[0] == 8 && arr[7] == 1) {
                res = "descending";
            } else {
                res = "mixed";
                break;
            }
        }

        System.out.println(res);

    }
}