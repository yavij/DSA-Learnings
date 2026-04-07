class Solution {
    public int findMin(int[] nums) {
        
        int len = nums.length;
        int min = nums[0];

        //Brute force 
        for(int i=1;i<len;i++){
            min = Math.min(min, nums[i]);
        }

        return min;
    }
}
