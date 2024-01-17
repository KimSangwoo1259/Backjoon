import java.io.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        String str = br.readLine();

        String[] splitArr= str.split("-");
        String[] split0 = splitArr[0].split("\\+");
        for (int i = 0; i < split0.length; i++){
            sum += Integer.valueOf(split0[i]);
        }
        for (int i = 1; i < splitArr.length; i++){
            String[] temp = splitArr[i].split("\\+");
            for (int j = 0; j < temp.length; j++){
                sum -= Integer.valueOf(temp[j]);
            }
        }
        System.out.println(sum);
    }
}