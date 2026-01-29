import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        Set<Character> set=new HashSet<>();

        int[] count =  new int[26];

        char[] strArr = br.readLine().toCharArray();

        int left = 0; int right = 0;

        set.add(strArr[0]);
        count[strArr[0]-'a']++;
        while(right < strArr.length){
           if (set.size() <= n){
               answer = Math.max(answer, right - left + 1);
               right ++;
               if (right < strArr.length){
                   set.add(strArr[right]);
                   count[strArr[right]-'a']++;
               }

           }
           else {
               count[strArr[left]-'a']--;
               if (count [strArr[left]-'a'] == 0){
                   set.remove(strArr[left]);
               }
               if (left == right){
                   right++;
               }
               left++;

           }
        }
        System.out.println(answer);
    }
}