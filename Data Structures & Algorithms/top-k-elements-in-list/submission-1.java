class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> freqMap = new HashMap<>();

        for(int num: nums){
           int value = freqMap.getOrDefault(num, 0)+1;
           freqMap.put(num, value);
        }

       PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a,b)-> b.getValue()- a.getValue());
        pq.addAll(freqMap.entrySet());
        int[] val = new int[k];
        for(int i=0;i<k;i++){
           val[i] = pq.poll().getKey();
        }

        return val;
    }
}
