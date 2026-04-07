class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();
        int len = nums.length, maxcount = 0;
        if(len == 0) return 0;
        //Add all the values to the set
        for(int num: nums){
            values.add(num);
        }

        /*Find the increment min value by 1 check is in values set, 
        increment count by 1
        */

        for(int i=0;i<len;i++){
            int num = nums[i];
            if (!values.contains(num - 1)) {
                int count = 0;
                while(values.contains(num)){
                    count++;
                    num++;
                }  
                maxcount = Math.max(count, maxcount);
            }
        }
        return maxcount;
    }
}
