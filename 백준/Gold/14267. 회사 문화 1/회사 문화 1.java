import java.io.*;
import java.util.*;


public class Main {


    static List<Integer>[] staff;
    static boolean[] visited;
    static int[] ans;
    static int[] praise;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 회사 직원수
        int m = Integer.parseInt(st.nextToken()); // 칭찬 횟수
        praise = new int[n+1];
        visited = new boolean[n + 1];
        staff = new List[n + 1];
        for (int i = 1; i <=n; i++){
            staff[i] = new ArrayList<>();
        }
        ans = new int[n + 1];
        int root = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++){
            int sup = Integer.parseInt(st.nextToken());
            if (sup != -1) {
                staff[sup].add(i);
            }
            else
                root = i;
        }

        for (int i = 0; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            praise[index] += w;
        }
        visited[root] = true;
        dfs(root, 0);

        for (int i = 1; i <=n; i++){
            bw.write(ans[i] + " ");
        }
        bw.flush();
        bw.close();
    }
    static void dfs(int n, int w){
        ans[n] += w;
        for (int i = 0; i < staff[n].size(); i++){
            int next = staff[n].get(i);
            if (!visited[next]){
                visited[next] = true;
                dfs(next, ans[n]+praise[next]);
            }
        }


    }


}