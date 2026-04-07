class Solution {
    public int lengthOfLongestSubstring(String s) {

        Set<Character> subString = new HashSet<>();
        int left = 0, result = 0;

        for(int right=0;right< s.length();right++){
           char c = s.charAt(right);
            while(subString.contains(c)){
                subString.remove(s.charAt(left));
                left++;
            }
            subString.add(c);
            result = Math.max(result, right-left+1);
        }
        return result;  
    }
}
