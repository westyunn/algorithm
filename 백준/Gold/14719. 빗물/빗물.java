import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Rec {
    int width;
    int height;
    Rec(int width, int height) {
        this.width = width;
        this.height = height;
    }
}
public class Main {
    static int N, M, maxHeight, idx, leftArea, rightArea;
    public static void main(String[] args) throws IOException {
        // 2304 창고다각형과 유사
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        ArrayList<Rec> list = new ArrayList<>();
        for(int i=0; i<M; i++) {
            int height = Integer.parseInt(st.nextToken());
            list.add(new Rec(i+1, height));
        }

        // 하나씩 너비 갱신하면서 기둥값 빼주면 됨
        findMaxHeight(list);
        int wholeArea = leftArea(list) + rightArea(list, M);
        System.out.println(wholeArea);
    }

    public static void findMaxHeight(ArrayList<Rec> list) {
        maxHeight = 0; idx = 0;
        for(int i=0; i<M; i++) {
            if(maxHeight < list.get(i).height) {
                maxHeight = list.get(i).height;
                idx = i;
            }
        }
    }
    public static int leftArea(ArrayList<Rec> list) {
        int leftMax = list.get(0).height;
        for(int i=1; i<idx; i++) {
            int width = list.get(i).width - list.get(i-1).width;
            if(leftMax < list.get(i).height) {
                leftMax = list.get(i).height;
            }
            leftArea += width * leftMax - list.get(i).height;
        }
        return leftArea;
    }

    public static int rightArea(ArrayList<Rec> list, int M) {
        int rightMax = list.get(M-1).height;
        for(int i=M-1; i>idx; i--) {
            int width = list.get(i).width - list.get(i-1).width;
            if(rightMax < list.get(i-1).height) {
                rightMax = list.get(i-1).height;
            }
            rightArea += width * rightMax - list.get(i-1).height;
        }
        return rightArea;
    }
}