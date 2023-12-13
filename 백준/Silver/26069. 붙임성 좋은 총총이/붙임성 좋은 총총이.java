import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int num = Integer.parseInt(st.nextToken());
		int cnt = 0;
		
		Set<String> set = new HashSet<>();
		
		set.add("ChongChong");
		
		for(int i=0; i<num; i++) {
			st = new StringTokenizer(br.readLine());
			String user1 = st.nextToken();
			String user2 = st.nextToken();
			
			if(set.contains(user1)) {
				set.add(user2);
			} else if(set.contains(user2)) {
				set.add(user1);
			}
			
		}
		
		System.out.println(set.size());
		
		
	}

}