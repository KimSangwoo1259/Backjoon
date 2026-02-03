import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static String str;
    static int n;
    static int len;
    static List<Integer> list;
    static boolean[] visited;
    static boolean found;
    static BufferedWriter bw;
    // 순열은 최대 1개에서 50개의 수로 이루어짐. 수열의 길이를 통해서 n을 유추할 수 있다.
    // 한자리 까지는 1만큼, 10부터는 2개씩늘어남.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        list = new ArrayList<>();

        str = br.readLine();

        len = str.length();
        found = false;
        if (len <= 9) {// 한자리 수로만 이루어짐
            n = len;
        }
        else {
            n = 9 + (len - 9) / 2;
        }
        visited = new boolean[n + 1];


        backtracking(0,0);

    }

    static void backtracking(int l, int strIndex) throws IOException {
        if (found)
            return;

        if (l == n && strIndex >= len){
            for (int i = 0; i < list.size(); i++){
                bw.write(list.get(i) + " ");
            }
            bw.flush();
            bw.close();
            found = true;
        }
        if (strIndex >= len)
            return;
        if (l >= n)
            return;
        int temp = Integer.parseInt(str.substring(strIndex, strIndex + 1));

        if (temp == 0)
            return;

        if (!visited[temp]){
            visited[temp] = true;
            list.add(temp);
            backtracking(l +1, strIndex + 1);
            list.remove(l);
            visited[temp] = false;
        }
        if (strIndex < len - 1){
            temp = Integer.parseInt(str.substring(strIndex,strIndex +2));

            if (temp <= n && !visited[temp]){
                visited[temp] = true;
                list.add(temp);
                backtracking(l +1, strIndex + 2);
                list.remove(l);
                visited[temp] = false;
            }

        }

    }


}
