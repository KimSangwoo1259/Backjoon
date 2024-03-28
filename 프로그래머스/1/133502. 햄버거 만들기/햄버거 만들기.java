import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        Stack<Integer> main = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        for (int i = 0; i < ingredient.length; i++){
            if (ingredient[i] == 1){
                if (main.size() < 3)
                    main.push(ingredient[i]);
                else {
                    for (int j = 3; j >= 1; j--){
                        if (main.peek() == j){
                            temp.push(main.pop());
                        }
                        else 
                            break;
                    }
                    if (temp.size() == 3) {
                        answer++;
                        while (!temp.isEmpty())
                            temp.pop();
                    }
                    else{
                        while (!temp.isEmpty())
                            main.push(temp.pop());
                        main.push(ingredient[i]);
                    }
                }
            }
            else {
                main.push(ingredient[i]);
            }
        }
        return answer;
    }
}