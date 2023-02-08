import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.replace("dz=",".");
        s = s.replace("=","");
        s = s.replace("-","");
        s = s.replace("lj",".");
        s = s.replace("nj",".");

        System.out.println(s.length());
    }
}