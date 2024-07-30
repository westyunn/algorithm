import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        if(str.equals("fdsajkl;") || str.equals("jkl;fdsa")){
            System.out.println("in-out");
        } else if(str.equals("asdf;lkj") || str.equals(";lkjasdf")) {
            System.out.println("out-in");
        } else if(str.equals("asdfjkl;")) {
            System.out.println("stairs");
        } else if(str.equals(";lkjfdsa")) {
            System.out.println("reverse");
        } else {
            System.out.println("molu");
        }
    }
}