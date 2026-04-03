import java.util.*;

class Solution {

    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        Map<String, Integer> map = new HashMap<>();
        int languageBias = (int) Math.pow(3, 3);
        int positionBias = (int) Math.pow(3, 2);
        int careerBias = (int) Math.pow(3, 1);

        map.put("cpp", 0);
        map.put("java", languageBias);
        map.put("python", 2 * languageBias);

        map.put("backend", 0);
        map.put("frontend", positionBias);

        map.put("junior", 0);
        map.put("senior", careerBias);

        map.put("chicken", 0);
        map.put("pizza", 1);

        List<Integer>[] lists = new List[80];

        for (int i = 0; i < 80; i++){
            lists[i] = new ArrayList<>();
        }

        for (int i = 0; i < info.length; i++){
            String[] split = info[i].split(" ");

            String language = split[0];
            String position = split[1];
            String career = split[2];
            String food = split[3];
            int score = Integer.parseInt(split[4]);

            int index = map.get(language) + map.get(position) + map.get(career) + map.get(food);

            lists[index].add(score);
        }
        for (int i = 0; i < lists.length; i++){
            lists[i].sort(Comparator.comparingInt(o -> o));
        }

        for (int i = 0; i < query.length; i++){
            String[] split = query[i].split(" and ");
            String language = split[0];
            String position = split[1];
            String career = split[2];
            String[] nestedSplit = split[3].split(" ");
            String food = nestedSplit[0];
            int score = Integer.parseInt(nestedSplit[1]);

            String anything = "-";

            List<Integer> queryList = new ArrayList<>();

            if (language.equals(anything)){
                queryList.add(map.get("cpp"));
                queryList.add(map.get("java"));
                queryList.add(map.get("python"));
            }
            else {
                queryList.add(map.get(language));
            }
            List<Integer> temp = new ArrayList<>();
            for (int q : queryList){
                if (position.equals(anything)){
                    temp.add(q + map.get("backend"));
                    temp.add(q + map.get("frontend"));
                }
                else {
                    temp.add(q + map.get(position));
                }

            }
            queryList = new ArrayList<>(temp);
            temp.clear();

            for (int q : queryList){
                if (career.equals(anything)){
                    temp.add(q + map.get("senior"));
                    temp.add(q + map.get("junior"));
                }
                else {
                    temp.add(q + map.get(career));
                }

            }
            queryList = new ArrayList<>(temp);
            temp.clear();

            for (int q : queryList){
                if (food.equals(anything)){
                    temp.add(q + map.get("chicken"));
                    temp.add(q + map.get("pizza"));
                }
                else {
                    temp.add(q + map.get(food));
                }

            }
            queryList = new ArrayList<>(temp);
            temp.clear();


            int count = 0;
            for (int q : queryList){
                List<Integer> target = lists[q];

                if (target.isEmpty())
                    continue;

                int left = 0;
                int right = target.size() - 1;

                int t = target.size();

                while(left <= right){
                    int mid = (left + right) / 2;

                    int value = target.get(mid);
                    if (value >= score){
                        t = mid;
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                count += target.size() - t;
            }

            answer[i] = count;

        }
        return answer;
    }



}
