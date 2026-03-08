
import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        Map<Position, Integer> posCountMap = new HashMap<>();
        Queue<Robot> robotQueue = new LinkedList<>();

        for (int i = 0; i < routes.length; i++){
            int point = routes[i][0] - 1;

            robotQueue.add(new Robot(points[point][0], points[point][1], routes[i], 1));
            Position p = new Position(points[point][0], points[point][1]);
            posCountMap.put(p, posCountMap.getOrDefault(p, 0) + 1);
        }
        while(robotQueue.size() > 1){ // 1대면 충돌 위험도 없음
            Set<Position> keySet = posCountMap.keySet();
            for (Position p: keySet){
                if (posCountMap.get(p) > 1)
                    answer++;
            }
            posCountMap.clear();
            int size = robotQueue.size();

            for (int i = 0; i < size; i++){
                Robot now = robotQueue.poll();

                int nowX = now.nowx;
                int nowY = now.nowy;

                int targetPoint = now.route[now.targetIndex] - 1;

                int targetX = points[targetPoint][0];
                int targetY = points[targetPoint][1];


                if (nowX != targetX){ //상하 운동 우선
                    if (nowX > targetX)
                        nowX--;
                    else
                        nowX++;
                }
                else {
                    if (nowY > targetY)
                        nowY--;
                    else
                        nowY++;

                }
                if (nowX == targetX && nowY == targetY)
                    now.targetIndex++;

                if (now.targetIndex < now.route.length)
                    robotQueue.add(new Robot(nowX, nowY, now.route, now.targetIndex));

                Position p = new Position(nowX, nowY);
                posCountMap.put(p, posCountMap.getOrDefault(p, 0) + 1);
            }

        }
        Set<Position> keySet = posCountMap.keySet();
        for (Position p: keySet){
            if (posCountMap.get(p) > 1)
                answer++;
        }

        return answer;
    }
    public class Robot {
        int nowx, nowy;
        int[] route;
        int targetIndex;

        public Robot(int nowx, int nowy, int[] route, int targetIndex) {
            this.nowx = nowx;
            this.nowy = nowy;
            this.route = route;
            this.targetIndex = targetIndex;
        }
    }
    public class Position {
        int x, y;

        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return x == position.x && y == position.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

// 이동할때 상하 이동이 좌우 이동보다 우선시된다.
// 같은시간에 여러대가 한곳에 부딪히는건 한번의 위험상황으로 간주
// 같은시간에 여러곳에서 부딪히는건 여러번의 위험상황