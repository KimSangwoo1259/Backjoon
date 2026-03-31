import java.util.*;

class Solution {

    int answer;
    public int solution(int n, int infection, int[][] edges, int k) {
        answer = 0;

        List<Integer>[][] listArr = new List[n + 1][4];



        for (int i = 1; i <=n; i++){
            listArr[i][1] = new ArrayList<>();
            listArr[i][2] = new ArrayList<>();
            listArr[i][3] = new ArrayList<>();
        }

        for (int i = 0; i <edges.length; i++){
            int start = edges[i][0];
            int end = edges[i][1];
            int value = edges[i][2];

            listArr[start][value].add(end);
            listArr[end][value].add(start);
        }

        Set<Integer> list = new HashSet<>();
        list.add(infection);


        Queue<Virus> q = new LinkedList<>();
        q.add(new Virus(list, 0));

        while(!q.isEmpty()){
            Virus now = q.poll();
            
            if (now.level == k){
                answer = Math.max(answer, now.virusList.size());
            }
            else {
                for (int i = 1; i <= 3; i++) {
                    Set<Integer> vList = new HashSet<>(now.virusList);
                    Set<Integer> temp = new HashSet<>(now.virusList);
                    Set<Integer> temp2 = new HashSet<>();
                    while(true){
                        int nowSize = temp.size();
                        for (int v: temp){
                            List<Integer> connected = listArr[v][i];
                            
                            for (int c: connected){
                                if (!vList.contains(c) && !temp.contains(c) && !temp2.contains(c)){
                                    temp2.add(c);
                                }
                            }
                            
                        }
                        vList.addAll(temp);
                        temp.addAll(temp2);
                        temp2.clear();
                        int nextSize = temp.size();

                        if (nowSize == nextSize)
                            break;
                        
                    }
                    q.add(new Virus(vList, now.level + 1));
                }
            }
        }





        return answer;
    }
    class Virus {
        Set<Integer> virusList;
        int level;
        public Virus(Set<Integer> virusList, int level) {
            this.virusList = virusList;
            this.level =level;
        }
    }

}