import java.util.*;

class Solution {
    public long solution(String expression) {
        List<String> exp = getStrings(expression);
        // + - *
        Long value1 = Math.abs(Long.parseLong(calExpression(calExpression(calExpression(exp, "+"), "-"), "*").get(0)));
        // + * -
        Long value2 = Math.abs(Long.parseLong(calExpression(calExpression(calExpression(exp, "+"), "*"), "-").get(0)));
        // - + *
        Long value3 = Math.abs(Long.parseLong(calExpression(calExpression(calExpression(exp, "-"), "+"), "*").get(0)));
        // - * +
        Long value4 = Math.abs(Long.parseLong(calExpression(calExpression(calExpression(exp, "-"), "*"), "+").get(0)));
        // * + -
        Long value5 = Math.abs(Long.parseLong(calExpression(calExpression(calExpression(exp, "*"), "+"), "-").get(0)));
        // * - +
        Long value6 = Math.abs(Long.parseLong(calExpression(calExpression(calExpression(exp, "*"), "-"), "+").get(0)));
        
        PriorityQueue<Long> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(value1);
        pq.add(value2);
        pq.add(value3);
        pq.add(value4);
        pq.add(value5);
        pq.add(value6);


        return pq.poll();
    }

    private static List<String> getStrings(String expression) {
        Set<Character> operSet = Set.of('-', '+', '*');
        StringBuilder sb = new StringBuilder();
        List<String> exp = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (operSet.contains(c)) {
                exp.add(sb.toString());
                sb.setLength(0);
                exp.add(String.valueOf(c));
            }
            else {
                sb.append(c);
            }
        }
        exp.add(sb.toString());
        return exp;
    }

    public List<String> calExpression(List<String> exp, String op){
        List<String> result = new ArrayList<>();
        boolean canCal = false;
        for (int i = 0; i < exp.size(); i++) {
            String now = exp.get(i);
            if (now.equals(op)) {
                canCal = true;
                continue;
            }
            if (canCal) {
                String last = result.remove(result.size() - 1);
                result.add(calValue(last, now, op));
                canCal = false;
                continue;
            }
            result.add(now);
        }
        return result;
        
    }
    private String calValue (String a, String b, String op){
        long intA = Long.parseLong(a);
        long intB = Long.parseLong(b);
        if (op.equals("+")){
            return String.valueOf(intA + intB);
        }
        else if (op.equals("-")){
            return String.valueOf(intA - intB);
        }
        else {
            return String.valueOf(intA * intB);
        }
    }
}