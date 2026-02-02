import java.io.*;

import java.util.*;


public class Main {


    static class Node {
        int parent;
        int value;

        public Node(int parent, int value) {
            this.parent = parent;
            this.value = value;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        List<Integer>[] listArr = new List[n+1];
        for (int i = 1 ; i <= n; i++){
            listArr[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            listArr[x].add(y);
            listArr[y].add(x);
        }
        int[] ans = new int[n + 1];
        boolean[] visited = new boolean[n + 1];
        Queue<Node> q = new LinkedList<>();
        visited[1] = true;
        for (int i = 0; i < listArr[1].size(); i++){
            q.add(new Node(1, listArr[1].get(i)));
        }
        while (!q.isEmpty()){
            Node now = q.poll();
            if (!visited[now.value]){
                visited[now.value] = true;
                ans[now.value] = now.parent;
                for (int i = 0; i < listArr[now.value].size(); i++){
                    q.add(new Node(now.value, listArr[now.value].get(i)));
                }
            }
        }
        for (int i = 2; i <= n; i ++){
            bw.write(ans[i] + "\n");
        }
        bw.flush();
        bw.close();

    }
}
