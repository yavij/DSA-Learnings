class Solution {
    public String minWindow(String s, String t) {

        if(s.length()<t.length()) return "";
        
        //Step1: calculated Freq
        int[] freq = new int[128];

        for(int i=0;i<t.length();i++){
            freq[t.charAt(i)]++;
        }

        int left = 0, right = 0;
        int required = t.length();
        int minLen = Integer.MAX_VALUE;
        int start = 0;

        while(right<s.length()){
            char c = s.charAt(right);
            if(freq[c]>0)required--;
            freq[c]--;
            right++;

            while(required == 0){
                if(right-left<minLen){
                    minLen = right - left;
                    start = left;
                }
                freq[s.charAt(left)]++;
                if(freq[s.charAt(left)]>0)required++;
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE? "": s.substring(start, start+minLen);

    }
}
