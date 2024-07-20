import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine()); // 굴다리 길이
        int M = Integer.parseInt(br.readLine()); // 가로등 개수

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] points = new int[M];
        for(int i=0; i<M; i++) {
            points[i] = Integer.parseInt(st.nextToken());
        }

        int start = 1;
        int end = N; // 최대 가로등 높이 = 터널 길이
        int answer = end;

        while(start <= end) {
            int mid = (start + end) / 2;
            // 모두 비추면 end값 범위 줄여서 값 조절 
            if(isAllLight(N, points, mid)) {
                answer = mid;
                end = mid - 1;
            } else {
                // 아닐 경우 start값 조절 
                start = mid + 1;
            }
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    public static boolean isAllLight (int N, int[] points, int mid) {
        int last = 0;
        for(int point: points) {
            // 가로등 비추는 범위가 짧으면
            if(point - mid > last) {
                return false;
            }
            last = point + mid;
            // 현재 가로등 불빛이 터널 끝까지 비춘다면
            if(last >= N) {
                return true;
            }
        }
        return last >= N;
    }

}