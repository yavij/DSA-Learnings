class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
       /*
       1. for loop to store the chac values int the map
       2. List<List<String>> valuesList = new ArrayList<>();
       3. Map<Integer, List<String>> valuesListMap
       4. Map<char, Integer> valuesMap to check the character count
       5. Now iterate the ValuesMap and sort based the alphabet and form key like
       a1b2c3 like and and store it with the length key in the ValuesListMap
       6. when the same length comes check with the values, if it has the same key
       then it will be added to the same list of String. or it be added 
       List<List<String>>.
       7. Finally return the get all the from the valuesListMap and add it to the
       List<List<String>>. this will be the final Answer. 
       */
    Map<String, List<String>> valuesListMap = new HashMap<>();
    
    for(String str: strs){
        char[] chArray = str.toCharArray();
        Arrays.sort(chArray);
        String key = new String(chArray);
        List<String> values = valuesListMap.getOrDefault(key, new ArrayList<>());
        values.add(str);
        valuesListMap.put(key, values);
    }
    return  new ArrayList<>(valuesListMap.values());
    }
}
