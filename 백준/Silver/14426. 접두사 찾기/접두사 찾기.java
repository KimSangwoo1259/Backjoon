import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.valueOf(st.nextToken());
        int m = Integer.valueOf(st.nextToken());
        String[] parent = new String[n];
        for (int i = 0; i < n; i++){
            parent[i] = br.readLine();
        }
        Arrays.sort(parent);
        String[] check = new String[m];
        for (int i = 0; i < m; i++){
            check[i] = br.readLine();
        }
        int count = 0;
        for (String s: check){
            int left = 0;
            int right = n - 1;
            while (left <= right){
                int mid = (left + right) / 2;
                if (checkStr(parent[mid],s) == true){
                    count++;
                    break;
                }
                if (s.compareTo(parent[mid]) < 0){
                    right = mid - 1;
                }
                else
                    left = mid + 1;

            }
        }
        System.out.println(count);
    }
    static boolean checkStr(String s1, String s2){
        if (s1.length() < s2.length())
            return false;
        for (int i = 0; i < s2.length(); i++){
            if (s1.charAt(i) != s2.charAt(i))
                return false;
        }
        return true;
    }
}
