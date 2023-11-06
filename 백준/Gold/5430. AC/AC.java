import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int t = Integer.valueOf(br.readLine());
        for (int i = 0; i < t; i++) {
            boolean isError = false;
            Deque<Integer> deque = new ArrayDeque<>();
            String cmd = br.readLine(); // 명령어
            int n = Integer.valueOf(br.readLine()); //배열 길이
            String str = br.readLine();
            str = str.replace("[", "").replace("]","");
            String[] split = str.split(",");
            for (int j = 0; j < n; j++) {
                deque.add(Integer.valueOf(split[j]));
            }
            int reverseStack = 0;
            for (int j = 0; j < cmd.length(); j++) {
                if (cmd.charAt(j) == 'R')
                    reverseStack++;
                else { //-> D
                    if (deque.isEmpty()) {
                        bw.write("error" + "\n");
                        isError = true;
                        break;
                    } else {
                        if (reverseStack % 2 == 0) {// 짝수 -> 원래 본문
                            deque.removeFirst();
                        } else { // 홀수 -> 바뀜
                            deque.removeLast();
                        }

                    }


                }
            }
            if (!isError) {
                bw.write("[");
                if (reverseStack % 2 == 0) {
                    if (!deque.isEmpty()) {
                        bw.write(deque.getFirst() + "");
                        deque.removeFirst();
                    }

                    int size = deque.size();
                    for (int k = 0; k < size; k++) {
                        bw.write("," + deque.getFirst());
                        deque.removeFirst();
                    }
                } else {
                    if (!deque.isEmpty()) {
                        bw.write(deque.getLast() + "");
                        deque.removeLast();
                    }

                    int size = deque.size();
                    for (int k = 0; k < size; k++) {
                        bw.write("," + deque.getLast());
                        deque.removeLast();
                    }

                }
                bw.write("]" + "\n");

            }


        }
        bw.flush();
        bw.close();
    }
}