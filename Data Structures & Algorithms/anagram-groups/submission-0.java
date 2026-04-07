class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for(String str: strs){

            //Make a unique key to add into the map
            Map<Character, Integer> charCount = new HashMap<>();
           for(int i=0;i<str.length();i++){
                char c = str.charAt(i);
               int count = charCount.getOrDefault(c,0);
               charCount.put(c, count+1);
           }
            StringBuilder keyString = new StringBuilder();
            List<Character> chars = new ArrayList<>(charCount.keySet());
            Collections.sort(chars);
           for(Character c: chars){
                int count = charCount.get(c);
                keyString.append(c);
                keyString.append(count);
           }
            String key = keyString.toString();
           anagrams.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(anagrams.values());
    }
}
