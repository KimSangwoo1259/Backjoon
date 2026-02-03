import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    static int n;
    static int[] arr;
    static List<String> list;
    static boolean found;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        list = new ArrayList<>();
        found = false;
        backtracking(1);


    }

    //숫자 추가 했을때 index / 2 까지만 검사하면됨
    static void backtracking(int index) {
        if (found)
            return;
        if (index > n){
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++){
                sb.append(arr[i]);
            }
            System.out.println(sb.toString());
            found = true;
            return;
        }
        for (int i = 1; i <= 3; i++){
            if (index == 1){
                arr[index] = i;
                backtracking(index + 1);
            }
            else {
                boolean realSame = false;
                for (int j = 1; j <= index/2; j++){
                    arr[index] = i;
                    boolean isSame = true;
                    for (int k = 0; k < j; k++){
                        if (arr[index-k] != arr[index-j-k]) {
                            isSame = false;
                            break;
                        }
                    }
                    if (isSame) {
                        realSame = true;
                        break;
                    }
                }
                if (!realSame){
                    backtracking(index + 1);
                }
            }
        }
    }


}
