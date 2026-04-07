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
                System.out.println(val1+" "+val2);
                int result = val2/val1;
                values.push(result); 
            }else{
                values.push(Integer.valueOf(token));
            }
        }
       
        return values.peek();
    }
}
