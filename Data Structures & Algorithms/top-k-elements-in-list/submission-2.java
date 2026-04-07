class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums){
           int value = freqMap.getOrDefault(num, 0)+1;
           freqMap.put(num, value);
        }

        List<Integer>[] bucket = new List[nums.length+1];

        for(int key: freqMap.keySet()){
            int val = freqMap.get(key);
            if(bucket[val] == null){
                bucket[val] = new ArrayList<>();
            }
            bucket[val].add(key);
        }
       
        int[] val = new int[k];
        int idx = 0;

        for(int i=bucket.length-1; i>0 && idx<k;i--){
            if(bucket[i]!=null){
                for(int num: bucket[i]){
                    val[idx++]= num;
                    if(idx==k) break;
                }
            }
        }
        
        return val;
    }
}
