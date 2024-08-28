import java.util.*;    

class Solution {
        public String[] solution(String[] files) {

            List<File> list = new ArrayList<>();

            for (String file : files) {
                int LastHeadIndex = 0;
                int LastNumIndex = file.length();
                for (int i = 0; i < file.length(); i++) {
                    if (file.charAt(i) - '0' >= 0 && file.charAt(i) - '0' < 10) {
                        LastHeadIndex = i;
                        break;
                    }
                }
                for (int i = LastHeadIndex; i < file.length(); i++) {
                    if(file.charAt(i) - '0' < 0 || file.charAt(i) - '0' > 9) {
                        LastNumIndex = i;
                        break;
                    }
                }
                String head = file.substring(0, LastHeadIndex);
                String num = file.substring(LastHeadIndex, LastNumIndex);
                String tail = file.substring(LastNumIndex);
                list.add(new File(head, num, tail));
            }
            list.sort(Comparator.comparing(File::getHead, String.CASE_INSENSITIVE_ORDER)
                    .thenComparingInt(File::getNumber));

            String[] answer = new String[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i).toString();
            }

            return answer;
        }
    }
    class File {
        

        public String getHead() {
            return head;
        }

        public int getNumber() {
            return Integer.parseInt(number);
        }

        public String getTail() {
            return tail;
        }

        String head;
        String number;
        String tail;

        public File(String head, String number, String tail) {
            this.head = head;
            this.number = number;
            this.tail = tail;
        }

        @Override
        public String toString() {
            return head + number + tail;
        }
    }