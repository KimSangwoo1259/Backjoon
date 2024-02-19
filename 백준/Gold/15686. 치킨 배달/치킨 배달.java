import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int m;
    static int map[][];
    static int ans = 0;
    static List<Chicken> cList;
    static List<Home> hList;
    static Chicken[] cArr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        m = Integer.valueOf(st.nextToken());
        cArr = new Chicken[m];
        map = new int[n][n];
        cList = new ArrayList<>();
        hList = new ArrayList<>();
        ans = 1000000000;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++){
                int temp = Integer.valueOf(st.nextToken());
                map[i][j] = temp;
                if (temp == 1){
                    hList.add(new Home(i, j));
                }
                else if(temp == 2){
                    cList.add(new Chicken(i, j, cList.size()));
                }
            }
        }
        back(0);
        System.out.println(ans);

    }
    static void back(int num){
        if (num == m){
            int s = 0;
            for (int i = 0; i < hList.size(); i++){
                int temp = 1000;
                for (int j = 0; j < m; j++){
                    temp = Math.min(temp, calDis(cArr[j], hList.get(i)));
                }
                s += temp;
            }
            ans = Math.min(ans, s);
            return;
        }
        for (int i = 0; i < cList.size(); i++){
            if (num != 0) {
                if (cArr[num - 1].level >= cList.get(i).level)
                    continue;
            }

            cArr[num] = cList.get(i);
            back(num + 1);
        }
    }
    static class Chicken{
        int x,y,level;
        Chicken(int _x, int _y, int l){
            x = _x;
            y = _y;
            level = l;
        }
    }
    static class Home {
        int x,y;
        Home(int _x, int _y){
            x = _x;
            y = _y;
        }
    }
    static int calDis(Chicken c, Home h){
        return Math.abs(c.x - h.x) + Math.abs(c.y - h.y);
    }
}
