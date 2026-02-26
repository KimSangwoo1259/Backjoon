import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int ans = 0;
        boolean[] visited = new boolean[100001];
        visited[n] = true;
        int[] path = new int[100001];
        Arrays.fill(path, -1);
        Queue<Me> q = new LinkedList<>();
        q.add(new Me(n, 0));

        while(!q.isEmpty()){
            Me now = q.poll();

            if (now.value == k){
                ans = now.count;
                break;
            }
            int left = now.value - 1;
            int right = now.value + 1;
            int x = now.value * 2;

            if (left >= 0 && !visited[left]){
                q.add(new Me(left, now.count + 1));
                visited[left] = true;
                path[left] = now.value;
            }
            if (right <= 100000 && !visited[right]){
                q.add(new Me(right, now.count + 1));
                visited[right] = true;
                path[right] = now.value;
            }
            if (x <= 100000 && !visited[x]){
                q.add(new Me(x, now.count + 1));
                visited[x] = true;
                path[x] = now.value;
            }
        }
        Stack<Integer> stack= new Stack<>();
        sb.append(ans).append("\n");
        int temp = k;
        while(temp != -1){
            stack.add(temp);
            temp = path[temp];

        }
        while(!stack.isEmpty()){
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);

    }
    static class Me {
        int value;
        int count;

        public Me(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }


}
