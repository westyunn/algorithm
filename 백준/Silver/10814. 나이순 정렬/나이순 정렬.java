import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

class Judges {
    int age;
    int enrollNum;
    String name;
    Judges(int age, int enrollNum, String name) {
        this.age = age;
        this.enrollNum = enrollNum;
        this.name = name;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Judges> judges = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            judges.add(new Judges(age, i, name));
        }
        Collections.sort(judges, new Comparator<Judges>() {
            @Override
            public int compare(Judges o1, Judges o2) {
                if(o1.age == o2.age) {
                    return Integer.compare(o1.enrollNum, o2.enrollNum);
                }
                return Integer.compare(o1.age, o2.age);
            }
        });
        for(int i=0; i<judges.size(); i++) {
            sb.append(judges.get(i).age+" "+judges.get(i).name).append('\n');
        }
        System.out.println(sb);

    }
}