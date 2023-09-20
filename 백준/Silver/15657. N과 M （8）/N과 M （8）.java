import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static int N, M;
	public static int[] num, arr;
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[M];
		num = new int[N];
		visited = new boolean[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(num);
		
		dfs(0, 0);
		System.out.println(sb);
		
	} // main
	
	public static void dfs(int idx, int depth) {
		// 기저조건
		if(depth == M) {
			for(int i=0; i<M; i++) {
				sb.append(arr[i]+" ");
			}
			sb.append('\n');
			return;
		}
		
		for(int i=idx; i<N; i++) {
			arr[depth] = num[i];
			dfs(i, depth+1);
		}
	}
	
}