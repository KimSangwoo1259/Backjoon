import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.valueOf(br.readLine());

        char[][] candy = new char[n][n];

        for (int i = 0; i < n; i++){
            String str = br.readLine();
            for (int j = 0; j < n; j++){
                candy[i][j] = str.charAt(j);
            }
        }
        int max = 1;
        max = Math.max(search(candy,n),max);

        for (int i = 0; i < n -1; i++){
            for (int j = 0; j < n-1; j++){
                char temp = candy[i][j];
                candy[i][j] = candy[i][j+1];
                candy[i][j + 1] = temp;
                max = Math.max(search(candy,n),max);
                candy[i][j+1] = candy[i][j];
                candy[i][j] = temp;

                candy[i][j] = candy[i+1][j];
                candy[i+1][j] = temp;
                max = Math.max(search(candy,n),max);
                candy[i + 1][j] = candy[i][j];
                candy[i][j] = temp;
            }
        }
        for (int i = 0; i < n -1; i++){
            char temp = candy[n-1][i];
            candy[n-1][i] = candy[n-1][i+1];
            candy[n-1][i + 1] = temp;
            max = Math.max(search(candy,n),max);
            candy[n-1][i+1] = candy[n-1][i];
            candy[n-1][i] = temp;
        }

        System.out.println(max);
    }
    public static int search(char[][] candy, int n){
        int cnt = 1;
        int maxNum = 1;
        for (int i = 0; i < n ; i++){
            for (int j = 0; j < n-1; j++){
                if(candy[i][j] == candy[i][j+1]){
                    cnt++;
                    maxNum = Math.max(maxNum, cnt);
                }

                else
                    cnt = 1;
            }
            cnt = 1;
        }

        for (int j = 0; j < n ; j++){
            for (int i = 0; i < n-1; i++){
                if(candy[i][j] == candy[i+1][j]){
                    cnt++;
                    maxNum = Math.max(maxNum, cnt);
                }

                else
                    cnt = 1;
            }
            cnt = 1;
        }
        return maxNum;
    }
}