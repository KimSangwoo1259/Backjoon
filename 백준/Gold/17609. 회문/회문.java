import java.io.*;

public class Main {


    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();

        while(t --> 0){
            int inCorrectCount = 0;
            char[] strArr = br.readLine().toCharArray();
            int left = 0;
            int right = strArr.length - 1;

            while (left < right){
                if (inCorrectCount > 1)
                    break;
                if (strArr[left] == strArr[right]){
                    left++;
                    right--;
                }
                else {
                    // 만약 left 랑 right 랑 맞닿아있다면? -> 길이가 짝수라는건데 그냥 1 카운트 해주면됨 ㅇㅇ
                    if (left + 1 == right){
                        inCorrectCount++;
                        left++;
                        right--;
                    }
                    // 안 맞닿아있다?
                    else {
                        inCorrectCount++;
                        //두 경우 둘다 테스트 해봐야 하는데..
                        int left1 = left; int right1 = right -1 ;
                        int left2 = left + 1; int right2 = right;
                        boolean diff1 = false; boolean diff2 = false;

                        while(left1 < right1){
                            if (strArr[left1] != strArr [right1]){
                                diff1 = true;
                                break;
                            }
                            left1++; right1--;
                        }
                        while(left2 < right2){
                            if (strArr[left2] != strArr [right2]){
                                diff2 = true;
                                break;
                            }
                            left2++; right2--;
                        }
                        if (diff1 && diff2){
                            inCorrectCount++;
                        }
                        break;


                    }
                }
            }
            inCorrectCount = inCorrectCount > 1 ? 2 : inCorrectCount;
            answer.append(inCorrectCount);
            answer.append('\n');

        }
        System.out.println(answer.toString());

    }
}
