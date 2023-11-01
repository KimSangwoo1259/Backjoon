import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());
        String str = br.readLine();
        char[] arr = str.toCharArray();
        char[] alphabet = new char[26];
        Set<Character> set = new HashSet<>();
        final int ASCII_VALUE = 97;
        int left = 0;
        int right = 0;
        int ans = 0;
        set.add(arr[right]);
        alphabet[arr[right] - ASCII_VALUE]++;
        right++;
        boolean isRight = true;
        while (right < arr.length){
           if (left == right){
               alphabet[arr[left-1]-ASCII_VALUE]--;
               if (alphabet[arr[left-1]-ASCII_VALUE]== 0)
                   set.remove(arr[left-1]);
               if (set.size() <= n)
                   ans = Math.max(right - left + 1,ans);
               right++;
               isRight = true;

           }
           else{
                if(isRight){
                    alphabet[arr[right] - ASCII_VALUE]++;
                    set.add(arr[right]);
                }
                else {
                    alphabet[arr[left-1]-ASCII_VALUE]--;
                    if (alphabet[arr[left-1]-ASCII_VALUE] == 0)
                        set.remove(arr[left-1]);
                }
               if (set.size() <= n) {
                   ans = Math.max(right - left + 1, ans);
                   right++;
                   isRight = true;
               }
               else {
                   left++;
                   isRight = false;
               }



           }
        }
        System.out.println(ans);
    }


}