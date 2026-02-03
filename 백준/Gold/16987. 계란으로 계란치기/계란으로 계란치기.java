import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Egg {
        int s;
        int w;

        public Egg(int s, int w) {
            this.s = s;
            this.w = w;
        }
        public void throwEgg(Egg target){
            this.s -= target.w;
            target.s -= this.w;
        }
        public void rollBack(Egg target){
            this.s += target.w;
            target.s += this.w;
        }
    }
    static Egg[] eggs;
    static boolean[] broken;
    static int n;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        eggs = new Egg[n];
        broken = new boolean[n];
        ans = 0;
        for (int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i] = new Egg(s, w);
        }
        backtrack(0,0);
        System.out.println(ans);
    }

    private static void backtrack(int l, int brokenCount) {

        if (l >= n){
            ans = Math.max(brokenCount,ans);
            return;
        }
        if (broken[l]) {
            backtrack(l + 1, brokenCount);
            return;
        }
        boolean hit = false;
        for (int i = 0; i < n; i++){
            if (broken[i] || i == l)
                continue;
            hit = true;
            Egg eggOnHand = eggs[l];
            Egg target = eggs[i];
            int eggOnHandS = eggOnHand.s;
            int targetS = target.s;
            eggOnHand.throwEgg(target);
            int prevCount = brokenCount;
            if (eggOnHand.s <= 0) {
                broken[l] = true;
                brokenCount++;
            }

            if (target.s <= 0) {
                broken[i] = true;
                brokenCount++;
            }
            backtrack(l+1, brokenCount);
            eggOnHand.s = eggOnHandS;
            target.s = targetS;
            broken[l] = false;
            broken[i] = false;
            brokenCount = prevCount;

        }
        if (!hit)
            backtrack(l+1,brokenCount);
    }


}
