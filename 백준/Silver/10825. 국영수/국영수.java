import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Student[] arr = new Student[n];

        for (int i = 0; i <n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            arr[i] = new Student(name, k, e, m);

        }

        Arrays.sort(arr);

        for (int i = 0 ; i < n; i++){
            sb.append(arr[i].name).append("\n");
        }
        System.out.println(sb);

    }
    static class Student implements Comparable<Student>{
        String name;
        int k,e, m;

        public Student(String name, int k, int e, int m) {
            this.name = name;
            this.k = k;
            this.e = e;
            this.m = m;
        }

        @Override
        public int compareTo(Student o) {
            if (this.k != o.k){
                return o.k - this.k;
            }
            else if(this.e != o.e){
                return this.e - o.e;
            }
            else if (this.m != o.m){
                return o.m - this.m;
            }
            else {
                return this.name.compareTo(o.name);
            }
        }
    }

}
