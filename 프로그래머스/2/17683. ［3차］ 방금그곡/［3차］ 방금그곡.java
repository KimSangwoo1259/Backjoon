import java.text.ParseException;
import java.time.Duration;
import java.time.LocalTime;
import java.util.*;

class Solution {
  public String solution(String m, String[] musicinfos) throws ParseException {

        String answer = "";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m.length(); i++){
            char temp = m.charAt(i);
            if (i != m.length() - 1){
                if (m.charAt(i + 1) == '#'){
                    temp += 32;
                    i++;
                }
            }
            sb.append(temp);
        }
        String newM = sb.toString();

        List<Music> musicList = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            String[] infos = musicinfos[i].split(",");
            musicList.add(new Music(infos[0], infos[1], infos[2], infos[3]));
        }
        musicList.sort(Music::compareTo);

        for (int i = 0; i < musicList.size(); i++) {
            if (musicList.get(i).sounds.contains(newM)){
                answer = musicList.get(i).name;
                break;
            }
        }
        if (answer.isEmpty())
            return "(None)";

        return answer;
    }
    static class Music implements Comparable<Music> {
        int length;
        String name;
        String sounds;

        public Music(String startDate, String endDate, String name, String sounds) throws ParseException {
            LocalTime start = LocalTime.parse(startDate);
            LocalTime end = LocalTime.parse(endDate);
            this.length = (int) Duration.between(start, end).toMinutes();
            this.name = name;
            int i = 0;
            int time = 0;
            StringBuilder sb = new StringBuilder();
            int strLen = sounds.length();
            System.out.println(strLen);
            while(time < this.length){
                char temp = sounds.charAt(i % strLen);
                if (i != strLen-1){
                    if (sounds.charAt((i + 1) % strLen) == '#'){
                        temp += 32;
                        i++;
                    }
                }
                i++;
                time++;
                sb.append(temp);
            }
            this.sounds = sb.toString();
            System.out.println(length + " " + this.name + " " + this.sounds);
        }
        @Override
        public int compareTo(Music o) {
            return o.length - this.length;
        }
    }
}