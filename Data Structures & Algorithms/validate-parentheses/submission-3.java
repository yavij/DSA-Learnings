class Solution {
    public boolean isValid(String s) {
        
        if(s.length() == 1) return false;
        Stack<Character> valid = new Stack<>();
        int right = s.length() - 1;
        for(int i=0;i<=right;i++){
           char c = s.charAt(i);
           if(c == '}'){
            if(valid.size() == 0) return false;
            if(valid.pop() != '{') return false;
           }else if(c == ']'){
            if(valid.size() == 0) return false;
            if(valid.pop() != '[') return false;
           }else if(c == ')'){
            if(valid.size() == 0) return false;
            if(valid.pop() != '(') return false;
           }else{
                valid.push(c);
           }
        }
        if(valid.size() != 0) return false;
       return true;  
    }
}
