class Solution {
    //진법 n, 미리 구할 숫자의 갯수 t, 게임에 참가하는 인원 m, 튜브의 순서 p
    char[] convertedNum;
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        StringBuilder numbers = new StringBuilder();


        convertedNum = new char[6];

        convertedNum[0] = 'A';
        convertedNum[1] = 'B';
        convertedNum[2] = 'C';
        convertedNum[3] = 'D';
        convertedNum[4] = 'E';
        convertedNum[5] = 'F';


        numbers.append(0);
        for (int i = 1; i < t * m; i++){
            String a = convert(i, n);
            numbers.append(a);
        }
        int index = 0;
        for (int i = 0; i < numbers.length() && index < t; i++){
            if (i % m == (p -1)){
                answer.append(numbers.charAt(i));
                index++;
            }
        }

        return answer.toString();
    }
    public String convert(int base, int n){
        StringBuilder temp = new StringBuilder();

        int value = base;

        while(value != 0){
            int mod = value % n;
            if (mod >= 10){
                temp.append(convertedNum[mod - 10]);
            }
            else
                temp.append(mod);
            value /= n;
        }
        return temp.reverse().toString();

    }

}