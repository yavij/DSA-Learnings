class Solution {
    public int evalRPN(String[] tokens) {
       Stack<Integer> values = new Stack<>();
        for(String token: tokens){
            if(token.equals("+")){
                values.push(values.pop()+values.pop()); 
            }else if(token.equals("-")){
                int val1 = values.pop();
                int val2 = values.pop();
                 values.push(val2-val1); 
            }else if(token.equals("*")){
                 values.push(values.pop()*values.pop()); 
            }else if(token.equals("/")){
                int val1 = values.pop();
                int val2 = values.pop();
                values.push(val2/val1); 
            }else{
                values.push(Integer.parseInt(token));
            }
        }
        return values.pop();
    }
}
