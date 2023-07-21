import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long kriii[] = new long[101];
        kriii[1] = 1;
        kriii[2] = 2;
        kriii[3] = 3;
        int n = Integer.valueOf(br.readLine());


        for (int i = 4; i <=n; i++){
            kriii[i] = i;
            for(int j = 1; j <= i -3; j++){
                kriii[i] = Math.max(kriii[i], kriii[j] * (i - j - 1));
            }
        }
        System.out.println(kriii[n]);






    }
}
/**
 * 화면에 A를 출력한다.
 * Ctrl-A: 화면을 전체 선택한다
 * Ctrl-C: 전체 선택한 내용을 버퍼에 복사한다
 * Ctrl-V: 버퍼가 비어있지 않은 경우에는 화면에 출력된 문자열의 바로 뒤에 버퍼의 내용을 붙여넣는다.
 */
// A,C를 하는것은 의미가 없음. ACV가 한세트이고, 3번을 소요해서 2배가 된다. CtrV 하면 현재 버퍼에 저장된 개수 만큼 붙여넣기.
// 현재 dp[index -3] * 2 와 dp[index -1] + curLength(현재 버퍼에 저장된 길이) 를 비교하면 될것같음
//// acvv acv
// 1 2 3 4 5 6 