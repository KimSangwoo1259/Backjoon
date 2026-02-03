import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int r;
    static int c;
    static char[][] board;
    static boolean[] alphabet;
    static int ans;
    static int[] dr = {0,1,0,-1};
    static int[] dc = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        ans = 1; //왼쪽 상단 시작위치도 포함 이라서 1로 시작
        board = new char[r][c];
        alphabet = new boolean[26];
        for (int i = 0; i < r; i++){
            String str = br.readLine();
            for (int j = 0; j < c; j++){
                board[i][j] = str.charAt(j);
            }
        }
        alphabet[board[0][0] - 'A'] = true;

        dfs(1,0,0);

        System.out.println(ans);
    }
    //종료 시점. 이미 밟은 알파벳 일 경우, or 범위를 넘은 경우에 종료
    static void dfs(int l,int x, int y){
        for (int i = 0; i < 4; i++){
            int nr = x + dr[i];
            int nc = y + dc[i];
            //범위 초과인 경우! || 이미 밟은 알파벳 인 경우
            if (nr < 0 || nr >= r || nc < 0 || nc >= c || alphabet[board[nr][nc] - 'A']){
                ans = Math.max(ans, l);
                continue;
            }
            alphabet[board[nr][nc] - 'A'] = true;
            dfs(l+1, nr,nc);
            alphabet[board[nr][nc] - 'A'] = false;


        }
    }

}
