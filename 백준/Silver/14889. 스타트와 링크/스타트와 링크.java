import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static int n;
    static int[][] map;
    static int min = 1000000000;
    static boolean[] selected;
    static int[] aTeam;
    static int[] bTeam;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.valueOf(br.readLine());
        map = new int[n+1][n+1];

        aTeam = new int[n / 2];
        bTeam = new int[n / 2];
        selected = new boolean[n + 1];
        StringTokenizer st ;

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <=n; j++){
                map[i][j] = Integer.valueOf(st.nextToken());
            }
        }
        makeTeam(0);
        System.out.println(min);

    }
    static void makeTeam(int num){
        if (num == n / 2){
            int index = 0;
            int aScore = 0;
            int bScore = 0;
            for (int i = 1; i <= n; i++){
                if (!selected[i]){
                    bTeam[index] = i;
                    index++;
                }
            }
            for (int i = 0; i < n/2 -1 ; i++){
                for (int j = i + 1; j < n/2; j++){
                    aScore += (map[aTeam[i]][aTeam[j]] + map[aTeam[j]][aTeam[i]]);
                    bScore += (map[bTeam[i]][bTeam[j]] + map[bTeam[j]][bTeam[i]]);
                }
            }
            int dif = Math.abs(aScore - bScore);
            min = Math.min(dif, min);
            return;
        }
        for (int i = 1; i <=n; i++){
            if (!selected[i]){
                if (num >0){
                    if (aTeam[num-1]> i)
                        continue;
                }
                aTeam[num] = i;
                selected[i] = true;
                makeTeam(num + 1);
                selected[i] = false;
            }
        }
    }
}