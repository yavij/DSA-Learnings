class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> valuesList = new ArrayList<>();
        List<Integer> values = null;
        valuesList.add(new ArrayList<>());

        int len = nums.length, j=0;
        while(j<len){
            int size = valuesList.size();
            for(int i = 0; i < size; i++){
                List<Integer> newSubset = new ArrayList<>(valuesList.get(i));
                newSubset.add(nums[j]);
                 valuesList.add(newSubset);
            }
            j++; 
        }
        return valuesList;
        
    }
}
