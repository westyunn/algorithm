import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        char[][] cookie = new char[N+1][N+1];
        for(int i=1; i<=N; i++) {
            String str = br.readLine();
            for(int j=1; j<=N; j++) {
                cookie[i][j] = str.charAt(j-1);
            }
        }
        ArrayList<Point> list = new ArrayList<>();
        // 머리가 제일 위에 있으니까 i값 제일 적은게 머리임
        for(int i=1; i<=N; i++) {
            for(int j=1; j<=N; j++) {
                if(cookie[i][j] == '*') {
                    list.add(new Point(i, j));
                }
            }
        }
        int heartX = 0; int heartY = 0;
        for(int i=0; i<list.size(); i++) {
            heartX = list.get(0).x + 1;
            heartY = list.get(0).y;
        }
        System.out.println(heartX+" "+heartY);
        int leftArm =0; int rightArm =0; int waist = 0; int leftLeg = 0; int rightLeg= 0;
        for (int j = heartY - 1; j >= 1; j--) {
            if (cookie[heartX][j] == '*') {
                leftArm++;
            } else {
                break;
            }
        }

        for (int j = heartY + 1; j <= N; j++) {
            if (cookie[heartX][j] == '*') {
                rightArm++;
            } else {
                break;
            }
        }

        for (int i = heartX + 1; i <= N; i++) {
            if (cookie[i][heartY] == '*') {
                waist++;
            } else {
                break;
            }
        }

        int waistEndX = heartX + waist;

        for (int i = waistEndX + 1; i <= N; i++) {
            if (cookie[i][heartY - 1] == '*') {
                leftLeg++;
            } else {
                break;
            }
        }

        for (int i = waistEndX + 1; i <= N; i++) {
            if (cookie[i][heartY + 1] == '*') {
                rightLeg++;
            } else {
                break;
            }
        }

        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}