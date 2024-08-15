import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num == 0) {
                if(!st.isEmpty()) st.pop();
            } else {
                st.push(num);
            }
        }
        while(!st.isEmpty()) {
            ans += st.pop();
        }
        System.out.println(ans);
    }
}