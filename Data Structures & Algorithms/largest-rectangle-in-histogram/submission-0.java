class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int result = 0;
        int len  = heights.length;
        int[] width = new int[len];
        int[] nsl = new int[len];
        int[] nsr = new int[len];

        //Calculate the width

        Stack<Integer> stack = new Stack<>(); 
        for(int i=0;i<len;i++){
           while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
            stack.pop();
           }
           nsl[i] = stack.isEmpty()? -1: stack.peek();
           stack.push(i);
        }
        stack.clear();
        for(int i=len-1;i>=0;i--){
           while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
            stack.pop();
           }
           nsr[i] = stack.isEmpty()? len: stack.peek();
           stack.push(i);
        }
        for(int i=0;i<len;i++){
            width[i]= (nsr[i] - nsl[i])-1;
        }
        for(int i=0;i<len;i++){
            int area = width[i] * heights[i];
            result = Math.max(area, result);
        }

        return result;
    }
}
