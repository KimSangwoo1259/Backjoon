import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int[][] answer;
        List<Data> dList = new ArrayList<>();
        final int LEN = data.length;
        int index = 4;
        if (ext.equals("code"))
            index = 0;
        else if (ext.equals("date"))
            index = 1;
        else if (ext.equals("maximum"))
            index = 2;
        else
            index = 3;
        for (int i = 0; i < LEN; i++){
            if (data[i][index] < val_ext)
                dList.add(new Data(data[i][0], data[i][1], data[i][2], data[i][3]));
        }


        if (sort_by.equals("code"))
           Collections.sort(dList,(Comparator.comparingInt(o -> o.code)));
        else if (sort_by.equals("date"))
            Collections.sort(dList,(Comparator.comparingInt(o -> o.date)));
        else if (sort_by.equals("maximum"))
            Collections.sort(dList,(Comparator.comparingInt(o -> o.maximum)));
        else
            Collections.sort(dList,(Comparator.comparingInt(o -> o.remain)));

        answer = new int[dList.size()][4];
        for (int i = 0; i < dList.size(); i++){
            Data now = dList.get(i);
            answer[i][0] = now.code;
            answer[i][1] = now.date;
            answer[i][2] = now.maximum;
            answer[i][3] = now.remain;
        }
        return answer;
    }

    static class Data {
        int code;
        int date;
        int maximum;
        int remain;

        Data(int c, int d, int m, int r){
            code = c;
            date = d;
            maximum = m;
            remain = r;

        }
    }
}