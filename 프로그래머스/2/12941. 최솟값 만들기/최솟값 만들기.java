import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        Arrays.sort(A);
        Integer[] b = new Integer[B.length];
        for(int i=0; i< B.length; i++) {
            b[i] = B[i];
        }
        Arrays.sort(b, Collections.reverseOrder());
            int sum = 0;
        for(int i=0; i<A.length; i++) {
            sum += A[i] * b[i];
        }
        return sum;
    }
}