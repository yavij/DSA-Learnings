class Solution {
    public int findDuplicate(int[] nums) {

        /**Optimised 
        Time Complexity: o(n)
        Space Complexity: o(1)
        **/

        int slow = nums[0];
        int fast = nums[0];

        //Cycle exists

        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(fast != slow);

        System.out.println(slow+" "+fast);

        //Find the duplicate

        slow = nums[0];
        while(fast!=slow){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
