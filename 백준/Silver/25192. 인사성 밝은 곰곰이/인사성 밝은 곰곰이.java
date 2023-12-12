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
		
		for(int i=0; i<num; i++) {
			String str= br.readLine();
			if(str.equals("ENTER")) {
				set.clear();
				continue;
			} else {
				if(!set.contains(str)) {
					set.add(str);
					cnt++;					
				}
			}
		}
		
		System.out.println(cnt);
		
	}

}