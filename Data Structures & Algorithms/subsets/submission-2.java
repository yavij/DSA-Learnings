class Solution {

    private List<List<Integer>> result;
    private int[] nums;

    public Solution(){
        this.result = new ArrayList<>();
    }

    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        backtrack(0, new ArrayList<>());
        return result;
    }

    private void backtrack(int start, List<Integer> current){
        result.add(new ArrayList<>(current));
        for(int i = start; i < nums.length; i++){
            current.add(nums[i]);
            backtrack(i + 1, current);
            current.remove(current.size() - 1);
        }
    }
}
