class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        while(n > 2){
            if (a < b && (b - a == 1) && (b % 2 == 0)){
                break;
            }
            if (b < a && (a - b == 1) && (a % 2 == 0)){
                break;
            }

            answer++;
            if (a % 2 == 0)
                a = a / 2;
            else
                a = a / 2 + 1;

            if (b % 2 == 0)
                b = b / 2;
            else
                b = b / 2 + 1;

            n /= 2;
        }

        return ++answer;
    }
}