class Solution {

    private List<List<Integer>> valuesList;

    public Solution(){
        this.valuesList = new ArrayList<>();
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backTrack(nums, new ArrayList<>(), 0);
        return valuesList;
    }

    private void backTrack(int[] nums, List<Integer> values, int start){
        valuesList.add(new ArrayList<>(values));
        
        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i] == nums[i - 1]) continue;
            values.add(nums[i]);
            backTrack(nums, values, i+1);
            values.remove(values.size()-1);
        }
    }
}
