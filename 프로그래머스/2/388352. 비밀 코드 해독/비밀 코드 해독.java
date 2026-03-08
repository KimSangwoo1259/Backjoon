
import java.util.*;

class Solution {
    static Set<Integer> temp;
    static int len;
    static Set<Set<Integer>> set;
    static Set<Integer> check;
    static List<Integer> others;
    public static int solution(int n, int[][] q, int[] ans) {
        len = n;
        set = new HashSet<>();
        temp = new HashSet<>();
        check = new HashSet<>();
        others = new ArrayList<>();

        int[] q1 = q[0];
        int ans1 = ans[0];
        for (int i = 0; i < 5; i++){
            check.add(q1[i]);
        }
        for (int i = 1; i <= len; i++){
            if (!check.contains(i))
                others.add(i);
        }
        back(0,ans1,q1,-1,-1);


        for (int i = 1; i < q.length; i++){
            int[] question = q[i];

            Iterator<Set<Integer>> iterator = set.iterator();

            while(iterator.hasNext()){
                Set<Integer> now = iterator.next();
                int count = 0;
                for (int j = 0; j < 5; j++){
                    if (now.contains(question[j]))
                        count++;
                }
                if (count != ans[i]){
                    iterator.remove();
                }
            }
        }
        return set.size();

    }
    public static void back(int index, int ans, int[] q1,int lastQIndex, int lastOIndex){
        if (index == 5){
            set.add(new HashSet<>(temp));
        }
        else if (index < ans){
            for (int i = lastQIndex+1; i < 5; i++){
                if (!temp.contains(q1[i])){
                    temp.add(q1[i]);
                    back(index +1,ans,q1,i,lastOIndex);
                    temp.remove(q1[i]);
                }
            }
        }
        else {
            for (int i = lastOIndex + 1; i < others.size(); i++){
                int value = others.get(i);
                if (!temp.contains(value)){
                    temp.add(value);
                    back(index+1,ans,q1,lastQIndex,i);
                    temp.remove(value);
                }
            }

        }
    }

}