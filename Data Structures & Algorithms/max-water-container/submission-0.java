class Solution {
    public int maxArea(int[] heights) {

        int left = 0;
        int right = heights.length -1, max = Integer.MIN_VALUE;
        
        //Brute force - o(n2)
       /* for(int i=0;i<len;i++){
            for(int j=i+1;j<len;j++){
                int area = (j-i) * Math.min(heights[i], heights[j]);
                max = Math.max(max, area);
            }
        }*/

        while(left < right){
            int area = (right - left) * Math.min(heights[left], heights[right]);
            max = Math.max(max, area);

            if(heights[left]<heights[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }
}
