import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Set<String> numSet = new HashSet<>();
        List<PhoneNumber> numList = new ArrayList<>();
        for (String s : phone_book) {
            numList.add(new PhoneNumber(s));
        }
        numList.sort(Comparator.naturalOrder());
        int minLen = numList.get(0).len;
        int maxLen = numList.get(0).len;
        for (PhoneNumber number : numList) {
            for (int i = minLen; i <= maxLen; i++){
                if (numSet.contains(number.num.substring(0,i))){
                    answer = false;
                    break;
                }
            }
            if (!answer) break;
            numSet.add(number.num);
            maxLen = Math.max(maxLen, number.len);
        }

        return answer;
    }
    static class PhoneNumber implements Comparable<PhoneNumber> {
        String num;
        int len;
        public PhoneNumber(String num){
            this.num = num;
            this.len = num.length();
        }

        @Override
        public int compareTo(PhoneNumber o) {
            return this.len - o.len;
        }
    }
}