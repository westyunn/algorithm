import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken()); // 햄버거 선택할 수 있는 거리

        String[] arr = br.readLine().split("");
        int count = 0;
        boolean flag = false;
        for(int i=0; i<N; i++) {
            flag = false;
            if(arr[i].equals("P")) {
                // 왼쪽에 있는지 체크
                for(int j=Math.max(0, i-K); j<i; j++) {
                    if(arr[j].equals("H")) {
                        arr[j] = "X";
                        flag = true;
                        count++;
                        break;
                    }
                }
                if(!flag) {
                    // 왼쪽에 없으면 오른쪽 체크
                    for(int j=i+1; j<Math.min(N, i+K+1); j++) {
                        if(arr[j].equals("H")) {
                            arr[j] = "X";
                            flag = true;
                            count++;
                            break;
                        }
                    }
                }
            }
        }
        System.out.println(count);

    }
}