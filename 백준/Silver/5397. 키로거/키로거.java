import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int j = 0; j < t; j++){
            LinkedList<Character> linkedList = new LinkedList<>();
            ListIterator<Character> iter = linkedList.listIterator();
            String str = br.readLine();
            char temp;
            for (int i = 0; i < str.length(); i++){
                temp = str.charAt(i);
                if (temp == '<'){
                    if (iter.hasPrevious()){
                        iter.previous();
                    }
                }
                else if(temp == '>'){
                    if (iter.hasNext()){
                        iter.next();
                    }
                }
                else if (temp == '-'){
                    if (iter.hasPrevious()){
                        iter.previous();
                        iter.remove();
                    }
                }
                else{
                    iter.add(temp);
                }
            }
            while (iter.hasPrevious())
                iter.previous();
            while (iter.hasNext()){
                bw.write(iter.next());
            }
            bw.write("\n");

        }
        bw.flush();
        bw.close();

    }
}