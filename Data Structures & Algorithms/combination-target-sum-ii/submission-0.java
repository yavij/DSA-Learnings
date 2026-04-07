class Solution {

    private List<List<Integer>> resultList;
    private int target;

    public Solution(){
        this.resultList = new ArrayList<>();
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.target = target;
        Arrays.sort(candidates);
        targetValues(candidates, target, 0, new ArrayList<>());
        return resultList;
    }

    private void targetValues(int[] candidates, int remainingTarget, int start, List<Integer> values){
        if(remainingTarget == 0){
            resultList.add(new ArrayList<>(values));
            return;
        }

        if(remainingTarget<0) return;

        for(int j=start;j<candidates.length;j++){
            // skip duplicates
            if(j > start && candidates[j] == candidates[j-1]) continue;
            if(candidates[j] > remainingTarget) break;

             values.add(candidates[j]);
             targetValues(candidates, remainingTarget-candidates[j], j+1, values);
             values.remove(values.size() - 1);
        }
    }
}
