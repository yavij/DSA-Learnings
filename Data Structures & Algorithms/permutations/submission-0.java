class Solution {

    private List<List<Integer>> resultList;

    public Solution(){
        this.resultList = new ArrayList<>();
    }

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums, new ArrayList<>());
        return resultList;
    }

    private void backtrack(int[] nums, List<Integer> values){
        int len = nums.length;
        if(values.size() == len){
            resultList.add(new ArrayList<>(values));
            return;
        }


        for(int i=0;i<len;i++){
            if(values.contains(nums[i])) continue;
            values.add(nums[i]);
            backtrack(nums, values);
            values.remove(values.size() - 1);
        }
    }
}
