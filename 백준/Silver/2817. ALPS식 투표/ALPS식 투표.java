import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int total = Integer.valueOf(br.readLine());
        int n = Integer.valueOf(br.readLine());

        int a;
        int b;
        float cut = (float) total * (float) 0.05;

        boolean[] isCandidate = new boolean[26];
        int[] answer = new int[26];
        List<Float> score = new ArrayList<>();
        Map<Float, Character> map = new HashMap<>();
        float temp;
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            a = st.nextToken().toCharArray()[0];
            b = Integer.valueOf(st.nextToken());
            if((float) b >= cut){
                isCandidate[a - 65] = true;
                for (int j = 1; j <= 14; j++){
                    temp = (float) b / (float) j;
                    score.add(temp);
                    map.put(temp, (char)a);
                }
            }
            else {
                answer[a - 65] = -1;
            }
        }
        Collections.sort(score,Collections.reverseOrder());
        for (int i = 0; i < 14; i++){
            Float value = score.get(i);
            answer[(int) map.get(value) - 65]++;
        }

        for (int i = 0; i < 26; i++){
            if(isCandidate[i])
                bw.write((char) (i + 65) + " " + answer[i] + "\n");
        }
        bw.flush();
        bw.close();


    }
}