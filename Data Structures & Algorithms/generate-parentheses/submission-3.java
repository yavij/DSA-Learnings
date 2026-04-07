class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> results  = new ArrayList<>();
        validBrakcets(n, results, "", 0, 0);
        return results;
    }

    private void validBrakcets(int n, List<String> results, String current, 
        int open, int close){
            if(current.length() == 2*n){
                results.add(current);
            }
        
        if(open < n){
            validBrakcets(n, results, current+"(", open+1, close);
        }

        if(close<open){
            validBrakcets(n, results, current+")", open, close+1);
        }
    }
}
