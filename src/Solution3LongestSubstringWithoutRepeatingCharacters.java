import java.util.HashMap;
import java.util.Map;

public class Solution3LongestSubstringWithoutRepeatingCharacters {
    //将substring.indexOf 改为用set去找快些但也不够好
    public static int lengthOfLongestSubstring(String s) {
        if ("".equals(s)){
            return 0;
        }
        int max = 1;
        for(int i=0;i<s.length();i++){
            int formax = 1;
            for(int j =i+1;j<s.length()+1;j++){
                String subString = s.substring(i, j);
                if(j!=s.length()&&(subString.indexOf(s.charAt(j))==-1)){
                    formax++;
                }
                else {
                    break;
                }
            }
            max = Math.max(formax,max);
        }
        return max;
    }
    //2 用map，想象一个滑块
    public static int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int maxLength = 0;
        Map<Character, Integer> charMap = new HashMap<>();
        int left = 0;

        for (int right = 0; right < n; right++) {
//            2、如果当前字符 ch 包含在 map中，此时有2类情况：
//            1）当前字符包含在当前有效的子段中，如：abca，当我们遍历到第二个a，当前有效最长子段是 abc，我们又遍历到a，
//            那么此时更新 left 为 map.get(a)+1=1，当前有效子段更新为 bca；
//            2）当前字符不包含在当前最长有效子段中，如：abba，我们先添加a,b进map，此时left=0，我们再添加b，发现map中包含b，
//            而且b包含在最长有效子段中，就是1）的情况，我们更新 left=map.get(b)+1=2，此时子段更新为 b，而且map中仍然包含a，map.get(a)=0；
//            随后，我们遍历到a，发现a包含在map中，且map.get(a)=0，如果我们像1）一样处理，就会发现 left=map.get(a)+1=1，实际上，left此时
//            应该不变，left始终为2，子段变成 ba才对
            if (!charMap.containsKey(s.charAt(right)) || charMap.get(s.charAt(right)) < left) {
                charMap.put(s.charAt(right), right);
                maxLength = Math.max(maxLength, right - left + 1);
            } else {
                left = charMap.get(s.charAt(right)) + 1;
                charMap.put(s.charAt(right), right);
            }
        }

        return maxLength;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcabcbb"));
    }
}
