class Solution {
    public int characterReplacement(String s, int k) {
        int length = s.length();
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;
        int result = 0;

        for(int right=0;right<length;right++){
           char c = s.charAt(right);
           freq[c-'A']+=1;
           maxFreq = Math.max(maxFreq, freq[c - 'A']);
            while((right - left+1)-maxFreq>k){
                char leftChar = s.charAt(left);
                freq[leftChar - 'A']--;
                left++;
            }
            result = Math.max(result, right - left + 1);
        }
        return result;
    }
}
