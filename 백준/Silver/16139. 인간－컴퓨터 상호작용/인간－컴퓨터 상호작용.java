import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        final int LEN = s.length();
        boolean[][] alphabetCount = new boolean[26][LEN];
        int[][] sumAlphabetCount = new int[26][LEN];
        int q = Integer.parseInt(br.readLine());

        for (int i = 0; i <LEN; i++){
            int alphabet = s.charAt(i) - 'a';

            alphabetCount[alphabet][i] = true;
        }

        for (int i = 0; i < 26; i++){
            for (int j = 0; j < LEN; j++){
                if (alphabetCount[i][j]){
                    if (j == 0){
                        sumAlphabetCount[i][j] = 1;
                    }
                    else {
                        sumAlphabetCount[i][j] += sumAlphabetCount[i][j - 1] + 1;
                    }
                }
                else {
                    if (j != 0){
                        sumAlphabetCount[i][j] = sumAlphabetCount[i][j - 1];
                    }
                }
            }
        }

        while(q --> 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int alphabet = st.nextToken().charAt(0) - 'a';
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            if (start == 0){
                sb.append(sumAlphabetCount[alphabet][end]).append("\n");
            }
            else {
                sb.append(sumAlphabetCount[alphabet][end] - sumAlphabetCount[alphabet][start - 1]).append("\n");
            }
        }

        System.out.println(sb);




    }


}