import java.io.*;
import java.util.*;


public class Main {

    // 일단 bfs로 푸는거 같음
    // 숫자배열을 문자열로 비교를 하자.
    // 0은 상하좌우로 움직일 수 있음. 상 -> -3 하 -> +3; 좌 -> -1 우 -> +1
    // 좌는 index % 3 !=0 일때만 가능 우는 index % 3 != 2 일때만 가능
    // 상은 index - 3 >= 0 일때만 하는 index + 3 < 9 일때만 가능
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        HashSet<String> puzzleSet = new HashSet<>();

        String ansStr = "123456780";

        int ans = -1;
        for (int i = 0; i < 3; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++){
                sb.append(st.nextToken());
            }
        }
        Queue<Puzzle> q = new LinkedList<>();
        Puzzle first = new Puzzle(sb.toString(), 0);

        puzzleSet.add(first.str);
        q.add(first);

        while(!q.isEmpty()){
            Puzzle now = q.poll();
            String nowStr = now.str;
            if (nowStr.equals(ansStr)){
                ans = now.count;
                break;
            }

            int zeroIndex = nowStr.indexOf("0");

            // 위로
            if (zeroIndex - 3 >= 0){
                String upSwapStr = swap(nowStr, zeroIndex, zeroIndex - 3);
                if (!puzzleSet.contains(upSwapStr)){
                    q.add(new Puzzle(upSwapStr, now.count + 1));
                    puzzleSet.add(upSwapStr);
                }
            }
            // 아래로
            if (zeroIndex + 3 < 9){
                String downSwapStr = swap(nowStr, zeroIndex, zeroIndex + 3);
                if (!puzzleSet.contains(downSwapStr)){
                    q.add(new Puzzle(downSwapStr, now.count + 1));
                    puzzleSet.add(downSwapStr);
                }
            }
            //좌
            if (zeroIndex % 3 != 0){
                String leftSwapStr = swap(nowStr, zeroIndex, zeroIndex - 1);
                if (!puzzleSet.contains(leftSwapStr)){
                    q.add(new Puzzle(leftSwapStr, now.count + 1));
                    puzzleSet.add(leftSwapStr);
                }
            }
            //우
            if (zeroIndex % 3 != 2){
                String rightSwapStr = swap(nowStr, zeroIndex, zeroIndex + 1);
                if (!puzzleSet.contains(rightSwapStr)){
                    q.add(new Puzzle(rightSwapStr, now.count + 1));
                    puzzleSet.add(rightSwapStr);
                }
            }



        }

        System.out.println(ans);



    }
    static class Puzzle{
        String str;
        int count;

        public Puzzle(String str, int count) {
            this.str = str;
            this.count = count;
        }

    }
    static String swap(String s, int i, int j){
        char[] strArr = s.toCharArray();

        char temp = strArr[i];
        strArr[i] = strArr[j];
        strArr[j] = temp;

        return String.valueOf(strArr);
    }


}