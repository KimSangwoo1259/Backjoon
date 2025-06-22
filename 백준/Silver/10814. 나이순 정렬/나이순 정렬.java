import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer line = Integer.valueOf(br.readLine());
        Set<Member> memberSet = new TreeSet<>();
        for (int i = 0; i < line; i++){
            String[] info = br.readLine().split(" ");
            memberSet.add(new Member(Integer.parseInt(info[0]), info[1], i));
        }
        for (Member m : memberSet){
            System.out.println(m);
        }


    }
    static class Member implements Comparable<Member> {
        int age;
        String name;
        int order;

        @Override
        public int compareTo(Member o) {
            if (this.age != o.age){
                return this.age - o.age;
            }
            else {
                return this.order - o.order;
            }
        }

        @Override
        public String toString() {
            return age + " " + name;
        }
        public Member (int age, String name, int order){
            this.age = age;
            this.name = name;
            this.order = order;

        }

    }
}