class Solution {
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length; 
        int[] leftProduct = new int[len];
        int[] rightProduct = new int[len];
        int[] productArray = new int[len];
        int product = 1;
        leftProduct[0] = 1;
        rightProduct[len-1] = 1;
        for(int i=1;i<len;i++){ 
            product*=nums[i-1];
            leftProduct[i] = product;
        }
        product = 1;
        for(int i=len-2;i>=0;i--){
            product*=nums[i+1];
            rightProduct[i] = product;
        }

        for(int i=0;i<len;i++){
            productArray[i] = leftProduct[i]*rightProduct[i];
        }

         return productArray;
    }
}  
