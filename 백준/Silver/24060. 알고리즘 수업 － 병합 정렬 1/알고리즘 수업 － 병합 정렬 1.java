import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int count = 0;
    static int n;
    static int k;
    static int[] temp;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.valueOf(st.nextToken());
        k = Integer.valueOf(st.nextToken());
        temp = new int[n];
        int[] a = new int[n];
        ans = -1;
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++){
            a[i] = Integer.valueOf(st.nextToken());
        }
        merge_sort(a, 0, n-1);
        System.out.println(ans);

    }
    public static void merge_sort(int[] arr,int p, int r){

        if(p < r){
            int q = (p + r) / 2;
            merge_sort(arr,p,q);
            merge_sort(arr,q+1,r);
            merge(arr, p, q, r);

        }
    }
    public static void merge(int[] arr,int p,int q ,int r){
        int i = p; int j = q +1; int t = i;
        while (i <= q && j <= r){
            if(arr[i] <= arr[j])
                temp[t++] = arr[i++];
            else
                temp[t++] = arr[j++];
        }
        while (i <= q)
            temp[t++] = arr[i++];
        while (j <= r)
            temp[t++] = arr[j++];
        i = p;
        while (i <= r){
            arr[i] = temp[i];
            count++;
            if (count == k)
                ans = arr[i];
            i++;
        }

    }
}