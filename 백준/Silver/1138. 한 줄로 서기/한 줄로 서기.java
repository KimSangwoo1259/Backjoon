import java.io.*;
import java.util.StringTokenizer;

//배열은 선언하면 0으로 초기화된다. 0으로 되어있는 부분(아직 자리가 채워지지 않은 부분)은 앞으로 자기보다 큰 수들이 들어올 자리라는뜻 이므로 자기 앞에있는 0의 수를 count해서 자리를 찾을 수 있다.
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());


        int[] arr = new int[n]; // 입력 값
        int[] answer = new int[n]; //정답

        for (int i = 0; i < n; i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        for (int i = 0; i < n; i++){
            int count = 0;
            for (int j = 0; j < n; j++){
                if (answer[j] == 0)
                    count++;
                if (count-1 == arr[i]){
                    answer[j] = i+1;
                    break;
                }
            }
        }

        for (int num : answer){
            bw.write(num + " ");
        }
        bw.flush();
        bw.close();
    }
}