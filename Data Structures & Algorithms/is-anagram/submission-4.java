class Solution {
    public boolean isAnagram(String s, String t) {
        int sLen = s.length(), tLen = t.length();
        if(sLen != tLen) return false;
        Map<Character, Integer> sString = new HashMap<>();
        Map<Character, Integer> tString = new HashMap<>();

        for(int i=0;i<sLen; i++){
            char sChar = s.charAt(i), tChar = t.charAt(i);
            int sCount = sString.getOrDefault(sChar,1), tCount = tString.getOrDefault(tChar,1);
            sString.put(sChar, sCount+1);
            tString.put(tChar, tCount+1);
        }

        for(char key: sString.keySet()){
            if(!tString.containsKey(key)) return false;
            int sCount = sString.get(key), tCount = tString.get(key);
            System.out.println(sCount+" "+tCount);
            if(sCount != tCount) return false;
        }
        return true;
    }
}
