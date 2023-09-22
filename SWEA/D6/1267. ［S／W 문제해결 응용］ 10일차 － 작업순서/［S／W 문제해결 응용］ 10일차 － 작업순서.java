import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static int V, E; // 정점의 개수, 간선의 개수 
	public static int[][] work;
	public static int[] degree;
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> list = new ArrayList<>();
			V = Integer.parseInt(st.nextToken()); 
			E = Integer.parseInt(st.nextToken());
			work = new int[V+1][V+1];
			degree = new int [V+1];
			
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				work[a][b] = 1; // 방향키 잇으니까 
				degree[b]++; // 진입차수 증가시켜줘야댐
			}
			
			Queue<Integer> queue = new LinkedList<>();
			
			for(int i=1; i<=V; i++) {
				if(degree[i] == 0) {
					queue.add(i);
				}
			} // 시작으로 둘 만한 애들 먼저 큐에 넣어주ㅗㄱ 
			
			while(!queue.isEmpty()) {
				int idx = queue.poll();
				list.add(idx);
				for(int i=1; i<=V; i++) {
					if(work[idx][i] == 1) {
						work[idx][i] = 0; // 간선없애기 
						degree[i] -- ;
						
						if(degree[i] == 0) {
							queue.add(i);
						}
					}

				}
	
			}
			sb.append("#"+tc+" ");
			for(int i=0; i< list.size(); i++) {
				sb.append(list.get(i)+" ");
			}
			System.out.println(sb);
		} // tc 
		

	} // main

}