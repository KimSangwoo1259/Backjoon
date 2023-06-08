import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));



        Map<String, Integer> map = new HashMap<>();

        int count = 0;

        String tree = br.readLine();

        while (true){
            map.put(tree, map.getOrDefault(tree, 0) + 1); //map에 나무 정보가 있으면 그값에 1을 더하고 없으면 1으로 설정
            count++;
            tree = br.readLine();
            if(tree == null || tree.length() ==0)
                break;

        }
        Object[] keyArr = map.keySet().toArray();
        Arrays.sort(keyArr); //사전순으로 key값 정렬

        StringBuilder sb = new StringBuilder();
        for (Object o : keyArr) {
            String key = (String) o;
            double rate = (double) ((map.get(key) * 100.0)) / count;
            sb.append(key + " " + String.format("%.4f", rate) + '\n');
        }
        System.out.println(sb.toString());

    }
}