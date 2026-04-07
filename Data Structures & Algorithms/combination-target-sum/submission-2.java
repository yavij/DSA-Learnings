class Solution {

    private List<List<Integer>> valuesList = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        combinations(nums, new ArrayList<>(), target, 0);
        return valuesList;
    }

    private void combinations(int[] nums, List<Integer> values, int remaningTarget, int i){
        if(remaningTarget == 0){
            valuesList.add(new ArrayList<>(values));
            return;
        }

        if(remaningTarget < 0){
            return;
        }
       for(int j=i;j<nums.length;j++){
            values.add(nums[j]);
            int val = remaningTarget-nums[j];
            combinations(nums, values, val, j);
            values.remove(values.size()-1);
       }
    }
}
