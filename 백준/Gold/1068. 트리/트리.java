import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static List<Integer>[] lists;
    static boolean[] deleted;
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.valueOf(br.readLine());

        lists = new List[n];
        for (int i = 0; i < n; i++){
            lists[i] = new ArrayList<>();
        }
        deleted = new boolean[n];
        count = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++){
            int temp = Integer.valueOf(st.nextToken());
            if (temp != -1){
                lists[temp].add(i);
            }
        }
        int deleteNode = Integer.valueOf(br.readLine());
        deleted[deleteNode] = true;
        delete(deleteNode);

        for (int i = 0; i < n; i++){
            if (!deleted[i]){
                boolean isLeaf = true;
                for (int j = 0; j < lists[i].size(); j++){
                    if (!deleted[lists[i].get(j)]){
                        isLeaf = false;
                        break;
                    }
                }
                if (isLeaf) {
                    count++;
                }
            }

        }
        System.out.println(count);

    }
    static void delete(int n){
        if (lists[n].isEmpty())
            return;

        for (int num : lists[n]){
            deleted[num] = true;
            delete(num);
        }
    }

}