class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = {};
        // 10진수를 2진수로 변환시켜 0이면 공백, 1이면 #으로 칠해주면 되는 문제 
        // arr1이랑 arr2 2진수로 변환시킨 다음 합쳐줄 부분만 합쳐주면 됨
        String[] tmp = new String[n];
        String[] tmp2 = new String[n];
        String[] map = new String[n];
        for(int i=0; i<n; i++) {
            tmp[i] = Integer.toBinaryString(arr1[i]);
            while (tmp[i].length() < n) {
                tmp[i] = "0" + tmp[i];
            }
            tmp2[i] = Integer.toBinaryString(arr2[i]);
            while (tmp2[i]. length() < n) {
                tmp2[i] = "0" + tmp2[i];
            }
            map[i] = tmp[i];
        }
        
        for(int i=0; i<n; i++) {
            char[] charArr = new char[n];
            for(int j=0; j<n; j++) {
                if(tmp[i].charAt(j) == '1' || tmp2[i].charAt(j) == '1') {
                    charArr[j] ='#';
                } else {
                    charArr[j] = ' ';
                }
            }
                map[i] = new String(charArr); // charArr String으로 변환해서 넣기
            
        }
        
        return map;
    }
}