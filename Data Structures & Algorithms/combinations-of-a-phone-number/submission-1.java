class Solution {

    private List<String> results;
    String[] chars = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public Solution(){
        this.results = new ArrayList<>();
    }

    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()) return new ArrayList<>();
        List<String> valList = charList(digits);
        return combination(valList, valList.size());
    }

    private List<String> charList(String digits){
        List<String> valList = new ArrayList<>();
        int len = digits.length();
        for(int i=0;i<len;i++){
            // ✅ FIXED INDEX
            valList.add(chars[digits.charAt(i) - '0']);
        }
        return valList;
    }

    private List<String> combination(List<String> values, int size){

        // ✅ START WITH EMPTY STRING
        List<String> resValues = new ArrayList<>();
        resValues.add("");

        // ✅ BUILD COMBINATIONS ITERATIVELY
        for(String val : values){
            List<String> temp = new ArrayList<>();

            for(String prefix : resValues){
                for(char ch : val.toCharArray()){
                    temp.add(prefix + ch);
                }
            }

            resValues = temp; // move to next stage
        }

        return resValues;
    }
}
