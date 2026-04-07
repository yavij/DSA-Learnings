class Solution {
    public boolean isPalindrome(String s) {
         /*Start, end = len-1, and check the each characters are same or not?
        If(not) return false;
         out of the while loop will return true;
        s.replace(" ", "");
        s.replace("[^a-zA-Z0-9] ", "");*/
        int start = 0, end = s.length()-1;
        while(start<end){
            char startChar = s.charAt(start);
            char endChar = s.charAt(end); 
            if(!Character.isDigit(endChar) && !Character.isLetter(endChar)){
                end--;
                continue;
            }

             if(!Character.isDigit(startChar) && !Character.isLetter(startChar)){
                start++;
                continue;
            }

            if(Character.toLowerCase(startChar) != Character.toLowerCase(endChar)){
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}
