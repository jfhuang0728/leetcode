package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxSize = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                left = Math.max(map.get(s.charAt(i)) + 1, left);//"abba"用例
            }
            map.put(s.charAt(i), i);
            maxSize = Math.max(i - left + 1, maxSize);
        }
        return maxSize;
    }
}
