import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[][][] visited = new boolean[201][201][201];
        Set<Integer> answers = new TreeSet<>();


        int a = Integer.valueOf(st.nextToken());
        int b = Integer.valueOf(st.nextToken());
        int c = Integer.valueOf(st.nextToken());

        Queue<Bottle> q = new LinkedList<>();
        q.add(new Bottle(0, 0, c));
        visited[0][0][c] = true;

        while (!q.isEmpty()){
            Bottle now = q.poll();
            if (now.a == 0){
                answers.add(now.c);
            }
            if (now.a < a && now.c !=0){ // c -> a // a가 가득 차있지 않거나, c 가 0이 아니여야함
                if (a - now.a < now.c){ //c의 전부를 a에게 부을 수 없는경우
                    if (!visited[a][now.b][now.c - (a-now.a)]){
                        q.add(new Bottle(a, now.b, now.c - (a - now.a)));
                        visited[a][now.b][now.c - (a-now.a)] = true;
                    }
                }
                else{
                    if (!visited[now.a+now.c][now.b][0]){
                        q.add(new Bottle(now.a + now.c, now.b, 0));
                        visited[now.a+now.c][now.b][0] = true;
                    }
                }

            }
            if (now.b < b && now.c !=0){
                if (b - now.b < now.c){ //c->b //c의 전부를 b에게 부을 수 없는경우
                    if (!visited[now.a][b][now.c - (b-now.b)]){
                        q.add(new Bottle(now.a, b, now.c - (b - now.b)));
                        visited[now.a][b][now.c - (b-now.b)] = true;
                    }
                }
                else{
                    if (!visited[now.a][now.b+now.c][0]){
                        q.add(new Bottle(now.a, now.b+now.c, 0));
                        visited[now.a][now.b+now.c][0] = true;
                    }
                }
            }
            if (now.b < b && now.a !=0){
                if (b - now.b < now.a){// a->b
                    if (!visited[now.a - (b - now.b)][b][now.c]){
                        q.add(new Bottle(now.a - (b - now.b), b, now.c));
                        visited[now.a - (b - now.b)][b][now.c] = true;
                    }
                }
                else{
                    if (!visited[0][now.b+now.a][now.c]){
                        q.add(new Bottle(0, now.b+now.a, now.c));
                        visited[0][now.b+now.a][now.c] = true;
                    }
                }
            }
            if (now.c < c && now.a !=0){
                if (c - now.c < now.a){ // a->c
                    if (!visited[now.a - (c - now.c)][now.b][c]){
                        q.add(new Bottle(now.a - (c - now.c), now.b, c));
                        visited[now.a - (c - now.c)][now.b][c] = true;
                    }
                }
                else{
                    if (!visited[0][now.b][now.c + now.a]){
                        q.add(new Bottle(0, now.b, now.c + now.a));
                        visited[0][now.b][now.c + now.a] = true;
                    }
                }
            }
            if (now.a < a && now.b !=0){
                if (a - now.a < now.b){ // b -> a
                    if (!visited[a][now.b - (a - now.a)][now.c]){
                        q.add(new Bottle(a, now.b - (a - now.a), now.c));
                        visited[a][now.b - (a - now.a)][now.c] = true;
                    }
                }
                else{
                    if (!visited[now.a + now.b][0][now.c]){
                        q.add(new Bottle(now.a + now.b, 0, now.c));
                        visited[now.a + now.b][0][now.c] = true;
                    }
                }
            }
            if (now.c < c && now.b !=0){
                if (c - now.c < now.b){ // b -> c
                    if (!visited[now.a][b - (c - now.c)][c]){
                        q.add(new Bottle(now.a, b- (c - now.c), c));
                        visited[now.a][b - (c - now.c)][c] = true;
                    }
                }
                else{
                    if (!visited[now.a][0][now.b + now.c]){
                        q.add(new Bottle(now.a, 0, now.b + now.c));
                        visited[now.a][0][now.b + now.c] = true;
                    }
                }
            }


        }
        for (Integer temp : answers){
            sb.append(temp + " ");
        }
        System.out.println(sb);

    }

    static class Bottle {
        int a, b, c;

        Bottle(int _a, int _b, int _c){
            a = _a;
            b = _b;
            c = _c;
        }
    }
}
