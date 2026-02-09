import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] students;
    static int[] temp;
    static Set<Integer> tempSet;
    static boolean[] visited;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while(t--> 0){
            ans = 0;
            n = Integer.parseInt(br.readLine());
            students = new int[n + 1];
            temp = new int[n + 1];
            visited = new boolean[n + 1];
            tempSet = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i<=n; i++){
                int value = Integer.parseInt(st.nextToken());
                if (value == i){
                    ans++;
                    visited[i] = true;
                }
                students[i] = value;
            }
            for (int i = 1; i <= n; i++){
                if (!visited[i]){
                    temp[i] = 0;
                    tempSet.add(i);
                    dfs(1,i);
                    for (int a : tempSet){
                        visited[a] = true;
                    }
                    tempSet.clear();
                }
            }
            bw.write(n - ans + "\n");

        }
        bw.flush();
        bw.close();


    }
    static void dfs(int level, int value) {


        int num = students[value];
        if (tempSet.contains(num)) {
            ans += (level - temp[num]);
            return;
        }
        if (!visited[num]) {
            temp[num] = level;
            tempSet.add(num);
            dfs(level + 1, num);
        }

    }

}

