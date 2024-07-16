import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 1000000000;

        int step = minerals.length/ 5;
        if (minerals.length % 5 != 0)
            step++;
        
        int[] dia = new int[step];
        int[] iron = new int[step];
        int[] stone = new int[step];

        for (int i = 0; i < step; i++){
            for(int j = i * 5; j < i * 5 + 5 && j < minerals.length; j++){
                if (minerals[j].equals("diamond")){
                    dia[i] += 1;
                    iron[i] += 5;
                    stone[i] += 25;
                }
                else if (minerals[j].equals("iron")){
                    dia[i] += 1;
                    iron[i] += 1;
                    stone[i] += 5;
                }
                else{
                    dia[i] += 1;
                    iron[i] += 1;
                    stone[i] += 1;
                }
            }
        }
        Queue<My> q = new LinkedList<>();

        q.add(new My(picks[0], picks[1], picks[2], 0, 0));
        
        while(!q.isEmpty()) {
            My m = q.poll();
            if (m.level < step&& (m.dia > 0 || m.iron > 0 || m.stone > 0)) {
                if (m.dia > 0) {
                    q.add(new My(m.dia - 1,m.iron, m.stone, m.fatigue + dia[m.level],m.level + 1));
                }
                if (m.iron > 0) {
                    q.add(new My(m.dia,m.iron-1, m.stone, m.fatigue + iron[m.level],m.level + 1));
                }
                if (m.stone > 0) {
                    q.add(new My(m.dia,m.iron, m.stone-1, m.fatigue + stone[m.level],m.level + 1));
                }
            }
            else {
                answer = Math.min(answer, m.fatigue);
            }
        }


        return answer;
    }
    class My{
        int dia,iron,stone,fatigue,level;
        public My(int dia, int iron, int stone, int fatigue, int level){
            this.dia = dia;
            this.iron = iron;
            this.stone = stone;
            this.fatigue = fatigue;
            this.level = level;
        }

    }
}
// 1. 한번 사용한건 끝까지
// 2. 주어진 순서대로 캐야함
// 3. 종료 조건 -> 곡괭이 없거나 or 광물이 없거나