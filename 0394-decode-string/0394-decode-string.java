import java.util.*;

class Solution {
    public String decodeString(String s) {
        Stack<Integer> counts = new Stack<>();
        Stack<StringBuilder> result = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int k = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                k = k * 10 + ch - '0';
            } else if (ch == '[') {
                counts.push(k);
                result.push(curr);
                curr = new StringBuilder();
                k = 0;
            } else if (ch == ']') {
                StringBuilder temp = curr;
                curr = result.pop();
                int repeat = counts.pop();
                while (repeat-- > 0) curr.append(temp);
            } else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}
