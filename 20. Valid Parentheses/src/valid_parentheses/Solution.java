package valid_parentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            if ((c == '(') || (c == '[') || (c == '{')) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char cc = stack.pop().charValue();
                    if (((c == ')') && (cc == '(')) || ((c == ']') && (cc == '[')) || ((c == '}') && (cc == '{'))) {
                        continue;
                    } else {
                        return false;
                    }
                }
            }
        }
        if (stack.isEmpty()) return true;
        return false;
    }
}
