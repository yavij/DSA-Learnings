class Solution {
    public int findDuplicate(int[] nums) {
        
        //Brute force

        int len = nums.length;

        Set<Integer> values = new HashSet<>();

        for(int i=0;i<len;i++){
            if(values.contains(nums[i])){
                return nums[i];
            }
           values.add(nums[i]);
        }
        return 0;
    }
}
