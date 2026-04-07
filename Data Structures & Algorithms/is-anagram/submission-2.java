class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character, Integer> scharCount = new HashMap<>();
        Map<Character, Integer> tcharCount = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            int count = scharCount.getOrDefault(c,0);
            scharCount.put(c,count+1);
        }

        for(int i=0;i<t.length();i++){
            char c = t.charAt(i);
            int count = tcharCount.getOrDefault(c,0);
            tcharCount.put(c,count+1);
        }
    
        for(Character c: scharCount.keySet()){
            if(!scharCount.get(c).equals(tcharCount.get(c))){
                return false;
            }
        }
        return true;
    }
}
