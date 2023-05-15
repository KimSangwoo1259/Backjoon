import java.io.*;
import java.util.StringTokenizer;
//조건 1) L이 홀수면 -> N / L 이 나누어 떨어져야하고 N/L 몫이  (L-1)/2보다 크거나 같아야함
//조건 2) L이 짝수다 -> 그러면 N/L의 값이 n.5의 값으로 나와야함 즉, N%L 의 값이 L/2 가 나와야한다. 이경우는 몫이 (L/2)-1보다 크거나 같아야함
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.valueOf(st.nextToken());
        int L = Integer.valueOf(st.nextToken());


        while(true){
            if(L%2 ==1){ //L이 홀수인 경우
                if(N % L == 0 && (N/L) >= ((L-1)/2)){
                    for(int i = (N/L)-((L-1)/2); i <= (N/L)+((L-1)/2); i++){
                        bw.write(i + " ");
                    }
                    break;
                }
            }
            else {
                if(N % L == L/2 && N/L >= (L/2)-1){
                    for (int i = (N/L) - ((L/2)-1); i <= (N/L) + (L/2); i++){
                        bw.write(i + " ");
                    }
                    break;
                }
            }
            if(L == 100){ //종료 조건
                bw.write(String.valueOf(-1));
                break;
            }
            L++;

        }

        bw.flush();
        bw.close();




    }
}