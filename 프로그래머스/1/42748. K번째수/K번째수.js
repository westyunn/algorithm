function solution(array, commands) {
    var answer = [];
    var arr = [];
    // i ~ j 까지 자르고 정렬 후 k번째 숫자를 뽑으면 된다.
    for(let l = 0; l < commands.length; l++) {
        arr = [];
        let i = commands[l][0];
        let j = commands[l][1];
        let k = commands[l][2];
        arr = array.slice(i-1, j);
        // javascript의 sort() 함수는 문자열로 변환하여 정렬하기 때문에 유니코드 포인트 순서로 정렬됨 
        // 숫자 배열로 정렬하려면 아래와 같이 정렬해야함 
        arr.sort((a, b) => a - b);
        let num = arr[k-1];
        answer = [...answer, num];
    }
    return answer;
}