import java.io.*;
import java.util.*;

public class Main {

    static int n;
    static int[] graph;
    static boolean[] visited;
    static int ans;
    //분명 왔단길을 다시 돌아갈 수 밖에 없음.. 그렇다고 visited 관리를 안하면 관리가 안되는데.. 가진 열쇠를 값으로 바꾸어서 visited 활용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        List<Integer>[] a = new List[n+1];

        while(t--> 0){
            ans = 0;
            n = Integer.parseInt(br.readLine());
            graph = new int[n + 1];
            visited = new boolean[n + 1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i<=n; i++){
                graph[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 1; i <= n; i++){
                if (!visited[i]){
                    ans++;
                    dfs(i);
                }
            }
            bw.write(ans + "\n");

        }
        bw.flush();
        bw.close();


    }
    static void dfs(int l){
        if (!visited[graph[l]]){
            visited[graph[l]] = true;
            dfs(graph[l]);
        }
    }


}

