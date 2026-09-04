import java.util.*;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character>set=new HashSet<>();
        int n=s.length();
        int left=0;
        int maxl=0;

        for(int right=0; right<n; right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }

            set.add(s.charAt(right));
            maxl=Math.max(maxl,right-left+1);
        }
        return maxl;
    }
}