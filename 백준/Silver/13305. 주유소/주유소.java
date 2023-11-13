import java.io.*;
import java.util.StringTokenizer;

public class Main {
    //현재 최솟값의 위치를 찾고 그뒤로 최대한 기름을 넣고 가기 -> 최솟값보다 왼쪽에서 부터 다시 그중에서의 최솟값을 찾고 그 지점 앞까지 쭉 달리기 반복

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        long d[] = new long[N-1]; //거리를 담은 배열
        for (int i = 0; i< N-1; i++) {
            d[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        long p[] = new long[N]; //주유하는 지점의 가격을 담은 배열
        for (int i = 0; i< N; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }

        int oldMin;
        int curMin;
        long price = 0L;
        // 초기 값설정
        curMin = minSearch(N,p);
        long temp = 0;
        for (int i = curMin; i < N-1; i++){
            temp += d[i];
        }
        price += temp * p[curMin];
        oldMin = curMin;
        temp = 0;

        while(true){
            if(oldMin == 0)
                break;
            curMin = minSearch(oldMin,p);
            temp = 0;
            for (int i = curMin; i < oldMin; i++){
                temp += d[i];
            }
            price += temp * p[curMin];
            oldMin = curMin;

        }
        bw.write(String.valueOf(price));
        bw.flush();
        bw.close();

    }


    static int minSearch(int n, long[] arr){
        int min = 0;
        for(int i = 0; i < n; i++){
            if(arr[min] >arr[i])
                min = i;
        }
        return min;

    }
}