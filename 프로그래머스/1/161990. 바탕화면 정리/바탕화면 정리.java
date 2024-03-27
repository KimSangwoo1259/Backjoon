class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = new int[4];
        int top = wallpaper.length;
        int bottom = 0;
        int west = wallpaper[0].length();
        int east = 0;

        for (int i = 0; i < wallpaper.length; i++){
            for (int j = 0; j < wallpaper[i].length(); j++){
                if (wallpaper[i].charAt(j) == '#'){
                    top = Math.min(top,i);
                    bottom = Math.max(bottom, i);
                    west = Math.min(west, j);
                    east = Math.max(east, j);
                }
            }
        }
        answer[0] = top;
        answer[1] = west;
        answer[2] = bottom + 1;
        answer[3] = east + 1;
        return answer;
    }
}