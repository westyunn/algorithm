import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

class Area {
    int width;
    int height;
    Area(int width, int height) {
        this.width = width;
        this.height = height;
    }
}

public class Main {
    static ArrayList<Area> list;
    static int leftArea, rightArea;
    static int max, idx;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        int area = 0;
        for(int i=0; i<N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            list.add(new Area(w, h));
        }
        sortedList(list);
        for(int i=0; i<N; i++) {
            if(max < list.get(i).height) {
                max = list.get(i).height;
                idx = i;
            }
        }
        int totalArea = leftArea(list) + rightArea(list, N) + max;
        System.out.println(totalArea);
    }
    public static void sortedList(ArrayList<Area> list) {
        Collections.sort(list, new Comparator<Area>() {
            @Override
            public int compare(Area o1, Area o2) {
                return Integer.compare(o1.width, o2.width);
            }
        });
    }

    public static int leftArea(ArrayList<Area> list) {
        int leftMax = list.get(0).height;
        for (int i = 1; i <= idx; i++) {
            int width = list.get(i).width - list.get(i - 1).width;
            leftArea += leftMax * width;
            if (list.get(i).height > leftMax) {
                leftMax = list.get(i).height;
            }
        }
        return leftArea;
    }

    public static int rightArea(ArrayList<Area> list, int N) {
        int rightMax = list.get(N-1).height;
        for(int i=N-1; i>idx; i--) {
            int width = list.get(i).width - list.get(i-1).width;
            rightArea += rightMax * width;
            if(list.get(i-1).height > rightMax) {
                rightMax = list.get(i-1).height;
            }
        }
       return rightArea;

    }
}