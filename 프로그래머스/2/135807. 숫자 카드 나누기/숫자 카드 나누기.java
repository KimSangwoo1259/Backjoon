class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int gcdA = getGcd(arrayA);
        int gcdB = getGcd(arrayB);
        
        boolean a = true;
        boolean b = true;
        
        for (int i = 0; i < arrayB.length; i++){
            if (arrayB[i] % gcdA == 0) {
                a = false;
                break;
            }
        }
        for (int i = 0; i < arrayA.length; i++){
            if (arrayA[i] % gcdB == 0) {
                b = false;
                break;
            }
        }
        if (a && b)
            answer = Math.max(gcdA, gcdB);
        else if (a && !b)
            answer = gcdA;
        else if (!a && b)
            answer = gcdB;
        else
            answer = 0;
        return answer;

    }
    public static int getGcd(int a, int b){
        if (b == 0) return a;
        return getGcd(b, a % b);
    }
    public static int getGcd(int[] arr){
        int result = arr[0];
        for (int i = 1; i < arr.length; i++){
            result = getGcd(result, arr[i]);
        }
        return result;
    }
}