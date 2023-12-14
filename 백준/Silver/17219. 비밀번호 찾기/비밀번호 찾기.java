import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n_site = Integer.parseInt(st.nextToken());
		int n_find = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<>();
		
		for(int i=0; i<n_site; i++) {
			st = new StringTokenizer(br.readLine());
			String site = st.nextToken();
			String find = st.nextToken();
			map.put(site, find);
			
		}
		
		for(int i=0; i<n_find; i++) {
			st = new StringTokenizer(br.readLine());
			String pwsite = st.nextToken();
			
			if(map.containsKey(pwsite)) {
				sb.append(map.get(pwsite)).append("\n");
			}
			
		}
		System.out.println(sb);
		
	}

}