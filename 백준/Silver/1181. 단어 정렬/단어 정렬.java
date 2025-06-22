import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {

  
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer line = Integer.valueOf(br.readLine());
        Set<Word> wordSet = new TreeSet<>();
        for (int i = 0; i < line; i++){
            String word = br.readLine();
            wordSet.add(new Word(word));
        }
        for (Word word: wordSet){
            System.out.println(word.value);
        }

    }
    static class Word implements Comparable<Word> {
        String value;

        @Override
        public int compareTo(Word o) {
            int o1Len = this.value.length();
            int o2Len = o.value.length();

            if (o1Len != o2Len)
                return o1Len - o2Len;
            else
                return this.value.compareTo(o.value);

        }
        public Word (String value){
            this.value = value;
        }
    }
}