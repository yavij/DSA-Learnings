class Solution {

    private List<List<Integer>> resultList;

    public Solution(){
        this.resultList = new ArrayList<>();
    }

    public List<List<Integer>> permute(int[] nums) {
         boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used);
        return resultList;
    }

    private void backtrack(int[] nums, List<Integer> values, boolean[] used){

        int len = nums.length;
        if(values.size() == len){
            resultList.add(new ArrayList<>(values));
            return;
        }


        for(int i=0;i<len;i++){
            if(used[i]) continue;
            values.add(nums[i]);
            used[i] = true;    
            backtrack(nums, values, used);
            values.remove(values.size() - 1);
            used[i] = false;    
        }
    }
}
