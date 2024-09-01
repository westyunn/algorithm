import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    static int[] dr = {0, 0, -1, 1, -1, 1, -1, 1};
    static int[] dc = {-1, 1, 0, 0, 1, -1, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[][] map = new String[N][N];
        for(int i=0; i<N; i++) {
            String line = br.readLine();
            for(int j=0; j<N; j++) {
                map[i][j] = String.valueOf(line.charAt(j));
            }
        }
        String[][] result = new String[N][N];
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                int count = 0;
                if(map[i][j].equals(".")) {
                    for(int d=0; d<8; d++) {
                        int nr = i + dr[d]; int nc = j + dc[d];
                        if(nr >= 0 && nc >= 0 && nr < N && nc < N && !map[nr][nc].equals(".")) {
                            count += Integer.parseInt(map[nr][nc]);
                        }
                    }
                   result[i][j] = (count >= 10 ? "M" : String.valueOf(count));
                } else result[i][j] = "*";
            }
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println();
        }



    }
}