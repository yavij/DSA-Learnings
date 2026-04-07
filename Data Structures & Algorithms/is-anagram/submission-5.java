class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if(sLen != tLen) return false;
        int[] values = new int[26];

        for(int i=0;i<sLen; i++){
            values[s.charAt(i) - 'a']++;
            values[t.charAt(i) - 'a']--;
        }

        for(int val: values){
            if(val!=0) return false;
        }

        return true;
    }
}
