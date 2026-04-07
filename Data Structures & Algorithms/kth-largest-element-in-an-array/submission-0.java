class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        PriorityQueue<Integer> numbers = new PriorityQueue<>(Collections.reverseOrder());

        for(int i=0;i<nums.length;i++){
            numbers.add(nums[i]);
        }
        int i=1;
        while(i<k){
            numbers.poll();
            i++;
        }

        return numbers.peek();
    }

}
