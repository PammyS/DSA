import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/*
* REQUIREMENTS
* Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.


Example 1:

Input: s = "()"

Output: true

Example 2:

Input: s = "()[]{}"

Output: true

Example 3:

Input: s = "(]"

Output: false

Example 4:

Input: s = "([])"

Output: true



Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
* */



public class ValidParentheses {
    public boolean isValid(String s) {
        if(s.length()%2!=0) return false;
        Stack<Character> stack = new Stack<Character>();
        Set<Character> set = new HashSet<>();
        set.add('(');set.add('[');set.add('{');
        for(char c: s.toCharArray()) {
            if(set.contains(c)) {
                stack.push(c);
            } else {
                if(stack.empty()) return false;
                char openChar = stack.pop();
                switch(c) {
                    case ')':
                        if('(' != openChar) return false;
                        break;
                    case '}':
                        if( '{' != openChar) return false;
                        break;
                    case ']':
                        if('[' != openChar) return false;
                        break;
                }
            }
        }
        return stack.empty()?true:false;
    }
}
