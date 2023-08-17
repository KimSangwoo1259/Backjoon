import java.io.*;
import java.util.StringTokenizer;

/**
 *  조의 개수는 상관이 없다.
 * 각각의 조가 잘 짜여진 정도는 그 조에 속해있는 가장 점수가 높은 학생의 점수와 가장 점수가 낮은 학생의 점수의 차이가 된다.
 * 또한 전체적으로 조가 잘 짜여진 정도는, 각각의 조가 잘 짜여진 정도의 합으로 나타난다.
 * 한 명으로 조가 구성되는 경우에는 그 조의 잘 짜여진 정도가 0이 된다(가장 높은 점수와 가장 낮은 점수가 같으므로).
 * 학생들의 점수가 주어졌을 때, 조가 잘 짜여진 정도의 최댓값을 구하는 프로그램을 작성하시오.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.valueOf(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int group[] = new int[n+1];
        int dp[] = new int[n+1];
        for (int i = 1; i <= n ; i++){
            group[i] = Integer.valueOf(st.nextToken());
        }
        for (int i = 2; i <= n; i++){
            for (int j = 1; j <= i; j++){
                dp[i] = Math.max(dp[j - 1] + Math.abs(group[i] - group[j]),dp[i]);
            }
        }
        System.out.println(dp[n]);
    }
}