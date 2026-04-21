class Solution {
    // 부분팰린드롬 최대 길이 구하라 s 는 2500이하의 길이
    //
    public int solution(String s) {
        int answer = 1;
        // 왼쪽이랑 같아?
        // 오른쪽이랑 같아?
        // 나제외 양쪽으로 같아?
        char[] stringArr = s.toCharArray();
        if (s.length() == 2){
            if (stringArr[0] == stringArr[1])
                answer = 2;
        }
        else {
            for (int i = 1; i < s.length() - 1; i++) {
                char left = stringArr[i - 1];
                char now = stringArr[i];
                char right = stringArr[i + 1];

                // 왼쪽이랑 같아?
                if (left == now) {
                    int l = i - 1;
                    int r = i;

                    while (l >= 0 && r < s.length()) {
                        if (stringArr[l] == stringArr[r]) {
                            l--;
                            r++;
                        } else
                            break;
                    }
                    l++;
                    r--;
                    answer = Math.max(answer, (r - l + 1));
                }

                //오른쪽이랑 같아?
                if (right == now) {
                    int l = i;
                    int r = i + 1;

                    while (l >= 0 && r < s.length()) {
                        if (stringArr[l] == stringArr[r]) {
                            l--;
                            r++;
                        } else
                            break;
                    }
                    l++;
                    r--;
                    answer = Math.max(answer, (r - l + 1));

                }

                // 나 제외 양쪽으로 같아?
                if (left == right) {
                    int l = i - 1;
                    int r = i + 1;

                    while (l >= 0 && r < s.length()) {
                        if (stringArr[l] == stringArr[r]) {
                            l--;
                            r++;
                        } else
                            break;
                    }
                    l++;
                    r--;
                    answer = Math.max(answer, (r - l + 1));

                }
            }
        }

        return answer;
    }
}