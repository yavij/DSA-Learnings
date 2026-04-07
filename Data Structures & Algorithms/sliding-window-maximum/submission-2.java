class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        if(len == 1) return nums;    

        List<Integer> maxValues = new ArrayList<>();

        for(int i=0;i<=len-k;i++){
            int left = i;
            int right = i+k;
            int max = Integer.MIN_VALUE;

            while(left<right){
                max = Math.max(max, nums[left++]);
            }

            maxValues.add(max);
        }
        int[] result = new int[maxValues.size()];
        int j = 0;
        for(int num: maxValues){
            result[j++] = num;
        }
        return result; 
    }
}
