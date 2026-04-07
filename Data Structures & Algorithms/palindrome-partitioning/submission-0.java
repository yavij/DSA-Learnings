class Solution {

    private List<List<String>> resultList;

    public Solution(){
        this.resultList = new ArrayList<>();
    }

    public List<List<String>> partition(String s) {
        List<String> path = new ArrayList<>();
        palindromeList(s, 0, path);
        System.out.println("resultList"+resultList);
        return resultList;
    }

    private void palindromeList(String s, int start, List<String> path){
        if (start == s.length()) {
            resultList.add(new ArrayList<>(path));
            return;
        }
        for (int end = start; end < s.length(); end++) {
            String sub = s.substring(start, end + 1);
             if (checkPalindrome(sub)) {
                System.out.println(sub);
                path.add(sub);
                palindromeList(s, end + 1, path);
                path.remove(path.size() - 1);
            }
        }
    }

    private boolean checkPalindrome(String s){
        char[] values = s.toCharArray();
        int start = 0, end = values.length-1;
        while(start<end){
            if(values[start] != values[end]){
                return false;
            }
            start++;end--;
        }
        return true;
    }
}
