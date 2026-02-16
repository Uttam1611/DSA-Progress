import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int[] count = new int[26];

        for (char c : p.toCharArray()) count[c-'a']++;

        int left = 0, right = 0, needed = p.length();

        while (right < s.length()) {
            if (count[s.charAt(right++)-'a']-- > 0) needed--;

            if (needed == 0) res.add(left);

            if (right - left == p.length() &&
                count[s.charAt(left++)-'a']++ >= 0) needed++;
        }
        return res;
    }
}
