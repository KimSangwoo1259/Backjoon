class Solution {
    public long[] solution(long[] numbers) {
        final int LEN = numbers.length;
        long[] answer = new long[LEN];

        for (int i = 0; i < LEN; i++) {
            long now = numbers[i];

            if (now % 2 == 0) {
                answer[i] = now + 1;
            } else {
                int firstZeroIndex = -1;

                StringBuilder sb = convertToBinary(now);

                for (int j = sb.length() - 1; j >= 0; j--) {
                    if (sb.charAt(j) == '0') {
                        firstZeroIndex = j;
                        break;
                    }
                }

                if (firstZeroIndex == -1) {
                    sb.deleteCharAt(0);
                    sb.insert(0, "10");
                } else {
                    sb.replace(firstZeroIndex, firstZeroIndex + 1, "1");
                    sb.replace(firstZeroIndex + 1, firstZeroIndex + 2, "0");
                }

                answer[i] = convertToDecimal(sb);
            }
        }
        // 1111011

        return answer;
    }

    public StringBuilder convertToBinary(long num) {
        StringBuilder sb = new StringBuilder();

        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
        }

        return sb.reverse();
    }

    public long convertToDecimal(StringBuilder sb) {
        long decimalValue = 0;
        for (int i = 0; i < sb.length(); i++) {
            decimalValue += Character.getNumericValue(sb.charAt(i)) * (long) Math.pow(2, sb.length() - 1 - i);
        }

        return decimalValue;
    }
}