class Solution {
    public boolean hasDuplicate(int[] nums) {
        
        Set<Integer> hasNums = new HashSet<>();

        for(int num: nums){
            if(hasNums.contains(num)){
                return true;
            }
            hasNums.add(num);
        }

        return false;
    }
}