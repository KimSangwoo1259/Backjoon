import java.io.*;
import java.util.*;


public class Main {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Set<Integer> ans = new TreeSet<>();

        Set<Integer> visited = new HashSet<>();
        Queue<WaterBottle> q = new LinkedList<>();

        q.add(new WaterBottle(0, 0, c));

        visited.add(getUniqueValue(0, 0, c));
        ans.add(c);

        while(!q.isEmpty()){
            WaterBottle now = q.poll();
            int nowA = now.a;
            int nowB = now.b;
            int nowC = now.c;

            if (nowA != 0){
                if (nowB != b){
                    int amount = Math.min(nowA, b - nowB);
                    int na = nowA - amount;
                    int nb = nowB + amount;
                    if (!visited.contains(getUniqueValue(na,nb,nowC))) {
                        visited.add(getUniqueValue(na, nb, nowC));
                        q.add(new WaterBottle(na,nb,nowC));
                        if (na == 0)
                            ans.add(nowC);
                    }
                }
                if (nowC != c){
                    int amount = Math.min(nowA, c - nowC);
                    int na = nowA - amount;
                    int nc = nowC + amount;
                    if (!visited.contains(getUniqueValue(na,nowB,nc))) {
                        visited.add(getUniqueValue(na,nowB,nc));
                        q.add(new WaterBottle(na,nowB,nc));
                        if (na == 0)
                            ans.add(nc);
                    }
                }

            }
            if (nowB != 0){
                if (nowA != a){
                    int amount = Math.min(nowB, a - nowA);
                    int na = nowA + amount;
                    int nb = nowB - amount;
                    if (!visited.contains(getUniqueValue(na, nb, nowC))) {
                        visited.add(getUniqueValue(na, nb, nowC));
                        q.add(new WaterBottle(na, nb, nowC));
                        if (na == 0)
                            ans.add(nowC);
                    }
                }
                if (nowC != c){
                    int amount = Math.min(nowB, c - nowC);
                    int nb = nowB - amount;
                    int nc = nowC + amount;

                    if (!visited.contains(getUniqueValue(nowA,nb,nc))) {
                        visited.add(getUniqueValue(nowA,nb,nc));
                        q.add(new WaterBottle(nowA,nb,nc));
                        if (nowA == 0)
                            ans.add(nowC);

                    }
                }

            }
            if (nowC != 0){
                if (nowA != a){
                    int amount = Math.min(nowC, a - nowA);
                    int na = nowA + amount;
                    int nc = nowC - amount;
                    if (!visited.contains(getUniqueValue(na,nowB,nc))) {
                        visited.add(getUniqueValue(na, nowB, nc));
                        q.add(new WaterBottle(na,nowB,nc));
                        if (na == 0)
                            ans.add(nc);

                    }
                }
                if (nowB != b){
                    int amount = Math.min(nowC, b - nowB);
                    int nb = nowB + amount;
                    int nc = nowC - amount;
                    if (!visited.contains(getUniqueValue(nowA,nb,nc))) {
                        visited.add(getUniqueValue(nowA, nb, nc));
                        q.add(new WaterBottle(nowA,nb,nc));
                        if (nowA == 0)
                            ans.add(nc);
                    }
                }

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int v : ans){
            sb.append(v).append(" ");
        }
        System.out.println(sb);


    }
    static class WaterBottle {
        int a,b, c;

        public WaterBottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
    static int getUniqueValue(int a, int b, int c){
        return (201 * 201 * a) + (201 * b) + c;
    }


}
