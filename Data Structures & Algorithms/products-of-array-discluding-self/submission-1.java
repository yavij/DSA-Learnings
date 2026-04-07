class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length; 
        int[] productArray = new int[len];
        int product = 1;
        productArray[0]=1;
        for(int i=1;i<len;i++){ 
            product*=nums[i-1];
            productArray[i] = product;
        }
        product = 1;
        for(int i=len-2;i>=0;i--){
            product*=nums[i+1];
            productArray[i]*= product;
        }

         return productArray;
    }
}  
