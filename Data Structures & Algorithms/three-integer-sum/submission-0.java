class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Map<String, List<Integer>> resultMap = new HashMap<>();

        int len = nums.length;

        for(int i=0;i<len;i++){
            for(int j=i+1; j<len; j++){
                for(int k=j+1; k<len; k++){
                    if( nums[i]+nums[j]+nums[k] == 0){
                    List<Integer> values = new ArrayList<>();
                        // Step 1: Put values into array and sort
                        int[] triplet = { nums[i], nums[j], nums[k] };
                        Arrays.sort(triplet);

                        // Step 2: Build normalized key
                        String key = triplet[0] + " " + triplet[1] + " " + triplet[2];

                        System.out.println("Key"+ key);
                        values.add(nums[i]);
                        values.add(nums[j]);
                        values.add(nums[k]);
                    resultMap.put(key, values);
                    }
                }
            }
        }

        List<List<Integer>> valuesList = new ArrayList<>();

        for(String key: resultMap.keySet()){
            valuesList.add(resultMap.get(key));
        }

        return valuesList;

    }
}
