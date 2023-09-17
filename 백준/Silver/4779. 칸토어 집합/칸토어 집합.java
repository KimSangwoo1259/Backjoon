import java.io.*;

public class Main {
    static int n;
    static String s;
    static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        String tempSt;
        while ((tempSt= br.readLine()) != null){
            n = Integer.valueOf(tempSt);
            for (int i = 0; i < (int) Math.pow(3,n); i++){
                sb.append("-");
            }

            can(sb,0,(int)Math.pow(3,n)-1);
            s = sb.toString();
            System.out.println(s);

            s = "";
            sb.setLength(0);

        }
    }
    static void can(StringBuilder sb, int start, int end) {
        if (start < end) {
            int num1 = start + ((end - start + 1) / 3) - 1;
            int num2 = start + (((end - start +1) / 3) * 2);
            for (int i = num1 + 1;  i < num2; i++) {
                sb.setCharAt(i, ' ');
            }
            can(sb,start, num1);
            can(sb,num2, end);
        }

    }

}