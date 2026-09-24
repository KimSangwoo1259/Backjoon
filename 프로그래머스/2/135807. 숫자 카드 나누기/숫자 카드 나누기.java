class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;

        boolean a = true;
        boolean b = true;

        int gcdA = getGcdFromArray(arrayA);
        int gcdB = getGcdFromArray(arrayB);
        //case1 (A 의 최대 공약수로 B를 나누기)
        for (int i = 0; i < arrayB.length; i++){
            if (arrayB[i] % gcdA == 0){
                a = false;
                break;
            }
        }




        //case2
        for (int i = 0; i < arrayA.length; i++){
            if (arrayA[i] % gcdB == 0){
                b = false;
                break;
            }
        }

        if (a && b){
            answer = Math.max(gcdA, gcdB);
        }
        else if (!a && b)
            answer = gcdB;
        else if (a && !b)
            answer = gcdA;

        return answer;
    }

    public int getGcdFromArray(int[] arr){
        if (arr.length == 1)
            return arr[0];

        int gcd = getGcd(arr[0], arr[1]);

        for (int i = 2; i < arr.length; i++){
            gcd = getGcd(gcd, arr[i]);
        }

        return gcd;
    }
    public int getGcd(int a, int b){
        if (a < b){
            while(a > 0){
                int r = b % a;
                b = a;
                a = r;
            }
            return b;
        }
        else if (b < a){
            while(b > 0){
                int r = a % b;
                a = b;
                b = r;
            }
            return a;
        }
        else {
            return a;
        }
    }
}