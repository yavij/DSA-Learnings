class Solution {
    public int[] twoSum(int[] nums, int target) {
       int len = nums.length;
        /*for(int i = 0; i<len; i++){ 
            //Time compexity: o(n^2) - My approach
            //Space complexity: o(1)
            for(int j = i+1; j<len; j++){
                if(nums[i]+nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }*/
        Map<Integer, Integer> visited = new HashMap<>();
        for(int i=0;i<len;i++){
            int complement = target-nums[i];
            /*
            Time complexity - o(n)
            space complexity - o(n)
            */

            if(visited.containsKey(complement)){
                return new int[]{visited.get(complement), i};
            }

            visited.put(nums[i],i);
        }
        return new int[2];
    }
}
