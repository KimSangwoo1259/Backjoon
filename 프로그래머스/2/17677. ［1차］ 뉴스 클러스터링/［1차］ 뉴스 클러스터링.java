class Solution {
public int solution(String str1, String str2) {

        int intersection = 0;
        int union = 0;

        int[][] alpha1 = new int[26][26];
        int[][] alpha2 = new int[26][26];

        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();

        for (int i = 0; i < str1.length()-1; i++){
            int index1 = str1.charAt(i) - 'a';
            int index2 = str1.charAt(i+1) - 'a';
            if(index1 >= 0 && index1 < 26 && index2 >= 0 && index2 < 26){
                alpha1[index1][index2]++;
            }
        }

        for (int i = 0; i < str2.length()-1; i++){
            int index1 = str2.charAt(i) - 'a';
            int index2 = str2.charAt(i+1) - 'a';
            if(index1 >= 0 && index1 < 26 && index2 >= 0 && index2 < 26){
                alpha2[index1][index2]++;
            }
        }

        for (int i = 0; i < 26; i++){
            for (int j = 0; j < 26; j++){
                intersection += Math.min(alpha1[i][j], alpha2[i][j]);
                union += Math.max(alpha1[i][j], alpha2[i][j]);
            }

        }

        if (intersection == 0 && union == 0){
            return 65536;
        }

        double rate = (double) intersection / (double) union;
        System.out.println(rate);
        return (int) (rate * (double) 65536);

    }
}