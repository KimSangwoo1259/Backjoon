import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine(); // 원래 문자열
        LinkedList<Character> list = new LinkedList<>();
        for (int i = 0; i < str.length(); i++){
            list.add(str.charAt(i));
        }
        int m = Integer.valueOf(br.readLine()); // 명령어 개수

        StringTokenizer st ;
        String temp;

        ListIterator<Character> iter = list.listIterator();

        while (iter.hasNext()){
            iter.next();
        }

        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            temp = st.nextToken();
            if (temp.equals("L")){
                if (iter.hasPrevious())
                    iter.previous();

            }
            else if (temp.equals("D")){
                if (iter.hasNext())
                    iter.next();

            }
            else if (temp.equals("B")){
                if(iter.hasPrevious()) {
                    iter.previous();
                    iter.remove();
                }

            }
            else if (temp.equals("P")){
                char nextTemp = st.nextToken().toCharArray()[0];
                iter.add(nextTemp);
            }
        }
        Iterator<Character> iterator = list.iterator();

        while (iterator.hasNext()){
            bw.write(iterator.next());
        }
        bw.flush();
        bw.close();
    }


}