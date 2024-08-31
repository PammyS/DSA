import java.util.HashSet;
import java.util.Set;


/* REQUIREMENTS
* Given a string s, find the length of the longest
substring
 without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
* */


public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        int l = 0, r=0, len = s.length();
        if(len <= 1) return len;
        int ans = Integer.MIN_VALUE;
        Set<Character> charSet = new HashSet<>();
        while(l<len && r<len) {
            if(!charSet.contains(s.charAt(r))) {
                charSet.add(s.charAt(r));
                ans = Math.max(ans, r-l+1);
            } else {
                while(s.charAt(l) != s.charAt(r)) {
                    charSet.remove(s.charAt(l++));
                }
                l++;
            }
            r++;
        }
        return ans;
    }
}
