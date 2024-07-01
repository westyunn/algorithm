import java.util.*;
class Solution {
    static boolean[] visited;
    static int start, n;
    static int r = 3; 
    static ArrayList<int[]> arr = new ArrayList<>();
    public int solution(int[] nums) {
        int answer = -1;
        n = nums.length;
        start = 0;
        visited = new boolean[n];
        combination(nums, visited, start, n, r);
        return arr.size();
    }
    public void combination(int[] nums, boolean[] visited, int start, int n, int r) {
        if(r == 0) {
            addCombination(nums, visited);
            return;
        } 
        for(int i=start; i<n; i++) {
            visited[i] = true;
            combination(nums, visited, i+1, n, r-1);
            visited[i] = false;
        }
    }
    public void addCombination(int[] nums, boolean[] visited) {
        int[] combination = new int[3];
        int idx = 0;
        int sum = 0;
        for(int i=0; i<n; i++) {
            if(visited[i]) {
                sum += nums[i];
            }
        }
        if(isPrime(sum)) {
            arr.add(combination);
        }
    }
    public boolean isPrime(int n) {
        for(int i=2; i<n; i++) {
            if(n % i == 0) {
                return false;
            }
        }
        return true;
    }
}