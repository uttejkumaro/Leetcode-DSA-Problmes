//import java.util.*;
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(result, "", num, target, 0, 0, 0);
        return result;
    }
    private void backtrack(List<String> result, String path, String num, int target, int pos, long eval, long multed) {
        if (pos == num.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }
        for (int i = pos; i < num.length(); i++) {
            // We don't allow numbers with leading zeroes
            if (i != pos && num.charAt(pos) == '0') break;            
            String curStr = num.substring(pos, i + 1);
            long cur = Long.parseLong(curStr);            
            if (pos == 0) {
                // First number, pick it without any operator
                backtrack(result, path + curStr, num, target, i + 1, cur, cur);
            } else {
                // Addition
                backtrack(result, path + "+" + curStr, num, target, i + 1, eval + cur, cur);                
                // Subtraction
                backtrack(result, path + "-" + curStr, num, target, i + 1, eval - cur, -cur);                
                // Multiplication
                backtrack(result, path + "*" + curStr, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}
