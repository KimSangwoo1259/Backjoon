import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int topA = Integer.valueOf(st.nextToken());
        int botA = Integer.valueOf(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int topB = Integer.valueOf(st.nextToken());
        int botB = Integer.valueOf(st.nextToken());

        int top = (topA * botB) + (topB *botA);
        int bot = botA * botB;

        int tempTop = top;
        int tempBot = bot;

        if(tempTop > tempBot){
            while(tempBot != 0){
                int r = tempTop%tempBot;
                tempTop = tempBot;
                tempBot = r;
            }
            top = top / tempTop;
            bot = bot / tempTop;
        }
        else{
            while(tempTop != 0){
                int r = tempBot%tempTop;
                tempBot = tempTop;
                tempTop = r;
            }
            top = top / tempBot;
            bot = bot / tempBot;
        }
        bw.write(top + " " + bot);
        bw.flush();
        bw.close();

    }
}