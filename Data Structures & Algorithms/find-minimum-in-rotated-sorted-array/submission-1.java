class Solution {
    public int findMin(int[] nums) {
        
        int len = nums.length;

        //Brute force 
       /* int min = nums[0];
         for(int i=1;i<len;i++){
            min = Math.min(min, nums[i]);
        }*/

        int left = 0, right = len-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>nums[right]){
                left = mid+1;
            }else{
                right=mid;
            }
        }

        return nums[left];
    }
}
