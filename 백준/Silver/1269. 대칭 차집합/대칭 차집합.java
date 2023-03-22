import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int duplicationCount = 0;
        Set<Integer> numSet = new HashSet<>();
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < n; i++){
            int input = Integer.parseInt(st.nextToken());
            numSet.add(input);
        }
        st = new StringTokenizer(bf.readLine());
        for(int i = 0; i < m; i++){
            int input = Integer.parseInt(st.nextToken());
            if(numSet.contains(input))
                duplicationCount++;
        }

        System.out.println((n + m) - 2 * duplicationCount);

    }
}