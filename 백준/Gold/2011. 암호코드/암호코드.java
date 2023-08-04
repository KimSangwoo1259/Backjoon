import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int length = str.length() + 1;

        char[] arr = new char[length];

        for (int i = 1; i <= str.length(); i++){
            arr[i] = str.charAt(i - 1);
            if(arr[i] == '0'){
                if(i == 1){ // 맨앞이 0이면 안됨
                    System.out.println(0);
                    return;
                }
                else {
                    if(arr[i-1] != '1' && arr[i-1] != '2'){ // 0앞에 1,2 가아닌경우
                        System.out.println(0);
                        return;
                    }

                }
            }


        }


        int[] dp = new int[length];
        int mod = 1000000;
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i < length; i++){
            if(Character.getNumericValue(arr[i]) == 0){
                dp[i] = dp[i - 2] %mod ;
            }
            else{
                if(Character.getNumericValue(arr[i-1]) == 0)
                    dp[i] = dp[i - 1] % mod;
                else{
                    if(Character.getNumericValue(arr[i-1]) * 10 + Character.getNumericValue(arr[i]) <= 26)
                        dp[i] = (dp[i - 1] + dp[i - 2]) % mod;
                    else
                        dp[i] = dp[i - 1] %mod;
                }

            }


        }

        System.out.println(dp[length - 1] %mod);

    }
}
// 2 -> B // 25 -> BE, Y // 251 BEA YA // 2511 BEAA, BEK, YAA, YAK // 25114 BEAK, YAN, BEAAD BEKD, YAAD, YAKD

// 만약 앞숫자 까지 해서 26 이하다 -> dp[i] = dp[i-1] + dp [i-2] // 아니다 -> dp[i] = dp[i-1]

// 해석할 수 없는경우 1) 0으로 시작하는 경우. 2) 앞숫자가 1,2가 아닌데 뒤에 0이 나오는경우 30

// 2 ->B // 21 -> BA, U// 210 -> BJ // 2102 BJB // 21025 BJBE, BJY


//