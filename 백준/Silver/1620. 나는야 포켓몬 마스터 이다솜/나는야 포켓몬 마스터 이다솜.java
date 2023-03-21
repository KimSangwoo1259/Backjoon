import java.util.*;



public class Main{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int index = 1;
        Map<String, Integer> map = new LinkedHashMap<>(); //순서를 그대로 유지하기 위해 LinkedHashMap사용



        for(int i = 0; i < N; i++){
            String name = sc.next();
            map.put(name,index);
            index++;
        }
        String[] keyArr = map.keySet().toArray(new String[map.size()]);
        List<String> answer = new ArrayList<>();
        for(int i = 0; i< M; i++){
            String q = sc.next();
            if(map.containsKey(q))
                answer.add(Integer.toString(map.get(q)));
            else{
                int que = Integer.valueOf(q);
                answer.add(keyArr[que-1]);
            }
        }

        for (String ans : answer){
            System.out.println(ans);
        }

    }
}