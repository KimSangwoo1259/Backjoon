import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Solution {
public int solution(String dirs) {
        int answer = 0;
        final int BORDER = 5;


        int curX = 0;
        int curY = 0;

        Set<PosAndDir> posSet  = new HashSet<>();

        for (char c : dirs.toCharArray()) {
            switch (c) {
                case 'U':
                    if (curY < 5){
                        PosAndDir pad = new PosAndDir(curX, curY, c);
                        if (!posSet.contains(pad)){
                            posSet.add(pad);
                            posSet.add(new PosAndDir(curX, curY+1, 'D'));
                            answer++;
                        }
                        curY++;
                    }
                    break;

                case 'D':
                    if (curY > -5){
                        PosAndDir pad = new PosAndDir(curX, curY, c);
                        if (!posSet.contains(pad)){
                            posSet.add(pad);
                            posSet.add(new PosAndDir(curX, curY-1, 'U'));
                            answer++;
                        }
                        curY--;
                    }
                    break;
                case 'L':
                    if (curX > -5){
                        PosAndDir pad = new PosAndDir(curX, curY, c);
                        if (!posSet.contains(pad)){
                            posSet.add(pad);
                            posSet.add(new PosAndDir(curX-1, curY, 'R'));
                            answer++;
                        }
                        curX--;
                    }
                    break;
                case 'R':
                    if (curX < 5){
                        PosAndDir pad = new PosAndDir(curX, curY, c);
                        if (!posSet.contains(pad)){
                            posSet.add(pad);
                            posSet.add(new PosAndDir(curX+1, curY, 'L'));
                            answer++;
                        }
                        curX++;
                    }
                    break;
            }
        }

        return answer;
    }
    class PosAndDir{
        int x, y;
        char dir;

        PosAndDir(int x, int y, char dir){
            this.x = x;
            this.y = y;
            this.dir = dir;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PosAndDir posAndDir = (PosAndDir) o;
            return x == posAndDir.x && y == posAndDir.y && Objects.equals(dir, posAndDir.dir);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, dir);
        }
    }
}