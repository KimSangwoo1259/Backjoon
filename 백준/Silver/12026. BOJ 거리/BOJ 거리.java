import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        String str = br.readLine();
        char[] arr = new char[n];
        int[] dp = new int[n];
        int max = 1000000000;
        for (int i = 1; i < n; i++){
            dp[i] = max;
        }
        for (int i = 0; i < n; i++){
            arr[i] = str.charAt(i);
        }
        for (int i = 0; i < n; i++){
            if (arr[i] == 'B'){
                for (int j = i+1; j < n; j++){
                    if (arr[j] == 'O'){
                        dp[j] = Math.min(dp[j], dp[i] + calScore(j, i));
                    }
                }
            }else if(arr[i] == 'O'){
                for (int j = i+1; j < n; j++){
                    if (arr[j] == 'J'){
                        dp[j] = Math.min(dp[j], dp[i] + calScore(j, i));
                    }
                }
            }else{ // arr[i] == 'J'
                for (int j = i+1; j < n; j++){
                    if (arr[j] == 'B'){
                        dp[j] = Math.min(dp[j], dp[i] + calScore(j, i));
                    }
                }

            }
        }
        if (dp[n-1] == max)
            dp[n - 1] = -1;
        System.out.println(dp[n - 1]);


    }
    static int calScore(int n, int m){
        return (m - n) * (m - n);
    }
}
//1 B -> O //2 O -> J //3 J -> B